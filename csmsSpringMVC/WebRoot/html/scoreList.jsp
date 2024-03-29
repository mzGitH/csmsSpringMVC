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
					<select name="statistics" id="statistics" lay-filter="statistics"
						lay-verify="required" lay-search="">
						<option value="project">项目统计</option>
						<option value="college">学院统计</option>
						<option value="major">专业统计</option>
						<option value="classes">班级统计</option>
						<option value="user">个人统计</option>
					</select>
				</div>
				<div class="layui-input-inline projectdiv">
					<select name="project" id="project" lay-filter="project"
						lay-search="">
						<option value="">请选择或输入项目名称</option>
					</select>
				</div>
				<div class="layui-input-inline collegediv">
					<select name="college" id="college" lay-filter="college"
						lay-search="">
						<option value="">请选择或输入学院名称</option>
					</select>
				</div>
				<div class="layui-input-inline majordiv">
					<select name="major" id="major" lay-filter="major"
						lay-search="">
						<option value="">请选择或输入专业名称</option>
					</select>
				</div>
				<div class="layui-input-inline classesdiv">
					<select name="classes" id="classes" lay-filter="classes"
						lay-search="">
						<option value="">请选择或输入班级名称</option>
					</select>
				</div>
				<div class="layui-input-inline sportdiv">
					<select name="sport" id="sport" lay-filter="sport"
						lay-search="">
						<option value="">请选择或输入赛事名称</option>
					</select>
				</div>
				<div class="layui-input-inline userdiv">
					<input type="text" name="username" id="username" placeholder="请输入运动员学号或姓名" class="layui-input" autocomplete="off">
			    </div>
				<div class="layui-input-inline" style="margin-left: -10px;">
					<button type="button" class="layui-btn layui-btn" lay-submit
						lay-filter="search">查询</button>
				</div>
			</form>
		</blockquote>
      
      <div class="layui-card-body">
      	<table class="layui-table" id="tabledata" lay-filter="tabledata"></table>
      </div>
    </div>
<script src="../layui/layui.all.js"></script>
<script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
<script id="barDemoproject" type="text/html">
    <button class="layui-btn layui-btn-sm layui-bg-green queryproject">查看详情</button>
</script>
<script id="barDemocollege" type="text/html">
    <button class="layui-btn layui-btn-sm layui-bg-green querycollege">查看详情</button>
</script>
<script id="barDemomajor" type="text/html">
    <button class="layui-btn layui-btn-sm layui-bg-green querymajor">查看详情</button>
</script>
<script id="barDemoclasses" type="text/html">
    <button class="layui-btn layui-btn-sm layui-bg-green queryclasses">查看详情</button>
</script>
<script id="barDemouser" type="text/html">
    <button class="layui-btn layui-btn-sm layui-bg-green queryuser">查看详情</button>
