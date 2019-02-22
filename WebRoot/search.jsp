<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML >
<html>
	<head>
		<title>EASYUI DEMO</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

		<script type="text/javascript" src="js/jquery-easyui-1.5.1/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>
		<link rel="stylesheet" href="js/jquery-easyui-1.5.1/themes/default/easyui.css" type="text/css"></link>
		<link rel="stylesheet" href="js/jquery-easyui-1.5.1/themes/icon.css" type="text/css"></link>

		<script type="text/javascript">
$(function() {
	$('#grid').datagrid( {
		url : 'search.action',
		pageSize : 15,
		pageList : [ 15, 20, 30 ],
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
		}, {
			field : 'xingming',
			title : '姓名',
			width : 70,
			align : 'center'
		},{
			field : 'xb',
			title : '姓别',
			width : 50,
			align : 'center'
		}, {
			field : 'zgxl',
			title : '最高学历',
			width : 80,
			align : 'center'
		},{
			field : 'zgxlbyyx',
			title : '毕业院校',
			width : 200,
			align : 'center'
		},{
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
		}] ]
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

function searchFun() {
	$('#grid').datagrid('load', serializeObject($('#admin_yhgl_searchForm')));
}
function clearFun() {
	$('#xingming').textbox('setValue','');
	$('#begintime').datebox('setValue','');
	$('#endtime').datebox('setValue','');
	$('#grid').datagrid('load', {});
}

	function toDownLoadExcel(){  
		var begintime = $('#begintime').val();
		var endtime = $('#endtime').val(); 
		var xingming = $('#xingming').val();
		document.getElementById("downLoadExcel").href ="${pageContext.request.contextPath}/daochu.action?begintime=" + begintime +"&endtime=" + endtime + "&xingming=" + xingming;    
	}

</script>

<style type="text/css">
body {
	margin:1px
}
</style>

	</head>
	<body align="center">

		<div id="tb" style="padding: 3px"
			data-options="region:'north',title:'查询条件',border:false">
			<form id="admin_yhgl_searchForm">
				姓名：
				<input id="xingming" class="easyui-textbox" name="xingming" />
				起始日期：<input id="begintime" class="easyui-datebox" name="begintime" />
				终止日期：<input id="endtime" class="easyui-datebox" name="endtime" />
				<a href="javascript:void(0);" class="easyui-linkbutton"
					data-options="iconCls:'icon-search'" onclick="searchFun();">查询</a>
					
				<a href="javascript:void(0);" id="downLoadExcel" class="easyui-linkbutton" iconCls="icon-add" onclick="toDownLoadExcel();">导出excel</a> 
				
				<a href="javascript:void(0);" class="easyui-linkbutton"
					data-options="iconCls:'icon-cancel'" onclick="clearFun();">清空</a>
			</form>
		</div>
		<div>
			<table id="grid" toolbar="#tb" title="新增查询"
				 iconCls="icon-search"
				data-options="singleSelect:true,rownumbers:true,pagination:true,striped:true,fitColumns:true"></table>
		</div>

	</body>

</html>