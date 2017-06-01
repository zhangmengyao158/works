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
	 <form id="aUser" enctype="multipart/form-data" onsubmit=" return addUser()"
	  style="width:85%; margin:0px auto;">
	  <br> 	
				 <p>
					<label style="margin-left:180px;font-size:12px;">编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</label> <input style="width:300px; height:25px; " id="ausid" name="usid" type="text" value=""/>
				</p><br>
				<p>
					<label style="margin-left:180px;font-size:12px;"> 用&nbsp;户&nbsp;名&nbsp; </label> <input style="width:300px; height:25px; " id="auname" name="uname" type="text" value=""/>
				</p><br>
				<p>
					<label style="margin-left:180px;font-size:12px;"> 密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码 </label> <input style="width:300px; height:25px; " id="aupwd" name="upwd" type="text" value=""/>
				</p><br>
				<p>
					<label style="margin-left:180px;font-size:12px;">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</label> <input style="width:300px; height:25px; " id="asex" name="sex" type="text" value=""/>
				</p><br>
				<p>
					<label style="margin-left:180px;font-size:12px;">&nbsp;T&nbsp;&nbsp;&nbsp;e&nbsp;&nbsp;&nbsp;l&nbsp; </label> <input style="width:300px; height:25px; " id="atel" name="tel" type="text" value=""/>
				</p><br>
				<p>
					<label style="margin-left:180px;font-size:12px;"> 用户权限 </label> <input  style="width:300px; height:25px; " id="muser_drop" name="user_drop" type="text" value=""/>
				</p> <br>
				 
 				&nbsp;&nbsp;<input type="submit" style="margin-left:290px;" value="添加" /> 
					<input type="reset" style="margin-left:20px;" value="重置"/>
			</form>

 <script type="text/javascript" src= "ueditor/ueditor.config.js"></script>
 <script type="text/javascript" src= "ueditor/ueditor.all.min.js"></script>
 <script type="text/javascript" src=" js/addUser.js"></script>
   	 
</body>
</html>
