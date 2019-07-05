<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>比赛成绩管理页面</title>
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
					<select id="sport">
						
					</select>
				</div>
				<div class="layui-inline">
					<select id="project" lay-search>
						
					</select>
				</div>
				<!--  <div class="layui-input-inline">
					<input type="text" name="sysmothed" id="sysmothed" placeholder="请输入查询条件" class="layui-input" autocomplete="off">
			    </div>-->
				<div class="layui-inline">
					<button id="btnselfrontinfo" type="button"
						class="layui-btn layui-bg-blue">查询</button>
				</div>
			</form>
		</blockquote>
      
      <div class="layui-card-body">
      <table id="scremanagement" style="text-align: center;" class="layui-table" lay-filter="tool"></table>
        
        <script type="text/html" id="imgTpl"> 
          <img style="display: inline-block; width: 50%; height: 100%;" src= {{ d.avatar }}>
        </script> 
        <script type="text/html" id="scoreIn">
          <button type="button" class="layui-btn layui-btn-sm layui-btn-normal" lay-event="signIn">成绩录入</button>
        </script>
      </div>
    </div>

  <script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
	
	<script src="../layui/layui.js" charset="utf-8"></script>
  <script>
  	layui.use([ 'table', 'form', 'layer',  'laytpl', 'element','laydate' ], function() {
		var table = layui.table, layer = layui.layer, $ = layui.jquery,
			element = layui.element,  laydate = layui.laydate;
		var form = layui.form;
		form.render();
		/*加载表格*/
		table.render({
			elem : '#scremanagement',
			id:'scremanagement',
			url : '../score/getscore',
			title : '后台用户数据表',
			height: "full-160",
			skin : 'row',
			even : true,
			cols : [ 
			     [ {
					type : 'numbers',
					title : '序号',
					align : 'center'
				},{
			     field : 'sportname',
			     align : 'center',
			     title : '运动会名称',
			    },{
			     field : 'arrname',
			     align : 'center',
			     title : '场次名称',
			    },{
			     field : 'proname',
			     align : 'center',
			     title : '比赛项目',
			    }, {
					field : '',
					title : '赛项类型',
					align : 'center',
					templet : function(data) {
						if(data.protype==1){
							return "学生个人赛";
						}
						if(data.protype==2){
							return "学生团体赛";
						}
						if(data.protype==3){
							return "教师个人赛";
						}
						if(data.protype==4){
							return "教师团体赛";
						}
					}
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
			     field : '',
			     title : '操作',
			     toolbar: '#scoreIn',
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
		
		//表格工具栏事件 
		table.on('tool(tool)', function(obj) {
			var data = obj.data;
			switch (obj.event) {
				case 'signIn':
					//alert(data.arrid);
					$.ajax({
			        	type: 'get',
			        	url: "../score/getuser",
			        	dataType: 'json',
			        	data:{
			        		arrid:data.arrid,
			        	},
						success : function(e) {
							if(e.code==0){
								var s = $("#userScore").html();
								var str="";
								for(var i=0;i<e.data.length;i++){
									str += '<div class="layui-form-item userScureNum"><label class="layui-form-label">'+e.data[i].username+'</label><input id="matchid" type="hidden" value="'+e.data[i].matchid+'" /><div class="layui-input-inline box"><input type="text" name="title" placeholder="请输入成绩" autocomplete="off" class="layui-input scoreInput"><input type="text" name="title" placeholder="请输入积分" autocomplete="off" class="layui-input accumul"></div></div>';
								}
								$("#userScore").append(str);
								//form.render("select");
							}
							//layer.alert(e.msg);
						},
						error : function(e) {
							layer.alert("error:"+e.msg);
						}
			
					})
					//$("#username").text(data.username);
					layer.open({
  						title:"比赛状态编辑",
  						type: 1,
  						area: ['450px', '300px'],
  						skin: 'demo-class',
  						btn:['确认保存'],
  						maxmin: true,//显示最大化最小化按钮
  						//offset: 'b', 弹框的位置
  						content: $('#div_editcollege'),
  						btn1: function(index, layero){
  							var matchid=$("#matchid").val();
        					var txt = $('.box').find(':text'); // 获取所有文本框
						    
						    var data={}; //定义json对象
							var resAccount=new Array();//定义数组对象
							
							var $scoreInput = $('.scoreInput');//获取class为resAccount的input对象
							var $accumul = $('.accumul');
							for(var i=0;i<$scoreInput.length;i++){
								var obj=new Object();
								obj.matchid=matchid;
								obj.scorenumber=$scoreInput[i].value;
								obj.scorerecord=$accumul[i].value;
								resAccount.push(obj);
							}
							
							data=resAccount;
							//alert(JSON.stringify(data));
						    
    						$.ajax({
			        		type: 'Post',
			        		url: "../score/addscore",
			        		dataType: 'json',
			        		data:{data:JSON.stringify(data)},
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
			        				icon: 1,
									  btn: ['确定']
									}, function(){
										$('.userScureNum').remove();
										layer.closeAll();
									});          				 
			        			}
			        			else{
			        				layer.confirm(data.msg, {
			        					  icon: 7,
										  btn: ['确定']
									},function(){
										$('.userScureNum').remove();
										layer.closeAll();
									});
			        			}
			        		},
			        		error:function(){
			        			//layer.confirm('出现错误，请重试！', {
			        				  //icon: 6,
									  //btn: ['确定']
								//});
			        		},
			        	});  
  						},
  						cancel: function(){ 
  							$('.userScureNum').remove();
  						}
					});
				break;
			};
		});
		
		/* 点击查询对网站用户进行筛选 */
		$("#btnselfrontinfo").click(function() {
			table.reload('scremanagement', {
				method : 'post',
				where : {
					//'wherecondition' : $("#sysmothed").val().trim(),
					'project':$("#project").val(),
					'sport':$("#sport").val()
						},
				page : {
					curr : 1
					}
			});
		});
		//下拉框加载
		$(function() {
			$.ajax({
				url : "../score/getsport",
				type : "POST",
				data : null,
				dataType : 'json',
				contentType : 'application/json;charset=UTF-8',//contentType 很重要
				success : function(e) {
					//alert(e.data[0].collegeid);
					var s = $("#sport").html();
					var str = "<option value='0'>请选择运动会名称</option>";
					//var str;
					for(var i=0;i<e.resultObject.length;i++){
						str += "<option value="+e.resultObject[i].sportid+">"+e.resultObject[i].sportname+"</option>"
					}
					$("#sport").append(str);
					form.render("select");
				},
				error : function(e) {
					layer.alert("error:"+e.msg);
				}
	
			})
			//$(".search").hide();
			$.ajax({
				url : "../score/getproject",
				type : "POST",
				data : null,
				dataType : 'json',
				contentType : 'application/json;charset=UTF-8',//contentType 很重要
				success : function(e) {
					//alert(e.data[0].collegeid);
					var s = $("#project").html();
					var str = "<option value='0'>请选择项目</option>";
					for(var i=0;i<e.resultObject.length;i++){
						var typeid = e.resultObject[i].protype;
						var protypename="";
						if(typeid==1){
							protypename="学生个人赛";
						}else if(typeid==2){
							protypename="学生团体赛";
						}
						else if(typeid==3){
							protypename="教职工个人赛";
						}else if(typeid==4){
							protypename="教职工团体赛";
						}
						str += "<option value="+e.resultObject[i].proid+">"+e.resultObject[i].proname+"("+protypename+")"+"</option>"
					}
					$("#project").append(str);
					form.render("select");
				},
				error : function(e) {
					layer.alert("error:"+e.msg);
				}
	
			})
		});
	});
</script>
   <!--学院编辑div  -->
	<div id="div_editcollege"
		style="display: none;text-align: center; margin-top: 10%;">
		<form action="" id="userScore">
			
		</form>
	</div>
</body>
		   
</html>
