<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML >
<html>
	<head>
		<title>EASYUI DEMO</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="description" content="This is my page">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

		<script type="text/javascript"
			src="js/jquery-easyui-1.5.1/jquery.min.js">
</script>
		<script type="text/javascript"
			src="js/jquery-easyui-1.5.1/jquery.easyui.min.js">
</script>
		<script type="text/javascript"
			src="js/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js">
</script>
		<link rel="stylesheet"
			href="js/jquery-easyui-1.5.1/themes/default/easyui.css"
			type="text/css"></link>
		<link rel="stylesheet" href="js/jquery-easyui-1.5.1/themes/icon.css"
			type="text/css"></link>

		<script type="text/javascript">
$(function() {
	$('#grid').datagrid( {
		url : 'jieguoshow.action',
		pageSize : 15,
		pageList : [ 15, 20, 30 ],
		idField : 'id',
		checkOnSelect : false,
		selectOnCheck : false,
		frozenColumns : [ [ {
			field : 'id',
			title : 'id',
			checkbox : true
		} ] ],
		columns : [ [ {
			field : 'areas',
			title : '区域',
			width : 100,
			align : 'center'
		},{
			field : 'waibaogongsi',
			title : '外包公司',
			width : 85,
			align : 'center'
		},{
			field : 'renyuanbianhao',
			title : '人员编号',
			width : 85,
			align : 'center'
		},{
			field : 'xingming',
			title : '姓名',
			width : 70,
			align : 'center'
		}, {
			field : 'xb',
			title : '姓别',
			width : 50,
			align : 'center'
		}, {
			field : 'shengri',
			title : '生日',
			width : 80,
			align : 'center'
		}, {
			field : 'zgxl',
			title : '最高学历',
			width : 80,
			align : 'center'
		}, {
			field : 'zgxlbyyx',
			title : '毕业院校',
			width : 200,
			align : 'center'
		}, {
			field : 'ywdymc',
			title : '部门',
			width : 120,
			align : 'center'
		}, {
			field : 'banzu',
			title : '班组',
			width : 150,
			align : 'center'
		}, {
			field : 'ywfw',
			title : '岗位',
			width : 150,
			align : 'center'
		}, {
			field : 'shenfenzheng',
			title : '身份证',
			width : 150,
			align : 'center'
		}, {
			field : 'shenqingriqi',
			title : '申请日期',
			width : 100,
			align : 'center'
		}, {
			field : 'shenheriqi',
			title : '审批日期',
			width : 100,
			align : 'center'
		}, {
			field : 'shenqingren',
			title : '申请人',
			width : 80,
			align : 'center'
		}, {
			field : 'state',
			title : '状态',
			width : 80,
			align : 'center'
		} ] ]
	});
});

serializeObject = function(form) {
	var o = {};
	$.each(form.serializeArray(), function(index) {
		if (o[this['name']]) {
			o[this['name']] = o[this['name']] + "," + this['value'];
		} else {
			o[this['name']] = this['value'];
		}
	});
	return o;
};
	
	function guidang() {
		var rows = $('#grid').datagrid('getChecked');
		//var rows = $('#grid').datagrid('getSelected');
		//var rows = $('#grid').datagrid('getSelections');
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要归档当前选中的项目？', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					$.ajax({
					type: 'POST',
						url : '${pageContext.request.contextPath}/guidang.action',
						data : {
							ids : ids.join(','),
						},
						dataType : 'json',
						success : function(r) {
							$('#grid').datagrid('load');
							$('#grid').datagrid('uncheckAll');
							$('#grid').datagrid('unselectAll');
							$.messager.show({
								title : '提示',
								msg : r.msg
							});
						}
					});
				}
			});
		} else {
			$.messager.show({
				title : '提示',
				msg : '请勾选要审批的记录！'
			});
		}
	}

</script>

		<style type="text/css">
body {
	margin: 1px
}
</style>

	</head>
	<body align="center">

		<div id="tb" style="padding: 3px"
			data-options="title:'查询条件',border:false">
			<form id="shenheForm">
				<a href="javascript:void(0);" class="easyui-linkbutton"
					data-options="iconCls:'icon-ok'" onclick="guidang();">归档</a>
			</form>
		</div>
		<div>
			<table id="grid" toolbar="#tb" title="请知悉后归档" iconCls="icon-search"
				data-options="singleSelect:true,rownumbers:true,pagination:true,striped:true,fitColumns:true"></table>
		</div>

		
	</body>

</html>
