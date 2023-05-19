package com.pute.ZSGpute;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pute.Dao.BaDao;
import com.pute.Dao.puteDao;

/**
 * Servlet implementation class delUser
 */
@WebServlet("/delUser")
public class delUser extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println("删除用户的id是"+id);
		//执行删除用户操作
		try {
			//执行用户所属宠物的删除
			BaDao.deletePute(id);
			//执行删除用户操作
			if (BaDao.deleUserid(id)) {
				//开启外键检查
				puteDao.statarPrk();
				response.sendRedirect("tuichu");
			}else {
				response.sendRedirect("User_detailed_information");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
