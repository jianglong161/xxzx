<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html class="ui-page-login">

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title></title>
		<link href="css/mui.min.css" rel="stylesheet" />
		<link href="css/style.css" rel="stylesheet" />
		<style>
			.area {
				margin: 20px auto 0px auto;
			}
			
			.mui-input-group {
				margin-top: 10px;
			}
			
			.mui-input-group:first-child {
				margin-top: 20px;
			}
			
			.mui-input-group label {
				width: 22%;
			}
			
			.mui-input-row label~input,
			.mui-input-row label~select,
			.mui-input-row label~textarea {
				width: 78%;
			}
			
			.mui-checkbox input[type=checkbox],
			.mui-radio input[type=radio] {
				top: 6px;
			}
			
			.mui-content-padded {
				margin-top: 25px;
			}
			
			.mui-btn {
				padding: 10px;
			}
			
			.link-area {
				display: block;
				margin-top: 25px;
				text-align: center;
			}
			
			.spliter {
				color: #bbb;
				padding: 0px 8px;
			}
			
			.oauth-area {
				position: absolute;
				bottom: 20px;
				left: 0px;
				text-align: center;
				width: 100%;
				padding: 0px;
				margin: 0px;
			}
			
			.oauth-area .oauth-btn {
				display: inline-block;
				width: 50px;
				height: 50px;
				background-size: 30px 30px;
				background-position: center center;
				background-repeat: no-repeat;
				margin: 0px 20px;
				/*-webkit-filter: grayscale(100%); */
				border: solid 1px #ddd;
				border-radius: 25px;
			}
			
			.oauth-area .oauth-btn:active {
				border: solid 1px #aaa;
			}
			
			.oauth-area .oauth-btn.disabled {
				background-color: #ddd;
			}
		</style>

	</head>

	<body>
		<header class="mui-bar mui-bar-nav">
			<h1 class="mui-title">登录</h1>
		</header>
		<div class="mui-content">
			<form id='login-form' class="mui-input-group">
				<div class="mui-input-row">
					<label>账号</label>
					<input id='userId' type="text" class="mui-input-clear mui-input" placeholder="请输入账号">
				</div>
				<div class="mui-input-row">
					<label>密码</label>
					<input id='password' type="password" class="mui-input-clear mui-input" placeholder="请输入密码">
				</div>
			</form>
			<div class="mui-content-padded">
				<button id='login' class="mui-btn mui-btn-block mui-btn-primary">登录</button>
				<div class="link-area">
				</div>
			</div>
			<div class="mui-content-padded oauth-area">

			</div>
		</div>
		<script src="js/mui.min.js"></script>
		<script src="js/mui.enterfocus.js"></script>
		<script src="js/app.js"></script>
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script>
			(function($, doc) {
				$.init({
					statusBarBackground: '#f7f7f7'
				});
				//mui.alert('欢迎使用Hello MUI', 'Hello MUI');
					var loginButton = doc.getElementById('login');
					var userid = doc.getElementById('userId');
					var pwb = document.getElementById('password');
					loginButton.addEventListener('tap', function(event) {
						//mui.alert(pwb.value, 'Hello MUI');
						  $.ajax({
							type: "POST",
							url: '/xxzx/user/login.do',
			    			data: {id:userid.value,password:pwb.value},
							dataType:'json',
							cache: false,
							success: function(data){
							    //mui.alert('欢迎使用Hello MUI', 'Hello MUI'); 
								 if(data.code == 0){
								    //mui.alert(data.msg, 'Hello MUI'); 
									$.openWindow({
										url: '/xxzx/menu/showMenu.do?id='+data.msg,
										id: 'main',
										preload: true,
										show: {
											aniShow: 'pop-in'
										},
										styles: {
											popGesture: 'hide'
										},
										waiting: {
											autoShow: false
										}
									});
								
								} else if(data.code == 1){
									mui.alert(data.msg, 'Hello MUI');
								}
							},
							error:function(data){
								mobile_alert(2);
						 	}
						});
					}); 
			}(mui, document));
		</script>
	</body>

</html>