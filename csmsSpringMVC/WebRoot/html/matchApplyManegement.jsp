<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>查看项目报名情况</title>
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
				<div class="layui-input-inline">
					<select name="college" id="college" lay-filter="college"
						lay-verify="required" lay-search="">
					</select>
				</div>
				<div class="layui-input-inline search">
					<select name="major" id="major" lay-filter="major">
						<option value="">请选择或输入专业名称</option>
					</select>
				</div>
				<div class="layui-input-inline search">
					<select name="classes" id="classes" lay-filter="class">
						<option value="">请选择或输入班级名称</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<input type="text" name="text" id="userid" placeholder="请输入学号/工号"
						autocomplete="off" class="layui-input">
				</div>
				<div class="layui-input-inline">
					<input type="text" name="sysmothed" id="sysmothed" placeholder="请输入查询条件" class="layui-input" autocomplete="off">
			    </div>
				<div class="layui-inline">
					<button id="btnselfrontinfo" type="button"
						class="layui-btn layui-bg-blue">查询</button>
				</div>
				<div class="layui-input-inline">
					<label class="layui-form-label">查询角色</label>
					<div class="layui-input-block">
					      <input type="radio" lay-filter="erweima" name="sex" value="学生" title="学生" id="btnradio">
					      <input type="radio" lay-filter="erweima" name="sex" value="教职工" title="教职工">
					      <input type="radio" lay-filter="erweima" name="sex" value="all" title="全部" checked>
					</div>
				</div>
			</form>
		</blockquote>
      
      <div class="layui-card-body">
         <table id="matchstatus" style="text-align: center;" class="layui-table" lay-filter="tool"></table>
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
	layui.use([ 'table', 'form', 'layer',  'laytpl', 'element','laydate' ], function() {
		var table = layui.table, layer = layui.layer, $ = layui.jquery,
			element = layui.element,  laydate = layui.laydate;
		var form = layui.form;
		form.render();
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
			     field : 'sportname',
			     align : 'center',
			     title : '运动会名称',
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
			     field : 'userid',
			     align : 'center',
			     title : '学号/工号',
			    },{
			     field : 'username',
			     align : 'center',
			     title : '运动员姓名',
			    }, {
					field : 'collegename',
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
		
		/* 点击查询对网站用户进行筛选 */
		$("#btnselfrontinfo").click(function() {
			var roletype=$('input:radio[name="sex"]:checked').val();
			table.reload('satustable', {
				method : 'post',
				where : {
					sportid:$("#sport").val(),
					userid:$("#userid").val(),
					collegeid:$("#college").val(),
					majorid:$("#major").val(),
					classid:$("#classes").val(),
					wherecondition:$("#sysmothed").val(),
					roletype:roletype,
				},
				page : {
					curr : 1
				}
			});
		});
		
		//单选框点击事件
		form.on('radio(erweima)', function (data) {
            //alert(data.elem);
            //console.log(data.elem);
            //alert(data.value);//判断单选框的选中值
            //console.log(data.value);
            //alert(data.othis);
            //layer.tips('开关checked：' + (this.checked ? 'true' : 'false'), data.othis);
            //layer.alert('响应点击事件');
            if(data.value=="学生"){
            	$(".search").show();
            }
            if(data.value=="教职工"){
            	$(".search").hide();
            	//alert($("#major").val()+","+$("#classes").val());
				$("#major").val("");
				$("#classes").val("")
            }
            if(data.value=="all"){
            	$(".search").show();
				$("#major").val("");
				$("#classes").val("")
            }
            table.reload('satustable', {
				method : 'post',
				where : {
					sportid:$("#sport").val(),
					userid:$("#userid").val(),
					collegeid:$("#college").val(),
					majorid:$("#major").val(),
					classid:$("#classes").val(),
					wherecondition:$("#sysmothed").val(),
					roletype:data.value,
				},
				page : {
					curr : 1
				}
			});
        });
		
		//学院下拉框加载
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
				url : "../select/selectcollege",
				type : "POST",
				data : null,
				dataType : 'json',
				contentType : 'application/json;charset=UTF-8',//contentType 很重要
				success : function(e) {
					//alert(e.data[0].collegeid);
					var s = $("#college").html();
					var str = "<option value='0'>请选择学院</option>";
					for(var i=0;i<e.data.length;i++){
						str += "<option value="+e.data[i].collegeid+">"+e.data[i].collegename+"</option>"
					}
					$("#college").append(str);
					form.render("select");
				},
				error : function(e) {
					layer.alert("error:"+e.msg);
				}
	
			})
		});
		
		/* 下拉框三级联动 */
		var $ = layui.jquery;
		form.render('select');
		form.on('select(college)',function(data) {
			var hosid = data.value;
			$.ajax({
				type : "post",
				url : "../select/selectmajorbycollegeid",
				data : {
					collegeid : hosid
				},
				dataType : "json",
				success : function(succ) {
					if (succ == "失败") {
						layer
								.msg("请刷新后重试");
					} else {
						var tmp = '<option value="0">请选择专业</option>';
						for ( var i in succ.data) {
							tmp += '<option value="' + succ.data[i].majorid +  '">'
									+ succ.data[i].majorname
									+ '</option>';
						}
						$("#major").html(tmp);
						var tmp2 = '<option value="0">请选择班级</option>';
						$("#class").html(tmp2);
						form.render();
					}
				},
				error : function() {
					layer.msg('请求失败，稍后再试',{icon : 5});
				}
			});
		});
		form.on('select(major)',function(data) {
			var hosid = data.value;
			$.ajax({
				type : "post",
				url : "../select/selectclassesbymajor",
				data : {
					majorid : hosid
				},
				dataType : "json",
				success : function(succ) {
					if (succ == "失败") {
						layer.msg("请刷新后重试");
					} else {
						var tmp = '<option value="0">请选择或输入班级名称</option>';
						for ( var i in succ.data) {
							tmp += '<option value="' + succ.data[i].classid +  '">'
									+ succ.data[i].classname
									+ '</option>';
						}
						$("#classes").html(tmp);
						form.render();
					}
				},
				error : function() {
					layer.msg('请求失败，稍后再试',{icon : 5});
				}
			});
		});
	});
</script>
</body>
		   
</html>
