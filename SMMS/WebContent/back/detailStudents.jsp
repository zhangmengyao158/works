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
</head> 
<body>
	<table width="80%" align="center" style="margin:0px auto">
          <tr width="100%">
            <td colspan="2" align="center" id="dsno"></td>
          </tr>
          <tr>
            <td colspan="2" align="center" id="dclname"><hr/>
            </td>
          </tr>
          <tr>
            <td align="left" id="dsname"> </td>
            <td align="center" id="dssex"> </td>
          </tr>
          <tr>
            <td align="center" id="dbornDate"> </td>
            <td align="left" id="dtel"> </td>
          </tr>
          <tr>
            <td align="center" id="daddress"> </td>
            <td align="left" id="dru_date"> </td>
          </tr>
          <tr>
            <td colspan="2" align="center"> </td>
          </tr>
           
         </table>
	
	 
 <script type="text/javascript" src="js/detailStudents.js"></script>
</body>
</html>
