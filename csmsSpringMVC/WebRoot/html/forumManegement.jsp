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
    		<blockquote class="layui-elem-quote" style="border-left: none">
			<form class="layui-form">
				<div class="layui-input-inline">
					<input type="text" name="sysmothed" id="wherecondition" placeholder="请输入查询条件" class="layui-input" autocomplete="off">
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
        <table id="forumlist" style="text-align: center;" class="layui-table" lay-filter="tool">
        </table>
        <script type="text/html" id="imgTpl"> 
          <img style="display: inline-block; width: 50%; height: 100%;" src= {{ d.avatar }}>
        </script> 
        <script type="text/html" id="barDemo">
		  <a class="layui-btn layui-btn-xs" lay-event="add">内容管理</a>
          <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
          <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
        </script>
      </div>
    </div>

  <script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
	
	<script src="../layui/layui.js" charset="utf-8"></script>
  <script>
  	layui.use(['layer','upload','table'], function(){
  		var layer = layui.layer,$=layui.jquery,upload = layui.upload,table=layui.table;
  		
  		/*加载表格*/
		table.render({
			elem : '#forumlist',
			id:'forumlist',
			url : '../forum/getforumlist',
			title : '文章数据表',
			height: "full-160",
			//skin : 'line',
			even : true,
			cols : [ 
			     [ {
					type : 'numbers',
					title : '序号',
					align : 'center',
					
				}, {
     field : 'title',
     align : 'center',
     title : '文章标题',
   
    }, {
     field : 'author',
     align : 'center',
     title : '投稿人',
    
    }, {
     field : 'createtime',
     title : '发布时间',
     align : 'center',
    		},{
			title : '操作',
					toolbar : '#barDemo',
					align : 'center'
				}] ],
			 page: {
					layout: ['prev', 'page', 'next', 'skip', 'count', 'limit'],
					groups: 5,
					limit: 10,
					limits: [1, 4, 5, 10, 50],
					theme: '#1E9FFF',						
			 },
		});
		
		//表格工具栏事件 
		table.on('tool(tool)', function(obj) {
			var data = obj.data;
			switch (obj.event) {
				//删除按钮操作
				case 'del':
					layer.confirm('确定要删除么？', {
					  btn: ['确定','取消'],
					  icon:3
					}, function(){
						$.ajax({
			        		type: 'get',
			        		url: "../forum/delforum",
			        		dataType: 'json',
			        		data:{
			        			forumid:data.forumid
			        		},
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
									  btn: ['确定']
									}, function(){
										table.reload("forumlist", { //此处是上文提到的 初始化标识id
							                where: {
							                	keyword:data.code=='0'
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
					/* 编辑文章标题按钮 */
					case 'edit':
					$("#oldtitle").val(data.title);
					$("#oldauthor").val(data.author);
					layer.open({
  						title:"文章信息编辑",
  						type: 1,
  						area: ['500px', '500px'],
  						skin: 'demo-class',
  						btn:['确认保存'],
  						maxmin: true,//显示最大化最小化按钮
  						//offset: 'b', 弹框的位置
  						content: $('#div_edlForum'),
  						btn1: function(index, layero){
  							var author=data.author,title=data.title;
  						
  							if($("#newtitle").val().trim()!=null && $("#newtitle").val().trim()!=""){
  							title=$("#newtitle").val().trim();
  							}
  							if($("#newauthor").val().trim()!=null && $("#newauthor").val().trim()!=""){
  								author=$("#newauthor").val().trim();
  							}
  							if(($("#newauthor").val().trim()==null ||$("#newauthor").val().trim()=="")&&($("#newtitle").val().trim()==null ||$("#newtitle").val().trim()=="")){
  							layer.tips('至少有一项修改才能提交', '#newtitle', {
								tips : [ 1, '#3595CC' ],
								time : 3000
								});
								return;
  							}
  							$.ajax({
			        		type: 'get',
			        		url: "../forum/edlforum",
			        		dataType: 'json',
			        		data:{
			        		forumid:data.forumid,
			        		 title:title,
			        		  author:author
			        		},
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
			        				icon: 1,
									  btn: ['确定']
									}, function(){
										table.reload("forumlist", { //此处是上文提到的 初始化标识id
							                where: {
							                	
							                },page: {
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
    						},
  						
  						cancel: function(){ 
  							$("#newcollegename").val("");
  						}
					});
				break;
				/* 添加文章内容按钮 */
				case 'add':
					alert(data.forumid);
					window.location.href="../forum/getforum?forumid="+data.forumid;
				break;
			};
		});
		
		
		/* 点击查询对网站用户进行筛选 */
		$("#btnselfrontinfo").click(function() {
			table.reload('forumlist', {
				method : 'post',
				where : {
					'wherecondition' : $("#wherecondition").val().trim(),
						},
				page : {
					curr : 1
					}
			});
		})
		
  		
  		//添加文章确认按钮点击事件
  		$("#btn_add").click(function(){
  			layer.open({
  				title:"添加文章",
  				type: 1,
  				area: ['400px', '300px'],
  				skin: 'demo-class',
  				btn:['添加'],
  				maxmin: true,//显示最大化最小化按钮
  				//offset: 'b', 弹框的位置
  				content: $('#div_addForum'),
  				btn1: function(index, layero){
   					$.ajax({
		        		type: 'get',
		        		url: "../forum/addforum",
		        		dataType: 'json',
		        		data:{
		        			author:$("#author").val().trim(),
		        			title:$("#title").val().trim()
		        		},
		        		success:function(data){
		        			if(data.code == 0){
		        				layer.confirm(data.msg, {
								  btn: ['确定']
								}, function(){
									table.reload("forumlist", { //此处是上文提到的 初始化标识id
						                where: {
						                	keyword:data.code=='0'
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
  				},
  				cancel: function(){ 
  					$('#title').val("");
  					$('#author').val("");
  				}
			});
  		})
  		$(".btn_det").click(function(){
  			window.location.href="addForumcontent.jsp";
  		})
  		
 		
	}); 
  </script>
   <!--添加文章  -->
	<div id="div_addForum"
		style="display: none;text-align: center; margin-top: 15px;">
		
		<div class="layui-form-item">
			<label class="layui-form-label">文章标题:</label>
			<div class="layui-input-inline">
				<input type="text" name="title" id="title" 
					placeholder="请输入文章标题" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">文章投稿人:</label>
			<div class="layui-input-inline">
				<input type="text" name="title"  id="author"
					placeholder="请输入投稿人" autocomplete="off" class="layui-input">
			</div>
		</div>
	</div>
	
	 <!--编辑文章  -->
	<div id="div_edlForum"
		style="display: none;text-align: center; margin-top: 15px;">
		
		<div class="layui-form-item">
			<label class="layui-form-label">文章原标题:</label>
			<div class="layui-input-inline">
				<input type="text" name="title" id="oldtitle" 
					readonly="true" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">文章新标题:</label>
			<div class="layui-input-inline">
				<input type="text" name="title" id="newtitle" 
					placeholder="请输入文章标题" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">文章原投稿人:</label>
			<div class="layui-input-inline">
				<input type="text" name="title"  id="oldauthor"
					readonly="true" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">文章新投稿人:</label>
			<div class="layui-input-inline">
				<input type="text" name="title"  id="newauthor"
					placeholder="请输入投稿人" autocomplete="off" class="layui-input">
			</div>
		</div>
	</div>
</body>
		   
</html>
