<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>团队登录</title>
		<script src="js/jquery-3.6.1.min.js"></script>
		<style type="text/css">
		*{
			    margin: 0px;
				padding: 0px;
			}
			/* 顶栏设置 */
			body{
				background-image: url("img/01093ebd-2aad-4c65-80c7-02737b9f961a.jpg");
				background-repeat: no-repeat;
				background-size:100% 100%;
			}
			div.navigation{
				width:100%;
				height:50px;
				background-color: white;
				opacity:0.9;
			}
			p.navigation_left{
				float: left;
				height:50px;
				line-height:50px;
				margin-left:5%;
				text-decoration:underline;
			}
			p.navigation_right{
				float: right;
				width:15%;
				height:50px;
				line-height:50px;
			}
			p.navigation_right a{
				margin-right:10%;
			}
			/* 注册登录页设置 */
			div.login_rest{
				background-color:white;
				
				width:500px;
				height:400px;
				border-radius:20px 20px;
				margin:6% auto;
			}
			h3.login_rest_h3{
				text-align: center;
				height:40px;
				line-height: 40px;
			}
			div.login_rest_button{
				width:100%;
				height:50px;
			}
			div.login_rest_button div{
				width:25%;
				height:40px;
				border-radius:20px 20px;
				line-height:40px;
				text-align: center;
				font-size:18px;
				/* 设置光标 */
				cursor:pointer;
			}
			div.button-left{
				margin-left:15%;
				float: left;
				background-color:aquamarine;
			}
			div.button-right{
				margin-right:15%;
				float: right;
			}
			div.login_from,div.login_from2{
				width:100%;
				height:310px;
				border-radius:0px 0px 20px 20px;
			}
			table.login,table.registati{
				float: left;
				width:80%;
				border-collapse: collapse;
				height:93%;
				margin-top:10px;
				margin-left:10%;
				font-size:18px;
				text-align: center;
			}
			input.input_txt{
				width:70%;
				height:30px;
				border:0px;
				border-bottom:1px solid black;
			}
			.btn,.btn_res{
				width:25%;
				height:30px;
				border-width: 0px; /* 边框宽度 */
				border-radius: 3px; /* 边框半径 */
				background: #1E90FF; /* 背景颜色 */
				cursor: pointer; /* 鼠标移入按钮范围时出现手势 */
				outline: none; /* 不显示轮廓线 */
				font-family: Microsoft YaHei; /* 设置字体 */
				color: white; /* 字体颜色 */
				font-size: 17px; /* 字体大小 */
			}
			.btn:hover { /* 鼠标移入按钮范围时改变颜色 */
			background: #5599FF;
			}
			input[type=text]:focus{
				outline:none;
			}
			input[type=password]:focus{
				outline:none;
			}
			/* 版权栏设置 */
			div.copy_qihang{
				width:100%;
				height:40px;
				background-color: white;
				margin-top:8.4%;
				opacity:0.7;
				text-align:center;
				line-height:40px;
			}
			.login_from2{
				display: none;
			}
		</style>
	</head>
	<body>
		<!-- 登录与注册模块切换 -->
		<script type="text/javascript">
			$(function(){
				//错误弹窗提示！
				if ($("#error").val()!="") {
					alert($("#error").val());
				}
				// 设置切换按钮的响应事件
				$(".button-right").click(function(){
					$("body").css("background-image","url('img/注册页面背景.webp')");
					$(this).css("background","aquamarine");
					$(".button-left").css("background-color","white");
					$(".login_from2").css("display","block");
					$(".login_from").css("display","none");
				})
				$(".button-left").click(function(){
					$("body").css("background-image","url('img/注册与登录页面背景bena.webp')");
					$(this).css("background","aquamarine");
					$(".button-right").css("background-color","white");
					$(".login_from").css("display","block");
					$(".login_from2").css("display","none");
				})
				
				//用户输入完整性验证
				$("input[name='login']").click(function(){
					var ok1=false,ok2=false,ok3=false,ok4=false;//验证标记
					//用户输入完整才可以提交否则返回false阻止提交
					if ($("input[name='login-name']").val()!="") {
						ok1=true;
					}
					if ($("input[name='login-pwd']").val()!="") {
						ok2=true;
					}
					if ($("input[name='login-yzm']").val()!="") {
						ok3=true;
					}
					if ($("input[name='login-xzk']").is(":checked")) {
						ok4=true;
					}
					//判断是否全部输入完整
					if (ok1&ok2&ok3&ok4) {
						if ($("input[name='login-yzm']").val()==40) {
							
						} else {
							alert("计算错误，请重新输入！！！");
							return false;
						}
					} else{
					alert("请填写完整！！！");
						return false;
					}
				});
				//用户注册输入完整性验证
				$(".btn_res").click(function(){
					var ok1=false,ok2=false,ok3=false,ok4=false;//验证标记
					//用户输入完整才可以提交否则返回false阻止提交
					if ($("input[name='rest-name']").val()!="") {
						ok1=true;
					}
					if ($("input[name='rest-pwd']").val()!="") {
						ok2=true;
					}
					if ($("input[name='rest-yzm']").val()!="") {
						ok3=true;
					}
					if ($("input[name='rest-xzk']").is(":checked")) {
						ok4=true;
					}
					
					//判断是否全部输入完整
					if (ok1&ok2&ok3&ok4) {
						
					} else{
					alert("请填写完整！！！");
						return false;
					}
				});
			});
		</script>
		<input type="text" value="${error}" style="display:none;" id="error"/>
		<!-- 提示顶栏 -->
		<div class="navigation">
			<p class="navigation_left">欢迎使用启航萌宠领养网，一同帮助流浪动物找到家！</p>
			<p class="navigation_right"><a href="#">了解详细</a><a href="#">遇到问题？</a></p>
		</div>
		<!-- 登录注册模块 -->
		<div class="login_rest">
				<h3 class="login_rest_h3">欢迎使用</h3>
				<div class="login_rest_button">
					<div class="button-left">
						团队管理登录
					</div>
					<div class="button-right">
						团队功能
					</div>
				</div>
				<form action="team" method="post">
				<div class="login_from">
					<table class="login">
						<tr>
							<td><input type="text" class="input_txt" placeholder="请输入登录名....." name="login-name"></td>
						</tr>
						<tr>
							<td><input type="password" class="input_txt" placeholder="请输入登录密码...." name="login-pwd"></td>
						</tr>
						<tr>
							<td><input type="text" class="input_txt" placeholder="请输入20+20的结果" name="login-yzm"></td>
						</tr>
						
						
						<tr>
							<td ><input type="submit" value="确认登录" class="btn" name="login">&nbsp;&nbsp;<input type="reset" value="内容重置" class="btn"></td>
						</tr>
						
						<tr>
						
							<td ><input type="checkbox" name="login-xzk" checked="checked">&nbsp;<a href="#" style="font-size:12px;" >登录确认用户隐私协议</a></td>
					
						</tr>
					</table>
				</div>
				</form>
		
		<!-- 版权 -->
		<div class="copy_qihang">
			<h5>版权著有启航小组所有2022-2023&copy;<a href="#">使用请联系！</a></h5>
		</div>
	</body>
</html>