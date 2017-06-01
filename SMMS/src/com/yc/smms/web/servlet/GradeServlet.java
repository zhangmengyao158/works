package com.yc.smms.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;

import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.yc.smms.entity.Grade;
import com.yc.smms.entity.Students;
import com.yc.smms.service.GradeService;
import com.yc.smms.service.impl.GradeServiceImpl;
import com.yc.smms.util.ServletUtil;
import com.yc.smms.service.GradeService;
import com.yc.smms.service.impl.GradeServiceImpl;

@WebServlet("/grade/*")
public class GradeServlet extends BaseServlet {
 
	private static final long serialVersionUID = -5783400370901118877L;
	private GradeService gradeService;
	public GradeServlet() {
		gradeService = new GradeServiceImpl();

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uriName = ServletUtil.getUriName(request.getRequestURI());
        LogManager.getLogger().debug("请求"+uriName+"进入GradeServlet中，做相应处理");
        switch(uriName){
    	case "list":
    		doList(request,response);
    		break;
    	case "byId" :
    		doById(request,response);
    		break;
    	case "detail" :
    		doDetail(request,response);
    		break;
    	case "modify" :
    		doModify(request,response);
    		break;
    	case "archive" :
    		doArchive(request,response);
    		break;
    	case "add" :
    		doAdd(request,response);
    		break;
		default:
	        respOutStr(response, "<h1>没有对应的请求资源...</h1>");
     	}	
		

	}
	private void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SmartUpload su = new SmartUpload();
		su.setCharset("utf-8");
		su. initialize(getServletConfig(), request, response);
		boolean isSuccess = false;
		try {
			su.upload();
			Request req = su.getRequest();
			Grade t = getReqParam2Obj(req, Grade.class);
			System.out.println("title==>" + t) ;
			isSuccess  = gradeService.addGrade(t);
		} catch (Exception e) {
 			e.printStackTrace();
		}
 		respOutStr(response, isSuccess + "");  //把对象转换成json字符串,做为响应数据


		
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("gid");
		System.out.println(id);
		Grade grade = gradeService.getGrade(id);
		respOutStr(response, toJsonStr(grade));  //把对象转换成json字符串,做为响应数据		
		
		
	}

	private void doById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("cnid");
		Map<String, Object> grade = gradeService.getGradeById(id);  //分页数据
		request.setAttribute("grade", grade);
		request.getRequestDispatcher("/page/news_modify.jsp").forward(request, response);
		
	}

	private void doArchive(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("gid");
		boolean isSuccess = gradeService.ArchiveGrade(id);
		respOutStr(response,isSuccess +"");  //把对象转换成json字符串,做为响应数据
	}

	private void doModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SmartUpload su = new SmartUpload();
		su.setCharset("utf-8");
		su.initialize(getServletConfig(), request, response);
		boolean isSuccess = false;
		try {
			su.upload();
			Request req = su.getRequest();
			Grade t = getReqParam2Obj(req, Grade.class);
			
			isSuccess  = gradeService.modifyGrade(t);
			System.out.println("title==>" + t) ;

		} catch (SmartUploadException e) {
 			e.printStackTrace();
		}
 		respOutStr(response, isSuccess + "");  //把对象转换成json字符串,做为响应数据
		
		
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//    	String temp = request.getParameter("page"); //分页的当前页数
//		String size = request.getParameter("rows");  //当前页面的数据条数 
		List<Grade> grades = gradeService.getAllGrade();
		respOutStr(response, toJsonStr(grades));
	}
	
}
