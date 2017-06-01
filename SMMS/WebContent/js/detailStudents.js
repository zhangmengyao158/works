 $.get("students/detail?cnid=" + cnid , function(data){
	alert(data);
	$("#dsno").html(data.sno);
	$("#dclname").html(data.clname);
	$("#dsname").html(data.sname);
	$("#dssex").html(data.ssex);
	$("#dbornDate").html(data.bornDate);
	$("#dtel").html(data.tel);
	$("#daddress").html(data.address);
	$("#dru_date").html(data.ru_date);
 },"json");