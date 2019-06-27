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
        	<thead>
        		<tr>
        			<td>序号</td>
        			<td>场次名称</td>
        			<td>比赛项目</td>
        			<td>开始时间</td>
        			<td>结束时间</td>
        			<td>比赛地点</td>
        			<td>比赛等级</td>
        			<td>比赛人数(人)</td>
        		</tr>
        	</thead>
        	<tbody>
        		<tr>
        			<td>1</td>
        			<td>男子跳高预赛第一场</td>
        			<td>跳高</td>
        			<td>2018-03-15 14:00:00</td>
        			<td>2018-03-15 14:10:00</td>
        			<td>田径场跳远场地二</td>
        			<td>预赛</td>
        			<td>8</td>
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
  	layui.use(['layer','upload','table'], function(){
  		var layer = layui.layer,$=layui.jquery,upload = layui.upload;
  		
  		
  		//编辑按钮点击事件
  		$(".layui-btn").click(function(){
  			layer.alert("查看详情");
  		})
  		
 		
	}); 
  </script>
</body>
		   
</html>
