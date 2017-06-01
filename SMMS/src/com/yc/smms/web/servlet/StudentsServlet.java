package com.yc.smms.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;

import com.google.gson.Gson;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.yc.smms.entity.Students;
import com.yc.smms.entity.StudentsBean;
import com.yc.smms.service.StudentsService;
import com.yc.smms.service.impl.StudentsServiceImpl;
 import com.yc.smms.util.ServletUtil;
 
@WebServlet("/students/*")
public class StudentsServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
  
	 private StudentsService studentsService;
	 public StudentsServlet() {

		 studentsService= new StudentsServiceImpl();
	}
	 //请求响应处理方法
	 //关注：1.请求来的参数（request的数据：uri parameter...）
	 //2.响应数据（针对异步）和跳转地址（针对正常请求）
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		String uriName = ServletUtil.getUriName(request.getRequestURI());
        LogManager.getLogger().debug("请求"+uriName+"进入StudentsServlet中，做相应处理");
        
    	//String type = request.getParameter("type") == null ? "list" :request.getParameter("type");
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
	        respOutStr(response, "<h1>没有对应的请求资源</h1>");
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
			Students n = getReqParam2Obj(req, Students.class);
			System.out.println("title==>" + n) ;
			isSuccess  = studentsService.addStudents(n);
		} catch (Exception e) {
 			e.printStackTrace();
		}
 		respOutStr(response, isSuccess + "");  //把对象转换成json字符串,做为响应数据

		
	}
	//归档学生信息
	private void doArchive(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("cnid"); //没有取到sno
		boolean  isSuccess = studentsService.ArchiveStudents(id);
		respOutStr(response,isSuccess +"");  //把对象转换成json字符串,做为响应数据

		
	}
	private void doModify(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
 		SmartUpload su = new SmartUpload();
		su.setCharset("utf-8");
		su.initialize(getServletConfig(), request, response);
		boolean isSuccess = false;
		try {
			su.upload();
			Request req = su.getRequest();
			Students n = getReqParam2Obj(req, Students.class);
			
			isSuccess  = studentsService.modifyStudents(n);
			System.out.println("title==>" + n) ;

		} catch (SmartUploadException e) {
 			e.printStackTrace();
		}
 		respOutStr(response, isSuccess + "");  //把对象转换成json字符串,做为响应数据
		
	}
	private void doDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
 		String id = request.getParameter("cnid");
        
		Students students = studentsService.getStudents(id);
		respOutStr(response, toJsonStr(students));  //把对象转换成json字符串,做为响应数据

	}
	/*
	 * 分页处理
	 */
	private void doList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String temp = request.getParameter("page"); //分页的当前页数
		String size = request.getParameter("rows");  //当前页面的数据条数 
		StudentsBean studentsBean = studentsService.getPartStudents(size, temp); //分页处理封装对象  封装要传递的数据		
		respOutStr(response, toJsonStr(studentsBean));//把对象转换成json字符串 ，作为响应数据
	}

	private void doById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("cnid");
		Map<String, Object> students = studentsService.getStudentsById(id);  //分页数据
 		request.setAttribute("students", students);
		request.getRequestDispatcher("/back/modifyStudents.jsp").forward(request, response);
		
	}
 

}
