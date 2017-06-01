$('#userInfo').datagrid({
	fitColumns : true,
	url:'user/list',
	singleSelect : true,
	pagination :true,
	columns : [ [ {
		field : 'usid',
		title : '编号',
		width : 20,
		align:'center'
	}, {
		field : 'uname',
		title : '教师名',
		width : 80,
		align:'center'
	}, {
		field : 'upwd',
		title : '密码',
		width : 60,
		align:'center'
	} , {
		field : 'sex',
		title : '性别',
		width : 40,
		align:'center'
	} , {
		field : 'tel',
		title : 'Tel',
		width : 100,
		align:'center'
	} , {
		field : 'user_drop',
		title : '教师权限',
		width : 40,
		align:'center'
	}  , {
		field : 'operator',
		title : '操作',
		width : 50,
		align:'center',
		
  
		formatter: function(value,row,index){
			var str =  '<a class="operatorBtn" href="javascript:void(0)" onClick="operatorFun(1, ' 
				+ row.usid + ')">修改</a>&nbsp;'
				+ '<a class="operatorBtn" href="javascript:void(0)" onClick="operatorFun(2, ' 
				+ row.usid + ')">停用</a>'
				+ '<script>$(".operatorBtn").linkbutton();</script>';
			return str;
			 
		}
	
	} ]]
 

});


function operatorFun(operType, id){
	switch(operType){
	case 1:
		parent.openMU(id);
		break;	
	case 2:
		stopUser(id);
		break;
	}
}

function stopUser(id){
	 
		$.messager.confirm('停用用户','是否确认停用此用户？', function(r){
			if(r){
					$.get("user/archive?cnid="+ id,function(data){
						if(data){
							$("#userInfo").datagrid("reload");
						}
						$.messager.show({
							title:'归档用户',
							msg:data ? "归档成功..." : "归档失败!!!" ,
							showType:'show',
							style:{
								top:document.body.scrollTop+document.documentElement.scrollTop + 40,
							}
						});
				},"json");
			} 
		});
 
}

