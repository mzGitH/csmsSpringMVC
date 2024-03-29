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
	tbody .layui-table-cell {
	    font-size:14px;
	    padding:0 5px;
	    height:100px;
	    overflow:visible;
	    text-overflow:inherit;
	    white-space:normal;
	    word-break: break-all;
	}
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
							<!-- <div style="float:right">
								<button class="layui-btn layui-btn-sm layui-btn-normal">修改文章信息</button>
							</div> -->
						</div>
						<div class="layui-card-body">
							<div class="layui-row layui-col-space20">
								<div class="layui-col-lg12">
									<table class="layui-table" id="forumcontent">
										<tr>
											<td>文章主标题</td>
											<td>${forum.title }</td>
										</tr>
										
										<tr>
											<td>发表日期</td>
											<td>${forum.createtime }</td>
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
						<div class="layui-card-header">文章内容管理<button style="margin-left: 50px;" class="layui-btn btn_addcontent layui-btn-sm layui-btn-normal">添加内容</button></div>
						<div class="layui-card-body">
							<table id="contentlist" style="text-align: center;" class="layui-table"></table>
							<!-- <table class="layui-table" lay-skin="line">
								<tr>
									<td>美丽西山大昆明</td>
									<td>图片</td>
									<td>测试内容</td>
									<td><button class="layui-btn btn_addcontent layui-btn-sm layui-btn-normal">编辑</button></td>
								</tr>
							</table> -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
<script src="../layui/layui.js" charset="utf-8"></script>
<script type="text/html" id="barDemo">
	<a class="layui-btn layui-btn-normal layui-btn-md edit" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
	<a class="layui-btn layui-btn-warm layui-btn-md del" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
