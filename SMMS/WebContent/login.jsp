<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台登录</title>
<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css">
<link type="text/css" rel="stylesheet" href="easyui/themes/default/easyui.css">
<link type="text/css" rel="stylesheet" href="css/login.css">
</head>
<body>
	<div id="loginDiv" class="easyui-dialog">
		<form id="loginForm" action="user/login" method="post">
			<label class='error'>${sessionScope.errorMsg }</label><c:remove var="errorMsg" scope="session"/>
			<input name="uname" required="required" placeholder="请输入用户名"/>
			<input name="upwd" type="password" required="required" placeholder="请输入密码"/>
			<button id="loginBtn">登录</button> 
		</form>
	</div>
	
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
 	<script type="text/javascript" src="js/login.js"></script>
</body>
</html>