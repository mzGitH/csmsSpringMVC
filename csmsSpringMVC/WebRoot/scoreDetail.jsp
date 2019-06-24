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
<title>成绩详情页面</title>
</head>

<body>
	<div class="layui-container">
		<div class="layui-card">
			<div class="layui-card-header">
				<div class="layui-row">
					<span class="layui-breadcrumb"> 
					<a href="home.jsp">首页</a>
					<c:if test="${type=='college' }">
					<a href="getcollege.action?op=college">学院成绩</a>
					</c:if>
					<c:if test="${type=='major' }">
					<a href="getcollege.action?op=major">专业成绩</a>
					</c:if>
					<c:if test="${type=='class' }">
					<a href="getcollege.action?op=class">班级成绩</a>
					</c:if>
					<c:if test="${type=='single' }">
					<a href="getcollege.action?op=single">个人成绩</a>
					</c:if>
					<a><cite>成绩详情</cite></a>
					</span>
				</div>
			</div>
			<div class="layui-card-header text-center">
				<div class="layui-row text-center">
					<h1>成绩详情页面</h1>
				</div>
			</div>
			<div class="layui-card-body">
				<div class="layui-row">
					<table class="layui-table" id="scoretable">
						<thead>
							<tr>
								<th class="text-center"><nobr>项目名称</nobr></th>
								<th class="text-center"><nobr>成绩</nobr></th>
							</tr>
						</thead>
						<tbody id="scoretable_tbody">
							<c:if test="${type eq 'college' }">
								<tr>
									<td colspan="2" class="text-center"
										style="border:3px solid #ccc">学生成绩</td>
								</tr>
							</c:if>
							<c:forEach items="${scorelist }" var="obj">
								<tr>
									<c:if test="${obj.protype eq 1}">
										<td class="text-center"><nobr>${obj.proname }(个人赛)</nobr>
										</td>
									</c:if>
									<c:if test="${obj.protype eq 2}">
										<td class="text-center"><nobr>${obj.proname }(团体赛)</nobr>
										</td>
									</c:if>
									<td class="text-center"><nobr>${obj.scorenumber }</nobr></td>
								</tr>
							</c:forEach>
							<tr class="layui-bg-green">
								<c:if test="${type ne 'college' }">
									<td class="text-center"><nobr>总成绩：${totalScore}</nobr></td>
									<td class="text-center"><nobr>平均成绩：${avgScore }</nobr></td>
								</c:if>
								<c:if test="${type eq 'college' }">
									<td class="text-center"><nobr>总成绩：${stuTotalScore}</nobr>
									</td>
									<td class="text-center"><nobr>平均成绩：${stuAvgScore }</nobr>
									</td>
								</c:if>
							</tr>
							<!-- 查看学院成绩详情是展示教师成绩 -->
							<c:if test="${type eq 'college' }">
								<c:if test="${teacher eq have}">
									<tr>
										<td colspan="2" class="text-center"
											style="border:3px solid #ccc">教师成绩</td>
									</tr>
									<c:forEach items="${scorelist }" var="obj">
										<tr>
											<c:if test="${obj.protype eq 3}">
												<td class="text-center"><nobr>${obj.proname }(个人赛)</nobr>
												</td>
											</c:if>
											<c:if test="${obj.protype eq 4}">
												<td class="text-center"><nobr>${obj.proname }(团体赛)</nobr>
												</td>
											</c:if>
											<td class="text-center"><nobr>${obj.scorenumber }</nobr>
											</td>
										</tr>
									</c:forEach>
									<tr class="layui-bg-green">
										<!-- <td class="text-center"><input type="checkbox" /></td> -->
										<td class="text-center"><nobr>总成绩：${teaTotalScore}</nobr>
										</td>
										<td class="text-center"><nobr>平均成绩：${teaAvgScore }</nobr>
										</td>
									</tr>
								</c:if>
							</c:if>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
<script src="layui/layui.all.js"></script>

</html>