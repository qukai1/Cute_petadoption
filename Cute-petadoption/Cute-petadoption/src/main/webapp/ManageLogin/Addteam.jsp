<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增团队</title>
</head>
<body>
<form action="Addteam">
<p>
团队名称：
<input type="text" name="team_name">
</p>
<p>
注册时间：
<input type="text" name="team_date">
</p>
<p>
团队地址：
<input type="text" name="team_address">
</p>
<p>
团队留言：
<input type="text" name="team_text">
</p>
<p>
团队电话：
<input type="text" name="team_phone">
</p>
<p>
<input type="submit" value="添加">
<input type="reset" value="重置">
</p>
</form>
</body>
</html>