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
<title>学院成绩查看页面</title>
</head>

<body>
	<div class="layui-container">
		<div class="layui-card">
			<div class="layui-card-header">
				<div class="layui-row">
					<span class="layui-breadcrumb"> <a href="home.jsp">首页</a> <a><cite>学院成绩</cite></a>
					</span>
				</div>
			</div>
			<div class="layui-card-header text-center">
				<div class="layui-row text-center">
					<h1>学院成绩查看页面</h1>
				</div>
			</div>
			<div class="layui-card-body">
				<div class="layui-row layui-form">
					<div class="layui-input-inline">
						<div id="college">
							<select name="college" id="college" lay-filter="college"
								lay-verify="required" lay-search="">
								<option value="0">请选择或输入学院名称</option>
								<c:forEach items="${listcollege}" var="obj">
									<option value="${obj.collegeid }">${obj.collegename }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="layui-input-inline" style="margin-left: -10px;">
						<button type="button" class="layui-btn layui-btn" lay-submit
							lay-filter="search">查询</button>
					</div>
					<div class="layui-row">
						<table class="layui-table" id="scoretable" lay-filter="demo"></table>
					</div>
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
	layui.use([ 'table', 'form', 'layer', 'jquery' ], function() {
		var table = layui.table;
		var $ = layui.jquery;
		var layer = layui.layer;
		var form = layui.form;

		//页面加载获取动态表格数据
		table.render({
			id : 'tableOne',
			elem : '#scoretable',
			toolbar : '#toolbarDemo',
			height : 'full-200', //高度最大化减去差值,
			url : 'getscore.action?op=college',
			page : true,
			even : true,
			limit : 10,
			limits : [ 10, 15, 20 ],
			skin : "nob",
			cellMinWidth : 35, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
			//,toolbar: '#toolbarDemo'
			title : '用户数据表',
			cols : [ [ {
				align : 'center',
				field : '',
				width : 200,
				title : '序号',
				type : 'numbers'
			}, {
				align : 'center',
				field : 'collegename',
				width : 340,
				title : '学院名称',
			}, {
				align : 'center',
				field : 'scorenumber',
				title : '平均成绩',
				width : 280
			}, {
				align : 'center',
				field : '',
				title : '操作',
				width : 288,
				toolbar : '#barDemo'
			}, {
				field : 'collegeid',
				title : '学院id',
				hide : true
			} ] ]
		});
		//查询提交
		form.on('submit(search)', function(data) {
			table.reload('tableOne', {
				method : 'post',
				where : {
					'collegeid' : data.field.college
				},
				page : {
					curr : 1
				}
			});

			return false;
		});
	});
	//查看详情点击事件
	$(document)
			.on(
					'click',
					".query",
					function() {
						var collegeid = $(this).parent().parent().next()
								.children().text().trim();
						window.location.href = "getscore.action?op=collegedetail&collegeid="
								+ collegeid;
					});
</script>
</html>