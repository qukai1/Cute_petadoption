package com.pute.ZSGpute;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pute.Dao.Addpute;
import com.pute.Entity.User;
import com.pute.Entity.pute_Entily;
import com.pute.Fileimg.FileimgNew;

/**
 * Servlet implementation class UpdateUserZiliao
 */
@WebServlet("/UpdateUserZiliao")
public class UpdateUserZiliao extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User pe=new User();
		//处理上传图片
		try {
			FileimgNew imgN=new FileimgNew();
			String[] strValue=imgN.ChuliImg(request);
			pe.setId(Integer.parseInt(strValue[5]));
			pe.setName(strValue[0]);
			pe.setPwd(strValue[1]);
			pe.setText(strValue[2]);
			pe.setPhone(strValue[3]);
			pe.setAddress(strValue[4]);
			pe.setImg(imgN.getUrl());
			System.out.println("用户添加的访问路径是："+imgN.getUrl());
			System.out.println("更新的用户表id是"+strValue[5]);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//执行sql
		try {
			if (new Addpute().Updatepute_User(pe)) {
				System.out.println("更改成功");
				response.sendRedirect("loginandregistration.jsp");
			}else {
				System.out.println("更改失败");
				response.sendRedirect("User_detailed_information");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
