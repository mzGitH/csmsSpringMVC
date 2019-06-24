<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<title>后台权限管理界面</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link rel="stylesheet" href="../layui/css/layui.css" media="all">
		<style>
		.not_border_left {
			border-left: none !important;
		}
		.backRoleSysModel-con{
			padding: 0 15px 15px 15px;
			margin-bottom:50px;
		}
		</style>
	</head>
	<body>
		<div class="backRoleSysModel-con">
			<blockquote class="layui-elem-quote not_border_left">
				<form class="layui-form" action="">	
					<div class="layui-inline">
						<div class="layui-input-inline">
							<select name="backrolemodel" id="backrolemodel" lay-filter="backrolemodel">	
								<option value="00">请选择角色</option>			
								<option value="1">超级管理员</option>	
								<option value="2">数据管理员</option>					
						    </select>
						</div>
						<div class="layui-inline">
							<button id="btnselbackrole" type="button" class="layui-btn layui-bg-blue">查询</button>							
						</div>
					</div>		
				</form>
			</blockquote>
			
			<table class="layui-hide" id="backrolesystemmodel" lay-filter="backrolesystemmodel"></table>

			<script type="text/html" id="selectbar">
				<input type="checkbox" value="{{d.id}}" title="授予" lay-filter="lockDemo" {{ d.isdelete == false ? 'checked' : '' }}>
			</script>		
		</div>
		<script src="../layui/layui.js" charset="utf-8"></script>
		<script src="../js/jquery-3.3.1.js"></script>
		<script>
		layui.use([ 'table', 'form', 'layer', 'laydate', 'laytpl', 'element' ],function() {
			var table = layui.table;
			form = layui.form, layer = layui.layer,
			laydate = layui.laydate, laytpl = layui.laytpl,
			element = layui.element;

			/*表格信息加载*/
			table.render({
				elem : '#backrolesystemmodel',
				id:'backrolesys',
				url : '../getsysmenu.action?page=1&limit=10',
				title : '系统菜单数据表',
				height: "full-165",
				skin : 'line',
				even : true,
				cols : [ 
				     [ {
						type : 'numbers',
						title : '序号',
						align : 'center',
						width : 80
					}, {
						field : 'name',
						title : '菜单名',
						align : 'center'
					}, {
						field : 'chinese',
						align : 'center',
						title : '菜单中文名',
					}, {
						field : 'nvaurl',
						align : 'center',
						title : '功能页面'
					},{
						field : 'deepth',
						align : 'center',
						title : '菜单层次'
					},{
						field : 'parentid',
						align : 'center',
						title : '所属父菜单'
					},{
						field : 'displayorder',
						align : 'center',
						title : '显示顺序'
					},{
						field: 'isdelete',
						align: 'center',
						title: '设置权限',
						templet: '#selectbar',
						width:150
					}] 
				 ]
			});
			
			//取消或授予权限
			form.on('checkbox(lockDemo)', function(obj) {
				if(obj.elem.checked){
					$.ajax({
						type : 'get',
						url : '../addremoverole.action?powerid=1&menuid='+this.value,
						datatype : 'json',
						success : function(data) {
							if (data.code == "0") {		
								layer.msg('授权成功！', {icon: 1}); 
							} else {
			    	        	layer.msg('授权失败！', {icon: 2});
							}
						},
						error : function() {}
					});
				}
				else{
					$.ajax({
						type : 'get',
						url : '../addremoverole.action?powerid=0&menuid='+this.value,
						datatype : 'json',
						success : function(data) {
							if (data.code == "0") {	
								layer.msg('取消授权成功！', {icon: 6}); 				
							} else {
								layer.msg('取消授权失败！', {icon: 2}); 
							}
						},
						error : function() {}
					});
				}				
			});
		});
		</script>
	</body>
</html>