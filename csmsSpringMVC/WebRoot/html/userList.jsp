<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>layuiAdmin 网站用户</title>
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
				<div class="layui-inline">
					<select id="collegeid">
						<option value="0">请选择学院</option>
					</select>
				</div>
				<div class="layui-inline">
					<select id="professionid">
						<option value="0">请选择专业</option>
					</select>
				</div>
				<div class="layui-inline">
					<select id="classid" lay-verify="" lay-search>
						<option value="0">请选择班级</option>
						<option value="0">请选择班级</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<input type="text" name="sysmothed" id="sysmothed" placeholder="请输入条件" class="layui-input" autocomplete="off">
			    </div>
				<div class="layui-inline">
					<button id="btnselfrontinfo" type="button"
						class="layui-btn layui-bg-blue">查询</button>
				</div>
				<div  class="layui-inline">
          			<button class="layui-btn layuiadmin-btn-useradmin" type="button" id="btn_addcollege">添加</button>
        		</div>
        		<div  class="layui-inline">
          			<button class="layui-btn layuiadmin-btn-useradmin" type="button" id="btn_importcollege">导入</button>
        		</div>
			</form>
		</blockquote>
      
      <div class="layui-card-body">
        <table id="LAY-user-manage" style="text-align: center;" class="layui-table" lay-filter="LAY-user-manage">
        	<thead>
        		<tr>
        			<td>序号</td>
        			<td>用户账号/工号</td>
        			<td>用户名称</td>
        			<td>学院名称</td>
        			<td>专业名称</td>
        			<td>班级名称</td>
        			<td>操作</td>
        		</tr>
        	</thead>
        	<tbody>
        		<tr>
        			<td>1</td>
        			<td>166125222635</td>
        			<td>李四</td>
        			<td>信息工程学院</td>
        			<td>计算机科学与技术</td>
        			<td>计算机科学与技术一班</td>
        			<td><button type="button" class="layui-btn btn_edit layui-btn-sm layui-btn-normal">编辑</button><button type="button" class="layui-btn layui-btn-sm layui-btn-danger">删除</button></td>
        		</tr>
        	</tbody>
        </table>
        <script type="text/html" id="imgTpl"> 
          <img style="display: inline-block; width: 50%; height: 100%;" src= {{ d.avatar }}>
        </script> 
        <script type="text/html" id="table-useradmin-webuser">
          <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
          <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
        </script>
      </div>
    </div>

  <script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
	
	<script src="../layui/layui.js" charset="utf-8"></script>
  <script>
  	layui.use(['layer','upload','table'], function(){
  		var layer = layui.layer,$=layui.jquery,upload = layui.upload;
  		
  		
  		//编辑按钮点击事件
  		$(".btn_edit").click(function(){
  			layer.open({
  				title:"学院信息编辑",
  				type: 1,
  				area: ['400px', '300px'],
  				skin: 'demo-class',
  				btn:['确认保存'],
  				maxmin: true,//显示最大化最小化按钮
  				//offset: 'b', 弹框的位置
  				content: $('#div_editcollege'),
  				btn1: function(index, layero){
    				layer.msg("666")
  				},
  				cancel: function(){ 
  					
  				}
			});
  		
  		})
  		//导入按钮事件
  		$("#btn_importcollege").click(function(){
  			layer.open({
  				title:"学院信息导入",
  				type: 1,
  				area: ['400px', '300px'],
  				skin: 'demo-class',
  				btn:['确认导入'],
  				maxmin: true,//显示最大化最小化按钮
  				//offset: 'b', 弹框的位置
  				content: $('#div_import'),
  				btn1: function(index, layero){
    				layer.msg("666")
  				},
  				cancel: function(){ 
  					
  				}
			});
  		})
  		
  		//添加学院按钮事件
  		$("#btn_addcollege").click(function(){
  			layer.open({
  				title:"添加学院",
  				type: 1,
  				area: ['400px', '300px'],
  				skin: 'demo-class',
  				btn:['添加'],
  				maxmin: true,//显示最大化最小化按钮
  				//offset: 'b', 弹框的位置
  				content: $('#div_addcollege'),
  				btn1: function(index, layero){
    				layer.msg("666")
  				},
  				cancel: function(){ 
  					$('#addcollegename').val("");
  				}
			});
  		})
		//执行实例
		var uploadInst = upload.render({
			elem : '#upfile' //绑定元素
			,auto: false, //不自动上传
			url : 'fileuploadservlet.do', //上传接口
			//accept : 'file'//上传所有格式文件,
			exts : 'xls|xlsx',
			choose: function(obj) {
					obj.preview(function(index, file, result) {
						layer.msg(file.name);
					});
				},
			before: function(input){
    		//返回的参数item，即为当前的input DOM对象
    		console.log('文件上传中');
    		layer.load(1, {
  				shade: [0.1,'#fff'] //0.1透明度的白色背景
				});
  			},
			success : function(res) {
			layer.closeAll('loading');
				//上传完毕回调
				if (res.code == 0) {
					layer.msg(res.msg);
					$("#path").val(res.msg);
				} else {
					layer.msg(res.msg);
				}
			},
			error : function() {
				//请求异常回调
				layer.closeAll('loading');
				layer.msg("请求异常回调");
			}
		});
 		
	}); 
  </script>
  <!--文件导入div  -->
	<div id="div_import" style="display: none;text-align: center;">
		<div class="layui-upload-drag" id="upfile" style="margin: 30px;">
			<i class="layui-icon"></i>
			<p>点击上传，或将文件拖拽到此处</p>
		</div>
	</div>
	 <!--学院添加div  -->
	<div id="div_addcollege"
		style="display: none;text-align: center; margin-top: 15%;">
		<span class="layui-input-inline">学院名称：</span>
		<div class="layui-input-inline">
			<input type="text" style="width:250px;border-radius: 5px;"
				name="sysmothed" id="addcollegename" placeholder="请输入学院名称"
				class="layui-input" autocomplete="off">
		</div>
	</div>
	 <!--学院编辑div  -->
	<div id="div_editcollege"
		style="display: none;text-align: center; margin-top: 15%;">
		<div class="layui-form-item">
			<label class="layui-form-label">学院原名称:</label>
			<div class="layui-input-inline">
				<input type="text" name="title" disabled="disabled" autocomplete="off" class="layui-input layui-btn-disabled">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">学院新名称:</label>
			<div class="layui-input-inline">
				<input type="text" name="title" 
					placeholder="请输入学院新名称" autocomplete="off" class="layui-input">
			</div>
		</div>
	</div>
</body>
		   
</html>
