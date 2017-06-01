<%@page import="java.util.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<base href="/SMMS/">
<meta charset="utf-8" />
<title>后台登录</title>
<!-- 引入easyui的框架 -->
<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css">
<link type="text/css" rel="stylesheet" href="easyui/themes/default/easyui.css">
 </head> 
<body>
	 <form id="mStudents" enctype="multipart/form-data" style="width:50%; margin:0px auto;">
	            <br>
 	            <p>
					  <input  id="msno" name="sno" type="hidden" value=""/>
				</p> <br>
				<p>
					<label> 班级名 </label> <input id="mclname" name="clname" type="text" value=""/>
				</p> <br>
				<p> 
					<label> 姓     名 </label> <input id="msname" name="sname" type="text" value=""/>
				</p> <br>
				<p>
					<label> 性     别 </label> <input id="mssex" name="ssex" type="text" value=""/>
				</p> <br>
				 
				<p>
					<label> T  e  l </label> <input id="mtel" name="tel" type="text" value=""/>
				</p> <br>
				<p>
					<label> 地    址 </label> <input id="maddress" name="address" type="text" value=""/>
				</p>
				 
 
 				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 				<input type="button" value="修改" onClick="modifyStudents()"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="重置"/>
			</form>

 <script type="text/javascript" src= "ueditor/ueditor.config.js"></script>
 <script type="text/javascript" src= "ueditor/ueditor.all.min.js"></script>
 <script type="text/javascript" src=" js/modifyStudents.js"></script>
   	 
</body>
</html>
