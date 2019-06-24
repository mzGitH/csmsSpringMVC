<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>后台用户管理</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="../layui/css/layui.css" media="all">
	<style>
		.blogUser-con .layui-table-view {
			border: none;
		}
		
		.blogUser-con .layui-table-box {
			margin-top: 10px;
		}
		
		.blogUser-con {
			padding: 0 15px 15px 15px;
			margin-bottom:50px;
		}
		.blogUser-con  .layui-table-tool-self{
			display:none;
		}
		.blogUser-con .not_border_left {
			border-left: none !important;
		}
		
		.blogUser-con .blogUser dl dd.layui-this {
			background-color: #1E9FFF !important;
		}
		
		.blogUser-con .hide {
			display: none;
		}
		
		.blogUser-con .show {
			display: block;
		}
		
		.blogUser-con .btn_size {
			height: 28px !important;
			line-height: 28px !important;
		}
		
		.blogUser-con .layui-table-body table tbody .layui-table-hover {
			background: #fffdd3 !important;
		}
		
		.blogUser-con .layui-table-body table tbody .layui-table-click {
			background: #fdef9b !important;
		}
		
		.blogUser-con .layui-table, .layui-table-view {
			border: none;
			margin-top: 0;
		}
		
		#add-AdminUser {
			display: none;
			z-index: 999 !important;
		}
		
		#add-AdminUser .artTypeLayer {
			width: 90%;
			margin-left: auto;
			margin-right: auto;
			padding-top: 20px;
		}
		.adminuserdetail{
			padding:20px;
			display: none;
		}
		.adminuserdetail table tr td{
			padding: 15px;text-align: center;
		}
		.adminuserdetail .tdbck{
			background: #f2f2f2;
			width: 30%;
		}
	</style>
