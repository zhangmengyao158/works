package com.yc.smms.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;

import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.yc.smms.entity.StudentsBean;
import com.yc.smms.entity.User;
import com.yc.smms.entity.UserBean;
import com.yc.smms.service.UserService;
import com.yc.smms.service.impl.userServiceImpl;
import com.yc.smms.util.ServletUtil;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
 
	private static final long serialVersionUID = 5130695560849273625L;
	private UserService userService;
	
	public UserServlet() {
		userService = new userServiceImpl();
	}
	 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uriName = ServletUtil.getUriName(request.getRequestURI());
        LogManager.getLogger().debug("请求"+uriName+"进入UserServlet中，做相应处理");
	
        switch(uriName){
    	case "login":
    		doLogin(request,response);
    		break;
    	 case "list":
     		doList(request,response);
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
			User u = getReqParam2Obj(req, User.class);
			System.out.println("title==>" + u) ;
			isSuccess  = userService.addUser(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		respOutStr(response, isSuccess + "");  //把对象转换成json字符串,做为响应数据

	}

private void doArchive(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id = request.getParameter("cnid");
	boolean  isSuccess = userService.ArchiveUsers(id);
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
		User u = getReqParam2Obj(req, User.class);
		
		isSuccess  = userService.modifyUser(u);
		System.out.println("title==>" + u) ;

	} catch (SmartUploadException e) {
			e.printStackTrace();
	}
		respOutStr(response, isSuccess + "");  //把对象转换成json字符串,做为响应数据
	
		
	}

private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id = request.getParameter("usid");
	String ud = request.getParameter("user_drop");
 	User user = userService.getUser(id);
	respOutStr(response, toJsonStr(user));  //把对象转换成json字符串,做为响应数据				
	}

private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 String temp = request.getParameter("page"); //分页的当前页数
		 String size = request.getParameter("rows");  //当前页面的数据条数 
		UserBean userBean  = userService.getAllUsers(size, temp); //分页处理封装对象  封装要传递的数据		
		respOutStr(response, toJsonStr(userBean));//把对象转换成json字符串 ，作为响应数据
	 
	 
	}

	//做业务处理    参数    分发
	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
	//1.把请求参数转换成请求对象  java是面向对象语言  更加便捷
		User user = getReqParam2Obj(request,User.class) ;  //User.class 就是一个实例
		System.out.println(user);   
		
		//直接把对象交给login
		HttpSession session = request.getSession();
      if(userService.login(user.getUname(),user.getUpwd() )){
    	  session.setAttribute("loginUser", user.getUname());
    	response.sendRedirect("/SMMS/back/admin.jsp");;
      }else{
    	  
    	  session.setAttribute("errorMsg","用户名或密码错误！！！");
      	response.sendRedirect("/SMMS/login.jsp");;
      }
	
		
	}
}
