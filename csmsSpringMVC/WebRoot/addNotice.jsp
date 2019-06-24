<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
<title>Insert title here</title>

<style type="text/css">
	body {
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
	<div class="layui-container">
		<div style="margin:10px auto;width:1000px;">
			<div class="layui-card">
				<div class="layui-card-header">
					<div class="layui-row">
						<span class="layui-breadcrumb"> <a href="home.jsp">首页</a> <a><cite>公告内容</cite></a></span>
					</div>
				</div>
				<div class="layui-card-header text-center">
					<div class="layui-row text-center">
						<h1>添加公告内容</h1>
					</div>
				</div>
				<div class="layui-card-body">
					<form class="layui-form" action="">
						<div class="layui-form-item">
							<label class="layui-form-label">公告标题</label>
							<div class="layui-input-block">
								<input type="text" name="content.photocontent" required
									lay-verify="required" placeholder="请选择一张内容照片"
									autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-form-item layui-form-text">
							<label class="layui-form-label">公告内容</label>
							<div class="layui-input-block">
								<textarea placeholder="请输入公告内容" name="content.textcontent"
									class="layui-textarea"></textarea>
							</div>
						</div>
						<div class="layui-form-item">
							<div class="layui-input-block">
								<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
								<button type="reset" class="layui-btn layui-btn-primary">重置</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
<script src="layui/layui.js" charset="utf-8"></script>
<script>
	layui
			.use(
					[ 'form', 'layedit', 'laydate', 'upload' ],
					function() {
						var form = layui.form, laydate = layui.laydate, upload = layui.upload, $ = layui.jquery;

						//日期
						laydate.render({
							elem : '#date'
						});
						//监听提交
						form.on('submit(formDemo)', function(data) {
							layer.alert(JSON.stringify(data.field), {
								title : '最终的提交信息'
							})
							return false;
						});
						upload.render({
							elem : '#btn-photo',
							url : 'fileuploadservlet.do',
							before : function(obj) {
								obj.preview(function(index, file, result) {
									$('#demo1').attr('src', result); //图片链接（base64）
								});
								layer.load(); //上传loading
							},
							done : function(res, index, upload) {
								layer.closeAll('loading'); //关闭loading
								$("#userphoto").val(data.result1); //将资源码传给 <input
								alert(data.msg);
							},
							error : function(index, upload) {
								layer.closeAll('loading'); //关闭loading
							}
						});
					});
</script>

</html>