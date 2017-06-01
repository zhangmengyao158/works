 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<base href="/SMMS/">
<meta charset="utf-8" />
<title>系统登录</title>
<!-- 引入easyui的框架 -->
<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css">
<link type="text/css" rel="stylesheet" href="easyui/themes/default/easyui.css">
<link type="text/css" rel="stylesheet" href="css/login.css">
</head> 
<body>
	 <form id="aStudents" enctype="multipart/form-data" onsubmit=" return addStudents()"
	  style="width:85%; margin:0px auto;">
 				<br> 	
				  <p>
					<label style="margin-left:180px;font-size:12px;"> 班&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级 </label> <input style="width:300px; height:25px; " id="aclname" name="clname" type="text" value=""/>
				</p><br>
				<p>
					<label style="margin-left:180px;font-size:12px;"> 学&nbsp;&nbsp;生&nbsp;&nbsp;名&nbsp; </label> <input style="width:300px; height:25px; " id="asname" name="sname" type="text" value=""/>
				</p><br>
				
				<p>
					<label style="margin-left:180px;font-size:12px;">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</label> <input style="width:300px; height:25px; " id="assex" name="ssex" type="text" value=""/>
				</p><br>
				 
				<p>
					<label style="margin-left:180px;font-size:12px;">联&nbsp;系&nbsp;电&nbsp;话 </label> <input style="width:300px; height:25px; " id="atel" name="tel" type="text" value=""/>
				</p><br>
				<p>
					<label style="margin-left:180px;font-size:12px;">家&nbsp;庭&nbsp;住&nbsp;址</label> <input style="width:300px; height:25px; " id="aaddress" name="address" type="text" value=""/>
				</p><br>

 				&nbsp;&nbsp;<input type="submit" style="margin-left:290px;" value="添加" /> 
					<input type="reset" style="margin-left:20px;" value="重置"/>
			</form>

 <script type="text/javascript" src= "ueditor/ueditor.config.js"></script>
 <script type="text/javascript" src= "ueditor/ueditor.all.min.js"></script>
 <script type="text/javascript" src=" js/addStudents.js"></script>
   	 
</body>
</html>
