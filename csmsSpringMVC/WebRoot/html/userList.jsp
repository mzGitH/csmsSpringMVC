<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>网站用户</title>
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
			<form class="layui-form"  lay-filter="formsearch">
				<div class="layui-inline">
					<select id="collegeid" lay-filter="collegeid">
						<option value="">请选择学院</option>
					</select>
				</div>
				<div class="layui-inline">
					<select id="professionid" lay-filter="professionid">
						<option value="">请选择专业</option>
					</select>
				</div>
				<div class="layui-inline">
					<select id="classid"  lay-filter="classid" lay-search>
						<option value="">请选择班级</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<input type="text" name="sysmothed" id="input_wherecondition" placeholder="请输入条件" class="layui-input" autocomplete="off">
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
        <table id="userlist" style="text-align: center;" class="layui-table" lay-filter="tool">	</table>
        <script type="text/html" id="imgTpl"> 
          <img style="display: inline-block; width: 50%; height: 100%;" src= {{ d.avatar }}>
		  <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
        </script> 
        <script type="text/html" id="barDemo"> 
          <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
        </script>
      </div>
    </div>

  	<script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
	<script src="../js/loadselect.js" charset="utf-8"></script>
	<script src="../layui/layui.js" charset="utf-8"></script>
  <script>
  	layui.use(['layer','upload','table'], function(){
  		var layer = layui.layer,$=layui.jquery,upload = layui.upload,table=layui.table,form=layui.form;
  		
  		//加载学院、专业下拉框信息
  		loadSelect("college","collegeid", form); 
  		loadSelect("major","professionid", form); 
  		loadSelect("class","classid", form); 
  		
  		/*加载表格*/
		table.render({
			elem : '#userlist',
			id:'userlist',
			url : '../user/getuser',
			title : '用户数据表',
			height: "full-160",
			//skin : 'line',
			even : true,
			cols : [ 
			     [ {
					type : 'numbers',
					title : '序号',
					align : 'center',
					
				}, {
     				field : 'userid',
     				align : 'center',
     				title : '用户账号/工号',
   
    			},{
     				field : 'username',
     				align : 'center',
     				title : '用户名称',
   
    			},
    			{
    				fild:'',
    				align:'center',
    				title:'用户类型',
    				templet: function(d){
    					if(d.usertype==0){
    						return "学生";
    					}else{
    						return "教师";
    					}
    				}
    			}
    			,{
     				field : 'collegename',
     				align : 'center',
     				title : '学院名称',
   
    			},{
     				field : 'majorname',
     				align : 'center',
     				title : '专业名称',
   
    			},{
     				field : 'classname',
     				align : 'center',
     				title : '班级名称',
   
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
  		
  		/* 点击查询对专业进行筛选 */
		$("#btnselfrontinfo").click(function() {
			table.reload('userlist', {
				method : 'post',
				where : {
					'wherecondition' : $("#input_wherecondition").val().trim(),
					'collegeid':$("#collegeid").val(),
					'majorid':$("#majorid").val(),
					'classid':$("#classid").val()
						},
				page : {
					curr : 1
					}
			});
		});
		
		//学院下拉框改变
  		form.on('select(collegeid)', function(data){
  			table.reload('userlist', {
				method : 'post',
				where : {
					'collegeid':data.value,
					'majorid':'',
					'classid':''
						},
				page : {
					curr : 1
					}
			});
			loadMajorSelectByCollegeid("professionid",data.value, form);
			loadclassSelectByCollegeid("classid",data.value, form);
			form.render('select', 'formsearch');
		});
		
		//专业下拉框改变
  		form.on('select(professionid)', function(data){
  			table.reload('userlist', {
				method : 'post',
				where : {
					'collegeid':$("#collegeid").val(),
					'majorid':data.value
						},
				page : {
					curr : 1
					}
			});
			loadClassSelectByMajor("classid",data.value, form)
			form.render('select', 'formsearch');
		});
		
		//班级下拉框改变
  		form.on('select(classid)', function(data){
  			table.reload('userlist', {
				method : 'post',
				where : {
					'collegeid':$("#collegeid").val(),
					'majorid':$("#majorid").val(),
					'classid':data.value
						},
				page : {
					curr : 1
					}
			});
		});
  		
  		//表格工具栏事件 
		table.on('tool(tool)', function(obj) {
			var data = obj.data;
			switch (obj.event) {
				//删除按钮操作
				case 'del':
					layer.confirm('即将删除'+data.username+',确定要删除么？', {
					  btn: ['确定','取消'],
					  icon:3
					}, function(){
						$.ajax({
			        		type: 'get',
			        		url: "../user/deluser",
			        		dataType: 'json',
			        		data:{
			        		userid:data.userid
			        		},
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
			        				icon: 1,
									  btn: ['确定']
									}, function(){
										table.reload("userlist", { //此处是上文提到的 初始化标识id
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
					$("#oldcollegename").val(data.collegename);
					layer.open({
  						title:"班级信息编辑",
  						type: 1,
  						area: ['400px', '300px'],
  						skin: 'demo-class',
  						btn:['确认保存'],
  						maxmin: true,//显示最大化最小化按钮
  						//offset: 'b', 弹框的位置
  						content: $('#div_editcollege'),
  						btn1: function(index, layero){
    						$.ajax({
			        		type: 'get',
			        		url: "../college/edcollege",
			        		dataType: 'json',
			        		data:{
			        		collegeid:data.collegeid,
			        		 collegename:$("#newcollegename").val().trim()
			        		},
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
			        				icon: 1,
									  btn: ['确定']
									}, function(){
										table.reload("userlist", { //此处是上文提到的 初始化标识id
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
			};
		});
  		//导入按钮事件
  		$("#btn_importcollege").click(function(){
  			layer.open({
  				title:"学院信息导入",
  				type: 1,
  				area: ['500px', '400px'],
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
  		});
  		
  		//确认导入按钮
		$("#btn_import").click(function(){
		
			if($("#btn_import").val()==null || $("#btn_import").val()==""){
				layer.msg("请先选择文件");
				return;
			}
			$.ajax({
				type:"GET",
        		url:"../user/adduserlist",
        		dataType:"json",
				data:{
					path:$("#btn_import").val()
				},beforeSend: function(){
        			layer.load();
    			},
        		success:function(data){
 					layer.closeAll('loading'); //关闭loading
           			if(data.code==0){
						layer.confirm(data.msg, { icon: 1, btn: ['确定'] },
				 		function(){
							table.reload("userlist", { //此处是上文提到的 初始化标识id
							      where: {
							        },
							        page: {
							          curr:1
							        }
							        })
							 layer.closeAll();
						})
							
						
           			}else{
              			layer.confirm(data.msg, { icon: 7,  btn: ['确定'] });
          			 }
        		},
       			 error:function(jqXHR){
 					layer.closeAll('loading'); //关闭loading
 					layer.msg("发生错误："+ jqXHR.status);
        		}
			})
		});
  		
  		//添加用户时用户类型下拉框改变
  		form.on('select(usertype)', function(data){
  			loadSelect("college","addclasscollege", form);
  			if(data.value==0){
  				//学生
  				$("#div_addmajor").show();
  				$("#div_addclass").show();
  			}else
  			{
  				$("#div_addmajor").hide();
  				$("#div_addclass").hide();
  			}
		});
		//添加用户时学院类型下拉框改变
  		form.on('select(addcollege)', function(data){
  			if($("#usertype").val()==0){
  				loadMajorSelectByCollegeid("addmajorid",data.value, form);
				loadclassSelectByCollegeid("addclassid",data.value, form);
  			}
		});
		//添加用户时专业类型下拉框改变
  		form.on('select(addmajorid)', function(data){
  			if($("#usertype").val()==0){
				loadClassSelectByMajor("addclassid",data.value, form);
  			}
		});
		
  		//添加学院按钮事件
  		$("#btn_addcollege").click(function(){
  			
  			layer.open({
  				title:"添加学院",
  				type: 1,
  				area: ['350px'],
  				skin: 'demo-class',
  				btn:['添加'],
  				maxmin: true,//显示最大化最小化按钮
  				//offset: 'b', 弹框的位置
  				content: $('#div_addcollege'),
  				btn1: function(index, layero){
  				
  				
  				if($("#usertype").val()==null||$("#usertype").val()==""){
  					layer.tips('请选择用户类型！', '#addusertype', {
						tips : [ 1, '#3595CC' ],
						time : 3000
					});
					return;
  				}if($("#adduserid").val().trim()==""){
  					layer.tips('用户账号不能为空！', '#adduserid', {
						tips : [ 1, '#3595CC' ],
						time : 3000
					});
					return;
  				}if($("#usertype").val()==0)
  				{
  					
  					if($("#addclassid").val()==null||$("#addclassid").val()==""){
  						layer.tips('请选择班级！', '#addclassid', {
							tips : [ 1, '#3595CC' ],
							time : 3000
						});
						return;
  					}
  				}
  				
  				if($("#addusername").val().trim()=="" ){
  					layer.tips('用户名不能为空！', '#addusername', {
						tips : [ 1, '#3595CC' ],
						time : 3000
					});
					return;
  				}if($("#addpwd").val().trim()=="" ){
  					layer.tips('用户密码不能为空！', '#addpwd', {
						tips : [ 1, '#3595CC' ],
						time : 3000
					});
					return;
				}
  					var classid=$("#addclassid").val();
  					if(classid==null||classid==""){
  						classid= $("#addclasscollege").val();
  					}
    				$.ajax({
			        		type: 'get',
			        		url: "../user/adduser",
			        		dataType: 'json',
			        		data:{
			        		classid:classid,
			        		 usertype:$("#usertype").val(),
			        		  userid:$("#adduserid").val().trim(),
			        		   username:$("#addusername").val().trim(),
			        		    pwd:$("#addpwd").val().trim()
			        		},
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
			        				icon: 1,
									  btn: ['确定']
									}, function(){
										table.reload("userlist", { //此处是上文提到的 初始化标识id
							                where: {
							                	
							                },page: {
							                curr:1
							                }
							            });	
							            form.render('select');
  										$('#adduserid').val("");
  										$('#addusername').val("");
  										$('#addpwd').val("");
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
  					form.render('select');
  					$('#adduserid').val("");
  					$('#addusername').val("");
  					$('#addpwd').val("");
  				}
			});
  		})
		//执行实例
		var uploadInst = upload.render({
			elem : '#upfile' //绑定元素
			,//auto: false, //不自动上传
			url : '../file/springimport', //上传接口
			//bindAction:'#btn_upload',
			//accept : 'file'//上传所有格式文件,
			exts : 'xls|xlsx',
			choose: function(obj) {
					obj.preview(function(index, file, result) {
							$("#filename").text('您的文件名是:'+file.name);
					});
				},
			done: function(res, index, upload){
    			//code=0代表上传成功
    			if(res.code == 0){
      				//layer.msg(res.msg);
					$("#btn_import").val(res.msg);
    			}else
    			{
    				layer.confirm(res.msg, { icon: 7,  btn: ['确定'] });
    			}
    
  			}
  			});
	}); 
  </script>
  <!--文件导入div  -->
	<div id="div_import" style="display: none;text-align: center;">
		<form class="layui-form" action="">
			<div class="layui-form-item">
				<div class="layui-upload-drag" id="upfile" style="margin: 30px;">
					<i class="layui-icon"></i>
					<p id="filename">点击选择文件，或将文件拖拽到此处</p>
				</div>
			</div>
			<div class="layui-form-item">
				<button class="layui-btn layuiadmin-btn-useradmin" type="button"
					id="btn_import">确认导入</button>
				<a href="../upload/download/用户模版.xlsx"><button
						class="layui-btn layuiadmin-btn-useradmin" type="button">下载模版</button></a>
			</div>
		</form>
	</div>
	 <!--学院添加div  -->
	<div id="div_addcollege"
		style="display: none;text-align: center; margin-top: 15%;">
		<form class="layui-form" action=""  lay-filter="addform">
			<div class="layui-form-item">
				 <label class="layui-form-label">用户类型:</label>
				<div class="layui-input-inline">
					<select id="usertype" lay-filter="usertype" >
						<option value="">请选择用户类型</option>
						<option value="0">学生</option>
						<option value="1">教师</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				 <label class="layui-form-label">所属学院:</label>
				<div class="layui-input-inline">
					<select id="addclasscollege" lay-filter="addcollege" lay-search>
						<option value="">请选择学院</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item" id="div_addmajor">
				 <label class="layui-form-label">所属专业:</label>
				<div class="layui-input-inline">
					<select id="addmajorid" lay-filter="addmajorid" lay-search>
						<option value="">请先选择学院</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item" id="div_addclass">
				 <label class="layui-form-label">班级名称:</label>
				<div class="layui-input-inline">
						<select id="addclassid"  lay-filter="addclassid" lay-search>
						<option value="">请选择班级</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				 <label class="layui-form-label">用户账号:</label>
				<div class="layui-input-inline">
					<input type="text" style="border-radius: 5px;"
						name="sysmothed" id="adduserid" placeholder="请输入用户账号"
						class="layui-input" autocomplete="off">
				</div>
			</div>
			<div class="layui-form-item">
				 <label class="layui-form-label">用户姓名:</label>
				<div class="layui-input-inline">
					<input type="text" style="border-radius: 5px;"
						name="sysmothed" id="addusername" placeholder="请输入用户姓名"
						class="layui-input" autocomplete="off">
				</div>
			</div>
			<div class="layui-form-item">
				 <label class="layui-form-label">用户密码:</label>
				<div class="layui-input-inline">
					<input type="password" style="border-radius: 5px;"
						name="sysmothed" id="addpwd" placeholder="请输入用户密码"
						class="layui-input" autocomplete="off">
				</div>
			</div>
		</form>
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
