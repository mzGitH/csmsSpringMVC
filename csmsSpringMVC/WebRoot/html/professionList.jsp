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
					<select id="collegeselect">
						<option value="">请选择学院</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<input type="text" name="sysmothed" id="input_collegename" placeholder="请输入专业名称" class="layui-input" autocomplete="off">
			    </div>
				<div class="layui-inline">
					<button id="btnselfrontinfo" type="button"
						class="layui-btn layui-bg-blue">查询</button>
				</div>
				<div  class="layui-inline">
          			<button class="layui-btn layuiadmin-btn-useradmin" type="button" id="btn_addmajor">添加</button>
        		</div>
        		<div  class="layui-inline">
          			<button class="layui-btn layuiadmin-btn-useradmin" type="button" id="btn_importcollege">导入</button>
        		</div>
			</form>
		</blockquote>
      
      <div class="layui-card-body">
       <table id="majorlist" style="text-align: center;" class="layui-table" lay-filter="tool">
        </table> 
        <script type="text/html" id="imgTpl"> 
          <img style="display: inline-block; width: 50%; height: 100%;" src= {{ d.avatar }}>
        </script> 
        <script type="text/html" id="barDemo">
          <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
          <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
        </script>
      </div>
    </div>

  <script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
	<script src="../js/loadselect.js" charset="utf-8"></script>
	<script src="../layui/layui.js" charset="utf-8"></script>
  <script>
  	layui.use(['layer','upload','table','form'], function(){
  	var layer = layui.layer,$=layui.jquery,upload = layui.upload,table=layui.table,form=layui.form;
  		
  		//加载学院下拉框信息
  		loadSelect("college","collegeselect", form); 
  		
  		/*加载表格*/
		table.render({
			elem : '#majorlist',
			id:'majorlist',
			url : '../major/getmajor',
			title : '专业数据表',
			height: "full-160",
			//skin : 'line',
			even : true,
			cols : [ 
			     [ {
					type : 'numbers',
					title : '序号',
					align : 'center',
					
				}, {
     				field : 'collegename',
     				align : 'center',
     				title : '学院名称',
   
    			},{
     				field : 'majorname',
     				align : 'center',
     				title : '专业名称',
   
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
			        		url: "../major/delmajor",
			        		dataType: 'json',
			        		data:{
			        		newid:data.majorid
			        		},
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
			        				icon: 1,
									  btn: ['确定']
									}, function(){
										table.reload("majorlist", { //此处是上文提到的 初始化标识id
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
				case 'edit':
					$("#oldmajorname").val(data.majorname);
					//加载学院下拉框信息
					
  					loadCollegeSelected("changcollegeselect",data.collegeid, form);
					layer.open({
  						title:"专业信息编辑",
  						type: 1,
  						area: ['500px', '600px'],
  						skin: 'demo-class',
  						btn:['确认保存'],
  						maxmin: true,//显示最大化最小化按钮
  						//offset: 'b', 弹框的位置
  						content: $('#div_editmajor'),
  						btn1: function(index, layero){
    						$.ajax({
			        		type: 'get',
			        		url: "../major/edmajor",
			        		dataType: 'json',
			        		data:{
			        		collegeid:$("#changcollegeselect").val(),
			        		majorid:data.majorid,
			        		 majorname:$("#newmajorname").val().trim()
			        		},
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
			        				icon: 1,
									  btn: ['确定']
									}, function(){
										table.reload("majorlist", { //此处是上文提到的 初始化标识id
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
			        			layer.confirm('出现错误，删除失败，请重试！', {
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
			};
		});
  		
  		/* 点击查询对专业进行筛选 */
		$("#btnselfrontinfo").click(function() {
			table.reload('majorlist', {
				method : 'post',
				where : {
					'wherecondition' : $("#input_collegename").val().trim(),
					'collegeid':$("#collegeselect").val()
						},
				page : {
					curr : 1
					}
			});
		})
  		
  		
  		//导入按钮事件
  		$("#btn_importcollege").click(function(){
  			layer.open({
  				title:"专业信息导入",
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
  		
  		//添加专业按钮事件
  		$("#btn_addmajor").click(function(){
  		//加载学院下拉框信息
  			loadSelect("college","addmajorselect", form); 
  			layer.open({
  				title:"添加专业",
  				type: 1,
  				area: ['500px','400px'],
  				skin: 'demo-class',
  				btn:['添加'],
  				maxmin: true,//显示最大化最小化按钮
  				//offset: 'b', 弹框的位置
  				content: $('#div_addmajor'),
  				btn1: function(index, layero){
    				$.ajax({
			        		type: 'get',
			        		url: "../major/addmajor",
			        		dataType: 'json',
			        		data:{
			        		collegeid:$("#addmajorselect").val(),
			        		 majorname:$("#addmajorname").val().trim()
			        		},
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
			        				icon: 1,
									  btn: ['确定']
									}, function(){
										table.reload("majorlist", { //此处是上文提到的 初始化标识id
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
  					$('#addmajorname').val("");
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
	 <!--专业添加div  -->
	<div id="div_addmajor"
		style="display: none;text-align: center; margin-top: 1%;">
		<form class="layui-form" action="">
			<div class="layui-form-item">
				 <label class="layui-form-label">所属学院:</label>
				<div class="layui-input-inline">
					<select id="addmajorselect">
						<option value="0">请选择学院</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				 <label class="layui-form-label">专业名称:</label>
				<div class="layui-input-inline">
					<input type="text" style="width:250px;border-radius: 5px;"
						name="sysmothed" id="addmajorname" placeholder="请输专业名称"
						class="layui-input" autocomplete="off">
				</div>
			</div>
		</form>
	</div>
	 <!--专业编辑div  -->
	<div id="div_editmajor"
		style="display: none;text-align: center; margin-top: 15%;">
		<form class="layui-form" action="">
			<div class="layui-form-item">
				<label class="layui-form-label">专业所属学院:</label>
				<div class="layui-input-inline">
					 <select id="changcollegeselect" lay-filter="college">
						<option value="0">请选择学院</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">专业原名称:</label>
				<div class="layui-input-inline">
					<input type="text" name="title" id="oldmajorname"
						disabled="disabled" autocomplete="off"
						class="layui-input layui-btn-disabled">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">专业新名称:</label>
				<div class="layui-input-inline">
					<input type="text" id="newmajorname" placeholder="请输入学院新名称"
						autocomplete="off" class="layui-input">
				</div>
			</div>
		</form>
	</div>
</body>
		   
</html>