</script>
<script>
layui.use(['layer','upload','table','jquery','form'], function(){
	var layer = layui.layer,
	form=layui.form,
	table=layui.table,
	$=layui.jquery,
	upload = layui.upload;
	/*加载表格*/
	table.render({
		elem : '#contentlist',
		id:'contentlist',
		url : '../forum/getcontentlist?forumid=${forum.forumid}',
		title : '文章数据表',
		even : true,
		cols : [ 
		     [ {
				type : 'numbers',
				title : '序号',
				align : 'center'
			}, {
			    field : 'picpath',
			    align : 'center',
			    title : '图片',
			    style:'height:100px;',
				templet:function(data){
					return '<img style="width: 150px;height:100%" src= "'+data.picpath+'">'
					+'<input type="hidden" class="picid" value="'+data.picid+'" />'
					+'<input type="hidden" class="picpath" value="'+data.picpath+'" />'
					+'<input type="hidden" class="contentid" value="'+data.contentid+'" />'
				}
			}, {
			    field : 'textcontent',
			    title : '文章内容',
			    align : 'center',
			    templet:function(data){
			    	var textcontent = data.textcontent;
			    	if(textcontent.length>50){
				    	var text = textcontent.slice(0,50)+"...";
						return text
					}else{
						return data.textcontent
					}
				}
    		},{
				title : '操作',
				toolbar : '#barDemo',
				align : 'center'
			}]
		]
	});
	//添加内容按钮点击事件
	$(".btn_addcontent").click(function(){
		layer.open({
			title:"编写一个博文内容",
			type: 1,
			area: ['500px'],
			skin: 'demo-class',
			btn:['添加'],
			maxmin: true,//显示最大化最小化按钮
			content: $('#div_addcontent'),
			btn1: function(index, layero){
	            var textcontent = $("#contenttext").val();
	            var photoid = $("#photoid").val();
 				$.ajax({
					type : "post",
					url : "../forum/addcontent",
					data : {
						forumid : ${forum.forumid},
						photoid : photoid,
						textcontent : textcontent
					},
					dataType : "json",
					success : function(succ) {
						layer.msg(succ.msg);
						if (succ.code == 0) {
							window.location.reload();
						}
					},
					error : function() {
						layer.msg('请求失败，稍后再试',{icon : 5});
					}
	
				});
			},
			cancel: function(){ 
				$("#contentid").val("");
	            $("#photopath").attr("src","../image/defaultuser.jpg");
	            $("#contenttext").text("");
	            $("#photoid").val("");
			}
		});
	})
	/* 文章内容编辑按钮 */
	$(document).on('click',".edit", function () {
            var contentid = $(this).parent().parent().prev().prev().find(".contentid").val();
            var content = $(this).parent().parent().prev().children().text();
            var photoid = $(this).parent().parent().prev().prev().find(".picid").val();
            var photopath = $(this).parent().parent().prev().prev().find(".picpath").val();
            $("#contentid").val(contentid);
            $("#photoid").val(photoid);
            $("#photopath").attr("src",photopath);
            $("#contenttext").text(content);
	        layer.open({
				title:"编写一个博文内容",
				type: 1,
				area: ['500px'],
				skin: 'demo-class',
				btn:['添加'],
				maxmin: true,//显示最大化最小化按钮
				//offset: 'b', 弹框的位置
				content: $('#div_addcontent'),
				btn1: function(index, layero){
	 				var contentid = $("#contentid").val();
		            var content = $("#contenttext").val();
		            var photoid = $("#photoid").val();
		            $.ajax({
						type : "post",
						url : "../forum/editcontent",
						data : {
							contentid : contentid,
							photoid : photoid,
							textcontent : content
						},
						dataType : "json",
						success : function(succ) {
							layer.msg(succ.msg);
							if (succ.code == 0) {
								window.location.reload();
							}
						},
						error : function() {
							layer.msg('请求失败，稍后再试',{icon : 5});
						}
		
					});
				},
				cancel: function(){ 
					$("#contentid").val("");
		            $("#photopath").attr("src","../image/defaultuser.jpg");
		            $("#contenttext").text("");
		            $("#photoid").val("");
				}
			});
    });
    /* 文章内容删除按钮 */
	$(document).on('click',".del", function () {
		var contentid = $(this).parent().parent().prev().prev().find(".contentid").val();
		layer.open({
			title: '温馨提示',
			content: '确定要删除这条内容吗？',
			yes:function(index,layero){
				$.ajax({
						type : "post",
						url : "../forum/delcontent",
						data : {
							contentid : contentid
						},
						dataType : "json",
						success : function(succ) {
							layer.msg(succ.msg);
							if (succ.code == 0) {
								window.location.reload();
							}
						},
						error : function() {
							layer.msg('请求失败，稍后再试',{icon : 5});
						}
		
					});
			}
		});
    });
	//监听提交
     form.on('submit(formDemo)', function(data) {
         layer.alert(JSON.stringify(data.field), {
             title: '最终的提交信息'
         })
         return false;
     });
     upload.render({
         elem: '#btn-photo',
         url: '../file/springUpload',
         before: function(obj) {
             obj.preview(function(index, file, result) {
                 $('#photopath').attr('src', result); //图片链接（base64）
             });
             layer.load(); //上传loading
         },
         done: function(res, index, upload) {
             layer.closeAll('loading'); //关闭loading
             if(res.code == 0){
             	$("#photoid").val(res.count); //将资源码传给 <input/>
             }
             layer.msg(res.msg);
         },
         error: function(index, upload) {
             layer.closeAll('loading'); //关闭loading
         }
     });
}); 
 </script>

<div class="layui-card" id="div_addcontent" style="display: none;height:450px;">
	<div class="layui-card-body">
		<div class="layui-card">
			<div class="layui-card-body">
				<!--表单开始-->
				<form class="layui-form">
					<input type="hidden" id="contentid" value="" />
					<div class="layui-form-item">
						<label class="layui-form-label">图片名称</label>
						<div class="layui-input-block">
							<input type="text" name="photoid" disabled="disabled" id="photoid" required
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
							<img class="layui-upload-img" src="../image/defaultuser.jpg" id="photopath" width="150px">
						</div>
					</div>

					<!-- <div class=" layui-form-item">
						<label class="layui-form-label">标题图片</label>
						<div class="layui-input-block">
							<input type="checkbox" name="like[true]" title="选定">
						</div>
					</div> -->
					<!-- <div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">位置</label>
							<div class="layui-input-block">
								<input class="layui-input" type="number" name="index" title="">
							</div>
						</div>
					</div> -->
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">图片描述</label>
						<div class="layui-input-block">
							<textarea name="signed" id="contenttext" placeholder="请输入一段文字描述图片"
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
