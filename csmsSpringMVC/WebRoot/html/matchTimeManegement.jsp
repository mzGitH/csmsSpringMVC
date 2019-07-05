<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title></title>
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
					<select id="sport" lay-search lay-filter="sport">
						<option value="">请选择运动会</option>
					</select>
				</div>
				<div class="layui-inline" id="selectpro" style="display: none">
					<select id="systemtype" lay-search>
						<option value="">请选择项目</option>
					</select>
				</div>
				<div class="layui-input-inline" id="div_input" style="display: none">
					<input type="text" name="sysmothed" id="sysmothed" placeholder="请输入查询条件" class="layui-input" autocomplete="off">
			    </div>
				<div class="layui-inline" id="div_search" style="display: none">
					<button id="btnselfrontinfo" type="button"
						class="layui-btn layui-bg-blue">查询</button>
				</div>
				<div class="layui-inline" id="div_add" style="display: none">
					<button id="btn_add" type="button"
						class="layui-btn layui-bg-blue">添加</button>
				</div>
			</form>
		</blockquote>
      
      <div class="layui-card-body">
        <table id="matchlist" style="text-align: center;" class="layui-table" lay-filter="LAY-user-manage">
        	<center id="tips"><p>请先选择运动会</p></center>
        </table>
        <script type="text/html" id="imgTpl"> 
          <img style="display: inline-block; width: 50%; height: 100%;" src= {{ d.avatar }}>
		  <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
        </script> 
        <script type="text/html" id="table-useradmin-webuser">
         
          <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
        </script>
      </div>
    </div>
	<!-- 添加模态框 -->
	<div class="layui-card" id="div_content"
		style="display: none;height:450px;">
		<div class="layui-card-body">
			<div class="layui-card">
				<div class="layui-card-body">
					<!--表单开始-->
					<form class="layui-form">
						<div class="layui-form-item">
							<label class="layui-form-label">运动会名称</label>
							<div class="layui-input-block">
								<!-- <select id="">
									<option value="">请选择运动会名称</option>
								</select> -->
								<input type="text" class="layui-input layui-bg-gary" value="${config.sportname }" disabled />
								<input id="addsport" type="hidden" value="${config.sportid }" />
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">场次名称</label>
							<div class="layui-input-block">
								<!-- required -->
								<input type="text" name="sportname" id="sportname"
									lay-verify="required" placeholder="请输入场次名称" autocomplete="off"
									class="layui-input layui-bg-gary">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">赛项名称</label>
							<div class="layui-input-block">
								<select id="addproid" lay-search>
									<option value="">请选择比赛项目</option>
								</select>
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">开始时间</label>
							<div class="layui-input-block">
								<input type="text" name="starttime" class="layui-input"
									id="starttime" lay-verify="date" placeholder="请选择赛事开始时间"
									autocomplete="off" class="layui-input layui-bg-gary">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">结束时间</label>
							<div class="layui-input-block">
								<input type="text" name="endtime" class="layui-input"
									id="endtime" lay-verify="date" placeholder="请选择赛事结束时间"
									autocomplete="off" class="layui-input layui-bg-gary">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">比赛地点</label>
							<div class="layui-input-block">
								<input type="text" name="sportname" id="addrname"
									lay-verify="required" placeholder="请输入比赛地点" autocomplete="off"
									class="layui-input layui-bg-gary">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">比赛级别</label>
							<div class="layui-input-block">
								<select id="addlevel">
									<option value="">请选择比赛级别</option>
									<option value="1">预赛</option>
									<option value="2">决赛</option>
								</select>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
	
	<script src="../layui/layui.js" charset="utf-8"></script>
	<script src="../js/loadselect.js" charset="utf-8"></script>
  <script>
  	layui.use(['layer','upload','jquery','form','table','laydate'], function(){
  		
		var layer = layui.layer,
		$=layui.jquery,
		upload = layui.upload;
		form = layui.form;
		table = layui.table;
		laydate = layui.laydate;
		//加载下拉框
  		loadSelectProject('systemtype','all',form);
  		loadSport('sport','all', form);
		/* 加载时间选择器 */
		laydate.render({
		    elem: '#starttime',
		    format:'yyyy-MM-dd HH:mm:ss',
	        type:'datetime',
	        theme: '#4476A7',
	        trigger: 'click'
		});
		laydate.render({
		    elem: '#endtime',
		    format:'yyyy-MM-dd HH:mm:ss',
	        type:'datetime',
	         theme: '#4476A7',
	        trigger: 'click'
		});
		//运动会下拉框改变
  		form.on('select(sport)', function(data){
  		if(data.value==0){
  			$("#div_input").hide();
  			$("#div_search").hide(); 
  			$("#div_add").hide();
  			$("#selectpro").hide();
  		}else
  		{
  			$("#div_input").show();
  			$("#div_search").show(); 
  			$("#div_add").show();
  			$("#selectpro").show();
  		}
  		$("#tips").hide();
  			/*加载表格*/
		table.render({
			elem : '#matchlist',
			id:'satustable',
			url : '../match/getmatch?sportid='+data.value,
			title : '后台用户数据表',
			height: "full-160",
			skin : 'line',
			even : true,
			cols : [ 
			     [ {
					type : 'numbers',
					title : '序号',
					align : 'center'
				},{
			     field : 'arrname',
			     align : 'center',
			     title : '场次名称',
			    }, {
			     field : 'proname',
			     align : 'center',
			     title : '赛项名称',
			    },{
			     field : 'starttime',
			     align : 'center',
			     title : '开始时间',
			    },{
			     field : 'endtime',
			     align : 'center',
			     title : '结束时间',
			    },{
			     field : 'addr',
			     align : 'center',
			     title : '比赛地点',
			    },{
			     field : 'leveltype',
			     align : 'center',
			     title : '比赛等级',
			     templet : function(d) {
						if(d.leveltype==1){
							return "预赛";
						}else{
							return "决赛";
						}
							
					}
			    }, {
					field : 'scenelimit',
					title : '比赛人数限制',
					align : 'center',
				}] 
			 ],
			 page: {
					layout: ['prev', 'page', 'next', 'skip', 'count', 'limit'],
					groups: 5,
					limit: 10,
					limits: [1, 4, 5, 10, 50],
					theme: '#1E9FFF',						
			 },
		});	
		
			loadSelectProject('systemtype',data.value,form);
			form.render();
		});
		
		/* 点击查询对网站用户进行筛选 */
		$("#btnselfrontinfo").click(function() {
			table.reload('satustable', {
				method : 'post',
				where : {
					'wherecondition' : $("#sysmothed").val().trim(),
					'sportid':$("#sport").val(),
					'proid':$("#systemtype").val()
						},
				page : {
					curr : 1
					}
			});
		});
		
  		//添加按钮点击事件
  		$("#btn_add").click(function(){ 
  			//加载下拉框
  			loadSelectProject('addproid','now',form);
  			//loadSport('addsport','now', form);
  			form.render();
  			layer.open({
  						title:"添加比赛场次",
  						type: 1,
  						area: ['500px', '550px'],
  						skin: 'demo-class',
  						btn:['确认保存'],
  						maxmin: true,//显示最大化最小化按钮
  						//offset: 'b', 弹框的位置
  						content: $('#div_content'),
  						btn1: function(index, layero){ 
  							if($("#sportname").val()==""){
  								layer.tips('场次名称不能为空！', '#sportname', {
									tips : [ 1, '#3595CC' ],
									time : 3000
								});
								return;
  							}
  							if($("#addproid").val()==""){
  								layer.tips('项目不能为空！', '#addproid', {
									tips : [ 1, '#3595CC' ],
									time : 3000
								});
								return;
  							}
  							if($("#starttime").val()==""){
  								layer.tips('开始时间不能为空！', '#starttime', {
									tips : [ 1, '#3595CC' ],
									time : 3000
								});
								return;
  							}
  							if($("#endtime").val()==""){
  								layer.tips('结束时间不能为空！', '#endtime', {
									tips : [ 1, '#3595CC' ],
									time : 3000
								});
								return;
  							}
  							if($("#addrname").val()==""){
  								layer.tips('比赛地点不能为空！', '#addrname', {
									tips : [ 1, '#3595CC' ],
									time : 3000
								});
								return;
  							}
  							 if($("#addlevel").val()==""){
  								layer.tips('比赛级别不能为空！', '#addlevel', {
									tips : [ 1, '#3595CC' ],
									time : 3000
								});
								return;
  							}
    						$.ajax({
			        		type: 'get',
			        		url: "../match/addmatch",
			        		dataType: 'json',
			        		data:{ 
			        			start:$("#starttime").val(),
			        			end:$("#endtime").val(),
			        			name:$("#sportname").val(),
			        			proid:$("#addproid").val(),
			        			addr:$("#addrname").val(),
			        			leveltype:$("#addlevel").val() 
			        		},
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
			        				icon: 1,
									  btn: ['确定']
									}, function(){
										$("input[type='radio']").removeAttr('checked');
										table.reload("satustable", { //此处是上文提到的 初始化标识id
							                where: {
							                },page: {
							                curr:1
							                }
							            });	
							            //form.render('radio', 'test2');
										layer.closeAll();
									});          				 
			        			}
			        			else{
			        				layer.confirm(data.msg, {
			        					  icon: 7,
										  btn: ['确定']
									}, function(){
										 
									});
			        			}
			        		},
			        		error:function(){
			        			layer.msg('出现错误，请重试！', {
			        				  icon: 6,
								});
			        		},
			        	});  
  						},
  						cancel: function(){ 
  							 
  						}
					});
  		})
  		
 		
	}); 
  </script>
 
</body>
		   
</html>
