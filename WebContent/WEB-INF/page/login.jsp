<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Main CSS-->
<link rel="stylesheet" type="text/css" href="${basePath }css/main.css">
<!-- Font-icon css-->
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<title>登录</title>
</head>
<body>
	<section class="material-half-bg">
		<div class="cover"></div>
	</section>
	<section class="login-content">
		<div class="logo">
			<h1>在线考试系统</h1>
		</div>
		<div class="login-box" style="height: 430px">
			<form class="login-form" id="loginForm">
				<h3 class="login-head">
					<i class="fa fa-lg fa-fw fa-user"></i>登录
				</h3>
				<div class="form-group">
					<label class="control-label">用户名</label> <input
						class="form-control" type="text" name="username" id="username"
						placeholder="请输入用户名" autofocus>
				</div>
				<div class="form-group">
					<label class="control-label">密码</label> <input class="form-control"
						type="password" name="password" id="password" placeholder="请输入密码">
				</div>
				<div class="form-group">
					<div class="animated-radio-button">
						<label> <input type="radio" name="role" value="1"
							checked="checked"><span class="label-text">学生</span>
						</label> <label> <input type="radio" name="role" value="2"><span
							class="label-text">教师</span>
						</label> <label> <input type="radio" name="role" value="3"><span
							class="label-text">管理员</span>
						</label>
					</div>
				</div>
				<div class="form-group">
					<div class="utility">
						<div class="animated-checkbox">
							<label> <input type="checkbox" name="auto" value="true"><span
								class="label-text">自动登陆</span>
							</label>
						</div>

					</div>
				</div>
				<div class="form-group btn-container">
					<button class="btn btn-primary btn-block" id="loginBtn" type="button">
						<i class="fa fa-sign-in fa-lg fa-fw"></i>登录
					</button>
				</div>
			</form>
		</div>
	</section>
	<!-- Essential javascripts for application to work-->
	<script src="${basePath }js/jquery-3.2.1.min.js"></script>
	<script src="${basePath }js/popper.min.js"></script>
	<script src="${basePath }js/bootstrap.min.js"></script>
	<script src="${basePath }js/main.js"></script>
	<!-- The javascript plugin to display page loading on top-->
	<script src="${basePath }js/plugins/pace.min.js"></script>
	<script type="text/javascript">
		$(function() {
			//表单验证
			$("#loginBtn").click(function() {
/* 				var username = $('#username').val();
				var password = $('#password').val();
				if (username == null || username == "") {
					alert("用户名不能为空");
					$('#username').focus();
					return false;
				}
				if (password == null || password == "") {
					alert("密码不能为空");
					$('#password').focus();
					return false;
				}
				loginForm.submit(); */
				$.ajax({
					url : '${basePath}' + 'DoLoginServlet',
					type : 'post',
					data : $("#loginForm").serialize(),
					dataType : 'text',
					success : function(data) {
						if (data == 'yes') {
							window.location.href = "${basePath}IndexServlet";
						}else if(data=='no'){
							alert("用户名或密码错误");
						}else if(data=="error"){
							alert("系统异常");
						}
					}
				})
			})
		})
	</script>
</body>
</html>