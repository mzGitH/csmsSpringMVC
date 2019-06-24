<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
<style>
.table1 {
	width: 90%;
	margin-left: 5%;
	margin-top: 10px;
	margin-bottom: 50px;
}

.table1 td {
	border: 1px solid #ccc;
}

.table2 {
	width: 100%;
}

.table2 .layui-bg-orange {
	width: 25%;
}

.table2 td {
	border: 1px solid #ccc;
}

.table3 .layui-card {
	height: 250px;
	background-color: #ccc;
}

.table3 td {
	width: 30%;
	margin-left: 20px;
	border-bottom: 10px solid #fff;
	border-left: 10px solid #fff;
}

.float {
	float: right;
}

.headphoto {
	border-radius: 50px;
	width: 50px;
	height: 50px;
	margin: 10px 0;
}

.authorphoto {
	border-radius: 50px;
	width: 25px;
	height: 25px;
}

.recommend .layui-card-header {
	font-size: 26px;
	color: chocolate;
}

.title {
	color: blue;
	margin: 15px 0;
	font-size: 24px;
}body {
    background-color: rgb(209, 207, 207);
    overflow: hidden;
      overflow-y: scroll;
    
}

body::-webkit-scrollbar {
        display: none;
    }
</style>
<title>文章列表</title>
</head>

<body>
	<div class="layui-container">
		<div class="layui-row layui-col-space15">
			<div class="">
				<div class="layui-card">

					<div class="layui-card-header">
						<div class="layui-row">
							<span class="layui-breadcrumb"> <a href="home.jsp">首页</a>
								<a><cite>文章列表</cite></a></span>
						</div>
					</div>
					<div class="layui-card-header text-center">
						<div class="layui-row text-center">
							<h1>文章列表</h1>
						</div>
					</div>
					<div class="layui-card-body">
						<div class="layui-row layui-form">
							<table class="layui-table" id="forumlist" lay-filter="test"
								width="100%"></table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
<script src="layui/layui.js" charset="utf-8"></script>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
  </div>
</script>
<script src="js/jquery-2.1.1.min.js" charset="utf-8"></script>
<script type="text/javascript">
	layui
			.use(
					[ 'element', 'carousel', 'table' ],
					function() {
						var element = layui.element;
						var carousel = layui.carousel;
						//导航栏点击
						element.on('nav(filter)', function(elem) {
							console.log(elem); //得到当前点击的DOM对象
						});
						var table = layui.table;
						table
								.render({
									elem : '#forumlist',
			toolbar : '#toolbarDemo',
									height : 'full-200',
									url : 'getforum.action', //数据接口
									cols : [ [ //表头
											{
												align : 'center',
												field : '',
												title : '序号',
												width : 180,
												type : 'numbers'
											},
											{
												align : 'center',
												field : 'title',
												title : '文章标题',
												width : 478,
												templet : function(data) {
													return "<a href='getcontent.action?op=byforumid&titleid="
															+ data.forumid
															+ "'>"
															+ data.title
															+ "</a>"
												}
											}, {
												align : 'center',
												field : 'author',
												title : '投稿人',
												width : 200
											//sort: true //是否排序
											}, {
												align : 'center',
												field : 'createtime',
												title : '时间',
												width : 250
											} ] ],
									page : true, //开启分页
									even : true, //每行颜色分隔
									skin : 'nob', //无边框
									limit : 10,
									limits : [ 10, 15, 20 ]
								/* first:true,
								last:true, */
								});
					});
</script>

</html>