</head>
<body>

	<div class="blogUser-con">
		<blockquote class="layui-elem-quote not_border_left">
			<form class="layui-form" action="">
			  	<div class="layui-input-inline">
					<input type="text" name="queryrealname" id="queryrealname" placeholder="请输入用户名" class="layui-input" autocomplete="off">
			    </div>
			    <div class="layui-inline">
	     	   		<select name="queryroleid" id="queryroleid" lay-filter="queryroleid">
						  <option value="00">请选择用户类型</option>
					</select> 
			    </div>
			    <div class="layui-inline">
	     	   		<button id="btnselfrontinfo" type="button" class="layui-btn layui-bg-blue">查询</button>
			    </div>
				<button type="button" class="layui-btn layui-bg-blue" id="addAdminUser" lay-event="addAdminUser" lay-filter="addAdminUser" style="margin-left: 10px;">新增用户</button>
			</form>
		</blockquote>

		<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-xs" lay-event="seladminuser">查看</a>
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</script>

		<!-- 表格开始 -->
		<table class="layui-hide" name="adminUser" id="adminUser" lay-filter="adminUser"></table>
		<!-- 表格结束 -->
		
		<!-- 弹出新增管理员用户对话框 -->
		<div id="add-AdminUser"> <!-- div必须要被定义为display:none样式  -->
			<div class="artTypeLayer">
				<form class="layui-form" action="">
					<div class="layui-form-item">
						<label class="layui-form-label">用户名:</label>
						<div class="layui-input-block">
							<input type="text" name="userid" id="userid" lay-verify="userid" autocomplete="off" placeholder="请输入管理员用户名" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">真实姓名:</label>
						<div class="layui-input-block">
							<input type="text" name="realname" id="realname" autocomplete="off" placeholder="请输入真实姓名" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">联系电话:</label>
						<div class="layui-input-block">
							<input type="text" name="mobile" id="mobile" autocomplete="off" placeholder="请输入联系电话" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">登录密码:</label>
						<div class="layui-input-block">
							<input type="password" name="pwd" id="pwd" autocomplete="off" placeholder="请输入登录密码" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">再次确认登录密码:</label>
						<div class="layui-input-block">
							<input type="password" name="confirmpwd" id="confirmpwd" autocomplete="off" placeholder="请再次输入登录密码" class="layui-input">
						</div>
					</div>
				    <div class="layui-form-item">
				      <label class="layui-form-label">用户类型:</label>
				      <div class="layui-input-block">
				       	<select id="userRole">
						  <option value="00">请选择用户类型</option>
						  <option value="1">超级管理员</option>
						  <option value="2">数据管理员</option>
						</select> 
				      </div>
				    </div>
				</form>
			</div>
		</div>
		<!-- 弹出新增管理员用户对话框结束 -->
	</div>
	<script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
	<script src="../layui/layui.js" charset="utf-8"></script>
	<script src="../js/loadselect.js" charset="utf-8"></script>
	<script>
	layui.use([ 'table', 'form', 'layer', 'laydate', 'laytpl', 'element' ], function() {
		var table = layui.table, form = layui.form, 
			layer = layui.layer, $ = layui.jquery,
			laydate = layui.laydate, laytpl = layui.laytpl,
			element = layui.element;
	
		//调用方法加载select管理员角色
		loadAdminRole("queryroleid",form); 
		
		/*加载表格*/
		table.render({
			elem : '#adminUser',
			id:'adminuser',
			url : '../admin/getuser',
			title : '后台管理员用户数据表',
			height: "full-160",
			skin : 'line',
			even : true,
			cols : [ 
			     [ {
					field : 'userid',
					align : 'center',
					title : '用户名',
					width : 100
				}, {
					field : 'realname',
					align : 'center',
					title : '真实姓名',
					width : 100
				}, {
					field : 'pwd',
					title : '密码',
					align : 'center',
					width : 150
				},{
					field : 'createtime',
					align : 'center',
					title : '创建时间'
				},{
					field : 'name',
					align : 'center',
					title : '用户角色'
				},{
					field : 'description',
					align : 'center',
					title : '角色描述'
				},{
					title : '操作',
					toolbar : '#barDemo',
					align : 'center'
				} ] 
			 ],
			 page: {
					layout: ['prev', 'page', 'next', 'skip', 'count', 'limit'],
					groups: 5,
					limit: 10,
					limits: [10, 20, 30, 40, 50],
					theme: '#1E9FFF',						
			 },
		});
		/*加载表格结束*/
		
		/* 点击查询对网站用户进行筛选 */
		$("#btnselfrontinfo").click(function() {
			table.reload('adminuser', {
				method : 'post',
				where : {
					'realname' : $("#queryrealname").val().trim(),
					'roleid': $("#queryroleid").val()
						},
				page : {
					curr : 1
					}
			});
		})
		/*点击查询加载表格数据结束*/
		
		
		
		/*
		 *添加一个管理员用户
		*/
		$("#addAdminUser").click(function(){
			loadAdminRole("userRole",form);
				
			layer.open({
				type : 1,
				title : '管理员用户添加',
				area : [ '540px', '575px' ],
				shade : 0.4,
				content : $('#add-AdminUser'),
				btn : [ '保存', '返回' ],
				yes : function() {
					//获取
					var userid = $("#userid").val().trim();
					var realname = $("#realname").val().trim();
					var pwd = $("#pwd").val().trim();	
					var confirmpwd = $('#confirmpwd').val().trim();
					var mobile = $('#mobile').val().trim();
					var userRole = $('#userRole').val().trim();
					if(userid == "") {
						layer.tips('不能为空', '#userid');
						return;
					} 
					if(realname==""){
						layer.tips('不能为空', '#realname');
						return;
					}
					if(pwd==""){
						layer.tips('不能为空', '#pwd');
						return;
					}
					if(confirmpwd==""){
						layer.tips('不能为空', '#confirmpwd');
						return;
					}
					if(confirmpwd != pwd) {
						layer.tips('密码不一致', '#confirmpwd');
						return;
					} 
					if(userRole == '00') {
						layer.tips('请选择用户角色', $("#userRole").parent());
						return;
					}
					
					//构建参数 
					var obj = {
						"userid":userid,
						"mobile":mobile,
						"realname":realname,
						"pwd":pwd,
						"roleid":userRole,	 
						};
						
					//alert(param)
					$.ajax({
						url : "../admin/addadminuser",
						type : "POST",
						data : obj, //直接传对象参数 
						dataType : 'json',
				
						success : function(data) {
							if (data.code == 0) {
								layer.confirm(data.msg, {
								  btn: ['确定'],
								  icon:1
								}, function(){
									table.reload('adminuser', {
										method : 'post',
											where : {
													'realname' : $("#queryrealname").val().trim(),
													'roleid': $("#queryroleid").val()
													},
											page : {
													curr : 1
													}
										});
									layer.closeAll();
								});
							}else{
								layer.confirm(data.msg, {
								  btn: ['确定'],
								  icon:2
								});
							}
						},
						error : function() {}
					});						
				},
				btn2 : function() {layer.closeAll();}
			});
		});
	});
	
	</script>
</body>
</html>