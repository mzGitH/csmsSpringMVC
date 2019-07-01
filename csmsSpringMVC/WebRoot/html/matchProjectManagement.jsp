<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>赛事赛项管理</title>
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
					<select name="sport" id="sport" lay-filter="sport"
						lay-verify="required" lay-search="">
						<option value="">请选择或输入赛事名称</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<select name="project" id="project" lay-filter="project"
						lay-verify="required" lay-search="">
						<option value="">请选择或输入项目名称</option>
					</select>
				</div>
				<div class="layui-inline">
					<button id="btnselfrontinfo" type="button" lay-filter="search"
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
	</div>
</div>
<script type="text/html" id="imgTpl"> 
	<img style="display: inline-block; width: 50%; height: 100%;" src= {{ d.avatar }}>
</script> 
<script type="text/html" id="barDemo">
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
	/*加载表格*/
	table.render({
		elem : '#projectlist',
		id:'projectlist',
		url : '../sports/getTSP',
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
			     title : '运动会名称',
			     templet:function(data){
			     	return '<span>'+data.sportname+'</span>'
			     	+'<input type="hidden" value="'+data.id+'" />'
			     }
			 }, {
			     field : 'proname',
			     align : 'center',
			     title : '项目名称',
			     templet:function(data){
			     	return '<span>'+data.proname+'</span>'
			     	+'<input type="hidden" value="'+data.proid+'" />'
			     }
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
	   		},{
				title : '操作',
				toolbar : '#barDemo',
				align : 'center'
			}] 
		]
	});
	/* 查询按钮事件 */
	$("#btnselfrontinfo").click(function() {
		var sportid = $("#sport").val();
		var proid = $("#project").val();
		table.reload('projectlist', {
			method : 'post',
			where : {
				'sportid' : sportid,
				'proid' : proid
			},
			page : {
				curr : 1
			}
		});
	});
	//删除按钮操作
	$(document).on('click',".del", function () {
		var id = $(this).parent().parent().prev().prev().prev().prev().prev().prev().find("input").val();
		layer.confirm('确定要删除么？', {
		  btn: ['确定','取消'],
		  icon:3
		}, function(){
			$.ajax({
        		type: 'get',
        		url: "../sports/deleteTSP",
        		dataType: 'json',
        		data:{
        			id:id
        		},
        		success:function(data){
        			if(data.code == 0){
        				getNotExistsSport();
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
	/* 监控复选框事件 */
	form.on('checkbox(addproject)', function(data){
		var prolist = JSON.parse(sessionStorage.getItem("prolists"));
		if(data.elem.checked){
			prolist.push(data.value);
			sessionStorage.setItem("prolists",JSON.stringify(prolist));
		}else{
			prolist.splice(jQuery.inArray(data.value,prolist),1);
			sessionStorage.setItem("prolists",JSON.stringify(prolist));
		}
	}); 
	/* 添加按钮 */
	$("#btn_add").click(function(){
		layer.open({
			title:"文章信息编辑",
			type: 1,
			area: ['500px', '500px'],
			skin: 'demo-class',
			btn:['确认保存'],
			maxmin: true,//显示最大化最小化按钮
			content: $('#div_content'),
			btn1: function(index, layero){
				var addsport = $("#addsport").val();
				var prolistjson = JSON.parse(sessionStorage.getItem("prolists"));
				var prolists = sessionStorage.getItem("prolists");
				if(addsport==null || addsport == ""){
					layer.confirm("赛事不能为空，请选择赛事", {
		     			icon: 6,
						btn: ['确定']
					}); 
				}else if(prolistjson.length<=0){
					layer.confirm("赛项不能为空，请至少选择一个赛项", {
		     			icon: 6,
						btn: ['确定']
					}); 
				}else{
					$.ajax({
		        		type: 'get',
		        		url: "../sports/addTSP",
		        		dataType: 'json',
		        		data:{
			        		sportid:addsport,
			        		prolist:prolists
		        		},
		        		success:function(data){
	        				getNotExistsSport();
	        				//$("input[name='addproid']").attr("checked", "");
	        				var ch = $("input[name='addproid']");
	        				for (var i = 0; i < ch.length; i++) {
				                ch[i].checked = false;                
				            }
	        				form.render('checkbox');
	        				sessionStorage.setItem("prolists", "[]");
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
		    }
	    });
	});
	/* 页面加载时运行 */
	$(document).ready(function(){
		getSport();
		getProject();
		getNotExistsSport();
		sessionStorage.setItem("prolists", "[]");
	})
	/* 获取运动会列表，填充赛事下拉框 */
	function getSport(){
		$.ajax({
			type : "post",
			url : "../sports/getsport",
			data : {},
			dataType : "json",
			success : function(succ) {
				if (succ.code == 1) {
					layer.confirm(succ.msg, {
        				  icon: 6,
						  btn: ['确定']
					});
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
	/* 获取未分配赛事运动会列表，填充赛事下拉框 */
	function getNotExistsSport(){
		$.ajax({
			type : "post",
			url : "../sports/getnotexitsTSP",
			data : {},
			dataType : "json",
			success : function(succ) {
				if (succ.code == 1) {
					$("#btn_add").hide();
				} else {
					$("#btn_add").show();
					var tmp = '<option value="">请选择或输入赛事名称</option>';
					for ( var i in succ.data) {
						tmp += '<option value="' + succ.data[i].sportid +  '">'
								+ succ.data[i].sportname
								+ '</option>';
					}
					$("#addsport").html(tmp);
					form.render();
				}
			},
			error : function() {
				layer.msg('请求失败，稍后再试',{icon : 5});
			}
		});
	}
	/* 获取项目列表，填充项目下拉框 */
	function getProject(){
		$.ajax({
			type : "post",
			url : "../project/getproject",
			data : {},
			dataType : "json",
			success : function(succ) {
				if (succ.code == 1) {
					layer.confirm(succ.msg, {
        				  icon: 6,
						  btn: ['确定']
					});
				} else {
					var tmp = '<option value="">请选择或输入项目名称</option>';
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
					var tmp1 = '',tmp2 = '',tmp3 = '',tmp4 = '';
					for ( var i in succ.data) {
						if(succ.data[i].protype==1){
							tmp1 += '<input type="checkbox" class="layui-col-4" lay-filter="addproject" name="addproid" title="'
								+succ.data[i].proname+'" value="'
								+succ.data[i].proid+'">';
						}else if(succ.data[i].protype==2){
							tmp2 += '<input type="checkbox" class="layui-col-4" lay-filter="addproject" name="addproid" title="'
								+succ.data[i].proname+'" value="'
								+succ.data[i].proid+'">';
						}else if(succ.data[i].protype==3){
							tmp3 += '<input type="checkbox" class="layui-col-4" lay-filter="addproject" name="addproid" title="'
								+succ.data[i].proname+'" value="'
								+succ.data[i].proid+'">';
						}else if(succ.data[i].protype==4){
							tmp4 += '<input type="checkbox" class="layui-col-4" lay-filter="addproject" name="addproid" title="'
								+succ.data[i].proname+'" value="'
								+succ.data[i].proid+'">';
						}
					}
					$("#stusingle").html(tmp1);
					$("#stuteam").html(tmp2);
					$("#teasingle").html(tmp3);
					$("#teateam").html(tmp4);
					form.render();
				}
			},
			error : function() {
				layer.msg('请求失败，稍后再试',{icon : 5});
			}
		});
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
						<label class="layui-form-label">赛事名称</label>
						<div class="layui-input-block">
							<select name="addsport" id="addsport" lay-filter="addsport"
								lay-verify="required" lay-search="">
								<option value="">请选择或输入赛事名称</option>
							</select>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">学生个人赛</label>
						<div class="layui-input-block" id="stusingle">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">学生团体赛</label>
						<div class="layui-input-block" id="stuteam">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">教师个人赛</label>
						<div class="layui-input-block" id="teasingle">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">教师团体赛</label>
						<div class="layui-input-block" id="teateam">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
		   
</html>
