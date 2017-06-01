$('#gradeInfo').datagrid({
	fitColumns : true,
	url:'grade/list',
	singleSelect : true,
	pagination :true,
	columns : [ [ {
		field : 'gid',
		title : '成绩编号',
		width : 20,
		align:'center'
	}, {
		field : 'sno',
		title : '学生学号',
		width : 100,
		align:'center'
	}, {
		field : 'cno',
		title : '课程编号',
		width : 100,
		align:'center'
	}, {
		field : 'score',
		title : '分数',
		width : 100,
		align:'center'
	} , {
		field : 'operator',
		title : '操作',
		width : 50,
		align:'center',
		formatter: function(value,row,index){
			
			var str = '<a class="operatorBtn" href="javascript:void(0)" onClick="operatorFun(1, ' 
				+ row.gid + ')">修改</a>&nbsp;'
				+ '<a class="operatorBtn" href="javascript:void(0)" onClick="operatorFun(2, ' 
				+ row.gid + ')">删除</a>'
				+ '<script>$(".operatorBtn").linkbutton();</script>';
			return str;
		}

	} ]]
});


function operatorFun(operType, id){
	switch(operType){
	case 1:
		parent.openMT(id);
		break;	
	case 2:
		stopGrade(id);
		break;
	}
}

function stopGrade(id){
	$.messager.confirm('删除成绩','是否确认删除此成绩？', function(r){
		if(r){
				$.get("grade/archive?gid="+ id,function(data){
					if(data){
						$("#gradeInfo").datagrid("reload");
					}
					$.messager.show({
						title:'删除成绩',
						msg:data ? "删除成功..." : "删除失败!!!" ,
						showType:'show',
						style:{
							top:document.body.scrollTop+document.documentElement.scrollTop + 40,
						}
					});
			},"json");
		} 
	});
}

