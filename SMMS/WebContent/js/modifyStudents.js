$.get("students/detail?cnid=" + cnid , function(data){
//    alert(JSON.stringify(data));  //把js的json对象转换成json字符串
  	$("#mclname").val(data.clname);
	$("#msname").val(data.sname);
	$("#mssex").val(data.ssex);
 	$("#mtel").val(data.tel);
	$("#maddress").val(data.address);
 	$("#msno").val(cnid);

 },"json");

 
  
 //修改学生信息
 function modifyStudents(){
	 //jquery对象转dom对象 jqueryObj[0]
	 
	 //dom对象转jquery对象 $(domObj)
	// alert($( "#mNews" )[0]);
	 var formData = new FormData($( "#mStudents" )[0]);  
//	 alert("进了");
	 $.ajax({  
		  url: 'students/modify' ,  
		  type: 'POST',  
		  data: formData,  
		  async: false,  
		  cache: false,  
		  contentType: false,  
		  processData: false,  
		  success: function (returndata) {  
			  if(returndata){
				 parent.closeMN();
				 $('#studentsInfo').datagrid("reload");
			  }
			  $.messager.show({
						title:'修改学生信息',
						msg:returndata ? "修改成功..." : "修改失败!!!" ,
						showType:'show',
						style:{
							top:document.body.scrollTop+document.documentElement.scrollTop + 40,
						}
			  });
			   
		  }  	  
	 });  
 }
 