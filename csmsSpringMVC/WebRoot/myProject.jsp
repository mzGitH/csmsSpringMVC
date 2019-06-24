<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>我的比赛项目</title>
<link rel="stylesheet" href="layui/css/layui.css">
<style>
body {
    background-color: rgb(209, 207, 207);
    overflow: hidden;
      overflow-y: scroll;
    
}

body::-webkit-scrollbar {
        display: none;
    }
</style>
</head>

<body>
	<div class="layui-card">
		<div class="layui-card-header">
			<div class="layui-row">
				<span class="layui-breadcrumb"> <a href="home.jsp">首页</a> <a><cite>我的比赛项目</cite></a></span>
			</div>
		</div>
		<div class="layui-card-header text-center">
			<div class="layui-row text-center">
				<h1>我的比赛项目</h1>
			</div>
		</div>
		<div class="layui-card-body">
			<table class="layui-table">
				<colgroup>
					<col width="70">
					<col width="200">
					<col width="150">
					<col width="150">
					<col width="150">
					<col width="150">
					<col width="150">
					<col width="150">
				</colgroup>
				<thead>
					<tr>
						<th>序号</th>
						<th>项目名称</th>
						<th>场次</th>
						<th>开始时间</th>
						<th>结束时间</th>
						<th>比赛地点</th>
						<th>比赛级别</th>
						<th>比赛状态</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${scenlist }" var="obj" varStatus="xh">
						<tr>
							<td class="text-center">${xh.index+1 }</td>
							<td class="text-center">${obj.proname }</td>
							<td class="text-center">${obj.arrname }</td>
							<td class="text-center">${obj.starttime }</td>
							<td class="text-center">${obj.endtime }</td>
							<td class="text-center">${obj.addr }</td>
							<c:if test="${obj.leveltype==1 }">
								<td class="text-center">预赛</td>
							</c:if>
							<c:if test="${obj.leveltype==2 }">
								<td class="text-center">决赛</td>
							</c:if>

							<c:if test="${obj.state == 0 }">
								<td class="text-center">未比赛</td>
							</c:if>
							<c:if test="${obj.state == 1 }">
								<td class="text-center">已结束</td>
							</c:if>
							<c:if test="${obj.state == 2 }">
								<td class="text-center">延时</td>
							</c:if>
							<c:if test="${obj.state == 3 }">
								<td class="text-center">取消</td>
							</c:if>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
<script src="layui/layui.js"></script>
<script type="text/javascript">
	layui.use(['form', 'element' ],function() {
		var form = layui.form;
		var element = layui.element;
	});
</script>
</html>