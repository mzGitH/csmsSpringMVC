<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>比赛时间地点安排</title>
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
					<input type="text" name="sysmothed" id="sysmothed" placeholder="请输入查询条件" class="layui-input" autocomplete="off">
			    </div>
				<div class="layui-inline">
					<button id="btnselfrontinfo" type="button"
						class="layui-btn layui-bg-blue">查询</button>
				</div>
				<div class="layui-inline">
					<button id="btn_add" type="button"
						class="layui-btn layui-bg-blue">添加</button>
				</div>
			</form>
		</blockquote>
      
      <div class="layui-card-body">
      	<table id="projectlist" style="text-align: center;" class="layui-table" lay-filter="tool">
      	</table>
        <!-- <table id="LAY-user-manage" style="text-align: center;" class="layui-table" lay-filter="LAY-user-manage">
        	<thead>
        		<tr>
        			<td>序号</td>
        			<td>赛项名称</td>
        			<td>操作</td>
        		</tr>
        	</thead>
        	<tbody>
        		<tr>
        			<td>1</td>
        			<td>跳远</td>
        			<td><button type="button" class="layui-btn layui-btn-sm layui-btn-normal">编辑</button></td>
        		</tr>
        	</tbody>
        </table> -->
        <script type="text/html" id="imgTpl"> 
          <img style="display: inline-block; width: 50%; height: 100%;" src= {{ d.avatar }}>
        </script> 
        <script type="text/html" id="barDemo">
          <a class="layui-btn layui-btn-normal layui-btn-xs edit" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
          <a class="layui-btn layui-btn-danger layui-btn-xs del" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
		</script>
	</div>
