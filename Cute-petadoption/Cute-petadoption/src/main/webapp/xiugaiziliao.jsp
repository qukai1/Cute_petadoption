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
 <form action="UpdateZiLiaoServlet" method="post"  enctype="multipart/form-data">
		<table border="1px" style="width:400px;height:450px;border-spacing: inherit;margin-left:20px">
			<tr>
				<td>请输入名称：<input type="text" name="pute_name" value="${pute_put.pute_name}"></td>
				<td>请选择性别：<select name="pute_sex" >
					<option value="公">公</option>
					<option value="母">母</option>
				</select></td>
			</tr>
			<tr>
				<td>年龄：<input type="text" name="pute_age" value="${pute_put.pute_age}">岁</td>
				<td>请选择类型<select name="pute_type">
					<option value="宠物狗类">宠物狗类</option>
					<option value="宠物猫类">宠物猫类</option>
				</select></td>
			</tr>
			<tr>
				<td>请输入备注：<input type="text" name="pute_text" value="${pute_put.pute_text}"></td>
				<td>请输入地区：<input type="text" name="pute_address" value="${pute_put.pute_address}"></td>
			</tr>
			<tr>
				<td colspan="2">更换图片<input type="file" name="pute_url" ><input type="text" name="hidden_id" value="${pute_put.id}" style="display:none;"></td>
			</tr>
			<tr><td colspan="2" style="text-align: center;"><input type="submit" value="提交" onclick="colos()">&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"></td></tr>
		</table>
		</form>
 </table>
</body>
</html>