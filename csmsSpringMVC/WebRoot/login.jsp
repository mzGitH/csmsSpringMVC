<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
<style>
body {
	background-image: url('image/login.jpg');
	background-size: 100% 100%;
	background-repeat: no-repeat;
	background-attachment: fixed;
}

.layui-form-label {
	text-align: center;
	background-color: rgb(245, 238, 238);
}

.layui-card-header {
	text-align: center;
	color: chocolate;
	margin: 10px 0;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="layui-container" style="margin-top:180px;">
		<div class="layui-row">
			<div
				class="layui-card layui-col-lg4 layui-col-md4 layui-col-sm4 layui-col-xs4 layui-col-lg-offset2 layui-col-md-offset2"
				style="height:330px;">
				<div class="layui-card-header textcenter">
					<h1>校园运动会</h1>
				</div>
				<div calss="layui-card-body">
					<img alt="" src="image/time.jpg" width="85%" height="80%"
						style="margin-left:5%;margin-bottom:10px;">
				</div>
			</div>
			<div
				class="layui-card layui-col-lg4 layui-col-md4 layui-col-sm4 layui-col-xs4"
				style="margin-left:20px;height:330px;">
				<div class="layui-card-header textcenter">
					<h1>用户登录</h1>
				</div>
				<div calss="layui-card-body">
					<div class="layui-row layui-col-space15">
						<div class="layui-col-lg12 layui-col-md12">
							<div class="layui-form" action="login.action"
								style="width:90%;margin-left:5%;">
								<div class="layui-form-item">
									<label class="layui-form-label">账号：</label>
									<div class="layui-input-block">
										<input type="text" name="userid" id="userid" required
											lay-verify="required" placeholder="请输入账号" autocomplete="off"
											class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">密码：</label>
									<div class="layui-input-block">
										<input type="password" name="password" id="password" required
											lay-verify="required" placeholder="请输入密码" autocomplete="off"
											class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">验证码：</label>
									<div class="layui-input-inline" style="width:35%;">
										<input type="text" name="safecode" id="safecode" required
											lay-verify="required" placeholder="请输入验证码" autocomplete="off"
											class="layui-input">
									</div>
									<div class="layui-form-mid layui-word-aux"
										style="width:90px;height:38px;margin-top:-5px;">
										<img src="safecode.do" width="100%" />
									</div>
								</div>
								<div class="layui-form-item">
									<button style="width:45%" class="layui-btn layui-btn-normal"
										id="btn_login" lay-filter="formDemo">立即登录</button>
									<button style="width:45%" type="reset"
										class="layui-btn layui-btn-danger">重置</button>
								</div>
								<div class="layui-form-item" style="color:#ccc;">
									<span>注册</span> <span style="float: right">忘记密码</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
<script src="layui/layui.js" charset="utf-8"></script>
<script src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
	layui.use('layer', function() {
		var layer = layui.layer;
		function login() {
			var userid = $("#userid").val();
			var password = $("#password").val();
			var safecode = $("#safecode").val();
			if (userid == null || userid == "") {

				layer.tips('用户名不能为空！', '#userid', {
					tips : [ 1, '#FF5722' ],
					time : 3000
				});
			} else if (password == null || password == "") {
				layer.tips('密码不能为空！', '#password', {
					tips : [ 1, '#FF5722' ],
					time : 3000
				});
			} else if (safecode == null || safecode == "") {
				layer.tips('验证码不能为空！', '#safecode', {
					tips : [ 1, '#FF5722' ],
					time : 3000
				});
			} else {
				//layer.msg(userid+password+safecode);
				$.ajax({
					type : "POST",
					url : "login.action",
					data : {
						userid : userid,
						password : password,
						safecode : safecode
					},
					dataType : "text",
					success : function(msg) {
						if (msg == "登录成功") {
							window.location.href = "main.jsp";
						} else {
							layer.alert(msg, {
								skin : 'demo-class',
								closeBtn : 0,
								anim : 5
							//动画类型
							});
						}

					},
				});
			}
		}
		;
		$("#btn_login").click(function() {
			login();
		});

		$("#userid").keypress(function(e) {
			if ((e.keyCode || e.which) == 13) {
				login();
			}
		});
		$("#password").keypress(function(e) {
			if ((e.keyCode || e.which) == 13) {
				login();
			}
		});
		$("#safecode").keypress(function(e) {
			if ((e.keyCode || e.which) == 13) {
				login();
			}
		});
	});
</script>

</html>
