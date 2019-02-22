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
		url : 'lindaoshow.action',
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
		}, {
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
			field : 'age',
			title : '年龄',
			width : 50,
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
			align : 'center',
			formatter : function(value, row, rowIndex) {
				return "<a href='javascript:showinfo(" + row.id
									+ ")'>" + row.shenfenzheng + "</a>";
			}
		}, {
			field : 'shenqingriqi',
			title : '申请日期',
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

function showinfo(id) {
	$('#info').dialog('open');
	$('#ff').form('load', 'showinfo.action?id='+id);
}

	function rollback() {
		var rows = $('#grid').datagrid('getChecked');
		//var rows = $('#grid').datagrid('getSelected');
		//var rows = $('#grid').datagrid('getSelections');
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要退回当前选中的项目？', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					$.ajax({
						type: 'POST',
						url : '${pageContext.request.contextPath}/lindaorollback.action',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(r) {
							$('#grid').datagrid('reload');
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
				msg : '请勾选要退回的记录！'
			});
		}
	}
	
	function shenhe() {
		var b = document.getElementById("wbgs");
		if (b.value == "all") {
			$.messager.alert({
				title : '提示',
				msg : '没选择外包公司，请重新选择！'
			});
			return false;
		}
		var rows = $('#grid').datagrid('getChecked');
		//var rows = $('#grid').datagrid('getSelected');
		//var rows = $('#grid').datagrid('getSelections');
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要审批当前选中的项目？', function(r) {
				if (r) {
					for ( var i = 0; i < rows.length; i++) {
						ids.push(rows[i].id);
					}
					$.ajax({
						type: 'POST',
						url : '${pageContext.request.contextPath}/lindaoshenhe.action',
						data : {
							ids : ids.join(','),
							wbgs : $('#wbgs').val()
						},
						dataType : 'json',
						success : function(r) {
							var wb = document.getElementById("wbgs");
							wb.options[0].selected = true;
							$('#grid').datagrid('reload');
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

document.onkeydown = function() {
	if (event.keyCode == 13) {
		alert("Enter");
		$('#grid').datagrid('load',
				serializeObject($('#shenheForm')));
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
				外包公司：
				<select id="wbgs" name="wbgs">
					<option value="all" selected>
						请选择
					</option>
					<option value="邮电人才">
						邮电人才
					</option>
					<option value="红海">
						红海
					</option>
					<option value="盈天">
						盈天
					</option>
					<option value="贯通">
						贯通
					</option>
				</select>
				<a href="javascript:void(0);" class="easyui-linkbutton"
					data-options="iconCls:'icon-ok'" onclick="shenhe();">审核通过</a>
				<a href="javascript:void(0);" class="easyui-linkbutton"
					data-options="iconCls:'icon-undo'" onclick="rollback();">退回</a>
			</form>
		</div>
		<div>
			<table id="grid" toolbar="#tb" title="请审核" iconCls="icon-search"
				data-options="singleSelect:true,rownumbers:true,pagination:true,striped:true,fitColumns:true"></table>
		</div>

		<div id="info" class="easyui-dialog" title="详细信息"
			data-options="modal:true,closed:true,buttons: [{
		text:'关闭',
		iconCls:'icon-ok',
			handler:function(){
			$('#info').dialog('close');
		}
	}]"
			style="width: 500px; height: 500px;">
			<div>
			       <form id="ff" >
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" name="xingming" style="width:100%" data-options="label:'姓名:',required:true">
            </div>
             <div style="margin-bottom:20px">
                <input class="easyui-textbox" name="areas" style="width:100%" data-options="label:'区域:',required:true">
            </div>
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" name="xb" style="width:100%" data-options="label:'姓别:',required:true">
            </div>
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" name="ywfw" style="width:100%" data-options="label:'岗位:',required:true">
            </div>
            <div style="margin-bottom:20px">
                <input class="easyui-textbox" name="shenqingliyou" style="width:100%;height:60px" data-options="label:'申请理由:',multiline:true">
            </div>
             <div style="margin-bottom:20px">
                <input class="easyui-textbox" name="chushenyijian" style="width:100%;height:60px" data-options="label:'初审意见:',multiline:true">
            </div>
        </form>
			</div>
		</div>
		
	</body>

</html>