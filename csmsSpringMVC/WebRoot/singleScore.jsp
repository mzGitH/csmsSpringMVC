<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link href="layui/css/layui.css" rel="stylesheet" type="text/css" />
<style>
.text-center {
	text-align: center;
}body {
    background-color: rgb(209, 207, 207);
    overflow: hidden;
      overflow-y: scroll;
    
}

body::-webkit-scrollbar {
        display: none;
    }
</style>
<title>个人成绩查看页面</title>
</head>

<body>
	<div class="layui-container">
		<div class="layui-card">
			<div class="layui-card-header">
				<div class="layui-row">
					<span class="layui-breadcrumb"> <a href="home.jsp">首页</a> <a><cite>个人成绩</cite></a></span>
				</div>
			</div>
			<div class="layui-card-header text-center">
				<div class="layui-row text-center">
					<h1>个人成绩查看页面</h1>
				</div>
			</div>
			<div class="layui-card-body">
				<div class="layui-row layui-form">
					<div class="layui-input-inline">
						<select name="college" id="college" lay-filter="college"
							lay-verify="required" lay-search="">
							<option value="0">请选择或输入学院名称</option>
							<c:forEach items="${listcollege}" var="obj">
								<option value="${obj.collegeid }">${obj.collegename }</option>
							</c:forEach>
						</select>
					</div>
					<div class="layui-input-inline">
						<select name="major" id="major" lay-filter="major"
							lay-verify="required" lay-search="">
							<option value="">请选择或输入专业名称</option>
						</select>
					</div>
					<div class="layui-input-inline">
						<select name="classes" id="class" lay-filter="class"
							lay-verify="required" lay-search="">
							<option value="">请选择或输入班级名称</option>
						</select>
					</div>
					<div class="layui-input-inline" style="margin-left: -10px;">
						<button type="button" class="layui-btn layui-btn" lay-submit
							lay-filter="search">查询</button>
					</div>
				</div>
				<div class="layui-row">
					<table class="layui-table" id="scoretable" lay-filter="demo"></table>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
<script src="layui/layui.all.js"></script>
<script src="js/jquery-2.1.1.min.js" charset="utf-8"></script>
<script id="barDemo" type="text/html">
    <button class="layui-btn layui-btn-sm layui-bg-green query">查看详情</button>
</script>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
  </div>
</script>
<script type="text/javascript">
	layui.use([ 'table', 'form', 'jquery', 'layer' ],function() {
		var layer = layui.layer;
		/* 页面加载动态表格绑定数据 */
		var table = layui.table;
		var ins1 = table.render({
			id : 'tableOne',
			elem : '#scoretable',
			toolbar : '#toolbarDemo',
			height : 'full-200', //高度最大化减去差值,
			url : 'getscore.action?op=single',
			page : true,
			even : true,
			limit : 10,
			limits : [ 10, 15, 20 ],
			skin : "nob",
			cellMinWidth : 35, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
			//,toolbar: '#toolbarDemo'
			title : '用户数据表',
			cols : [ [
					{
						align : 'center',
						field : '',
						width : 78,
						title : '序号',
						type : 'numbers'
					},
					{
						align : 'center',
						field : 'userid',
						title : '学号/工号',
						width : 130
					},
					{
						align : 'center',
						field : 'username',
						title : '姓名',
						width : 100,
						templet : function(data) {
							if (data.protype == 1
									|| data.protype == 2) {
								return data.username;
							} else {
								return data.teausername;
							}
						}
					},
					{
						align : 'center',
						field : 'scorenumber',
						title : '平均成绩',
						width : 100
					},
					{
						align : 'center',
						field : 'collegename',
						width : 130,
						title : '学院名称',
						templet : function(data) {
							if (data.protype == 1
									|| data.protype == 2) {
								return data.collegename;
							} else {
								return data.teacollegename;
							}
						}
					},
					{
						align : 'center',
						field : 'majorname',
						width : 200,
						title : '专业名称',
						templet : function(data) {
							if (data.protype == 1
									|| data.protype == 2) {
								return data.majorname;
							} else {
								return "";
							}
						}
					},
					{
						align : 'center',
						field : 'classname',
						title : '班级名称',
						width : 250,
						templet : function(data) {
							if (data.protype == 1
									|| data.protype == 2) {
								return data.classname;
							} else {
								return "";
							}
						}
					},
					{
						align : 'center',
						field : '',
						title : '操作',
						width : 120,
						toolbar : '#barDemo'
					},
					{
						field : '',
						title : '用户角色id',
						hide : true,
						templet : function(data) {
							if (data.protype == 1
									|| data.protype == 2) {
								return 1;
							} else {
								return 2;
							}
						}
					} ] ]
		});
		/* 下拉框三级联动 */
		var form = layui.form;
		var $ = layui.jquery;
		form.render('select');
		form.on('select(college)',function(data) {
			var hosid = data.value;
			$.ajax({
				type : "post",
				url : "getmajor.action",
				data : {
					collegeid : hosid
				},
				dataType : "json",
				success : function(succ) {
					if (succ == "失败") {
						layer
								.msg("请刷新后重试");
					} else {
						var tmp = '<option value="0">请选择或输入专业名称</option>';
						for ( var i in succ.data) {
							tmp += '<option value="' + succ.data[i].majorid +  '">'
									+ succ.data[i].majorname
									+ '</option>';
						}
						$("#major").html(tmp);
						form.render();
					}
				},
				error : function() {
					layer.msg('请求失败，稍后再试',{icon : 5});
				}

			});
		});
		form.on('select(major)',function(data) {
			var hosid = data.value;
			//alert(hosid);
			$.ajax({
				type : "post",
				url : "getclass.action",
				data : {
					majorid : hosid
				},
				dataType : "json",
				success : function(succ) {
					if (succ == "失败") {
						layer.msg("请刷新后重试");
					} else {
						var tmp = '<option value="0">请选择或输入班级名称</option>';
						for ( var i in succ.data) {
							tmp += '<option value="' + succ.data[i].classid +  '">'
									+ succ.data[i].classname
									+ '</option>';
						}
						$("#class").html(tmp);
						form.render();
					}
				},
				error : function() {
					layer.msg('请求失败，稍后再试',{icon : 5});
				}

			});
		});
		//查询提交
		form.on('submit(search)', function(data) {
			table.reload('tableOne', {
				method : 'post',
				where : {
					'collegeid' : data.field.college,
					'majorid' : data.field.major,
					'classid' : data.field.classes,
				},
				page : {
					curr : 1
				}
			});

			return false;
		});
	});
	$(document).ready(function() {
		//查看详情点击事件
		$(document).on('click',".query",function() {
			var userid = $(this).parent()
					.parent().prev().prev()
					.prev().prev().prev()
					.prev().children().text()
					.trim();
			var usertype = $(this).parent()
					.parent().next().children()
					.text().trim();
			window.location.href = "getscore.action?op=singledetail&userid="
					+ userid
					+ "&usertype="
					+ usertype;
		});
	})
</script>
</html>