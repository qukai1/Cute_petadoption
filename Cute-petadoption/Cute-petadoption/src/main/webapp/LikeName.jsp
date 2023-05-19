<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>宠物领养平台</title>
		<script src="js/jquery-3.6.1.min.js"></script>
		<script type="text/javascript" src="js/半部分动态交互.js"></script>
		<link rel="stylesheet" type="text/css" href="css/likeName.css"/>
		<style type="text/css">
					 a.sli:hover{
				 color: red;
			text-decoration:underline;
			}
		</style>
		<script type="text/javascript">
		
		</script>
	</head>
	<body>
	<% 
	  pageContext.setAttribute("name",session.getAttribute("pute-name"));
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
				<ul class="meve_index">
					<li><a href="ShowAll_index">领养中心</a></li>
					<li><a href="">团队博客</a></li>
					<li><a href="">宠物知识</a></li>
					<li><a href="Allteam">团队展示</a></li>
					<li><a href="#" onclick="Addpute_team()">发布领养</a></li>
					<li><a href="AddPute">申请成为志愿者</a></li>
				</ul>
				<form action="puteLikeName" method="post">
				<p class="shou_input">
				<input type="text" name="suosi" placeholder="请您输入...." class="text_input" /><input
						type="submit" name="" value="搜索" class="btn" 
						style="background-color:#ff0000;border:none;border-radius:0px 5px 5px 0px;color:white;" /><input
						type="button" name="" value="全网查找" onclick="baidu()" class="btn"
						style="margin-left:1%;background-color:#ff8b5d;color:white;border-radius: 5px 5px;border:none;" />
				</p>
				</form>
			</div>
			<!-- 内容模块 -->
			<div class="body_item">
				<!-- 个人发布的领养宠物模块 -->
				<div class="personal_nt">
					<!-- 个人零领养宠物模块 -->
					<!-- 进行判断 -->
					<h2 class="meven_et"><span class="LI"></span>
					<c:if test="${likePute.size()==20}">
					<span class="LII">系统推荐<span>暂无结果系统为您推荐</span></span>
					</c:if>
					<c:if test="${likePute.size()!=20}">
					<span class="LII">搜索结果<span>数据来自平台</span></span>
					</c:if>
					</h2>
					<div class="seller_nt">
						<div class="seller_nt_left_1">
							<span class="seller_text_nt_left">
								<h2>个人转养</h2>
									查看更多
							</span>
						</div>
						<div class="seller_nt_right">
							<c:forEach var="l" items="${likePute}">
							<dl>
								<a href="#" onclick="admin_detalis(${l.id})">
								<dt><img src="/file/${l.pute_img}"></dt>
								<dd><span class="text_moyent">
								<!-- 宠物名称 --> 
								${l.pute_name}
								</span>
								<span class="text_GPS">
								<!-- 宠物地址 -->
								${l.pute_address}
								</span>
								</dd>
								<dd class="dd_text">
								<!-- 宠物描述 -->
								${l.pute_text}
								</dd>
								</a>
							</dl>
							</c:forEach>
								
						</div>
				</div>
				
			</div>
			<div style="height:50px;background-color: #ebebeb;">
				
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
