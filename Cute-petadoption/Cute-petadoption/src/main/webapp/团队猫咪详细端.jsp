<%@page import="com.pute.Entity.team_pute"%>
<%@page import="com.pute.Entity.pute_team"%>
<%@page import="com.pute.Entity.admin_pute"%>
<%@page import="com.pute.Entity.User"%>
<%@page import="com.pute.Entity.pute_Entily"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>团队转养猫咪详细</title>
		<script src="js/jquery-3.6.1.min.js"></script>
		<script src="js/切换效果.js"></script>
		<script type="text/javascript" src="js/半部分动态交互.js"></script>
		<link rel="stylesheet" href="css/个人猫咪详细.css">
			<style type="text/css">
					 a.sli:hover{
				 color: red;
			text-decoration:underline;
			}
		</style>
	</head>
	<body>
	<script type="text/javascript">
	window.onload = function(){
		if (document.getElementById("xinxi").value!="") {
			alert(document.getElementById("xinxi").value);
		}
	}
		lingyang = function (id) {
			var suoshuid=document.getElementById("suishuid").value;
			if (confirm("你确定要领养该宠物嘛！")) {
				document.location="lingyangServlet?iduser="+id+":"+suoshuid;
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
	  //脚本处理
		<% 
	  pageContext.setAttribute("name",session.getAttribute("pute-name"));
	  team_pute te=(team_pute)request.getAttribute("pute_Entliy");
	  pute_team pt=(pute_team)request.getAttribute("Team");
	  User u=(User)request.getAttribute("user");
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
					<h3 style="text-align: center;line-height:70px;">团队宠物详细资料</h3>
				</div>
				<p class="shou_input">
				<input type="text" name="suosi" placeholder="请您输入...." class="text_input" /><input
						type="button" name="" value="搜索" class="btn" 
						style="background-color:#ff0000;border:none;border-radius:0px 5px 5px 0px;color:white;" /><input
						type="button" name="" value="全网查找"  onclick="baidu()" class="btn"
						style="margin-left:1%;background-color:#ff8b5d;color:white;border-radius: 5px 5px;border:none;" />
				</p>
			</div>
			<!-- bnea菜单栏 -->
			<div class="bean_even">
				<ul>
					<li class="ite1">猫咪详细</li>
					<li class="ite2">查看团队</li>
					<li class="ite3">团队留言</li>
				</ul>
			</div>
			<div class="body_iutem">
				<div class="body_top">
					<dl class="dlist">
						<dt><img src="/file/<%=te.getTeam_imgw() %>" alt="" srcset=""></dt>
						<dd>
							<h1>猫咪档案</h1>
							<table>
								<tr >
									<td>姓名：<%=te.getTeam_name() %></td>
									<td>年龄：<%=te.getTeam_age() %></td>
								</tr>
								<tr>
									<td>类别：<%=te.getTeam_type() %></td>
									<td>性别：<%=te.getTeam_sex()%></td>
								</tr>
								<tr>
									<td>转养时间：<%=te.getTeam_date() %></td>
									<td>地区：<%=te.getTeam_address() %></td>
								</tr>
							</table> 
							<c:if test="${ski==null}"><input type="submit" value="申请领养" class="but" onclick="lingyang(<%=te.getTeamid()%>)" style="margin-left:44px;"></c:if> <input type="button" value="返回首页" class="but" onclick="zhuye()" style="margin-left:14px"> 
						</dd>
					</dl>
				</div>
				<input type="text"  value="${ski}" id="xinxi" style="display:none;"/>
				<div class="body_center">
					<dl class="dlist">
						<dt><img src="/file/<%=pt.getTeam_img() %>" alt="" srcset=""></dt>
						<dd>
						<input type="text" id="suishuid" value="<%=pt.getTeam_id()%>" style="display:none;"/>
							<h1>宠物团队信息</h1>
							<table>
								<tr >
									<td>团队名称：<%=pt.getTeam_name() %></td>
									<td>团队性质：<%=pt.getTeam_text() %></td>
								</tr>
								<tr>
									<td>团队人数：200人</td>
									<td>是否允许加入：允许</td>
								</tr>
								<tr>
									<td>联系方式：<%=pt.getTeam_phone()%></td>
									<td>地区：<%=pt.getTeam_address() %></td>
								</tr>
							</table>
							<input type="submit" value="申请加入" class="but" style="margin-left:44px;"> <input type="button" onclick="lianxi()" value="联系团队" class="but"> 
						</dd>
					</dl>
				</div>
				
				<div class="body_buttom">
					<dl class="dlist">
						<dt><img src="/file/<%=pt.getTeam_img() %>" alt="" srcset=""></dt>
						<dd>
							<h1>给宠物团队留言</h1>
							<textarea name="" id="" cols="30" rows="10"  class="text">
								请您留言
							</textarea>
							<input type="submit" value="提交留言"  onclick="tijiaoliuyan()" class="but" style="margin-left:44px;"> <input type="reset" value="清空留言" class="but"> <input type="button" value="返回首页" class="but"> 
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