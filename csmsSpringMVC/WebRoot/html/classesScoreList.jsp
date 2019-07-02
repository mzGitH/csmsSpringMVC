<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>学院成绩</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
 <link rel="stylesheet" href="../layui/css/layui.css" media="all">
</head>
<style>
	body .demo-class .layui-layer-title{background:#4476A7; color:#fff; border: none;}
body .demo-class .layui-layer-btn{border-top:1px solid #4476A7}
body .demo-class .layui-layer-btn a{background:#4476A7;}
body .demo-class .layui-layer-btn .layui-layer-btn1{background:#4476A7;}
body .demo-class .layui-layer-page .layui-layer-content {background-color: #e13e4;}
</style>
<body>

  <div class="layui-fluid" style="margin-top: 10px">
    		<blockquote class="layui-elem-quote" style="border-left: none">
			<form class="layui-form">
				<div class="layui-input-inline">
						<select name="college" id="college" lay-filter="college"
							lay-verify="required" lay-search="">
							<option value="0">请选择或输入学院名称</option>
							<c:forEach items="${listcollege}" var="obj">
								<option value="${obj.collegeid }">${obj.collegename }</option>
							</c:forEach>
						</select>
					</div>
					<div class="layui-input-inline">
						<select name="major" id="major" lay-filter="major"
							lay-verify="required" lay-search="">
							<option value="">请选择或输入专业名称</option>
						</select>
					</div>
					<div class="layui-input-inline">
						<select name="classes" id="class" lay-filter="class"
							lay-verify="required" lay-search="">
							<option value="">请选择或输入班级名称</option>
						</select>
					</div>
					<div class="layui-input-inline" style="margin-left: -10px;">
						<button type="button" class="layui-btn layui-btn" lay-submit
							lay-filter="search">查询</button>
					</div>
			</form>
		</blockquote>
      
      <div class="layui-card-body">
      	<table class="layui-table" id="scoretable" lay-filter="demo"></table>
        <!-- <table id="LAY-user-manage" style="text-align: center;" class="layui-table" lay-filter="LAY-user-manage">
        	<thead>
        		<tr>
        			<td>序号</td>
        			<td>学院名称</td>
        			<td>学院分数</td>
        			<td>操作</td>
        		</tr>
        	</thead>
        	<tbody>
        		<tr>
        			<td>1</td>
        			<td>信息工程学院</td>
        			<td>88</td>
        			<td><button type="button" class="layui-btn layui-btn-sm layui-btn-normal">查看详情</button></td>
        		</tr>
        	</tbody>
        </table> -->
        <script type="text/html" id="imgTpl"> 
          <img style="display: inline-block; width: 50%; height: 100%;" src= {{ d.avatar }}>
        </script> 
        <script type="text/html" id="table-useradmin-webuser">
          <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
          <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
        </script>
      </div>
    </div>
<script src="layui/layui.all.js"></script>
<script src="js/jquery-2.1.1.min.js" charset="utf-8"></script>
<script id="barDemo" type="text/html">
    <button class="layui-btn layui-btn-sm layui-bg-green query">查看详情</button>
</script>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
  </div>
</script>
<script type="text/javascript">
	layui.use([ 'table', 'laydate', 'layer', 'jquery', 'form' ],function() {
		var table = layui.table;
		var $ = layui.jquery;
		var laydate = layui.laydate;
		var layer = layui.layer;
		var form = layui.form;

		//页面加载获取动态表格数据
		table.render({
			id : 'tableOne',
			elem : '#scoretable',
			toolbar : '#toolbarDemo',
			height : 'full-200', //高度最大化减去差值,
			url : 'getscore.action?op=class',
			page : true,
			even : true,
			limit : 5,
			limits : [ 5,10, 15 ],
			skin : "nob",
			cellMinWidth : 35, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
			//,toolbar: '#toolbarDemo'
			title : '用户数据表',
			cols : [ [ {
				align : 'center',
				field : '',
				title : '序号',
				type : 'numbers'
			},{
				align : 'center',
				field : 'classname',
				title : '班级名称'
			}, {
				align : 'center',
				field : 'majorname',
				title : '专业名称',
			}, {
				align : 'center',
				field : 'collegename',
				title : '学院名称',
			}, {
				align : 'center',
				field : 'allscore',
				title : '总成绩'
			}, {
				align : 'center',
				field : 'scorenumber',
				title : '平均成绩'
			}, {
				align : 'center',
				field : '',
				title : '操作',
				toolbar : '#barDemo'
			}, {
				field : 'classid',
				hide : true
			} ] ]
		});
		/* 下拉框三级联动 */
		var $ = layui.jquery;
		form.render('select');
		form.on('select(college)',function(data) {
			var hosid = data.value;
			$.ajax({
				type : "post",
				url : "getmajor.action",
				data : {
					collegeid : hosid
				},
				dataType : "json",
				success : function(succ) {
					if (succ == "失败") {
						layer
								.msg("请刷新后重试");
					} else {
						var tmp = '<option value="0">请选择或输入专业名称</option>';
						for ( var i in succ.data) {
							tmp += '<option value="' + succ.data[i].majorid +  '">'
									+ succ.data[i].majorname
									+ '</option>';
						}
						$("#major").html(tmp);
						var tmp2 = '<option value="0">请选择或输入班级名称</option>';
						$("#class").html(tmp2);
						form.render();
					}
				},
				error : function() {
					layer.msg('请求失败，稍后再试',{icon : 5});
				}
			});
		});
		form.on('select(major)',function(data) {
			var hosid = data.value;
			$.ajax({
				type : "post",
				url : "getclass.action",
				data : {
					majorid : hosid
				},
				dataType : "json",
				success : function(succ) {
					if (succ == "失败") {
						layer.msg("请刷新后重试");
					} else {
						var tmp = '<option value="0">请选择或输入班级名称</option>';
						for ( var i in succ.data) {
							tmp += '<option value="' + succ.data[i].classid +  '">'
									+ succ.data[i].classname
									+ '</option>';
						}
						$("#class").html(tmp);
						form.render();
					}
				},
				error : function() {
					layer.msg('请求失败，稍后再试',{icon : 5});
				}
			});
		});
		//查询提交
		form.on('submit(search)', function(data) {
			table.reload('tableOne', {
				method : 'post',
				where : {
					'collegeid' : data.field.college,
					'majorid' : data.field.major,
					'classid' : data.field.classes,
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
		var classid = $(this).parent().parent().next()
				.children().text().trim();
		window.location.href = "getscore.action?op=classdetail&classid="
				+ classid;
	});
</script>
</html>