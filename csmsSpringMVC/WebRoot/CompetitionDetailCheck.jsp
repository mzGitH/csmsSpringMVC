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
				<span class="layui-breadcrumb"> <a href="home.jsp">首页</a> <a href="getproject.action?op=getproject">场次信息</a> <a><cite>比赛场次人员信息</cite></a></span>
			</div>
		</div>
		<div class="layui-card-header text-center">
			<div class="layui-row text-center">
				<h1>比赛场次人员信息</h1>
			</div>
		</div>
		<div class="layui-card-body">
			<div class="layui-row layui-form">
				<table class="layui-table">
					<thead>
						<th>序号</th>
						<c:if test="${protype==1||protype==2 }">
						<th>学号</th>
						</c:if>
						<c:if test="${protype==3||protype==4 }">
						<th>工号</th>
						</c:if>
						<th>姓名</th>
						<th>性别</th>
						<th>学院</th>
						<c:if test="${protype==1||protype==2 }">
						<th>专业</th>
						<th>班级</th>
						</c:if>
						<th>联系电话</th>
					</thead>
					<tbody>
					<c:forEach items="${arrlist }" var="arrange" varStatus="status">
						<tr>
							<td>${status.index + 1}</td>
							<td>${arrange.userid }</td>
							<c:if test="${protype==1||protype==2 }">
							<td>${arrange.username }</td>
							<td>${arrange.agend }</td>
							<td>${arrange.collegename }</td>
							<td>${arrange.majorname }</td>
							<td>${arrange.classname }</td>
							<td>${arrange.mobile }</td>
							</c:if>
							<c:if test="${protype==3||protype==4 }">
							<td>${arrange.teausername }</td>
							<td>${arrange.teaagend }</td>
							<td>${arrange.teacollegename }</td>
							<td>${arrange.teamobile }</td>
							</c:if>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
<script src="layui/layui.all.js"></script>
<script src="js/jquery-2.1.1.min.js" charset="utf-8"></script>

</html>