<%@page import="com.pute.Entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<!-- 全域访问 -->
<%
	User u=(User) request.getAttribute("userList");
%>
	<head>
		<meta charset="utf-8">
		<title>个人信息中心</title>
		<script src="js/jquery-3.6.1.min.js"></script>
		<script src="js/切换效果.js"></script>
		<script type="text/javascript" src="js/半部分动态交互.js"></script>
		<link rel="stylesheet" href="css/个人详细页面.css">
			<style type="text/css">
					 a.sli:hover{
				 color: red;
			text-decoration:underline;
			}
		</style>
	</head>
	<body>
	<script type="text/javascript">
	//用户添加宠物
	Liu = function () {
		document.location="UserAddPute_pet.jsp";
	}
	//如果该用户是团队所有人则允许管理团队
	guanliteam_id = function (id) {
		document.location="Team_puteAdmin?id="+id;
	}
	//删除宠物
	delpute = function () {
		//获取所有的子项
		var item=document.getElementsByName("auto");
		//选中的图书数量
		var booknum=0;
		//需要删除的图书id
		var id="";
		for (var i = 0; i < item.length; i++) {
			if (item[i].checked==true) {
				//组成解析字符串
				id+=item[i].value+":";
				booknum++;
			}
		}
		//当用户没有选中一个图书的时候不允许删除！
		if (booknum==0) {
			alert("请您选择要删除的宠物");
		} else{
			if (confirm("您当前选中的宠物数量为"+booknum+"个您确定要删除这些宠物嘛吗！")) {
				//进行批量删除
				document.location="delputeServlet?id="+id+":"+"pute_put";
			}
		}
	}
	
	zhuanchuliyang = function () {
		//获取所有的子项
		var item=document.getElementsByName("auto");
		//选中的图书数量
		var booknum=0;
		//需要删除的图书id
		var id="";
		for (var i = 0; i < item.length; i++) {
			if (item[i].checked==true) {
				//组成解析字符串
				id+=item[i].value+":";
				booknum++;
			}
		}
		//当用户没有选中一个的时候不允许删除！
		if (booknum==0) {
			alert("请您选择要转养的宠物");
		} else{
			if (confirm("您当前选中的宠物数量为"+booknum+"个您确定要转养这些宠物给别人嘛！")) {
				//进行批量删除
				document.location="ZhuanyangServlet?id="+id+":"+"pute_put";
			}
		}
	}
	
	chexiao = function() {
		//获取所有的子项
		var item=document.getElementsByName("auto");
		//选中的图书数量
		var booknum=0;
		//需要删除的图书id
		var id="";
		for (var i = 0; i < item.length; i++) {
			if (item[i].checked==true) {
				//组成解析字符串
				id+=item[i].value+":";
				booknum++;
			}
		}
		//当用户没有选中一个图书的时候不允许删除！
		if (booknum==0) {
			alert("请您选择要撤销的宠物");
		} else{
			if (confirm("您当前选中的宠物数量为"+booknum+"个您确定要撤销吗！")) {
				//进行批量删除
				document.location="UpdateCheServlet?id="+id+":"+"pute_put";
			}
		}
	}
	//用户修改自己的资料
	userXin = function (flg){
		document.location="UpdateZiLiaoServlet?flg="+flg;
	}
	//用户修改猫咪资料
	xiugaiziliao = function () {
		//获取所有的子项
		var item=document.getElementsByName("auto");
		//选中的图书数量
		var booknum=0;
		//需要删除的图书id
		var id="";
		for (var i = 0; i < item.length; i++) {
			if (item[i].checked==true) {
				//组成解析字符串
				id+=item[i].value;
				booknum++;
			}
		}
		//当用户没有选中一个图书的时候不允许删除！
		if (booknum==0) {
			alert("请您选择要修改的宠物");
		} else{
			if (booknum==1) {
					//修改
					document.location="UpdateZiLiaoServlet?id="+id;
			}else{
				alert("请选中一个进行修改");
			}
		}
	}
	//用户注销账号
	logout = function (id) {
		if (confirm("你确定要删除该账号嘛，您所有的信息都将删除包括宠物，此操作将不能撤销")) {
			//删除
			document.location="delUser?id="+id;
		}
	}
	//宠物所属人查看申请
	guanli = function (xinxi) {
		document.location="guanlichongwu?xinxi="+xinxi;
	}
	</script>
		<div id="box">
			<div id="dierhang">
			<!-- 网站logo -->
				<a href="#"><p class="logo_img"><img src="img/logo.jpg" alt="" srcset=""></p></a>
				<div class="user_init">
					<dl style="width:60%;margin:0px auto;">
						<dt style="float: left;width:40%;height:100%;margin-top:5%;">
						<img src="/file/<%=u.getImg() %>" style="width:100%;height:60px;">
						</dt>
						<dd style="float: right;width:58%;height:100%;">
						<!-- 用户个人的图片，名称等信息 -->
						<h3 style="line-height:75px;font-size:15px;"><%=u.getName() %>
						&nbsp;&nbsp;
						<c:if test="${team_admin=='trsue'}">
							<a href="#" onclick="guanliteam_id(<%=u.getId()%>)">管理团队</a>
						</c:if>
						</h3>
						</dd>
					</dl>
				</div>
				<p class="shou_input">
				<input type="text" name="suosi" placeholder="请您输入...." class="text_input" /><input
						type="button" name="" value="已领养宠物" class="btn" 
						style="background-color:#ff0000;border:none;border-radius:0px 5px 5px 0px;color:white;" /><input
						type="button" name="" value="转养宠物"  class="btn"
						style="margin-left:1%;background-color:#ff8b5d;color:white;border-radius: 5px 5px;border:none;" />
				</p>
			</div>
			<!-- bnea菜单栏 -->
			<div class="bean_even">
				<ul>
					<li class="ite1">已领养猫咪</li>
					<li class="ite2">转养猫咪</li>
					<li class="ite3">个人资料</li>
				</ul>
			</div>
			<div style="width:100%;background-color:#edf1f9;overflow: hidden;">
				<div class="body_iutem">
					<div class="body_top">
						<div class="list">
							<table  width="100%" height="100%" >
							<tr>
							<th><input type="checkbox" class="che">全选</th>
							<th>姓名</th>
							<th>性别</th>
							<th>年龄</th>
							<th>类型</th>
							<th>领养时间</th>
							</tr>
							</table>
							</div>
							<div class="shuju_table">
								<!-- 此处如果查询到用户没有领养宠物则替换图片，否则表格显示 -->
										<table class="el" >
											<c:forEach items="${li_pute}" var="l">
											<tr>
												<td><input type="checkbox" class="ulist" name="auto" value="${l.id}"></td>
												<td>&nbsp;&nbsp;&nbsp;${l.pute_name}</td>
												<td>${l.pute_sex}</td>
												<td>${l.pute_age}岁</td>
												<td>${l.pute_type}</td>
												<td>${l.pute_date}</td>
											</tr>
												</c:forEach>
										</table>
										<input type="submit" value="删除宠物" onclick="delpute()" class="but lists" style="margin-left:28%;"> <input type="button" value="修改资料" onclick="xiugaiziliao()" class="but lists"> <input type="button" value="转出领养" onclick="zhuanchuliyang()" class="but lists"> 
							</div>
					</div>
					<div class="body_center">
						<div class="list">
							<table  width="100%" height="100%" >
							<tr>
							<th><input type="checkbox" class="che">全选</th>
							<th>姓名</th>
							<th>性别</th>
							<th>年龄</th>
							<th>类型</th>
							<th>转养时间</th>
							</tr>
							</table>
							</div>
							<div class="shuju_table">
								<!-- 此处如果查询到用户没有领养宠物则替换图片，否则表格显示 -->
										<table class="el" >
											<c:forEach items="${Zhuan_pute}" var="p">
											<c:if test="${p.pute_iux==0}">
											<tr>
												<td><input type="checkbox" class="ulist" name="auto" value="${p.id}"></td>
												<td>&nbsp;&nbsp;&nbsp;${p.pute_name}</td>
												<td>${p.pute_sex}</td>
												<td>${p.pute_age}岁</td>
												<td>${p.pute_type}</td>
												<td>${p.pute_date}</td>
												<td>暂时无人领养</td>
											</tr>
											</c:if>
											<c:if test="${p.pute_iux!=0}">
											<tr>
												<td><input type="checkbox" class="ulist" name="auto" value="${p.id}"></td>
												<td>&nbsp;&nbsp;&nbsp;${p.pute_name}</td>
												<td>${p.pute_sex}</td>
												<td>${p.pute_age}岁</td>
												<td>${p.pute_type}</td>
												<td>${p.pute_date}</td>
												<td><input type="button" value="查看申请" onclick="guanli(${p.id}+':'+${p.pute_iux})" class="but lists"></td>
											</tr>
											</c:if>
												</c:forEach>
										</table>
										<input type="submit" value="删除宠物" onclick="delpute()" class="but lists" style="margin-left:35%;"> <input type="button" value="添加宠物" onclick="Liu()" class="but lists"> <input type="button" value="撤销转养" onclick="chexiao()" class="but lists">  
							</div>
					</div>
					<div class="body_buttom">
						<dl class="dlist" >
							<dt><img src="/file/<%=u.getImg() %>" alt="" srcset="" style="height:500px;"></dt>
							<dd>
								<h1>个人资料信息</h1>
								<table>
									<tr >
										<td>姓名：【<%=u.getName() %>】</td>
										<td>密码：【<%=u.getPwd()%>】</td>
									</tr>
									<tr>
										<td>：</td>
										<td>备注：【<%=u.getText() %>】</td>
									</tr>
									<tr>
										<td>联系方式：【<%=u.getPhone() %>】</td>
										<td>地区：【<%=u.getAddress() %>】</td>
									</tr>
								</table>
								<input type="submit" value="修改信息" class="but"  onclick="userXin(<%=u.getId() %>)" style="margin-left:44px;"> <input type="button" value="注销账号" onclick="logout(<%=u.getId() %>)" class="but"> <input type="button" value="返回首页"  onclick="red()" class="but"> 
							</dd>
						</dl>
					</div>
				</div>
			</div>
			<div style="height:50px;background-color:#edf1f9;">
				
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
					<p style="display:none;"></p>
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