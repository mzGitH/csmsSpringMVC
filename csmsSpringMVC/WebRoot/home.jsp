<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
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
</head>

<body>
	<div class="layui-row">
		<div class="layui-col-md3 layui-col-lg3">
			<div class="layui-fluid layui-col-md12 layui-col-lg12">
				<div class="layui-card">
					<div class="layui-card-header">
						<b><span style="font-size:18px;">运动会公告</span></b>
					</div>
					<div class="layui-card-body">
						<table class="layui-table" id="table-title" lay-skin="nob">
						</table>
					</div>
				</div>
				<!--运动会公告结束-->
			</div>
		</div>
		<div class="layui-col-md8 layui-col-lg8" style="width:74%">
			<div class="layui-carousel" id="lb">
				<div carousel-item>
					<img src="image/2.jpg"> <img src="image/10.jpg"> <img
						src="image/5.jpg"> <img src="image/6.jpg"> <img
						src="image/7.jpg">
				</div>
			</div>
			<!--轮播结束-->
		</div>
	</div>
	<div class="layui-row layui-col-space30">
		<div class="layui-fluid" style="width:95%">
			<div class="layui-col-md12 layui-col-lg12">
				<div class="layui-card">
					<div class="layui-card-header">
						<b><span style="font-size:18px;">运动会热讯</span></b>
					</div>
					<div class="layui-card-body">
						<div class="layui-row layui-col-space20">
							<div class="layui-card layui-col-md6 layui-col-lg6">
								<div class="layui-card-header">
									<b><span style="font-size:14px;">热点文章</span></b> <a
										href="forumList.jsp"><span style="float:right">更多>></span></a>
								</div>
								<div class="layui-card-body">
									<table class="layui-table" id="table-forum" ></table>
								</div>
							</div>
							<div class="layui-card layui-col-md6 layui-col-lg6">
								<div class="layui-card-header">
									<b><span style="font-size:14px;">学院成绩排名</span></b>
								</div>
								<div class="layui-card-body">
									<table class="layui-table" id="table-score" lay-skin="nob"></table>
								</div>
							</div>
							<div class="layui-card layui-col-md12 layui-col-lg12">
								<div class="layui-card-header">
									<b><span style="font-size:14px;">精彩瞬间</span></b>
								</div>
								<div class="layui-card-body">
									<div id="div-img">
										<ul>
											<li><img src="image/1.jpg" /></li>
											<li><img src="image/2.jpg" /></li>
											<li><img src="image/3.jpg" /></li>
											<li><img src="image/4.jpg" /></li>
										</ul>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
				<!--运动会热讯end-->
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
<script src="layui/layui.js" charset="utf-8"></script>
<script src="js/jquery-2.1.1.min.js" charset="utf-8"></script>
<script src="js/home.js" charset="utf-8"></script>
</html>