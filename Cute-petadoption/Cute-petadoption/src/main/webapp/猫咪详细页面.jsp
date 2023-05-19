<%@page import="com.pute.Entity.admin_pute"%>
<%@page import="com.pute.Entity.User"%>
<%@page import="com.pute.Entity.pute_Entily"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 管理员发布的流浪猫信息与个人转养猫公用一个猫咪详细页面 -->
<html>
	<head>
		<meta charset="utf-8">
		<title>个人转养猫咪详细</title>
		<script src="js/jquery-3.6.1.min.js"></script>
		<script type="text/javascript" src="js/半部分动态交互.js"></script>
		<script src="js/切换效果.js"></script>
		<link rel="stylesheet" href="css/个人猫咪详细.css">
			<style type="text/css">
					 a.sli:hover{
				 color: red;
			text-decoration:underline;
			}
		</style>
		<script type="text/javascript">
		//检测内容
		window.onload = function(){
			if (document.getElementById("xinxi").value!="") {
				alert(document.getElementById("xinxi").value);
			}
		}
		//领养宠物
		lingyang = function (id) {
			var suoshuid=document.getElementById("suishuid").value;
			if (confirm("你确定要领养该宠物嘛！")) {
				document.location="Admin_puteLingyang?iduser="+id+":"+suoshuid;
			}
		}
		lianxi = function () {
			alert("联系QQ:3326133613");
		}
		zhuye = function () {
			document.location="ShowAll_index";
		}
		tijiaoliuyan = function (){
			alert("留言成功！");
			location.reload();
			}
		</script>
	</head>
	
	<body>
	<% 
	//脚本处理
	pute_Entily Pe=new pute_Entily();
	User u=(User)request.getAttribute("user");
	  pageContext.setAttribute("name",session.getAttribute("pute-name"));
	  if(request.getAttribute("pute")=="pute"){
		  System.out.println("1");
		  pageContext.setAttribute("pute","pute");
		  Pe=(pute_Entily)request.getAttribute("pute_Entliy");
	  }else{
		  System.out.println("2");
		  pageContext.setAttribute("pute",null);
	  }
	  pageContext.setAttribute("Pe",Pe);
	  System.out.println(Pe.getPute_name());
	  System.out.println(request.getAttribute("pute"));
	  System.out.println(u.getName());
	%>
		<div id="box">
			<div id="diyihang">
				<div class="comt">
					<P class="p_text">欢迎来到易领平台！</P>
					<ul class="logo_user">
						<li class="li_hover">
							<!-- 从此处用户展示用户登录状态，首次加载首页如果session中没有用户登录信息则提示用户进行登录注册，有就加载用户ID  -->
							<c:if test="${name!=null}">
							   <a href="#" onclick="tui()">退出！</a>
							</c:if>
							<c:if test="${name==null}">
							   <a href="loginandregistration.jsp">登录注册</a>
							</c:if>
						</li>
					</ul>
					<!-- 此处展示登录用户的name -->
					<span class="sp"><!-- 从此处用户展示用户登录状态，首次加载首页如果session中没有用户登录信息则提示用户进行登录注册，有就加载用户ID  -->
							<c:if test="${name!=null}">
							   <a href="#"  onclick="elname('${name}')" style="color:orange;" class="sli">欢迎${name}</a>登录成功！
							</c:if>
					<!-- 用户个人领养的宠物信息 -->
						<a href="#" onclick="elname('${name}')" class="sli">我的宠物信息</a>
						<a href="#" class="sli">领养社区</a>
						<a href="#" class="sli">请求帮助</a>
						<a href="#" class="sli">意见反馈</a>
					</span>
				</div>
			</div>
			<div id="dierhang">
			<!-- 网站logo -->
				<a href="#"><p class="logo_img"></p></a>
				<div class="user_init">
					<h3 style="text-align: center;line-height:70px;">个人宠物详细资料</h3>
				</div>
				<p class="shou_input">
				<input type="text" name="suosi" placeholder="请您输入...." class="text_input" /><input
						type="button" name="" value="搜索" class="btn" 
						style="background-color:#ff0000;border:none;border-radius:0px 5px 5px 0px;color:white;" /><input
						type="button" name="" value="全网查找" onclick="baidu()" class="btn"
						style="margin-left:1%;background-color:#ff8b5d;color:white;border-radius: 5px 5px;border:none;" />
				</p>
			</div>
			<!-- bnea菜单栏 -->
			<div class="bean_even">
				<ul>
					<li class="ite1">猫咪详细</li>
					<li class="ite2">查看个人</li>
					<li class="ite3">个人留言</li>
				</ul>
			</div>
			<div class="body_iutem">
				<div class="body_top">
					<dl class="dlist">
					<c:if test="${pute=='pute'}">
						<dt><img src="/file/<%=Pe.getPute_img()%>" alt="" srcset=""></dt>
						<dd>
							<h1>猫咪档案</h1>
								<table>
								<tr >
									<td>姓名：<%=Pe.getPute_name()%></td>
									<td>年龄：<%=Pe.getPute_age() %></td>
								</tr>
								<tr>
									<td>类别：<%=Pe.getPute_type() %></td>
									<td>性别：<%=Pe.getPute_sex() %></td>
								</tr>
								<tr>
									<td>转养时间：<%=Pe.getPute_date() %></td>
									<td>地区：<%=Pe.getPute_address() %></td>
								</tr>
							</table>
							<c:if test="${ski==null}"><input type="submit" value="申请领养" onclick="lingyang(<%=Pe.getId()%>)" class="but" style="margin-left:44px;"></c:if>  <input type="button" value="返回首页" onclick="zhuye()" class="but" style="margin-left:14px;"> 
							</dd>
							</c:if>
					</dl>
				</div>
				<input type="text"  value="${ski}" id="xinxi" style="display:none;"/>
				<div class="body_center">
					<dl class="dlist">
						<dt><img src="/file/<%=u.getImg() %>" alt="" srcset=""></dt>
						<dd>
							<h1>宠物主人信息</h1>
							<input type="text" id="suishuid" value="<%=u.getId() %>" style="display:none;"/>
							<table>
								<tr >
									<td>姓名:<%=u.getName() %></td>
									<td>年龄：18</td>
								</tr>
								<tr>
									<td>领养宠物注意事项：好好对他</td>
									<td>备注：<%=u.getText() %></td>
								</tr>
								<tr>
									<td>联系方式：<%=u.getPhone() %></td>
									<td>地区：<%=u.getAddress() %></td>
								</tr>
							</table>
							<input type="button" value="联系个人" onclick="lianxi()" class="but" style="margin-left:44px;"> <input type="button" value="返回首页" class="but" onclick="zhuye()"> 
						</dd>
					</dl>
				</div>
				<div class="body_buttom">
					<dl class="dlist">
						<dt><img src="/file/<%=u.getImg() %>" alt="" srcset=""></dt>
						<dd>
							<h1>给宠物主人留言</h1>
							<textarea name="" id="" cols="30" rows="10"  class="text">
								请您留言
							</textarea>
							<input type="button"  onclick="tijiaoliuyan()" value="提交留言" class="but" style="margin-left:54px;"> <input type="reset" value="清空留言" class="but">  
						</dd>
					</dl>
				</div>
			</div>
			<div id="disihang">
				<div class="buo_top">
					<div id="disihang1">
						<dl class="copy_dl">
							<dt>热门链接</dt>
							<dd><a href="#">比特犬</a></dd>
							<dd><a href="#">泰迪</a></dd>
							<dd><a href="#">犬类</a></dd>
							<dd><a href="#">猫类</a></dd>
							<dd><a href="#">体验中心</a></dd>
							<dd><a href="#">常见问题</a></dd>
						</dl>
					</div>
					<div id="disihang2">
						<dl class="copy_dl">
							<dt>自由选择</dt>
							<dd><a href="#">宠物百科</a></dd>
							<dd><a href="#">领养猫咪</a></dd>
							<dd><a href="#">领养狗狗</a></dd>
							<dd><a href="#">寄养宠物</a></dd>
							<dd><a href="#">发布信息</a></dd>
							<dd><a href="#">服务保障</a></dd>
						</dl>
					</div>
					<div id="disihang3">
						<dl class="copy_dl">
							<dt>服务支持</dt>
							<dd><a href="#">服务首页</a></dd>
							<dd><a href="#">服务网点查询</a></dd>
							<dd><a href="#">联系客服</a></dd>
							<dd><a href="#">服务政策</a></dd>
							<dd><a href="#">预约地点</a></dd>
							<dd><a href="#">宠物百科</a></dd>
						</dl>
					</div>
					<div id="disihang4">
						<dl class="copy_dl">
							<dt>宠物社区社区</dt>
							<dd><a href="#">社区首页</a></dd>
							<dd><a href="#">摄影专区</a></dd>
							<dd><a href="#">微博</a></dd>
							<dd><a href="#">贴吧</a></dd>
							<dd><a href="#">兴趣部落</a></dd>
			
						</dl>
					</div>
					<div id="disihang5">
						<dl class="copy_dl">
							<dt>关于起航</dt>
							<dd><a href="#">起航简介</a></dd>
							<dd><a href="#">工作机会</a></dd>
							<dd><a href="#">新闻咨询</a></dd>
							<dd><a href="#">启动平台</a></dd>
							<dd><a href="#">开发者平台</a></dd>
			
						</dl>
					</div>
					<div id="disihang6">
						<h2>联系我们</h2>
						<p class="weixin_img"></p>
					</div>
				</div>
				<div class="buo_but">
					<hr style="width:90%;margin: 0px auto;color: white;size:0.5px;" />
					<h5 class="div_copy">&copy;2010-2023京沪IP | 互联网药品信息服务资格证书（京）-经营性-2017-0020  | 医疗器械网络交易服务第三方平台备案：<br />（京）网械平台备字（2020） | 第00002号
						京ICP证030173号  京公网安备11000002000001号</h5>
				</div>
			</div>
			</div>
	</body>
</html>