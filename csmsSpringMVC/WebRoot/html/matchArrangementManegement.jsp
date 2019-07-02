<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>比赛人员安排</title>
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
			</form>
		</blockquote>
      
      <div class="layui-card-body">
        <table id="matchstatus" style="text-align: center;" class="layui-table" lay-filter="tool"></table>
        <script type="text/html" id="imgTpl"> 
          <img style="display: inline-block; width: 50%; height: 100%;" src= {{ d.avatar }}>
        </script> 
        <script type="text/html" id="addArrUser">
          <button type="button" class="layui-btn layui-btn-sm layui-btn-normal" lay-event="addArrUser">添加人数</button>
        </script>
        <script type="text/html" id="check">
		  <div class="layui-form"><input type="checkbox" name="checkuser" title="添加"></div>
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
			elem : '#matchstatus',
			id:'satustable',
			url : '../arrange/getarrange',
			title : '后台用户数据表',
			height: "full-160",
			skin : 'line',
			even : true,
			cols : [ 
			     [ {
					type : 'numbers',
					title : '序号',
					align : 'center'
				},  {
			     field : 'arrname',
			     align : 'center',
			     title : '场次名称',
			    }, {
			     field : 'proname',
			     align : 'center',
			     title : '赛项名称',
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
			     field : 'addr',
			     align : 'center',
			     title : '比赛地点',
			    }, {
					field : '',
					title : '赛项级别',
					align : 'center',
					templet : function(data) {
						return data.leveltype==1 ? "决赛":"预赛";
					}
				},{
			     field : 'createdate',
			     title : '操作',
			     align : 'center',
			     toolbar: '#addArrUser',
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
				case 'addArrUser':
				//表格加载
					table.render({
						elem : '#arruser',
						id:'arruser',
						url : '../arrange/getarruser?proid='+data.proid,
						title : '后台用户数据表',
						height: "full-160",
						skin : 'line',
						even : true,
						cols : [ 
						     [ {
								type : 'numbers',
								title : '序号',
								align : 'center'
							},  {
						     field : 'userid',
						     align : 'center',
						     title : '工号/学号',
						    }, {
						     field : 'username',
						     align : 'center',
						     title : '姓名',
						    },{
						     field : 'createdate',
						     title : '操作',
						     align : 'center',
						     toolbar: '#check',
						    }] 
						 ],
					});	

					layer.open({
  						title:"添加该场次运动员",
  						type: 1,
  						area: ['500px', '300px'],
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
				break;
			};
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
		});
		/* 点击查询对网站用户进行筛选 */
		$("#btnselfrontinfo").click(function() {
			table.reload('satustable', {
				method : 'post',
				where : {
					'wherecondition' : $("#sysmothed").val().trim(),
					'protype':$("#protype").val(),
					'sport':$("#sport").val(),
						},
				page : {
					curr : 1
					}
			});
		});
	});
</script>

<!--状态编辑div  -->
		<div id="div_content" style="display: none;text-align: center;">
			<table id="arruser" style="text-align: center;" class="layui-table">
				
			</table>
		</div>
</body>
		   
</html>
