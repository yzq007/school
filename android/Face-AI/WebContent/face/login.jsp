<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>face door</title>
		<meta name="description" content="这是一个 index 页面">
		<meta name="keywords" content="index">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<link rel="icon" type="image/png" href="assets/i/icon.png">
		<link rel="apple-touch-icon-precomposed" href="assets/i/icon.png">
		<meta name="apple-mobile-web-app-title" content="Amaze UI" />
		<script src="assets/js/echarts.min.js"></script>
		<link rel="stylesheet" href="assets/css/amazeui.min.css" />
		<link rel="stylesheet" href="assets/css/amazeui.datatables.min.css" />
		<link rel="stylesheet" href="assets/css/app.css">
		<script src="assets/js/jquery.min.js"></script>
</head>
<body data-type="login">
		<script src="assets/js/theme.js"></script>
		<div class="am-g tpl-g">
			<!-- 风格切换 -->
			<div class="tpl-skiner">
				<div class="tpl-skiner-toggle am-icon-cog">
				</div>
				<div class="tpl-skiner-content">
					<div class="tpl-skiner-content-title">
						选择主题
					</div>
					<div class="tpl-skiner-content-bar">
						<span class="skiner-color skiner-white" data-color="theme-white"></span>
						<span class="skiner-color skiner-black" data-color="theme-black"></span>
					</div>
				</div>
			</div>
			<div class="tpl-login">
				<div class="tpl-login-content">
					<div class="tpl-login-logo">

					</div>
					<form class="am-form tpl-form-line-form" action="/Face-AI/loginServlet">
						<div class="am-form-group">
							<input type="text" class="tpl-form-input" id="user-name" placeholder="请输入账号" name="user-name">

						</div>

						<div class="am-form-group">
							<input type="password" class="tpl-form-input" id="user-name" placeholder="请输入密码" name="user-pswd">

						</div>
						

						<div class="am-form-group">

							<button type="submit" class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn">登录</button>

						</div>
					</form>
				</div>
			</div>
		</div>
		<script src="assets/js/amazeui.min.js"></script>
		<script src="assets/js/app.js"></script>
	</body>

</html>