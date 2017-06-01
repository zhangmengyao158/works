 $.get("grade/detail?gid=" + gid , function(data){
   // alert(JSON.stringify(data));  //把js的json对象转换成json字符串
    //alert(data.tid);
 	$("#mgid").val(data.gid);
 	$("#msno").val(data.sno);
 	$("#mcno").val(data.cno);
 	$("#mscore").val(data.score);
	
	$.get("grade/list", function(d){
		   // alert(JSON.stringify(d));  //把js的json对象转换成json字符串
		   for(var i = 0;i<d.length;i++){
			   $("#ntid").append("<option value='"+d[i].tid+"' "
					   +(d[i].tid == data.ntid ? "selected" : "")+">"
					   + d[i].tname+ "</option>");
		   }
		 },"json");
 },"json");
 
 //修改新闻
 function modifyGrade(){
	 //jquery对象转dom对象 jqueryObj[0]
	 
	 //dom对象转jquery对象 $(domObj)
	// alert($( "#mNews" )[0]);
	 var formData = new FormData($( "#mGrade" )[0]);  
	 alert("进了");
	 $.ajax({  
		  url: 'grade/modify' ,  
		  type: 'POST',  
		  data: formData,  
		  async: false,  
		  cache: false,  
		  contentType: false,  
		  processData: false,  
		  success: function (returndata) {  
			  if(returndata){
				 parent.closeMT();
				 $('#gradeInfo').datagrid("reload");
			  }
			  $.messager.show({
						title:'修改成绩',
						msg:returndata ? "修改成功..." : "修改失败!!!" ,
						showType:'show',
						style:{
							top:document.body.scrollTop+document.documentElement.scrollTop + 40,
						}
			  });
			   
		  }  	  
	 });  
 }
 