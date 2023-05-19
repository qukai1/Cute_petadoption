<%@page import="com.pute.Entity.User"%>
<%@page import="com.pute.Entity.lingyang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看领养表</title>
</head>
<script type="text/javascript">
  jujue = function (id) {
	  if (confirm("你确定拒绝该申请嘛！")) {
			//进行批量删除
			document.location="guanlichongwu?id="+id;
		}
}
</script>
<body>
<%
	lingyang l=(lingyang) request.getAttribute("lingyangbiao");
	User u=(User) request.getAttribute("userbiao");
%>
<form action="guanlichongwu" method="post">
		<fieldset style="width:400px;">
			<legend>领养人信息</legend>
			<label >领养人姓名：<%=u.getName() %></label><br>
			<label >领养人年龄：18岁</label><br>
			<label >领养人地址：<%=u.getAddress() %></label><br>
			<label >领养人备注：<%=u.getText() %></label><br>
			<label >领养人联系电话：<%=u.getPhone() %></label><br>
			<label >领养人宠物是：${pute_name}</label><br>
			<input type="text"  value="<%=l.getBiaoid()%>" name="ux" style="display:none;"/>
			<input type="submit" value="同意领养"> <input type="button" value="拒绝领养" onclick="jujue(<%=l.getLingyangid()%>)">
		</fieldset>
		</form>
</body>
</html>