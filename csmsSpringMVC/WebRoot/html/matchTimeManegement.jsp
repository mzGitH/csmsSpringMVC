<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>学院成绩</title>
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
					<select id="systemtype">
						<option value="0">请选择项目</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<input type="text" name="sysmothed" id="sysmothed" placeholder="请输入查询条件" class="layui-input" autocomplete="off">
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
        <table id="LAY-user-manage" style="text-align: center;" class="layui-table" lay-filter="LAY-user-manage">
        	
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
  	layui.use(['layer','upload','jquery','form','table','laydate'], function(){
		var layer = layui.layer,
		$=layui.jquery,
		upload = layui.upload;
		form = layui.form;
		table = layui.table;
		laydate = layui.laydate;
		
		/* 加载时间选择器 */
		laydate.render({
		    elem: '#starttime',
		    format:'yyyy-MM-dd',
	        type:'date',
	        trigger: 'click'
		});
		laydate.render({
		    elem: '#endtime',
		    format:'yyyy-MM-dd',
	        type:'date',
	        trigger: 'click'
		});
		
		/*加载表格*/
		table.render({
			elem : '#matchstatus',
			id:'satustable',
			url : '../match/getmatch',
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
			    }, {
					field : 'arr',
					title : '学院',
					align : 'center',
				},{
			     field : '',
					title : '比赛状态',
					align : 'center',
					templet : function(data) {
						if (data.classname == ""||data.classname==null) {
							return "教职工没有班级"
						} else {
							return data.classname;
						} 
						
					}
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
		
  		//编辑按钮点击事件
  		$(".layui-btn").click(function(){
  			layer.open({
  						title:"比赛状态编辑",
  						type: 1,
  						area: ['500px', '500px'],
  						skin: 'demo-class',
  						btn:['确认保存'],
  						maxmin: true,//显示最大化最小化按钮
  						//offset: 'b', 弹框的位置
  						content: $('#div_content'),
  						btn1: function(index, layero){
  							var state = $('input:radio[name="sex"]:checked').val();
    						$.ajax({
			        		type: 'get',
			        		url: "../compelition/updatestate",
			        		dataType: 'json',
			        		data:{
			        			state:state,
			        			arrid:data.arrid,
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
										$("input[type='radio']").removeAttr('checked');
										//form.render('radio', 'test2')
									});
			        			}
			        		},
			        		error:function(){
			        			layer.confirm('出现错误，请重试！', {
			        				  icon: 6,
									  btn: ['确定']
								}, function(){
									//form.render('radio', 'test2')
									$("input[type='radio']").removeAttr('checked');
								});
			        		},
			        	});  
  						},
  						cancel: function(){ 
  							$("input").removeAttr('checked');
  						}
					});
  		})
  		
 		
	}); 
  </script>
  <!-- 添加模态框 -->
  <div class="layui-card" id="div_content" style="display: none;height:450px;">
	<div class="layui-card-body">
		<div class="layui-card">
			<div class="layui-card-body">
				<!--表单开始-->
				<form class="layui-form">
					<input type="hidden" id="proid" value="" />
					<div class="layui-form-item">
						<label class="layui-form-label">场次名称</label>
						<div class="layui-input-block">
							<!-- required -->
							<input type="text" name="sportname" id="sportname"
								lay-verify="required" placeholder="请输入场次名称"
								autocomplete="off" class="layui-input layui-bg-gary">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">场次名称</label>
						<div class="layui-input-block">
							<select id="systemtype">
								<option value="0">请选择比赛项目</option>
							</select>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">开始时间</label>
						<div class="layui-input-block">
							<input type="text" name="starttime" class="layui-input" id="starttime"
								lay-verify="date" placeholder="请选择赛事开始时间"
								 autocomplete="off" class="layui-input layui-bg-gary">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">结束时间</label>
						<div class="layui-input-block">
							<input type="text" name="endtime" class="layui-input" id="endtime"
								lay-verify="date" placeholder="请选择赛事结束时间"
								 autocomplete="off" class="layui-input layui-bg-gary">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">比赛地点</label>
						<div class="layui-input-block">
							<input type="text" name="sportname" id="addrname"
								lay-verify="required" placeholder="请输入比赛地点"
								autocomplete="off" class="layui-input layui-bg-gary">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">比赛级别</label>
						<div class="layui-input-block">
							<select id="systemtype">
								<option value="0">请选择比赛级别</option>
							</select>
						</div>
					</div>
					<input type="hidden" id="sportid" value="" />
				</form>
			</div>
		</div>
	</div>
</div>
</body>
		   
</html>
