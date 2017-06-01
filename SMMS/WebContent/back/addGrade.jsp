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
	 <form id="aGrade" enctype="multipart/form-data" onsubmit=" return addGrade()"
	  style="width:85%; margin:0px auto;">
				 <br><br><br><br><br>
                 
				<br> 
				<p>
					<label style="margin-left:180px;font-size:13px;"> 学生学号 </label> <input style="width:300px; height:25px; " id="asno" name="sno" type="text" value=""/>
				</p><br> 
				<p>
					<label style="margin-left:180px;font-size:13px;"> 班     级     号 </label> <input style="width:300px; height:25px; " id="acno" name="cno" type="text" value=""/>
				</p><br> 
				<p>
					<label style="margin-left:180px;font-size:13px;"> 学生成绩 </label> <input style="width:300px; height:25px; " id="ascore" name="score" type="text" value=""/>
				</p>
				<br> 
 				&nbsp;&nbsp;<input type="submit" style="margin-left:290px;" value="添加" /> 
					<input type="reset" style="margin-left:20px;" value="重置"/>
			</form>

 <script type="text/javascript" src= "ueditor/ueditor.config.js"></script>
 <script type="text/javascript" src= "ueditor/ueditor.all.min.js"></script>
 <script type="text/javascript" src=" js/addGrade.js"></script>
   	 
</body>
</html>
