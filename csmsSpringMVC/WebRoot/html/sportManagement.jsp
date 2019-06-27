<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>赛项管理页面</title>
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

 .div_addsport_label {
	float: right;
}.div_addsport_input {
	float: left;
}
</style>
<body>

  <div class="layui-fluid" style="margin-top: 10px">
      <div class="layui-card-body">
			<center>
				<label>历届运动会名称</label>
			</center>
			<button type="button" id="btn_add" class="layui-btn layui-btn-normal">添加</button>
			<table id="LAY-user-manage" style="text-align: center;"
				class="layui-table" lay-filter="LAY-user-manage">
				<thead>
					<tr>
						<td>序号</td>
						<td>运动会名称</td>
						<td>开始时间</td>
						<td>结束时间</td>
						<td>报名开始时间</td>
						<td>报名结束时间</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>2018春季运动会</td>
						<td>2018-03-15 00:00:00</td>
						<td>2018-03-25 00:00:00</td>
						<td>2018-03-10 00:00:00</td>
						<td>2018-03-15 00:00:00</td>
					</tr>
				</tbody>
				
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
  	layui.use(['layer','upload','table','laydate'], function(){
  		var layer = layui.layer,$=layui.jquery,upload = layui.upload,laydate=layui.laydate;
  		  //时间选择器
  		laydate.render({
    			elem: '#starttime'
    			,theme: '#4476A7'
  		});
  		  //时间选择器
  		laydate.render({
    			elem: '#endtime'
    			,theme: '#4476A7'
  		});
  		  //时间选择器
  		laydate.render({
    			elem: '#reportstart'
    			,theme: '#4476A7'
  		});
  		  //时间选择器
  		laydate.render({
    			elem: '#reportend'
    			,theme: '#4476A7'
  		});
  		
  		
  		//添加按钮点击事件
  		$("#btn_add").click(function(){
  			layer.open({
  				title:"添加新一届运动会",
  				type: 1,
  				area: ['600px', '400px'],
  				skin: 'demo-class',
  				btn:['添加'],
  				maxmin: true,//显示最大化最小化按钮
  				//offset: 'b', 弹框的位置
  				content: $('#div_addsport'),
  				btn1: function(index, layero){
    				layer.msg("666")
  				},
  				cancel: function(){ 
  					
  				}
			});
  		})
 		
	}); 
  </script>
  
   <!--学院添加div  -->
	<div id="div_addsport"
		style="display: none;text-align: center; margin-top: 1%;">
		<table  class="layui-table" lay-skin="nob" style="margin: 0 auto;">
			<tr>
				<td><label class="layui-form-label div_addsport_label"><nobr>运动会名称:</nobr></label></td>
				<td><div class="layui-input-inline div_addsport_input">
						<input type="text" style="width:250px;border-radius: 5px;"
							name="sysmothed" id="addcollegename" placeholder="请输入运动会名称"
							class="layui-input" autocomplete="off">
					</div></td>
			</tr>

			<tr>
				<td><label class="layui-form-label div_addsport_label"><nobr>运动会开始时间:</nobr></label></td>
				<td><div class="layui-input-inline div_addsport_input" >
						<input type="text" class="layui-input"  style="width:250px;border-radius: 5px;" id="starttime"
							placeholder="yyyy-MM-dd">
					</div></td>
			</tr>
			<tr>
				<td><label class="layui-form-label div_addsport_label"><nobr>运动会结束时间:</nobr></label></td>
				<td><div class="layui-input-inline div_addsport_input">
						<input type="text" class="layui-input"  style="width:250px;border-radius: 5px;"id="endtime"
							placeholder="yyyy-MM-dd">
					</div></td>
			</tr>
			<tr>
				<td><label class="layui-form-label div_addsport_label"><nobr>报名开始时间:</nobr></label></td>
				<td><div class="layui-input-inline div_addsport_input">
						<input type="text" class="layui-input"  style="width:250px;border-radius: 5px;" id="reportstart"
							placeholder="yyyy-MM-dd">
					</div></td>
			</tr>
			<tr>
				<td><label class="layui-form-label div_addsport_label"><nobr>报名结束时间:</nobr></label></td>
				<td><div class="layui-input-inline div_addsport_input">
						<input type="text" class="layui-input"  style="width:250px;border-radius: 5px;" id="reportend"
							placeholder="yyyy-MM-dd">
					</div></td>
			</tr>
		</table>
	</div>
</body>
		   
</html>
