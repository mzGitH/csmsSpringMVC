<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>报名查询</title>
<link rel="stylesheet" href="layui/css/layui.css">

<style>
.layui-table-cell {
	white-space: normal;
	height: inherit;
}body {
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
				<span class="layui-breadcrumb"> <a href="home.jsp">首页</a> <a><cite>比赛时间安排查询</cite></a></span>
			</div>
		</div>
		<div class="layui-card-header text-center">
			<div class="layui-row text-center">
				<h1>比赛时间安排查询</h1>
			</div>
		</div>
		<div class="layui-card-body">
			<div class="layui-row layui-form">

				<div class="layui-input-inline">
					<select name="collegeid" lay-filter="college">
						<option value="">选择或输入学院名称</option>
						<c:forEach items="${collegelist }" var="obj">
							<option value="${obj.collegeid }">${obj.collegename }</option>
						</c:forEach>
					</select>
				</div>
				<div class="layui-input-inline" id="select-class">
					<select name="classid" id="classid" lay-search="">
						<option value="">选择或搜索班级</option>
						<c:forEach items="${classlist }" var="obj">
							<option value="${obj.classid }">${obj.classname }</option>
						</c:forEach>
					</select>
				</div>
				<div class="layui-input-inline">
					<input type="text" placeholder="请输入查询条件" name="strwhere"
						autocomplete="off" class="layui-input">
				</div>
				<div class="layui-input-inline" style="margin-left: -10px;">
					<button type="button" class="layui-btn layui-btn" lay-submit
						lay-filter="search">查询</button>
				</div>
			</div>
			<div class="layui-row layui-form">
				<table class="layui-table" id="basic-table"></table>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
<script src="layui/layui.all.js"></script>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
  </div>
</script>
<script src="js/jquery-2.1.1.min.js" charset="utf-8"></script>
<script>
	layui.use([ 'form', 'table' ], function() {

		var url = "arrangeview.action?op=load";

		var form = layui.form, table = layui.table;
		form.on('select(college)', function(data) {
			$.ajax({
				type : 'post',
				url : "arrangeview.action?op=load",
				data : {
					collegeid : data.value,
					type : 'select',
				},
				dataType : "json",
				success : function(data) {
					//清空赋值
					if (data != null) {
						$("#classid").empty();
						console.log(data.data);
						$("#classid").append(new Option("选择或搜索班级", ""));
						$.each(data, function(index, item) {
							//赋值
							$('#classid').append(
									new Option(item.classname, item.classid));
						});
					} else {
						$("#classid").append(new Option("暂无数据", ""));
					}
					layui.form.render("select");
				},
				error : function(jqXHR, textStatus, errorThrown) {
					layer.msg("后台错误");
					/*弹出jqXHR对象的信息
					alert(jqXHR.responseText);
					alert(jqXHR.status);
					alert(jqXHR.readyState);
					alert(jqXHR.statusText);
					/*弹出其他两个参数的信息
					alert(textStatus);
					alert(errorThrown);*/
				}
			});
		});

		//监听提交
		form.on('submit(search)', function(data) {
			table.reload('tableOne', {
				method : 'post',
				where : {
					'strwhere' : data.field.strwhere,
					'collegeid' : data.field.collegeid,
					'classid' : data.field.classid,
				},
				page : {
					curr : 1
				}
			});

			return false;
		});
		table.render({
			elem : '#basic-table',
			toolbar : '#toolbarDemo',
			//height : 513,
			url : url,
			height : 'full-100',
			id : 'tableOne',
			page : true,
			limit : 10,
			limits : [ 10, 15,20 ],
			cols : [ [ // 表头
			{
				align : 'center',
				field : 'userid',
				title : '学号',
				width : 100
			}, {
				align : 'center',
				field : '',
				title : '姓名',
				width : 100,
				templet : function(d) {
					if (d.username == null || d.username == "") {
						return d.teausername;
					} else {
						return d.username;
					}
				}
			}, {
				align : 'center',
				field : '',
				title : '班级',
				width : 100,
				templet : function(d) {
					if (d.classname == null || d.classname == "") {
						return "教师用户不分班级";
					} else {
						return d.classname;
					}
				}
			}, {
				align : 'center',
				field : '',
				title : '专业',
				width : 100,
				templet : function(d) {
					if (d.majorname == null || d.majorname == "") {
						return "教师用户专业";
					} else {
						return d.majorname;
					}
				}
			}, {
				align : 'center',
				field : '',
				title : '院系',
				width : 100,
				templet : function(d) {
					if (d.collegename == null || d.collegename == "") {
						return d.teacollegename;
					} else {
						return d.collegename;
					}
				}
			}, {
				align : 'center',
				field : 'proname',
				title : '项目名称',
				width : 100
			}, {
				align : 'center',
				field : 'arrname',
				title : '场次',
				width : 100
			}, {
				align : 'center',
				field : 'starttime',
				title : '开始时间',
				width : 110
			}, {
				align : 'center',
				field : 'endtime',
				title : '结束时间',
				width : 110
			}, {
				align : 'center',
				field : 'addr',
				title : '比赛地点',
				width : 75
			}, {
				align : 'center',
				field : '',
				title : '比赛级别',
				width : 65,
				templet : function(d) {
					if (d.leveltype == 1) {
						return "预赛";
					} else {
						return "决赛";
					}
				}
			}, {
				align : 'center',
				field : '',
				title : '比赛状态',
				width : 75,
				templet : function(d) {
					if (d.state == 0) {
						return "未开始";
					} else if (d.state == 1) {
						return "已结束";
					} else if (d.state == 2) {
						return "延时";
					} else {
						return "取消";
					}
				}
			} ] ]
		})
	});
</script>

</html>
