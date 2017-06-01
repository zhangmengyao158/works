<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<base href="/SMMS/">
<meta  charset=UTF-8>
<title>学生信息管理</title>
<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css">
<link type="text/css" rel="stylesheet" href="easyui/themes/default/easyui.css" >
<link type="text/css" rel="stylesheet" href="css/admin.css">
</head> 
 <body class="easyui-layout" id="layoutBody">   
    <div data-options="region:'north'" style="height:160px;">
	    <div id="header">
			  <div id="welcome">欢迎使用学生信息管理系统！</div>
			  <div id="nav"><img src="images/logo.jpg" alt="2333" /> 
			  </div>
			</div>
		    </div>  
		     <div data-options="region:'west',title:'菜单栏',collapsible:false" style="width:100px;">
		     <div id="leftSider" class="easyui-accordion" >   
		    <div title="教师管理" data-options="iconCls:'icon-man'">                             
               <ul class="menutree">   
 				   <li><span>编辑教师</span></li>   
 	    		   <li><span>添加教师</span></li>   	  
			   </ul>   		            
 		    </div>   
		    <div title="学生管理" data-options="iconCls:'icon-man'" >   
		       <ul class="menutree">   
 	               <li><span>添加学生</span></li>   
				   <li><span>编辑学生</span></li>   
			   </ul>
		    </div>   
		    <div title="成绩管理" data-options="iconCls:'icon-man'">   
		       <ul class="menutree">   
 	               <li><span>添加成绩</span></li>   
				   <li><span>编辑成绩</span></li>   
			   </ul>
		    </div>   
		</div>       
     </div>   
    <div data-options="region:'center'">
      <div id="main" style="width:500px;height:250px;">   
		    <div title="主界面">   
		        <h1>欢迎使用学生信息管理系统</h1>    
		    </div>   
		</div> 
    </div>   
    <!-- 子窗口中的对话框 -->
  <div id="detailStudents" style="margin:0px auto"></div>
  <div id="modifyStudents"></div>
  <div id="stopStudents"></div>
  
   <div id="detailGrade" style="margin:0px auto"></div>
  <div id="modifyGrade"></div>
  <div id="stopGrade"></div>
  
   <div id="detailUser" style="margin:0px auto"></div>
  <div id="modifyUser"></div>
  <div id="stopUser"></div>
 
 
 
 <script type="text/javascript" src="js/jquery-2.1.3.min.js"  ></script>
 <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src= "easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src=" js/admin.js"></script>
 
</body>  

</html>