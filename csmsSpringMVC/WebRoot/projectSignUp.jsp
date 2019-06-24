<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>文章内容</title>
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
				<span class="layui-breadcrumb"> <a href="home.jsp">首页</a> <a><cite>比赛项目查看</cite></a></span>
			</div>
		</div>
		<div class="layui-card-header text-center">
			<div class="layui-row text-center">
				<h1>比赛项目查看</h1>
			</div>
		</div>
		<div class="layui-card-body">
			<div class="layui-row">
				<div class="layui-input-inline">
					<input type="text" name="text" id="strwhere" placeholder="请输入查询条件"
						autocomplete="off" class="layui-input">
				</div>
				<div class="layui-input-inline" style="margin-left: -10px;">
					<button type="button" id="btn-search" class="layui-btn layui-btn">查询</button>
				</div>
			</div>
			<div class="layui-row">
				<table class="layui-table" id="forumlist" lay-filter="test"
					width="100%"></table>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
<script src="layui/layui.js"></script>
<script src="js/jquery-2.1.1.min.js" charset="utf-8"></script>
<script id="barDemo" type="text/html">
  <button type="button" lay-event="add" class="layui-btn layui-btn-sm baom">报名</button>
</script>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
  </div>
</script>
<script>
	layui.use([ 'element', 'carousel', 'table' ], function() {
		var element = layui.element;
		var carousel = layui.carousel;
		//导航栏点击
		element.on('nav(filter)', function(elem) {
			console.log(elem); //得到当前点击的DOM对象
		});
		var table = layui.table;
		table.render({
			elem : '#forumlist',
			id : 'tableOne',
			toolbar : '#toolbarDemo',
			height : 'full-200',
			url : 'getproject.action', //数据接口
			skin : "nob",
			cols : [ [ //表头
			{
				align : 'center',
				field : '',
				title : '序号',
				type : 'numbers',
				width : 100
			}, {
				field : 'proid',
				title : '序号',
				hide : true,
			}, {
				field : 'proname',
				title : '项目名称',
				align : 'center'
			}, {
				field : 'currentnum',
				title : '当前报名人数',
				align : 'center'
			//sort: true //是否排序
			}, {
				field : 'totallimit',
				title : '人数限制',
				align : 'center'
			}, {
				field : '',
				title : '项目类型',
				align : 'center',
				templet : function(data) {
					if (data.protype == 1) {
						return "<a href=''>学生个人赛</a>"
					} else if (data.protype == 2) {
						return "<a href=''>学生团体赛</a>"
					} else if (data.protype == 3) {
						return "<a href=''>教师个人赛</a>"
					} else if (data.protype == 4) {
						return "<a href=''>教师团体赛</a>"
					}
				}
			}, {
				field : '',
				title : '操作',
				align : 'center',
				toolbar : '#barDemo',
				width : 150
			} ] ],
			page : true, //开启分页
			even : true, //每行颜色分隔
			//skin: 'nob', //无边框
			limit : 10,
			limits : [ 1, 10, 15, 20 ]
		/* first:true,
		last:true, */
		});
		//监听工具条
		table.on('tool(demo)', function(obj) {
			var data = obj.data;
			if (obj.event === 'add') {
				layer.alert('报名')
			}
		});
		//查询按钮
		$("#btn-search").click(function() {
			table.reload('tableOne', {
				method : 'post',
				where : {
					'strwhere' : $("#strwhere").val(),
					'type' : 'search'
				},
				page : {
					curr : 1
				}
			});
		})
	});
<%int roletype = Integer.parseInt(session.getAttribute("role")
					.toString());
			request.setAttribute("roletype", roletype);%>
	$(document)
			.on(
					'click',
					".baom",
					function() {
						if (${roletype!=1}) {
							var currentnum = $(this).parent().parent().prev()
									.prev().prev().find("div").text().trim();
							var totalnum = $(this).parent().parent().prev()
									.prev().find("div").text().trim();
							if (parseInt(currentnum) >= parseInt(totalnum)) {
								layer.msg("该项目报名人数已达上限，请另外选择其他项目");
							} else {
								var proid = $(this).parent().parent().prev()
										.prev().prev().prev().prev()
										.find("div").text().trim();
								//layer.msg(proid);
								window.location.href = "studentSignUp.jsp?proid="
										+ encodeURI(proid);
							}
						} else {
							layer.msg("你的权限不够");
						}
					});
</script>
</html>