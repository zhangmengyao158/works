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
	 <form id="mGrade" enctype="multipart/form-data" style="width:85%; margin:0px auto;">
  				 <p>
					  <input id="mgid" name="gid" type="hidden" value=""/>
				</p><br>
				 <p>
					&nbsp;&nbsp;&nbsp;<label> &nbsp;&nbsp;学&nbsp;  号</label> <input id="msno" name="sno" type="text" value=""/>
				</p><br>
				<p>
					&nbsp;&nbsp;&nbsp;<label> &nbsp;&nbsp;班&nbsp;级</label> <input id="mcno" name="cno" type="text" value=""/>
				</p><br>
				<p>
					&nbsp;&nbsp;&nbsp;<label> &nbsp;&nbsp;成&nbsp;绩</label> <input id="mscore" name="score" type="text" value=""/>
				</p>
				
				 
				
 				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="修改" onClick="modifyGrade()"/> 
					&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"/>
			</form>

 <script type="text/javascript" src= "ueditor/ueditor.config.js"></script>
 <script type="text/javascript" src= "ueditor/ueditor.all.min.js"></script>
 <script type="text/javascript" src=" js/modifyGrade.js"></script>
   	 
</body>
</html>
