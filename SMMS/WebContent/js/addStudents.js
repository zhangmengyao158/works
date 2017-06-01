
//	$.get("topic/list", function(d){
//	   // alert(JSON.stringify(d));  //把js的json对象转换成json字符串
//	   for(var i = 0;i<d.length;i++){
//		   $("#antid").append("<option value='"+d[i].tid+"'> "
// 				   + d[i].tname+ "</option>");
//	   }
//	 },"json");
// 

// function addPic(obj){
//	 var picStr = window.URL.createObjectURL(obj.files[0]);// 获取图片上传地址
//	 //alert(picStr);
//	 $("#acurrPic").attr("src",picStr);
//	 
// }
  
 //添加学生
 function addStudents(){
	 //jquery对象转dom对象 jqueryObj[0]
	 
	 //dom对象转jquery对象 $(domObj)
	 alert($( "#aStudents" )[0]);
	 var formData = new FormData($( "#aStudents" )[0]);  
	 alert("进了");
	 $.ajax({  
		  url: 'students/add' ,  
		  type: 'POST',  
		  data: formData,  
		  async: false,  
		  cache: false,  
		  contentType: false,  
		  processData: false,  
		  success: function (returndata) {  
				  $.messager.show({
						title:'添加学生信息',
						msg:returndata ? "添加成功..." : "添加失败!!!" ,
						showType:'show',
						style:{
							top:document.body.scrollTop+document.documentElement.scrollTop + 40,
						}
					});
		  }  	  
	 });  
	 return false;
 }
 