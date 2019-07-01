<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>赛事管理页面</title>
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
	 .div_addsport_label {
		float: right;
	}.div_addsport_input {
		float: left;
	}
</style>
<body>
  <div class="layui-fluid" style="margin-top: 10px">
      <div class="layui-card-body">
			<center>
				<label>历届运动会信息</label>
			</center>
			<button type="button" id="btn_add" class="layui-btn layui-btn-normal">添加</button>
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
layui.use(['layer','upload','jquery','form','table','laydate'], function(){
	var layer = layui.layer,
	$=layui.jquery,
	upload = layui.upload;
	form = layui.form;
	table = layui.table;
	laydate = layui.laydate;
	
	/* 加载时间选择器 */
	laydate.render({
	    elem: '#starttime',
	    format:'yyyy-MM-dd',
        type:'date',
        trigger: 'click'
	});
	laydate.render({
	    elem: '#endtime',
	    format:'yyyy-MM-dd',
        type:'date',
        trigger: 'click'
	});
	laydate.render({
	    elem: '#reportstart',
	    format:'yyyy-MM-dd HH:mm:ss',
        type:'datetime',
        trigger: 'click'
	});
	laydate.render({
	    elem: '#reportend',
	    format:'yyyy-MM-dd HH:mm:ss',
        type:'datetime',
        trigger: 'click'
	});
	/*加载表格*/
	table.render({
		elem : '#projectlist',
		id:'projectlist',
		url : '../sports/getsportslist',
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
			     field : 'sportname',
			     align : 'center',
			     title : '项目名称',
			     templet:function(data){
			     	return '<span>'+data.sportname+'</span>'
			     	+'<input type="hidden" value="'+data.sportid+'" />'
			     }
			 }, {
			     field : 'starttime',
			     align : 'center',
			     title : '运动会开始时间',
			 }, {
			     field : 'endtime',
			     align : 'center',
			     title : '运动会结束时间',
			 }, {
			     field : 'reportstart',
			     title : '报名开始时间',
			     align : 'center',
	   		}, {
			     field : 'reportend',
			     title : '报名结束时间',
			     align : 'center'
	   		}, {
			     field : 'iscomplete',
			     title : '运动会状态',
			     align : 'center',
			     templet:function(data){
			     	if(data.iscomplete){
			     		return "<span style='color:green;'>进行中</span>";
			     	}else{
			     		return "<span>未开始/已结束</span>";
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
		var sportid = $(this).parent().parent().prev().prev().prev().prev().prev().prev().find("input").val();
		layer.confirm('确定要删除么？', {
		  btn: ['确定','取消'],
		  icon:3
		}, function(){
			$.ajax({
        		type: 'get',
        		url: "../sports/deletesports",
        		dataType: 'json',
        		data:{
        			sportid:sportid
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
	
	/* 添加按钮 */
	$("#btn_add").click(function(){
		$("#sportname").val("");
		$("#starttime").val("");
		$("#endtime").val("");
		$("#reportstart").val("");
		$("#reportend").val("");
		layer.open({
			title:"文章信息编辑",
			type: 1,
			area: ['500px', '500px'],
			skin: 'demo-class',
			btn:['确认保存'],
			maxmin: true,//显示最大化最小化按钮
			content: $('#div_content'),
			btn1: function(index, layero){
				var sportname = $("#sportname").val();
				var starttime = $("#starttime").val();
				var endtime = $("#endtime").val();
				var reportstart = $("#reportstart").val();
				var reportend = $("#reportend").val();
				var isnull = false;
				/* 非空判断 */
				if(sportname!=null&&sportname!=""){
					if(starttime!=null&&starttime!=""){
						if(endtime!=null&&endtime!=""){
							if(reportstart!=null&&reportstart!=""){
								if(reportend!=null&&reportend!=""){
									isnull = true;
								}
							}
						}
					}
				}
				if(isnull){
					/* 判断时间大小 */
					if(compareDate(starttime,endtime)){
						if(compareDate(reportstart,reportend)){
							if(compareDate(reportend,starttime)){
								$.ajax({
					        		type: 'get',
					        		url: "../sports/addsports",
					        		dataType: 'json',
					        		data:{
						        		sportname:sportname,
						        		starttime:starttime,
						        		endtime:endtime,
						        		reportstart:reportstart,
						        		reportend:reportend
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
				        	}else{
								layer.confirm("报名结束时间不能晚于运动会开始时间", {
		        					  icon: 7,
									  btn: ['确定']
								});
							}
						}else{
							layer.confirm("报名开始时间不能晚于结束时间", {
	        					  icon: 7,
								  btn: ['确定']
							});
						}
					}else{
						layer.confirm("运动会开始时间不能晚于结束时间", {
	       					  icon: 7,
							  btn: ['确定']
						});
					}
				}else{
					layer.confirm("含有非空项，请检查后再提交", {
       					  icon: 7,
						  btn: ['确定']
					});
				}
	        }
		});
	});
	
	/* 编辑按钮 */
	$(document).on('click',".edit", function () {
		var sportid = $(this).parent().parent().prev().prev().prev().prev().prev().prev().find("input").val();
		var sportname = $(this).parent().parent().prev().prev().prev().prev().prev().prev().find("span").text();
		var starttime = $(this).parent().parent().prev().prev().prev().prev().prev().children().text();
		var endtime = $(this).parent().parent().prev().prev().prev().prev().children().text();
		var reportstart = $(this).parent().parent().prev().prev().prev().children().text();
		var reportend = $(this).parent().parent().prev().prev().children().text();
		$("#sportid").val(sportid);
		$("#sportname").val(sportname);
		$("#starttime").val(getDate(starttime,"date"));
		$("#endtime").val(getDate(endtime,"date"));
		$("#reportstart").val(getDate(reportstart,"datetime"));
		$("#reportend").val(getDate(reportend,"datetime"));
		var aaa = getDate(starttime,"date");
		var bbb = getDate(reportend,"datetime");
		layer.open({
			title:"文章信息编辑",
			type: 1,
			area: ['500px', '500px'],
			skin: 'demo-class',
			btn:['确认保存'],
			maxmin: true,//显示最大化最小化按钮
			content: $('#div_content'),
			btn1: function(index, layero){
				var sportid = $("#sportid").val();
				var sportname = $("#sportname").val();
				var starttime = $("#starttime").val();
				var endtime = $("#endtime").val();
				var reportstart = $("#reportstart").val();
				var reportend = $("#reportend").val();
				var isnull = false;
				/* 非空判断 */
				if(sportname!=null&&sportname!=""){
					if(starttime!=null&&starttime!=""){
						if(endtime!=null&&endtime!=""){
							if(reportstart!=null&&reportstart!=""){
								if(reportend!=null&&reportend!=""){
									isnull = true;
								}
							}
						}
					}
				}
				if(isnull){
					/* 判断时间大小 */
					if(compareDate(starttime,endtime)){
						if(compareDate(reportstart,reportend)){
							if(compareDate(reportend,starttime)){
								$.ajax({
					        		type: 'get',
					        		url: "../sports/editsports",
					        		dataType: 'json',
					        		data:{
					        			sportid:sportid,
					        			sportname:sportname,
						        		starttime:starttime,
						        		endtime:endtime,
						        		reportstart:reportstart,
						        		reportend:reportend
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
					        }else{
								layer.confirm("报名结束时间不能晚于运动会开始时间", {
		        					  icon: 7,
									  btn: ['确定']
								});
							}
						}else{
							layer.confirm("报名开始时间不能晚于结束时间", {
	        					  icon: 7,
								  btn: ['确定']
							});
						}
					}else{
						layer.confirm("运动会开始时间不能晚于结束时间", {
	       					  icon: 7,
							  btn: ['确定']
						});
					}
				}else{
					layer.confirm("含有非空项，请检查后再提交", {
       					  icon: 7,
						  btn: ['确定']
					});
				}
			}
		});
	});
	/* 比较时间大小 */
	function compareDate(starttime, endtime) {
	    var start = new Date(starttime.replace("-", "/").replace("-", "/"));
		var end = new Date(endtime.replace("-", "/").replace("-", "/"));
		if(start>=end){  
			return false;  
		}else{
			return true;
		}
	}
	/* 时间字符串转日期时间格式 */
	function getDate(strDate,type) {  
		// 转换日期格式
		strDate = strDate.replace(/-/g, '/'); // "2010/08/01";
		// 创建日期对象
		var date = new Date(strDate);
		// 加一天
		date.setDate(date.getDate() + 1);
		//判断日期格式为date还是datetime
		if(type=="date"){
			strDate = date.getFullYear() + '-'
			    + (parseInt(date.getMonth()) + 1) + '-' + date.getDate();
		}else{
			strDate = date.getFullYear() + '-'
			    + (parseInt(date.getMonth()) + 1) + '-' + date.getDate() 
			    + ' '+date.getHours()+':'+date.getMinutes()+':'+date.getSeconds();
		}
		return strDate;
    }
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
						<label class="layui-form-label">运动会名称</label>
						<div class="layui-input-block">
							<!-- required -->
							<input type="text" name="sportname" id="sportname"
								lay-verify="required" placeholder="请输入项目名称"
								autocomplete="off" class="layui-input layui-bg-gary">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">运动会开始时间</label>
						<div class="layui-input-block">
							<input type="text" name="starttime" class="layui-input" id="starttime"
								lay-verify="date" placeholder="请选择运动会开始时间"
								 autocomplete="off" class="layui-input layui-bg-gary">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">运动会结束时间</label>
						<div class="layui-input-block">
							<input type="text" name="endtime" class="layui-input" id="endtime"
								lay-verify="date" placeholder="请选择运动会结束时间"
								 autocomplete="off" class="layui-input layui-bg-gary">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">报名开始时间</label>
						<div class="layui-input-block">
							<input type="text" name="reportstart" class="layui-input" id="reportstart"
								lay-verify="date" placeholder="请选择报名开始时间"
								 autocomplete="off" class="layui-input layui-bg-gary">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">报名结束时间</label>
						<div class="layui-input-block">
							<input type="text" name="reportend" class="layui-input" id="reportend"
								lay-verify="date" placeholder="请选择报名结束时间"
								 autocomplete="off" class="layui-input layui-bg-gary">
						</div>
					</div>
					<input type="hidden" id="sportid" value="" />
				</form>
			</div>
		</div>
	</div>
</div>
</body>
		   
</html>
