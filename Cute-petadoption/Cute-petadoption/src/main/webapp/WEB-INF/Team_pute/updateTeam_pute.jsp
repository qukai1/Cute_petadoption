<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>团队宠物修改资料</title>
</head>
<body>
	<form action="Update_teampute" method="post">
		<p>宠物名称：<input type="text" value="${team_pute.team_name}" name="team_name"></p>
		<p>宠物性别：<select  name="team_sex">
					<option value="公">宠物猫类</option>
					<option value="母">宠物狗类</option>
				   </select>
		</p>
		<p>宠物岁数：<input type="text" value="${team_pute.team_age}" name="team_age"></p>
		<p>宠物类型：<select  name="team_type">
					<option value="宠物猫类">宠物猫类</option>
					<option value="宠物狗类">宠物狗类</option>
				   </select>
		</p>
		<p><input type="text" value="${team_pute.teamid}" style="display:none;" name="teamid"/></p>
		<p><input type="submit"  value="确认修改"/><input type="button"  value="返回"/></p>
	</form>
</body>
</html>