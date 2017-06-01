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
	 <form id="mUser" enctype="multipart/form-data" style="width:85%; margin:0px auto;">
	 <input type="hidden" name="nid" id="mnid"/><br>
				 <p>
					<label>编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</label> <input id="musid" name="usid" type="text" value=""/>
				</p><br>
				<p>
					<label> 教&nbsp;师&nbsp;名&nbsp; </label> <input id="muname" name="uname" type="text" value=""/>
				</p><br>
				<p>
					<label> 密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码 </label> <input id="mupwd" name="upwd" type="text" value=""/>
				</p><br>
				<p>
					<label>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</label> <input id="msex" name="sex" type="text" value=""/>
				</p><br>
				<p>
					<label> &nbsp;T&nbsp;&nbsp;&nbsp;e&nbsp;&nbsp;&nbsp;l&nbsp; </label> <input id="mtel" name="tel" type="text" value=""/>
				</p><br>
				<p>
					<label> 用户权限 </label> <input style="readonly:true" id="muser_drop" name="user_drop" type="text" value=""/>
				</p> 
 				
 			   <input style="margin-left:80px ;margin-top:10px" type="button" value="修改" onClick="modifyUser()"/> 
					<input style="margin-top:10px" type="reset" value="重置"/>
			</form>

 <script type="text/javascript" src= "ueditor/ueditor.config.js"></script>
 <script type="text/javascript" src= "ueditor/ueditor.all.min.js"></script>
 <script type="text/javascript" src=" js/modifyUser.js"></script>
   	 
</body>
</html>
