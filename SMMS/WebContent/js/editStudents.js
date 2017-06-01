$('#studentsInfo').datagrid({
	fitColumns : true,
	url:'students/list',
	singleSelect : true,
	pagination :true,
	columns : [ [ {
		field : 'sno',
		title : '学号',
		width : 20,
		align:'center'
	}, {
		field : 'clname',
		title : '班级',
		width : 40,
		align:'center'
	}, {
		field : 'sname',
		title : '姓名',
		width : 40,
		align:'center'
	}, {
		field : 'ssex',
		title : '性别',
		width : 20,
		align:'center'
	}, {
		field : 'bornDate',
		title : '出生日期',
		width : 50,
		align:'center'
	}, {
		field : 'tel',
		title : '联系电话',
		width : 50,
		align:'center'
	}, {
		field : 'address',
		title : '家庭住址',
		width : 50,
		align:'center'
	}, {
		field : 'ru_date',
		title : '入学时间',
		width : 50,
		align:'center'
	}, {
		field : 'operator',
		title : '操作',
		width : 50,
		align:'center',
		formatter: function(value,row,index){
			var str = '<a class="operatorBtn" href="javascript:void(0)" onClick="operatorFun(3, ' 
				+ row.sno + ')">停用</a>&nbsp;'
				+ '<a class="operatorBtn" href="javascript:void(0)" onClick="operatorFun(2, ' 
				+ row.sno + ')">修改</a>&nbsp;'
				+ '<a class="operatorBtn" href="javascript:void(0)" onClick="operatorFun(1, ' 
				+ row.sno + ')">详情</a>'
				+ '<script>$(".operatorBtn").linkbutton();</script>';
			return str;
		}

	} ]]
});


function operatorFun(operType,id){
	switch(operType){
	case 1:
		parent.openDN(id);
		break;	
	case 2:
		parent.openMN(id);
		break;
	case 3:
		stopStudents(id);
		break;
	}
}

function stopStudents(id){
	$.messager.confirm('停用该学生','是否确认停用此学生信息？', function(r){
		if(r){
				$.get("students/archive?cnid="+ id,function(data){
					if(data){
						$("#studentsInfo").datagrid("reload");
					}
					$.messager.show({
						title:'归档学生信息',
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