</div>
<script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
<script src="../layui/layui.js" charset="utf-8"></script>
<script>
layui.use(['layer','upload','jquery','form','table'], function(){
	var layer = layui.layer,
	$=layui.jquery,
	upload = layui.upload;
	form = layui.form;
	table = layui.table;
	/*加载表格*/
	table.render({
		elem : '#projectlist',
		id:'projectlist',
		url : '../project/getprojectlist',
		title : '公告数据表',
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
			     title : '项目名称',
			     templet:function(data){
			     	return '<span>'+data.proname+'</span>'
			     	+'<input type="hidden" value="'+data.proid+'" />'
			     }
			 }, {
			     field : 'scenelimit',
			     align : 'center',
			     title : '场次人数限制',
			 }, {
			     field : 'collegelimit',
			     align : 'center',
			     title : '学院人数限制',
			 }, {
			     field : 'totallimit',
			     title : '总人数限制',
			     align : 'center',
	   		}, {
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
	   		},{
				title : '操作',
				toolbar : '#barDemo',
				align : 'center'
			}] 
		]
	});
	
	//删除按钮操作
	$(document).on('click',".del", function () {
		var proid = $(this).parent().parent().prev().prev().prev().prev().prev().find("input").val();
		layer.confirm('确定要删除么？', {
		  btn: ['确定','取消'],
		  icon:3
		}, function(){
			$.ajax({
        		type: 'get',
        		url: "../project/deleteproject",
        		dataType: 'json',
        		data:{
        			proid:proid
        		},
        		success:function(data){
        			if(data.code == 0){
        				layer.confirm(data.msg, {icon: 1,btn: ['确定']}, function(){
							table.reload("projectlist", { //此处是上文提到的 初始化标识id
				                where: {},
				                page: {
				                	curr:1
				                }
				            });	
							layer.closeAll();
						});     				 
        			}
        			else{
        				layer.confirm(data.msg, {
							  btn: ['确定']
						});
        			}
        		},
        		error:function(){
        			layer.confirm('出现错误，删除失败，请重试！', {
						  btn: ['确定']
					});
        		},
        	});   
		}, function(){ 
			layer.closeAll();
		});
	});
	
	/* 编辑按钮 */
	$(document).on('click',".edit", function () {
		var proid = $(this).parent().parent().prev().prev().prev().prev().prev().find("input").val();
		var proname = $(this).parent().parent().prev().prev().prev().prev().prev().find("span").text();
		var scenelimit = $(this).parent().parent().prev().prev().prev().prev().children().text();
		var colllimit = $(this).parent().parent().prev().prev().prev().children().text();
		var prolimit = $(this).parent().parent().prev().prev().children().text();
		var protype = $(this).parent().parent().prev().find("input").val();
		$("#proid").val(proid);
		$("#proname").val(proname);
		$("#colllimit").val(colllimit);
		$("#scenelimit").val(scenelimit);
		$("#prolimit").val(prolimit);
		$("#protype").val(protype);
		layer.open({
			title:"文章信息编辑",
			type: 1,
			area: ['500px', '500px'],
			skin: 'demo-class',
			btn:['确认保存'],
			maxmin: true,//显示最大化最小化按钮
			content: $('#div_content'),
			btn1: function(index, layero){
				var proid = $("#proid").val();
				var proname = $("#proname").val();
				var colllimit = $("#colllimit").val();
				var scenelimit = $("#scenelimit").val();
				var prolimit = $("#prolimit").val();
				var protype = $("#protype").val();
				$.ajax({
	        		type: 'get',
	        		url: "../project/editproject",
	        		dataType: 'json',
	        		data:{
	        			proid:proid,
		        		proname:proname,
		        		colllimit:colllimit,
		        		scenelimit:scenelimit,
		        		prolimit:prolimit,
		        		protype:protype
	        		},
	        		success:function(data){
	        			if(data.code == 0){
	        				layer.confirm(data.msg, {icon: 1,btn: ['确定']}, function(){
								table.reload("projectlist", { //此处是上文提到的 初始化标识id
					                where: {},
					                page: {
					                	curr:1
					                }
					            });	
								layer.closeAll();
							});          				 
	        			}
	        			else{
	        				layer.confirm(data.msg, {
	        					  icon: 7,
								  btn: ['确定']
							});
	        			}
	        		},
	        		error:function(){
	        			layer.confirm('出现错误，请重试！', {
	        				  icon: 6,
							  btn: ['确定']
						});
	        		},
	        	});  
			}
		});
	});
	
	/* 添加按钮 */
	$("#btn_add").click(function(){
		$("#proname").val("");
		$("#colllimit").val("");
		$("#scenelimit").val("");
		$("#prolimit").val("");
		$("#protype").val("");
		layer.open({
			title:"文章信息编辑",
			type: 1,
			area: ['500px', '500px'],
			skin: 'demo-class',
			btn:['确认保存'],
			maxmin: true,//显示最大化最小化按钮
			content: $('#div_content'),
			btn1: function(index, layero){
				var proname = $("#proname").val();
				var scenelimit = $("#scenelimit").val();
				var colllimit = $("#colllimit").val();
				var prolimit = $("#prolimit").val();
				var protype = $("#protype").val();
				$.ajax({
	        		type: 'get',
	        		url: "../project/addproject",
	        		dataType: 'json',
	        		data:{
		        		proname:proname,
		        		scenelimit:scenelimit,
		        		colllimit:colllimit,
		        		prolimit:prolimit,
		        		protype:protype
	        		},
	        		success:function(data){
	        			if(data.code == 0){
	        				layer.confirm(data.msg, {
	        				icon: 1,
							  btn: ['确定']
							}, function(){
								table.reload("projectlist", { //此处是上文提到的 初始化标识id
					                where: {},
					                page: {
					                	curr:1
					                }
					            });	
								layer.closeAll();
							});          				 
	        			}
	        			else{
	        				layer.confirm(data.msg, {
	        					  icon: 7,
								  btn: ['确定']
							});
	        			}
	        		},
	        		error:function(){
	        			layer.confirm('出现错误，请重试！', {
	        				  icon: 6,
							  btn: ['确定']
						});
	        		},
	        	});
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
					<!-- <div class="layui-form-item">
						<label class="layui-form-label">项目类型</label>
						<div class="layui-input-block">
							<select name="protype" id="protype" lay-verify="">
								<option value="0">请选择一个项目类型</option>
								<option value="1">学生个人赛</option>
								<option value="2">学生团体赛</option>
								<option value="3">教师个人赛</option>
								<option value="4">教师团体赛</option>
							</select> 
						</div>
					</div> -->
				</form>
			</div>
		</div>
	</div>
</div>
</body>
		   
</html>
