<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>公告详细信息</title>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
<link rel="stylesheet" type="text/css" href="css/lgd.css">
<style type="text/css">
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

	<div class="layui-container" style="height:auto;">
		<div class="layui-card">
			<div class="layui-card-header">
				<div class="layui-row">
					<span class="layui-breadcrumb"> <a href="home.jsp">首页</a> <a><cite>公告内容</cite></a></span>
				</div>
			</div>
			<div class="layui-card-header text-center">
				<div class="layui-row text-center">
					<h1>公告内容</h1>
				</div>
			</div>
			<div class="layui-card-body">
				<div class="layui-container layui-col-space20">
					<div class="layui-row"
						style="border-bottom:blanchedalmond 1px sold">
						<div class="layui-col-md6 layui-col-md6">
							<span style="font-size:18px;"><b>${news.newstitle }</b></span>
						</div>
						<div class="layui-col-md6 layui-col-md6">
							<span style="font-size:16px; float: right; margin-right: 20px;">发布人：${news.username}
								&nbsp;&nbsp;&nbsp;&nbsp; 发布时间：${news.datetime }</span>
						</div>
					</div>
					<div class="layui-row">
						<div class="layui-col-md12" style="width:97%">
							<article for="text">
							${news.newscontent}
							</article>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
<script src="layui/layui.js" charset="utf-8"></script>
<script src="js/home.js" charset="utf-8"></script>

</html>
