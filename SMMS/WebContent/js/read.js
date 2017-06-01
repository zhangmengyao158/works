 var nidParam = location.href.substring(location.href.indexOf("?"));

function check(){ 
	var cauthor = document.getElementById;
	var content = document.getElementById("ccontent");
	if($("#cauthor").val() == ""){
		alert("用户名不能为空！！");
		return false;
	}else if($("#ccontent").val() == ""){
		alert("评论内容不能为空！！");
		return false;
	}

	var params = $("#commentForm").serialize();  //serialize  序列表表格内容为字符串。

	alert("2");
   //将评论内容添加到数据库    并显示出来
	$.post("comment/add"+nidParam, params, function(data){
		if(data){
			alert(data);
			alert(data.ccontent);
			$("#commentContent tr:first").before("<tr><td colspan='3'>"+ data.ccontent +
	    	 "</td><td>"+ data.cdate + "</td><td>" +data.cip+
	    	 "</td><td>"+ data.cauthor+ "</td></tr>");
		}
	},"json"); 
	return false;  //不让submit提交
}
   

// //取到当前新闻的评论信息
 $.get("comment/list"+ nidParam, function(data){
	 alert(nidParam);
     var commentStr = "";
     if(data.length >0 ){
     for(var i = 0;i<data.length;i++){
    	 commentStr += "<tr><td colspan='3'>" + data[i].ccontent +
    	 "</td><td>"+ data[i].cdate + "</td><td>" +data[i].cip+
    	 "</td><td>"+ data[i].cauthor+ "</td></tr>"
     }
    $("#commentContent tr:first").before(commentStr);
 }else{
	 $("#commentContent tr:first").before("<tr><td colspan='6'> 暂无评论！ </td></tr>");
 }
     //alert(commentStr);
	 
 },"json"); 
 
 
//2.异步取到所有主题信息
 $.post("topic/list",function(data){
	$("#class_month").empty();
	for(var i = 0 ; i < data.length; i++){
		$("#class_month").append("<a href='page/news_read.jsp'><b>"+data[i].tname+ "</b></a>");		
	}	 
 },"json");
 
//3.异步取到根据新闻类型的新闻信息
 $("#china").empty();
 $("#inter").empty();
 $("#happy").empty();
 $.get("news/typeNews",function(data){ 
		for(var i= 0; i<data.length;i++){
			if(data[i].ntid==1){
			 $("#china").append("<li><a href='page/news_read.jsp'><b>"+ data[i].ntitle +"</b></a></li>");	
			}else if(data[i].ntid==2){
			 $("#inter").append("<li><a href='page/news_read.jsp'><b>"+ data[i].ntitle +"</b></a></li>");	
			}else if(data[i].ntid==5){
			 $("#happy").append("<li><a href='page/news_read.jsp'><b>"+ data[i].ntitle +"</b></a></li>");	
			}
		}
		 
	  },"json");
 
 var loginStr;
 
 
   