<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>项目场次查询</title>
<link rel="stylesheet" href="layui/css/layui.css">

<style>
.layui-table-cell {
	white-space: normal;
	height: inherit;
}
</style>
</head>

<body>
	<div class="layui-card">
		<div class="layui-card-header">
			<div class="layui-row">
				<span class="layui-breadcrumb"> <a href="home.jsp">首页</a> <a><cite>场次信息</cite></a></span>
			</div>
		</div>
		<div class="layui-card-header text-center">
			<div class="layui-row text-center">
				<h1>场次信息</h1>
			</div>
		</div>
		<div class="layui-card-body">
			<div class="layui-row layui-form">
				<div class="layui-row">
					<div class="layui-input-inline">
						<div id="college">
							<select name="project" id="project" lay-filter="project"
								lay-verify="required" lay-search="">
								<option value="0">请选择或输入项目名称</option>
								<c:forEach items="${projectlist}" var="obj">
									<option value="${obj.proid }">${obj.proname }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="layui-input-inline" style="width:300px;">
						<input type="text" placeholder="请输入场次名称/比赛地点" name="strwhere"
							autocomplete="off" class="layui-input">
					</div>
					<div class="layui-input-inline" style="margin-left: -5px;">
						<button type="button" class="layui-btn layui-btn" lay-submit
							lay-filter="search">查询</button>
					</div>
				</div>
			</div>
			<div class="layui-row layui-form">
				<table class="layui-table" id="basic-table"></table>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
<script src="layui/layui.all.js"></script>
<script id="barDemo" type="text/html">
    <button class="layui-btn layui-btn-sm layui-bg-green query">查看详情</button>
</script>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
  </div>
</script>
<script src="js/jquery-2.1.1.min.js" charset="utf-8"></script>
<script>
	layui.use([ 'form', 'table' ], function() {
		var form = layui.form, table = layui.table;
		//监听提交
		form.on('submit(search)', function(data) {
			table.reload('tableOne', {
				method : 'post',
				where : {
					'strwhere' : data.field.strwhere,
					'project':data.field.project
				},
				page : {
					curr : 1
				}
			});

			return false;
		});
		table.render({
			elem : '#basic-table',
			toolbar : '#toolbarDemo',
			url : "arrangeview.action?op=getarr",
			height : 'full+100',
			id : 'tableOne',
			page : true,
			limit : 10,
			limits : [10, 15,20 ],
			cols : [ [ // 表头
			{
				align : 'center',
				field : '',
				title : '序号',
				width : 60,
				type : 'numbers'
			}, {
				align : 'center',
				field : 'arrname',
				title : '场次名称',
				width : 130
			}, {
				align : 'center',
				field : 'proname',
				title : '项目名称',
				width : 150
			}, {
				align : 'center',
				field : 'starttime',
				title : '开始时间',
				width : 120
			}, {
				align : 'center',
				field : 'endtime',
				title : '结束时间',
				width : 120
			}, {
				align : 'center',
				field : 'addr',
				title : '比赛地点',
				width : 150
			}, {
				align : 'center',
				field : '',
				title : '比赛级别',
				width : 90,
				templet : function(d) {
					if (d.leveltype == 1) {
						return "预赛";
					} else {
						return "决赛";
					}
				}
			}, {
				align : 'center',
				field : '',
				title : '比赛状态',
				width : 90,
				templet : function(d) {
					if (d.state == 0) {
						return "未开始";
					} else if (d.state == 1) {
						return "已结束";
					} else if (d.state == 2) {
						return "延时";
					} else {
						return "取消";
					}
				}
			}, {
				align : 'center',
				field : '',
				title : '操作',
				width : 230,
				toolbar : '#barDemo'
			}, {
				field : 'arrid',
				hide : true
			} ] ]
		})
	});
	//查看详情点击事件
	$(document).on('click',".query",function() {
		var arrid = $(this).parent().parent().next().children().text().trim();
		window.location.href = "getarrdetail.action?arrid="+ arrid;
	});
</script>

</html>