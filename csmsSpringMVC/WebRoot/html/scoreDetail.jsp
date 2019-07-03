<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>成绩详情</title>
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
			<!-- <form class="layui-form">
				<div class="layui-input-inline">
					<select name="protype" id="protype" lay-filter="protype"
						lay-verify="required" lay-search="">
						<option value="">请选择或输入项目类型</option>
						<option value="1">学生个人赛</option>
						<option value="2">学生团体赛</option>
						<option value="3">教师个人赛</option>
						<option value="4">教师团体赛</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<input type="text" name="proname" id="proname" placeholder="请输入项目名称" class="layui-input" autocomplete="off">
			    </div>
				<div class="layui-inline">
					<button id="btnselfrontinfo" type="button"
						class="layui-btn layui-bg-blue">查询</button>
				</div>
				<div class="layui-inline">
					<button id="btn_add" type="button"
						class="layui-btn layui-bg-blue">添加</button>
				</div>
			</form> -->
		</blockquote>
      
      <div class="layui-card-body">
      	<table id="projectlist" style="text-align: center;" class="layui-table" lay-filter="tool">
      	</table>
	</div>
</div>
<script type="text/html" id="imgTpl"> 
	<img style="display: inline-block; width: 50%; height: 100%;" src= {{ d.avatar }}>
</script> 
<script type="text/html" id="barDemo">
	<a class="layui-btn layui-btn-normal layui-btn-xs edit" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
	<a class="layui-btn layui-btn-danger layui-btn-xs del" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
</script>
<script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
<script src="../layui/layui.js" charset="utf-8"></script>
<script>
layui.use(['layer','upload','jquery','form','table'], function(){
	var layer = layui.layer,
	$=layui.jquery,
	upload = layui.upload;
	form = layui.form;
	table = layui.table;
	/* 获取地址栏参数 */
	function getQueryString(name){
	    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	    var r = window.location.search.substr(1).match(reg);
	    if(r!=null)return  unescape(r[2]); return null;
	}
	var type=getQueryString("type");
	var typeid=getQueryString("typeid");
	var sportid=getQueryString("sportid");
	var uri = "../score/getdetail?type="+type+"&typeid="+typeid+"&sportid="+sportid
	/*加载表格*/
	table.render({
		elem : '#projectlist',
		id:'projectlist',
		url : uri,
		title : '成绩详情表',
		height: "full-160",
		even : true,
		page: {
			layout: ['prev', 'page', 'next', 'skip', 'count', 'limit'],
			groups: 5,
			limit: 10,
			limits: [1, 4, 5, 10, 50],
			theme: '#1E9FFF',						
		},
		cols : [ 
		     [ {
				type : 'numbers',
				title : '序号',
				align : 'center',
				
			}, {
			     field : 'proname',
			     align : 'center',
			     title : '项目名称'
			},{
			     field : 'protype',
			     title : '项目类型',
			     align : 'center',
			     templet:function(data){
				     if(data.protype==1){
				     	return '<span>学生个人赛</span>'
				     	+'<input type="hidden" value="'+data.protype+'" />';
				     }else if(data.protype==2){
				     	return '<span>学生团体赛</span>'
				     	+'<input type="hidden" value="'+data.protype+'" />';
				     }else if(data.protype==3){
				     	return '<span>教师个人赛</span>'
				     	+'<input type="hidden" value="'+data.protype+'" />';
				     }else if(data.protype==4){
				     	return '<span>教师团体赛</span>'
				     	+'<input type="hidden" value="'+data.protype+'" />';
				     }
			     }
	   		}, {
			     field : 'scorenumber',
			     align : 'center',
			     title : '成绩'
			}, {
			     field : 'userid',
			     align : 'center',
			     title : '学号/工号'
			}, {
			     field : 'username',
			     align : 'center',
			     title : '运动员姓名'
			}, {
			     field : 'collegename',
			     align : 'center',
			     title : '学院名称'
			}, {
			     field : 'majorname',
			     align : 'center',
			     title : '专业名称'
			}, {
			     field : 'classname',
			     align : 'center',
			     title : '班级名称'
			}] 
		]
	});
	/* 查询按钮事件 */
	$("#btnselfrontinfo").click(function() {
		var protype = $("#protype").val();
		var proname = $("#proname").val();
		table.reload('projectlist', {
			method : 'post',
			where : {
				'protype' : protype,
				'proname' : proname
			},
			page : {
				curr : 1
			}
		});
	});
});
</script>
<div class="layui-card" id="div_content" style="display: none;height:450px;">
	<div class="layui-card-body">
		<div class="layui-card">
			<div class="layui-card-body">
				<!--表单开始-->
				<form class="layui-form">
					<input type="hidden" id="proid" value="" />
					<div class="layui-form-item">
						<label class="layui-form-label">项目名称</label>
						<div class="layui-input-block">
							<input type="text" name="proname" id="proname" required
								lay-verify="required" placeholder="请输入项目名称"
								autocomplete="off" class="layui-input layui-bg-gary">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">比赛人数限制</label>
						<div class="layui-input-block">
							<input type="number" name="scenelimit" id="scenelimit" required
								lay-verify="required" placeholder="请输入每场比赛限制"
								 autocomplete="off" class="layui-input layui-bg-gary">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">学院人数限制</label>
						<div class="layui-input-block">
							<input type="number" name="colllimit" id="colllimit" required
								lay-verify="required" placeholder="请输入学院人数限制"
								 autocomplete="off" class="layui-input layui-bg-gary">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">总人数限制</label>
						<div class="layui-input-block">
							<input type="number" name="prolimit" id="prolimit" required
								lay-verify="required" placeholder="请输入项目总人数限制"
								 autocomplete="off" class="layui-input layui-bg-gary">
						</div>
					</div>
					<input id="protype" type="hidden" value="" />
				</form>
			</div>
		</div>
	</div>
</div>
</body>
		   
</html>
