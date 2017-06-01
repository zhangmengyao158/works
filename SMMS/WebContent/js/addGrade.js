	//$("#currPic").attr("src",data.picPath);
	
	$.get("grade/list", function(d){
	   // alert(JSON.stringify(d));  //把js的json对象转换成json字符串
	   for(var i = 0;i<d.length;i++){
		   $("#ntid").append("<option value='"+d[i].tid+"' "
				   +(d[i].tid == d.ntid ? "selected" : "")+">"
				   + d[i].tname+ "</option>");
	   }
	 },"json");
 
 
  
 //添加学生成绩
 function addGrade(){
	 //jquery对象转dom对象 jqueryObj[0]
	 
	 //dom对象转jquery对象 $(domObj)
	 //alert($( "#aTopic" )[0]);
	 var formData = new FormData($( "#aGrade" )[0]);  
	 alert("进了");
	 $.ajax({  
		  url: 'grade/add' ,  
		  type: 'POST',  
		  data: formData,  
		  async: false,  
		  cache: false,  
		  contentType: false,  
		  processData: false,  
		  success: function (returndata) {  
				  $.messager.show({
						title:'添加成绩',
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
 