$("#leftSider").accordion({
	fit:true,
});

var urlJson = {"编辑学生":"editStudents.jsp","添加学生":"addStudents.jsp","编辑教师":"editUsers.jsp","编辑成绩":"editGrade.jsp","添加成绩":"addGrade.jsp","添加教师":"addUser.jsp"}

$(".menutree").tree({
	onClick: function(node){
		var nt = node.text;
		if($('#main').tabs('exists',nt)){//判断主面板是否存在
			//打开主面板
			//alert(nt);
			$('#main').tabs('select',nt);
		}else{
			//添加面板
			if(urlJson[nt]){
				$('#main').tabs('add',{    
				    title:nt,    
				    href:"back/"+urlJson[nt],    
				    closable:true
				});
			}else{
				$('#main').tabs('add',{    
				    title:nt,    
				    content:'<h1>'+ nt +'</h1>',    
				    closable:true         
				});
			} 
		}	
	}
});
$("#main").tabs({
	fit:true
});
var cnid;

function openDN(id){
	cnid=id;
	alert(id);
	$("#detailStudents").dialog({
		title:'detailStudents',
		width: 800,    
	    height: 400,    
	    closable: true,
	    modal:true,
	    href:'back/detailStudents.jsp'
	});
}

function openAN(id){
	cnid=id;
	$("#addStudents").dialog({
		title:'addStudents',
		width: 800,    
	    height: 400,    
	    closable: true,
	    modal:true,
	    href:'back/addStudents.jsp'
	});
}
 

function openAU(id){
	cnid=id;
	$("#addUser").dialog({
		title:'addUser',
		width: 400,    
	    height: 400,    
	    closable: true,
	    modal:true,
	    href:'back/addUser.jsp'
	});
}
function openMN(id){
	cnid=id;
	alert(id);
	$("#modifyStudents").dialog({
		title:'modifyStudents',
	    width: 400,    
	    height:300,    
	    closable: true,
	    modal:true,
	    href:'back/modifyStudents.jsp'
	});
}
function openSN(){
	$("#stopStudents").dialog({
		title:'stopStudents',
		width: 400,    
	    height: 200,    
	    closable: true,
	    top:80,
	    modal:true
	});
}
function openEU(id){
	cnid=id;
	$("#editUsers").dialog({
		title:'editUsers',
	    width: 800,    
	    height:400,    
	    closable: true,
	    modal:true,
	    href:'back/editUsers.jsp'
	});
}
var gid;
function openET(id){
	gid=id;
	$("#editGrade").dialog({
		title:'editGrade',
	    width: 800,    
	    height:400,    
	    closable: true,
	    modal:true,
	    href:'back/editGrade.jsp'
	});
}
function openMT(id){
	gid=id;
	$("#modifyGrade").dialog({
		title:'modifyGrade',
	    width: 400,    
	    height:200,    
	    closable: true,
	    modal:true,
	    href:'back/modifyGrade.jsp'
	});
}
function openAN(id){
	gid=id;
	$("#addGrade").dialog({
		title:'#addGrade',
		width: 800,    
	    height: 400,    
	    closable: true,
	    modal:true,
	    href:'back/#addGrade.jsp'
	});
}

function openMU(id){
	usid=id;
	$("#modifyUser").dialog({
		title:'modifyUser',
	    width: 300,    
	    height:360,    
	    closable: true,
	    modal:true,
	    href:'back/modifyUser.jsp'
	});
}
function closeMN(){  //关闭修改新闻窗口
	$("#modifyStudents").dialog("close",true);
}
function closeMT(){  //关闭修改新闻窗口
	$("#modifyGrade").dialog("close",true);
}
function closeMU(){  //关闭修改新闻窗口
	$("#modifyUser").dialog("close",true);
}

