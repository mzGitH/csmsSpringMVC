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
<title>项目成绩查看页面</title>
</head>

<body>
	<div class="layui-container">
		<div class="layui-card">
			<div class="layui-card-header">
				<div class="layui-row">
					<span class="layui-breadcrumb"> <a href="home.jsp">首页</a> <a><cite>项目成绩</cite></a>
					</span>
				</div>
			</div>
			<div class="layui-card-header text-center">
				<div class="layui-row">
					<h1>项目成绩查看页面</h1>
				</div>
			</div>
			<div class="layui-card-body">
				<div class="layui-row layui-form">
					<div class="layui-input-inline">
						<select name="project" id="project" lay-filter="project"
							lay-verify="required" lay-search="">
							<option value="0">请选择或输入项目名称</option>
							<c:forEach items="${projectlist}" var="obj">
								<c:if test="${obj.protype==1 }">
								<option value="${obj.proid }">${obj.proname }(学生个人赛)</option>
								</c:if>
								<c:if test="${obj.protype==2 }">
								<option value="${obj.proid }">${obj.proname }(学生团体赛)</option>
								</c:if>
								<c:if test="${obj.protype==3 }">
								<option value="${obj.proid }">${obj.proname }(教师个人赛)</option>
								</c:if>
								<c:if test="${obj.protype==4 }">
								<option value="${obj.proid }">${obj.proname }(教师团体赛)</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
					<div class="layui-input-inline">
						<select name="userselect" id="userselect" lay-filter="userselect">
							<option value="0">请选择项目类型</option>
							<option value="stusingle">学生个人赛</option>
							<option value="stuteam">学生团体赛</option>
							<option value="teasingle">教师个人赛</option>
							<option value="teateam">教师团体赛</option>
						</select>
					</div>
					<div class="layui-input-inline" style="margin-left: -10px;">
						<button type="button" class="layui-btn layui-btn" lay-submit lay-filter="search">查询</button>
					</div>
				</div>
				<div class="layui-row">
					<table class="layui-table" id="scoretable" lay-filter="demo"></table>
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
	layui.use([ 'table', 'laydate', 'layer', 'jquery', 'form', 'element' ],function() {
		var table = layui.table;
		var $ = layui.jquery;
		var laydate = layui.laydate;
		var layer = layui.layer;
		var form = layui.form;
		var element = layui.element;
		//页面加载获取动态表格数据
		table.render({
			id : 'tableOne',
			elem : '#scoretable',
			toolbar : '#toolbarDemo',
			height : 'full-200', //高度最大化减去差值,
			url : 'getprojectscore.action?op=load&user='
					+ $("#userselect").val(),
			even : true,
			skin : "nob",
			cellMinWidth : 35, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
			//,toolbar: '#toolbarDemo'
			title : '用户数据表',
			cols : [ [ {
				align : 'center',
				field : '',
				title : '序号',
				type : 'numbers'
			}, {
				align : 'center',
				field : 'proname',
				title : '项目名称',
				sort : true
			}, {
				align : 'center',
				field : '',
				title : '项目类型',
				templet : function(data) {
					if (data.protype == 1) {
						return "学生个人赛"
					} else if (data.protype == 2) {
						return "学生团体赛"
					} else if (data.protype == 3) {
						return "教师个人赛"
					} else if (data.protype == 4) {
						return "教师团体赛"
					}
				}
			}, {
				align : 'center',
				field : '',
				title : '参赛者',
				templet : function(data) {
					if (data.protype == 1 || data.protype == 2) {
						return data.username
					} else {
						return data.teausername
					}
				}
			}, {
				align : 'center',
				field : '',
				title : '学院名称',
				sort : true,
				templet : function(data) {
					if (data.protype == 1 || data.protype == 2) {
						return data.collegename
					} else {
						return data.teacollegename
					}
				}
			}, {
				align : 'center',
				field : 'scorenumber',
				title : '最高分成绩',
				sort : true
			}, {
				align : 'center',
				field : '',
				title : '操作',
				toolbar : '#barDemo'
			}, {
				field : 'proid',
				hide : true
			} ] ]
		});
		//查询提交
		form.on('submit(search)', function(data) {
			table.reload('tableOne', {
				method : 'post',
				where : {
					'project' : data.field.project,
					'usertype' : data.field.userselect
				},
				page : {
					curr : 1
				}
			});
			return false;
		});
	});
			//查看详情点击事件
	$(document).on('click',".query",function() {
		var proid = $(this).parent().parent().next().children().text().trim();
		window.location.href = "getprojectscore.action?op=prodetail&proid=" + proid;
	});
</script>
</html>
