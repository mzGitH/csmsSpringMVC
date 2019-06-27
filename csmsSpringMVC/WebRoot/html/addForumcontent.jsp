<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>文章管理</title>
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
		<!--第一列结束-->
		<div class="layui-col-md12 layui-col-lg12 layui-col-space20">
			<div class="layui-row">
				<div class="layui-fluid layui-col-md12 layui-col-lg12">
					<div class="layui-card">
						<div class="layui-card-header">
							<span style="font-size:18px;">文章信息</span>
							<div style="float:right">
								<button class="layui-btn layui-btn-sm layui-btn-normal">修改文章信息</button>
							</div>
						</div>
						<div class="layui-card-body">
							<div class="layui-row layui-col-space20">
								<div class="layui-col-lg12">
									<table class="layui-table" id="forumcontent">
										<tr>
											<td>文章主标题</td>
											<td>美丽西山大昆明</td>
										</tr>
										
										<tr>
											<td>发表日期</td>
											<td>2018-11-23 23:06</td>
										</tr>
										<tr>
											<td>发表届数</td>
											<td>2018春季运动会</td>
										</tr>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--第二列第一行结束-->
			<div class="layui-row">
				<div class="layui-container layui-col-md12 layui-col-lg12">
					<div class="layui-card ">
						<div class="layui-card-header">文章内容管理<button class="layui-btn btn_addcontent layui-btn-sm layui-btn-normal">添加内容</button></div>
						<div class="layui-card-body">
							<table class="layui-table" lay-skin="line">
								<tr>
									<td>标题</td>
									<td>图片</td>
									<td>内容</td>
									<td><button class="layui-btn btn_addcontent layui-btn-sm layui-btn-normal">编辑</button></td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

  <script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
	
	<script src="../layui/layui.js" charset="utf-8"></script>
  <script>
  	layui.use(['layer','upload','table'], function(){
  		var layer = layui.layer,$=layui.jquery,upload = layui.upload;
  		
  		
  		//编辑按钮点击事件
  		$(".btn_addcontent").click(function(){
  			layer.open({
  				title:"编写一个博文内容",
  				type: 1,
  				area: ['600px'],
  				skin: 'demo-class',
  				btn:['添加'],
  				maxmin: true,//显示最大化最小化按钮
  				//offset: 'b', 弹框的位置
  				content: $('#div_addcontent'),
  				btn1: function(index, layero){
    				layer.msg("666")
  				},
  				cancel: function(){ 
  					//$('#addcollegename').val("");
  				}
			});
  		})
  		//监听提交
        form.on('submit(formDemo)', function(data) {
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })
            return false;
        });
        upload.render({
            elem: '#btn-photo',
            url: 'fileuploadservlet.do',
            before: function(obj) {
                obj.preview(function(index, file, result) {
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
                layer.load(); //上传loading
            },
            done: function(res, index, upload) {
                layer.closeAll('loading'); //关闭loading
                $("#userphoto").val(data.result1); //将资源码传给 <input
                alert(data.msg);
            },
            error: function(index, upload) {
                layer.closeAll('loading'); //关闭loading
            }
        });
  		
 		
	}); 
  </script>

	<div class="layui-card" id="div_addcontent" style="display: none">
		<div class="layui-card-body">
			<div class="layui-card">
				
				<div class="layui-card-body">
					<!--表单开始-->
					<form class="layui-form">
						<div class="layui-form-item">
							<label class="layui-form-label">图片名称</label>
							<div class="layui-input-block">
								<input type="text" name="userid"  required
									lay-verify="required" placeholder="请选择上传的文章内容图片"
									autocomplete="off" class="layui-input layui-bg-gary">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label"></label>
							<div class="layui-input-block">
								<button type="button" class="layui-btn layui-btn-normal"
									id="btn-photo">上传内容图片</button>
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">图片预览</label>
							<div class="layui-input-block">
								<img class="layui-upload-img" src="img/2.jpg" id="demo1"
									height="200px" width="300px">
							</div>
						</div>

						<div class=" layui-form-item">
							<label class="layui-form-label">标题图片</label>
							<div class="layui-input-block">
								<input type="checkbox" name="like[true]" title="选定">
							</div>
						</div>
						<div class="layui-form-item">
							<div class="layui-inline">
								<label class="layui-form-label">位置</label>
								<div class="layui-input-block">
									<input class="layui-input" type="number" name="index" title="">
								</div>
							</div>
						</div>

						<div class="layui-form-item layui-form-text">
							<label class="layui-form-label">图片描述</label>
							<div class="layui-input-block">
								<textarea name="signed" placeholder="请输入一段文字描述图片"
									class="layui-textarea"></textarea>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
		   
</html>
