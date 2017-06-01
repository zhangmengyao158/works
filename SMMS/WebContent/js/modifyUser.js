 $.get("user/detail?usid=" + usid , function(data){
   // alert(JSON.stringify(data));  //把js的json对象转换成json字符串
    //alert(data.tid);
 	$("#musid").val(data.usid);
	$("#muname").val(data.uname);
	$("#mupwd").val(data.upwd);
	$("#msex").val(data.sex);
	$("#mtel").val(data.tel); 
	$("#muser_drop").val(data.user_drop); 
 },"json");
 

 
 //修改新闻
 function modifyUser(){
	 //jquery对象转dom对象 jqueryObj[0]
	 
	 //dom对象转jquery对象 $(domObj)
	// alert($( "#mNews" )[0]);
	 var formData = new FormData($( "#mUser" )[0]);  
//	 alert("进了");
	 $.ajax({  
		  url: 'user/modify' ,  
		  type: 'POST',  
		  data: formData,  
		  async: false,  
		  cache: false,  
		  contentType: false,  
		  processData: false,  
		  success: function (returndata) {  
			  if(returndata){
				 parent.closeMU();
				 $('#userInfo').datagrid("reload");
			  }
			  $.messager.show({
						title:'修改用户',
						msg:returndata ? "修改成功..." : "修改失败!!!" ,
						showType:'show',
						style:{
							top:document.body.scrollTop+document.documentElement.scrollTop + 40,
						}
			  });
			   
		  }  	  
	 });  
 }
 