</script>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container"></div>
</script>
<script type="text/javascript">
layui.use([ 'table', 'form', 'jquery', 'layer' ],function() {
	var layer = layui.layer;
	var table = layui.table;
	var form = layui.form;
	var $ = layui.jquery;
	/* 通过项目统计成绩 */
	function getProject(){
		table.render({
		id : 'tabledata',
		elem : '#tabledata',
		toolbar : '#toolbarDemo',
		height : 'full-200', //高度最大化减去差值,
		url : '../score/getprojectscore',
		page : true,
		even : true,
		limit : 5,
		limits : [ 5,10, 15 ],
		skin : "nob",
		cellMinWidth : 35, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
		//,toolbar: '#toolbarDemo'
		title : '用户数据表',
		cols : [ [
			{
				align : 'center',
				field : '',
				title : '序号',
				type : 'numbers'
			},
			{
				align : 'center',
				field : 'proname',
				title : '项目名称',
				templet:function(data){
					return '<span>'+data.proname+'</span>'
						+'<input type="hidden" value="'+data.proid+'" />'
				}
			},
			{
				align : 'center',
				field : 'userid',
				title : '学号/工号'
			},
			{
				align : 'center',
				field : 'username',
				title : '姓名'
			},
			{
				align : 'center',
				field : 'scorenumber',
				title : '最好成绩'
			},
			{
				align : 'center',
				field : 'collegename',
				title : '学院名称'
			},
			{
				align : 'center',
				field : 'majorname',
				title : '专业名称'
			},
			{
				align : 'center',
				field : 'classname',
				title : '班级名称'
			},{
				align : 'center',
				field : 'sportname',
				title : '赛事名称',
				templet:function(data){
					return '<span>'+data.sportname+'</span>'
						+'<input type="hidden" value="'+data.sportid+'" />'
				}
			},
			{
				align : 'center',
				field : '',
				title : '操作',
				toolbar : '#barDemoproject'
			} ] ]
		});
	}
	/* 通过学院统计成绩 */
	function getCollege(){
		table.render({
		id : 'tabledata',
		elem : '#tabledata',
		toolbar : '#toolbarDemo',
		height : 'full-200', //高度最大化减去差值,
		url : '../score/getcollegescore',
		page : true,
		even : true,
		limit : 5,
		limits : [ 5,10, 15 ],
		skin : "nob",
		cellMinWidth : 35, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
		//,toolbar: '#toolbarDemo'
		title : '用户数据表',
		cols : [ [
			{
				align : 'center',
				field : '',
				title : '序号',
				type : 'numbers'
			},
			{
				align : 'center',
				field : 'collegename',
				title : '学院名称',
				templet:function(data){
					return '<span>'+data.collegename+'</span>'
						+'<input type="hidden" value="'+data.collegeid+'" />'
				}
			},
			{
				align : 'center',
				field : 'allscore',
				title : '总成绩'
			},
			{
				align : 'center',
				field : 'scorenumber',
				title : '平均成绩'
			},
			{
				align : 'center',
				field : 'sportname',
				title : '赛事名称',
				templet:function(data){
					return '<span>'+data.sportname+'</span>'
						+'<input type="hidden" value="'+data.sportid+'" />'
				}
			},
			{
				align : 'center',
				field : '',
				title : '操作',
				toolbar : '#barDemocollege'
			} ] ]
		});
	}
	/* 通过专业统计成绩 */
	function getMajor(){
		table.render({
		id : 'tabledata',
		elem : '#tabledata',
		toolbar : '#toolbarDemo',
		height : 'full-200', //高度最大化减去差值,
		url : '../score/getmajorscore',
		page : true,
		even : true,
		limit : 5,
		limits : [ 5,10, 15 ],
		skin : "nob",
		cellMinWidth : 35, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
		//,toolbar: '#toolbarDemo'
		title : '用户数据表',
		cols : [ [
			{
				align : 'center',
				field : '',
				title : '序号',
				type : 'numbers'
			},
			{
				align : 'center',
				field : 'majorname',
				title : '专业名称',
				templet:function(data){
					return '<span>'+data.majorname+'</span>'
						+'<input type="hidden" value="'+data.majorid+'" />'
				}
			},
			{
				align : 'center',
				field : 'collegename',
				title : '学院名称'
			},
			{
				align : 'center',
				field : 'allscore',
				title : '总成绩'
			},
			{
				align : 'center',
				field : 'scorenumber',
				title : '平均成绩'
			},
			{
				align : 'center',
				field : 'sportname',
				title : '赛事名称',
				templet:function(data){
					return '<span>'+data.sportname+'</span>'
						+'<input type="hidden" value="'+data.sportid+'" />'
				}
			},
			{
				align : 'center',
				field : '',
				title : '操作',
				toolbar : '#barDemomajor'
			} ] ]
		});
	}
	/* 通过班级统计成绩 */
	function getClasses(){
		table.render({
		id : 'tabledata',
		elem : '#tabledata',
		toolbar : '#toolbarDemo',
		height : 'full-200', //高度最大化减去差值,
		url : '../score/getclassesscore',
		page : true,
		even : true,
		limit : 5,
		limits : [ 5,10, 15 ],
		skin : "nob",
		cellMinWidth : 35, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
		//,toolbar: '#toolbarDemo'
		title : '用户数据表',
		cols : [ [
			{
				align : 'center',
				field : '',
				title : '序号',
				type : 'numbers'
			},
			{
				align : 'center',
				field : 'classname',
				title : '班级名称',
				templet:function(data){
					return '<span>'+data.classname+'</span>'
						+'<input type="hidden" value="'+data.classid+'" />'
				}
			},
			{
				align : 'center',
				field : 'majorname',
				title : '专业名称'
			},
			{
				align : 'center',
				field : 'collegename',
				title : '学院名称'
			},
			{
				align : 'center',
				field : 'allscore',
				title : '总成绩'
			},
			{
				align : 'center',
				field : 'scorenumber',
				title : '平均成绩'
			},
			{
				align : 'center',
				field : 'sportname',
				title : '赛事名称',
				templet:function(data){
					return '<span>'+data.sportname+'</span>'
						+'<input type="hidden" value="'+data.sportid+'" />'
				}
			},
			{
				align : 'center',
				field : '',
				title : '操作',
				toolbar : '#barDemoclasses'
			} ] ]
		});
	}
	/* 通过用户统计成绩 */
	function getUser(){
		table.render({
		id : 'tabledata',
		elem : '#tabledata',
		toolbar : '#toolbarDemo',
		height : 'full-200', //高度最大化减去差值,
		url : '../score/getuserscore',
		page : true,
		even : true,
		limit : 5,
		limits : [ 5,10, 15 ],
		skin : "nob",
		cellMinWidth : 35, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
		//,toolbar: '#toolbarDemo'
		title : '用户数据表',
		cols : [ [
			{
				align : 'center',
				field : '',
				title : '序号',
				type : 'numbers'
			},
			{
				align : 'center',
				field : 'userid',
				title : '学号/工号'
			},
			{
				align : 'center',
				field : 'username',
				title : '姓名'
			},
			{
				align : 'center',
				field : 'allscore',
				title : '总成绩'
			},
			{
				align : 'center',
				field : 'scorenumber',
				title : '平均成绩'
			},
			{
				align : 'center',
				field : 'collegename',
				title : '学院名称'
			},
			{
				align : 'center',
				field : 'majorname',
				title : '专业名称',
				templet:function(data){
					if(data.majorid==undefined){
						return '教职工'
					}else{
						return data.majorname
					}
				}
			},
			{
				align : 'center',
				field : 'classname',
				title : '班级名称'
			},
			{
				align : 'center',
				field : 'sportname',
				title : '赛事名称',
				templet:function(data){
					return '<span>'+data.sportname+'</span>'
						+'<input type="hidden" value="'+data.sportid+'" />'
				}
			},
			{
				align : 'center',
				field : '',
				title : '操作',
				toolbar : '#barDemouser'
			} ] ]
		});
	}
	/* 获取学院搜索下拉框数据 */
	function collegelist(){
		$.ajax({
			type : "post",
			url : "../college/getallcollege",
			data : {},
			dataType : "json",
			success : function(succ) {
				if (succ == "失败") {
					layer.msg("请刷新后重试");
				} else {
					var tmp = '<option value="">请选择或输入学院名称</option>';
					for ( var i in succ.data) {
						tmp += '<option value="' + succ.data[i].collegeid +  '">'
								+ succ.data[i].collegename
								+ '</option>';
					}
					$("#college").html(tmp);
					form.render();
				}
			},
			error : function() {
				layer.msg('请求失败，稍后再试',{icon : 5});
			}

		});
	}
	/* 根据所选学院获取专业搜索下拉框数据 */
	form.on('select(college)',function(data) {
		var hosid = data.value;
		$.ajax({
			type : "post",
			url : "../major/getallmajor",
			data : {
				collegeid : hosid
			},
			dataType : "json",
			success : function(succ) {
				if (succ == "失败") {
					layer.msg("请刷新后重试");
				} else {
					var tmp = '<option value="">请选择或输入专业名称</option>';
					for ( var i in succ.data) {
						tmp += '<option value="' + succ.data[i].majorid +  '">'
								+ succ.data[i].majorname
								+ '</option>';
					}
					$("#major").html(tmp);
					var tmp2 = '<option value="">请选择或输入班级名称</option>';
					$("#classes").html(tmp2);
					form.render();
				}
			},
			error : function() {
				layer.msg('请求失败，稍后再试',{icon : 5});
			}

		});
	});
	/* 根据所选专业获取班级搜索下拉框数据 */
	form.on('select(major)',function(data) {
		var hosid = data.value;
		$.ajax({
			type : "post",
			url : "../classes/getallclasses",
			data : {
				majorid : hosid
			},
			dataType : "json",
			success : function(succ) {
				if (succ == "失败") {
					layer.msg("请刷新后重试");
				} else {
					var tmp = '<option value="">请选择或输入班级名称</option>';
					for ( var i in succ.data) {
						tmp += '<option value="' + succ.data[i].classid +  '">'
								+ succ.data[i].classname
								+ '</option>';
					}
					$("#classes").html(tmp);
					form.render();
				}
			},
			error : function() {
				layer.msg('请求失败，稍后再试',{icon : 5});
			}

		});
	});
	/* 获取赛事筛选下拉框数据 */
	function sportlist(){
		$.ajax({
			type : "post",
			url : "../sports/getsport",
			data : {},
			dataType : "json",
			success : function(succ) {
				if (succ == "失败") {
					layer.msg("请刷新后重试");
				} else {
					var tmp = '<option value="">请选择或输入赛事名称</option>';
					for ( var i in succ.data) {
						tmp += '<option value="' + succ.data[i].sportid +  '">'
								+ succ.data[i].sportname
								+ '</option>';
					}
					$("#sport").html(tmp);
					form.render();
				}
			},
			error : function() {
				layer.msg('请求失败，稍后再试',{icon : 5});
			}

		});
	}
	/* 获取项目搜索下拉框数据 */
	function projectlist(){
		$.ajax({
			type : "post",
			url : "../project/getproject",
			data : {},
			dataType : "json",
			success : function(succ) {
				if (succ == "失败") {
					layer.msg("请刷新后重试");
				} else {
					var tmp = '<option value="0">请选择或输入项目名称</option>';
					for ( var i in succ.data) {
						if(succ.data[i].protype==1){
							tmp += '<option value="' + succ.data[i].proid +  '">'
								+ succ.data[i].proname
								+ '(学生个人赛)</option>';
						}else if(succ.data[i].protype==2){
							tmp += '<option value="' + succ.data[i].proid +  '">'
								+ succ.data[i].proname
								+ '(学生团体赛)</option>';
						}else if(succ.data[i].protype==3){
							tmp += '<option value="' + succ.data[i].proid +  '">'
								+ succ.data[i].proname
								+ '(教师个人赛)</option>';
						}else if(succ.data[i].protype==4){
							tmp += '<option value="' + succ.data[i].proid +  '">'
								+ succ.data[i].proname
								+ '(教师团体赛)</option>';
						}
					}
					$("#project").html(tmp);
					form.render();
				}
			},
			error : function() {
				layer.msg('请求失败，稍后再试',{icon : 5});
			}

		});
	}
	/* 统计下拉框改变事件 */
	form.on('select(statistics)',function(data) {
		form.render();
		/* 获取统计方式 */
		var statistics = $("#statistics").val();
		if(statistics == "project"){
			getProject();
			$(".projectdiv").show();
			$(".collegediv").hide();
			$(".majordiv").hide();
			$(".classesdiv").hide();
			$(".userdiv").hide();
		}else if(statistics == "college"){
			getCollege();
			$(".projectdiv").hide();
			$(".collegediv").show();
			$(".majordiv").hide();
			$(".classesdiv").hide();
			$(".userdiv").hide();
		}else if(statistics == "major"){
			getMajor();
			$(".projectdiv").hide();
			$(".collegediv").show();
			$(".majordiv").show();
			$(".classesdiv").hide();
			$(".userdiv").hide();
		}else if(statistics == "classes"){
			getClasses();
			$(".projectdiv").hide();
			$(".collegediv").show();
			$(".majordiv").show();
			$(".classesdiv").show();
			$(".userdiv").hide();
		}else if(statistics == "user"){
			getUser();
			$(".projectdiv").hide();
			$(".collegediv").show();
			$(".majordiv").show();
			$(".classesdiv").show();
			$(".userdiv").show();
		}
	});
	//查询提交
	form.on('submit(search)', function(data) {
		var sport = $("#sport").val();
		var project = $("#project").val();
		var college = $("#college").val();
		var major = $("#major").val();
		var classes = $("#classes").val();
		var username = $("#username").val();
		table.reload('tabledata', {
			method : 'post',
			where : {
				'sport' : sport,
				'project' : project,
				'college' : college,
				'major' : major,
				'classes' : classes,
				'username' : username
			},
			page : {
				curr : 1
			}
		});
		return false;
	});
	/* 页面加载 */
	$(document).ready(function() {
		/* 加载筛选下拉框数据 */
		collegelist();
		projectlist();
		sportlist();
		getProject();
		
		$(".projectdiv").show();
		$(".collegediv").hide();
		$(".majordiv").hide();
		$(".classesdiv").hide();
		$(".userdiv").hide();
	})
	/* 查看详情点击事件 */
	$(document).on('click',".queryproject",function() {
		var proid = $(this).parent().parent()
				.prev().prev().prev().prev()
				.prev().prev().prev().prev()
				.find("input").val().trim();
		var sportid = $(this).parent().parent()
				.prev().find("input").val().trim();
		window.location.href = "scoreDetail.jsp?type=project&typeid="+proid+"&sportid="+sportid;
	});
	/* 查看详情点击事件 */
	$(document).on('click',".querycollege",function() {
		var collegeid = $(this).parent().parent()
				.prev().prev().prev().prev()
				.find("input").val().trim();
		var sportid = $(this).parent().parent()
				.prev().find("input").val().trim();
		window.location.href = "scoreDetail.jsp?type=college&typeid="+collegeid+"&sportid="+sportid;
	});
	/* 查看详情点击事件 */
	$(document).on('click',".querymajor",function() {
		var majorid = $(this).parent().parent()
				.prev().prev().prev().prev().prev()
				.find("input").val().trim();
		var sportid = $(this).parent().parent()
				.prev().find("input").val().trim();
		window.location.href = "scoreDetail.jsp?type=major&typeid="+majorid+"&sportid="+sportid;
	});
	/* 查看详情点击事件 */
	$(document).on('click',".queryclasses",function() {
		var classesid = $(this).parent().parent()
				.prev().prev().prev().prev().prev()
				.prev().find("input").val().trim();
		var sportid = $(this).parent().parent()
				.prev().find("input").val().trim();
		window.location.href = "scoreDetail.jsp?type=classes&typeid="+classesid+"&sportid="+sportid;
	});
	/* 查看详情点击事件 */
	$(document).on('click',".queryuser",function() {
		var userid = $(this).parent().parent()
				.prev().prev().prev().prev()
				.prev().prev().prev().prev()
				.children().text().trim();
		var sportid = $(this).parent().parent()
				.prev().find("input").val().trim();
		window.location.href = "scoreDetail.jsp?type=user&typeid="+userid+"&sportid="+sportid;
	});
});
</script>
</body>
		   
</html>
