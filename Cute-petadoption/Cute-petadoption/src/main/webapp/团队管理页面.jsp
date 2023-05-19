<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.pute.Entity.team_pute"%>
<%@page import="com.pute.Entity.pute_team"%>
<%@page import="com.pute.Entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<!-- 全域访问 -->
<%
String name=(String)session.getAttribute("pute-name");
pute_team te=(pute_team)request.getAttribute("pute_team");
//List<team_pute> teams_pute=(ArrayList<team_pute>)request.getAttribute("team_pute");
%>
	<head>
		<meta charset="utf-8">
		<title>团队管理中心</title>
		<script src="js/jquery-3.6.1.min.js"></script>
		<script src="js/切换效果.js"></script>
		<script type="text/javascript" src="js/半部分动态交互.js"></script>
		<link rel="stylesheet" href="css/个人详细页面.css">
	</head>
	<body>
	<script type="text/javascript">
	//注销账号
	
	deleteTeam = function (id) {
		if (confirm("你确定要注销该团队嘛，此操作将不会被撤销！")) {
			document.location.href="DeleteTeam?id="+id
		}
	}
	
	//修改账户资料
	UpdateTeam= function(id) {
		document.location.href="Team_update?id="+id
	}
	
	//修改宠物资料
	Pet_update = function() {
		//获取所有的子项
		var item=document.getElementsByName("auto");
		var booknum=0;
		var id="";
		for (var i = 0; i < item.length; i++) {
			if (item[i].checked==true) {
				//组成解析字符串
				id+=item[i].value;
				booknum++;
			}
		}
		if (booknum==1) {
			//进行团队宠物资料修改
			document.location="Team_puteUpdateServlet?id="+id;
		}else{
			alert("请选择一个宠物进行修改")
		}
	}
	
	//删除宠物
	delpute = function () {
		//获取所有的子项
		var item=document.getElementsByName("auto");
		var booknum=0;
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
				document.location="delputeServlet?id="+id+":"+"team_pute";
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
				//进行批量转养
				document.location="ZhuanyangServlet?id="+id+":"+"team_pute";
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
				document.location="UpdateCheServlet?id="+id+":"+"team_pute";
			}
		}
	}
	
	//宠物所属人查看申请
	guanli = function (xinxi) {
		document.location="guanlichongwu?xinxi="+xinxi+":"+"team";
	}
	</script>
		<div id="box">
			<div id="dierhang">
			<!-- 网站logo -->
				<a href="#"><p class="logo_img"><img src="img/logo.jpg" alt="" srcset=""></p></a>
				<div class="user_init">
					<dl style="width:60%;margin:0px auto;">
						<dt style="float: left;width:40%;height:100%;"><img src="/file/<%=te.getTeam_img() %>" style="width:100%;height:70%;"></dt>
						<dd style="float: right;width:58%;height:100%;">
						<!-- 用户个人的图片，名称等信息 -->
						<h3 style="line-height:75px;"><%=te.getTeam_name() %></h3>
						</dd>
					</dl>
				</div>
				<p class="shou_input">
				<input type="text" name="suosi" placeholder="请您输入...." class="text_input" /><input
						type="button" name="" value="已领养宠物" class="btn" 
						style="background-color:#ff0000;border:none;border-radius:0px 5px 5px 0px;color:white;" /><input
						type="button" name="" value="转养宠物" class="btn"
						style="margin-left:1%;background-color:#ff8b5d;color:white;border-radius: 5px 5px;border:none;" />
				</p>
			</div>
			<!-- bnea菜单栏 -->
			<div class="bean_even">
				<ul>
					<li class="ite1">团队猫咪</li>
					<li class="ite2">团队管理</li>
					<li class="ite3">团队资料</li>
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
							<th>领养状态</th>
							</tr>
							</table>
							</div>
							<div class="shuju_table">
								<!-- 此处如果查询到用户没有领养宠物则替换图片，否则表格显示 -->
										
										<table class="el" >
											<c:forEach items="${team_pute}" var="p">
											<!-- 该宠物处于未转养状态 -->
											<c:if test="${p.team_ski==0}">
											<tr>
											<c:if test="${p.team_iux==0}">
												<td><input type="checkbox" class="ulist" name="auto" value="${p.teamid}"></td>
												<td>&nbsp;&nbsp;&nbsp;${p.team_name}</td>
												<td>${p.team_sex}</td>
												<td>${p.team_age}岁</td>
												<td>${p.team_type}</td>
												<td>${p.team_date}</td>
												<td>未转养</td>
												</c:if>
												<c:if test="${p.team_iux!=0}">
												<td><input type="checkbox" class="ulist" name="auto" value="${p.teamid}"></td>
												<td>&nbsp;&nbsp;&nbsp;${p.team_name}</td>
												<td>${p.team_sex}</td>
												<td>${p.team_age}1岁</td>
												<td>${p.team_type}</td>
												<td>${p.team_date}</td>
												<td>未转养</td>											
												</c:if>
											</tr>
											</c:if>
											<!-- 该宠物处于转养状态 -->
											<c:if test="${p.team_ski==1}">
											<tr style="background-color:aqua;">
											<c:if test="${p.team_iux==0}">
												<td><input type="checkbox" class="ulist" name="auto" value="${p.teamid}"></td>
												<td>&nbsp;&nbsp;&nbsp;${p.team_name}</td>
												<td>${p.team_sex}</td>
												<td>${p.team_age}岁</td>
												<td>${p.team_type}</td>
												<td>${p.team_date}</td>
												<td>暂时无人领养</td>
												</c:if>
												<c:if test="${p.team_iux!=0}">
												<td><input type="checkbox" class="ulist" name="auto" value="${p.teamid}"></td>
												<td>&nbsp;&nbsp;&nbsp;${p.team_name}</td>
												<td>${p.team_sex}</td>
												<td>${p.team_age}1岁</td>
												<td>${p.team_type}</td>
												<td>${p.team_date}</td>
												<td><input type="button" value="查看申请" onclick="guanli(${p.teamid}+':'+${p.team_iux})" class="but lists"></td>
											</c:if>
											</tr>
											</c:if>
												</c:forEach>
										</table>
										<input type="submit" value="删除宠物" onclick="delpute()" class="but lists" style="margin-left:28%;"> <input type="button" value="修改资料" onclick="Pet_update()" class="but lists"> <input type="button" value="转出领养" onclick="zhuanchuliyang()" class="but lists"> <input type="button" value="撤销转养" onclick="chexiao()" class="but lists"> 
							</div>
					</div>
					<div class="body_center">
						<div class="list">
								<div class="list_left">
									管理功能区域>>>>
								</div>
								<div class="list_right">
									<input type="button" value="删除选中成员" class="buti" style="margin-left:20px;"/>
									<input type="button" value="添加团队管理员" class="buti"/>
									<input type="button" value="添加成员" class="buti"/>
									<input type="button" value="更改成员信息" class="buti"/>
									<input type="button" value="申请管理" class="buti"/>
								</div>
							</div>
							<div class="shuju_table">
									
										<table class="el" >
											<c:forEach items="${chengyuan}" var="z">
											<tr>
												<td><input type="checkbox" class="ulist" name="auto" value="${z.id}"></td>
												<td>&nbsp;&nbsp;&nbsp;${z.name}</td>
												<td>${z.sex}</td>
												<td>${z.age}岁</td>
												<td>${z.address}</td>
												<td>${z.phone}</td>
											</tr>
												</c:forEach>
										</table>
							</div>
					</div>
					<div class="body_buttom">
						<dl class="dlist" >
							<dt><img src="/file/<%=te.getTeam_img()%>" alt="" srcset=""></dt>
							<dd>
								<h1>团队资料信息</h1>
								<table>
									<tr >
										<td>团队名称：<%=te.getTeam_name() %></td>
										<td>团队所属人：<%=name%></td>
									</tr>
									<tr>
										<td>团队总人数：200人</td>
										<td>备注：<%=te.getTeam_text() %></td>
									</tr>
									<tr>
										<td>联系方式：<%=te.getTeam_phone() %></td>
										<td>地区：<%=te.getTeam_address() %></td>
									</tr>
								</table>
								<input type="submit" value="修改信息" class="but" style="margin-left:44px;" onclick="UpdateTeam(<%= te.getTeam_id()%>)"> <input type="button" value="注销账号" class="but" onclick="deleteTeam(<%= te.getTeam_id()%>)"> <input type="button" value="返回首页" class="but" onclick="javascript:location.href='ShowAll_index'"> 
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