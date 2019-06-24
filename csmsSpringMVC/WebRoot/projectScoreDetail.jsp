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
}
body {
    background-color: rgb(209, 207, 207);
    overflow: hidden;
      overflow-y: scroll;
    
}

body::-webkit-scrollbar {
        display: none;
    }
</style>
<title>项目成绩详情页面</title>
</head>

<body>
	<div class="layui-container">
		<div class="layui-card">
			<div class="layui-card-header">
				<div class="layui-row">
					<span class="layui-breadcrumb"> <a href="home.jsp">首页</a> <a href="getproject.action?op=project">项目成绩</a> <a><cite>项目成绩详情</cite></a>
					</span>
				</div>
			</div>
			<div class="layui-card-header text-center">
				<div class="layui-row">
					<c:if test="${project.protype==1}">
					<h1>${project.proname}(学生个人赛)--项目成绩详情</h1>
					</c:if>
					<c:if test="${project.protype==2}">
					<h1>${project.proname}(学生团体赛)--项目成绩详情</h1>
					</c:if>
					<c:if test="${project.protype==3}">
					<h1>${project.proname}(教师个人赛)--项目成绩详情</h1>
					</c:if>
					<c:if test="${project.protype==4}">
					<h1>${project.proname}(教师团体赛)--项目成绩详情</h1>
					</c:if>
				</div>
			</div>
			<div class="layui-card-body">
				<div class="layui-row">
					<table class="layui-table" id="scoretable">
						<thead>
							<th>排名</th>
							<th>参赛人</th>
							<th>学院</th>
							<th>成绩</th>
						</thead>
						<tbody>
							<c:forEach items="${proscorelist }" var="obj" varStatus="status">
							<tr>
								<td>${ status.index + 1}</td>
								<c:if test="${project.protype==1 || project.protype==2}">
								<td>${obj.username }</td>
								<td>${obj.collegename }</td>
								</c:if>
								<c:if test="${project.protype==3 || project.protype==4}">
								<td>${obj.teausername }</td>
								<td>${obj.teacollegename }</td>
								</c:if>
								<td>${obj.scorenumber }</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
<script src="layui/layui.js"></script>
<script id="barDemo" type="text/html">
    <button class="layui-btn layui-btn-sm layui-bg-green query">查看详情</button>
</script>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
  </div>
</script>
<script src="js/jquery-2.1.1.min.js" charset="utf-8"></script>
<script type="text/javascript">
	layui.use([ 'layer', 'jquery', 'form', 'element' ],function() {
		var $ = layui.jquery;
		var layer = layui.layer;
		var form = layui.form;
		var element = layui.element;
		
	});
			//查看详情点击事件
	$(document).on('click',".query",function() {
		var majorid = $(this).parent().parent().next().children().text().trim();
		window.location.href = "getscore.action?op=majordetail&majorid=" + majorid;
	});
</script>
</html>
