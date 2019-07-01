<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>公告管理</title>
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
				<label>公告标题:</label>
				<div class="layui-input-inline">
					<input type="text" name="newstitle" id="newstitle"
						placeholder="请输入标题" class="layui-input" autocomplete="off">
				</div>
			</form>
		</blockquote>

		<div class="layui-card-body">
		<label>公告内容:</label>
			<center>
				<textarea class="layui-textarea" id="LAY_demo1"style="display: none">  
  				
				</textarea>
			</center>
			<div class="site-demo-button" style="margin-top: 20px;">
				<button class="layui-btn site-demo-layedit" id="content">发布</button>
			</div>
		</div>
	</div>

	<script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
	
	<script src="../layui/layui.js" charset="utf-8"></script>
  <script>
  	layui.use(['layer','upload','table','layer','layedit'], function(){
  		var layer = layui.layer,$=layui.jquery,upload = layui.upload,layedit=layui.layedit;
  		
  		//构建一个默认的编辑器
  var index = layedit.build('LAY_demo1');
  
  
    $("#content").click( function(){
       //获取编辑器内容
     var newstitle= $("#newstitle").val().trim();
     var newscontent=layedit.getContent(index);
     if(newstitle==null||newstitle==""){
     layer.tips('文章标题不能为空！', '#newstitle', {
					tips : [ 1, '#3595CC' ],
					time : 3000
				});
				return;
     }
     if(newscontent==null||newscontent==""){
				layer.alert("文章内容不能为空！", {icon: 2});
				return;
     }
      $.ajax({
		type: 'Post',
		url: "../news/addnews",
		dataType: 'json',
		data:{
			newstitle:$("#newstitle").val().trim(),
			newscontent:newscontent
		},
		success:function(data){
		     if(data.code == 0){
			     layer.alert('添加成功', {icon: 1})
			     window.loaction.href="../html/newsManegement.jsp";
		     }
		     else{
		         layer.confirm('出现错误,请重试！', {btn: ['确定']});
		     }
		 },
		error:function(){
		    layer.confirm('出现错误，请重试！', {btn: ['确定']});
		},
	});
  });
}); 
  </script>
</body>
		   
</html>
