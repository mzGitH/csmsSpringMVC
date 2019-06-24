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
<title>Insert title here</title>
</head>

<body>
	<div class="layui-container">
		<div class="layui-row layui-col-space15">
			<div class="">
				<div class="layui-card">
					<div class="layui-card-header">
						<div class="layui-row">
							<span class="layui-breadcrumb"> <a href="home.jsp">首页</a>
								<a href="forumList.jsp">文章列表</a> <a><cite>文章内容</cite></a></span>
						</div>
					</div>
					<div class="layui-card-body text-center">
						<div class="layui-row">
							<span class="title">文章标题：运动会调高高能瞬间</span>
							<button id="addTitle"
								class="layui-btn layui-bg-blue float layui-btn-sm">编辑文章标题</button>
						</div>
					</div>
				</div>
				<div class="layui-card">
					<div class="layui-card-header">
						文章内容管理
						<button id="addModel"
							class="layui-btn layui-bg-blue float layui-btn-sm">添加文章内容</button>
					</div>
					<div class="layui-card-body">
						<table id="demo" lay-filter="test" width="100%"></table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 编辑文章标题模态框 -->
	<div id="editTitle" style="display: none;">
		<form class="layui-form" action="">
			<div class="layui-form-item">
				<label class="layui-form-label">文章标题</label>
				<div class="layui-input-block">
					<input type="text" name="content.photocontent" id="forumtitle"
						required lay-verify="required" placeholder="请输入文章标题"
						autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="formDemo">确定</button>
				</div>
			</div>
		</form>
	</div>
	<!-- 添加文章内容模态框 -->
	<div id="editContent" style="display: none;">
		<form class="layui-form" action="">
			<div class="layui-form-item">
				<label class="layui-form-label">内容照片</label>
				<div class="layui-input-block">
					<input type="text" disabled="disabled" name="content.photocontent"
						required lay-verify="required" placeholder="请选择一张内容照片"
						autocomplete="off" class="layui-input layui-bg-gray">
				</div>
				<label class="layui-form-label"> </label>
				<div class="layui-input-inline" style="margin:10px 0;">
					<button class="layui-btn layui-bg-blue" id="btn-photo">上传内容图片</button>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">图片预览</label>
				<div class="layui-input-block">
					<div style="width:250px;height:250px;border:1px solid #ccc;">
						<img alt="" src="img/defaultuser.jpg" width="100%" />
					</div>
				</div>
			</div>
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">文章内容</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入文章内容" name="content.textcontent"
						class="layui-textarea"></textarea>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
				</div>
			</div>
		</form>
	</div>
	<%@include file="footer.jsp"%>
</body>
<script src="layui/layui.js" charset="utf-8"></script>
<script src="js/jquery-2.1.1.min.js" charset="utf-8"></script>
<script type="text/javascript">
	// 显示编辑文章标题模态框
	$("#addTitle").click(function() {
		layui.use([ 'layer' ], function() {
			var layer = layui.layer, $ = layui.$;
			layer.open({
				type : 1, //类型
				area : [ '500px', '250px' ], //定义宽和高
				title : '编辑文章标题', //题目
				shadeClose : false, //点击遮罩层关闭
				content : $('#editTitle')
			//打开的内容
			});
		})
	})
	// 显示编辑文章内容模态框
	$("#addModel").click(function() {
		layui.use([ 'layer' ], function() {
			var layer = layui.layer, $ = layui.$;
			layer.open({
				type : 1, //类型
				area : [ '700px', '600px' ], //定义宽和高
				title : '编辑文章内容', //题目
				shadeClose : false, //点击遮罩层关闭
				content : $('#editContent')
			//打开的内容
			});
		})
	})
	layui.use([ 'element', 'carousel', 'table' ], function() {
		var element = layui.element;
		var carousel = layui.carousel;
		//导航栏点击
		element.on('nav(filter)', function(elem) {
			console.log(elem); //得到当前点击的DOM对象
		});
		var table = layui.table;
		table.render({
			elem : '#demo',
			height : 500,
			url : 'service/getcontent.action', //数据接口
			cols : [ [ //表头
					{
						field : 'ordernum',
						title : '内容序号',
						width : 40,
					},
					{
						field : '',
						title : '文章图片',
						width : 80,
						templet : function(data) {
							return "<img src='" + data.photoname
									+ "' style='width:100%'/>"
						}
					}, {
						field : 'textcontent',
						title : '文章内容',
						width : 300,
						sort : true
					}, {
						fixed : 'right',
						title : '操作',
						width : 140,
						toolbar : '#barDemo'
					} ] ],
			page : true, //开启分页
			even : true, //每行颜色分隔
			skin : 'nob', //无边框
			limit : 10,
			limits : [ 5, 10, 15 ]
		/* first:true,
		last:true, */
		});
		//监听工具条
		table.on('tool(demo)', function(obj) {
			var data = obj.data;
			if (obj.event === 'edit') {
				layer.alert('编辑行：<br>' + JSON.stringify(data))
			} else if (obj.event === 'del') {
				layer.confirm('真的删除行么', function(index) {
					obj.del();
					layer.close(index);
				});
			}
		});
	});
</script>

</html>