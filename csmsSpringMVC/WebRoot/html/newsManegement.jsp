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
				<div class="layui-input-inline">
					<input type="text" name="sysmothed" id="wherecondition" placeholder="请输入查询条件" class="layui-input" autocomplete="off">
			    </div>
				<div class="layui-inline">
					<button id="btnselfrontinfo" type="button"
						class="layui-btn layui-bg-blue">查询</button>
				</div>
				<div class="layui-inline">
					<a href="addNews.jsp"><button id="btn_add" type="button" 
						class="layui-btn layui-bg-blue">添加</button></a>
				</div>
			</form>
		</blockquote>
      
      <div class="layui-card-body">
        <table id="newlist" style="text-align: center;" class="layui-table" lay-filter="tool">
        </table>
        <script type="text/html" id="imgTpl"> 
          <img style="display: inline-block; width: 50%; height: 100%;" src= {{ d.avatar }}>
        </script> 
        <script type="text/html" id="barDemo" >
          <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="query"><i class="layui-icon layui-icon-search"></i>查看</a>
          <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
        </script>
      </div>
    </div>
<script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
<script src="../layui/layui.js" charset="utf-8"></script>
<script>
  	layui.use(['layer','upload','layedit','table','code'], function(){
  		var layer = layui.layer,$=layui.jquery,upload = layui.upload,table=layui.table,layedit=layui.layedit;
  		
  		layedit.build('content', {
  			height: 180 //设置编辑器高度
  			, tool: ['']
		});
  		
  		/*加载表格*/
		table.render({
			elem : '#newlist',
			id:'newlist',
			url : '../news/getallnewlist',
			title : '公告数据表',
			height: "full-160",
			//skin : 'line',
			even : true,
			cols : [ 
			     [ {
					type : 'numbers',
					title : '序号',
					align : 'center',
					
				}, {
				     field : 'newstitle',
				     align : 'center',
				     title : '公告标题'
				    }, {
				     field : 'realname',
				     align : 'center',
				     title : '发布人',
				    
				    }, {
				     field : 'datetime',
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
			//alert(data.newid);
			switch (obj.event) {
				//查看按钮操作
				case 'query':
				
				$("#newstitle").val(data.newstitle);
				 $("#content").text(data.newscontent);
				 layer.open({
						 title:"展示公告内容",
						 type: 1,
						 area: ['500px','500px'],
						 skin: 'demo-class',
						 maxmin: true,//显示最大化最小化按钮
						 content: $('#div_content')
				  });  
				break;
				//删除按钮操作
				case 'del':
					layer.confirm('确定要删除么？', {
					  btn: ['确定','取消'],
					  icon:3
					}, function(){
						$.ajax({
			        		type: 'get',
			        		url: "../news/delnews",
			        		dataType: 'json',
			        		data:{
			        		newid:data.newid
			        		},
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
			        				icon: 1,
									  btn: ['确定']
									}, function(){
										table.reload("newlist", { //此处是上文提到的 初始化标识id
							                where: {
							                	keyword:data.code=='0'
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
			        			layer.confirm('出现错误，删除失败，请重试！', {
			        				  icon: 6,
									  btn: ['确定']
								});
			        		},
			        	});   
					}, function(){ 
						layer.closeAll();
					});
				break;
			}
			;
		});
		
		/* 点击查询对网站用户进行筛选 */
		$("#btnselfrontinfo").click(function() {
			table.reload('newlist', {
				method : 'post',
				where : {
					'wherecondition' : $("#wherecondition").val().trim(),
						},
				page : {
					curr : 1
					}
			});
		}) 
	}); 
</script>
<div class="layui-card" id="div_content" style="display: none;height:250px;">
	<div class="layui-card-body">
		<div class="layui-card">
			<div class="layui-card-body">
				<!--表单开始-->
				<form class="layui-form">
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">公告标题</label>
						<div class="layui-input-block">
							<input type="text"  id="newstitle"  class="layui-input"  readonly="readonly" />
						</div>
						<br/>
						<label class="layui-form-label">公告内容</label>
							<div class="layui-input-block">
								<textarea id="content" style="display: none;"></textarea>
							</div>
						</div>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
		   
</html>
