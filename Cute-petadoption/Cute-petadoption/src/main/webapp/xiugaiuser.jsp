<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改资料</title>
</head>
<body>
 <table>
 <form action="UpdateUserZiliao" method="post"  enctype="multipart/form-data">
		<table border="1px" style="width:400px;height:450px;border-spacing: inherit;margin-left:20px">
			<tr>
				<td>名称：<input type="text" name="user_name" value="${user.name}"></td>
				<td>密码：<input type="text" name="user_pwd" value="${user.pwd}"></td>
			</tr>
			<tr>
				<td colspan="2">个性签名：<input type="text" name="user_text" value="${user.text}"></td>
			</tr>
			<tr>
				<td>手机：<input type="text" name="user_phone" value="${user.phone}">岁</td>
				<td>地区：<input type="text" name="user_address" value="${user.address}"></td>
			</tr>
			<tr>
				<td colspan="2">更换图片<input type="file" name="pute_url" ><input type="text" name="hidden_id" value="${user.id}" style="display:none;"></td>
			</tr>
			<tr><td colspan="2" style="text-align: center;"><input type="submit" value="确认修改" onclick="colos()">&nbsp;&nbsp;&nbsp;<input type="reset" value="取消修改" onclick="javascript:history.back()"></td></tr>
		</table>
		</form>
 </table>
</body>
</html>