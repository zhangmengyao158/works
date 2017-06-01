 
 
  
 //修改新闻
 function addUser(){
	 //jquery对象转dom对象 jqueryObj[0]
	 
	 //dom对象转jquery对象 $(domObj)
//	 alert($( "#aUser" )[0]);
	 var formData = new FormData($( "#aUser" )[0]);  
//	 alert("进了");
	 $.ajax({  
		  url: 'user/add' ,  
		  type: 'POST',  
		  data: formData,  
		  async: false,  
		  cache: false,  
		  contentType: false,  
		  processData: false,  
		  success: function (returndata) {  
				  $.messager.show({
						title:'添加教师',
						msg:returndata  ? "添加成功..." : "添加失败!!!" ,
						showType:'show',
						style:{
							top:document.body.scrollTop+document.documentElement.scrollTop + 40,
						}
					});
		  }  	  
	 });  
	 return false;
 }
 