package com.pute.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pute.Dao.Index_servlet_List;

/**
 * 网站首页加载
 */
@WebServlet("/ShowAll_index")
public class ShowAll_index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取系统团队领养推荐数据
		try {
			//执行所有团队宠物人数统计写入方法
			Index_servlet_List.countNumTeam();
			request.setAttribute("SystemList",new Index_servlet_List().SystemList());
			System.out.println("推荐领养猫咪数量为"+new Index_servlet_List().SystemList().size());
			//获取个人领养推荐数据
			request.setAttribute("IntList",new Index_servlet_List().IntList());
			System.out.println(" 个人推荐领养猫咪数量为"+new Index_servlet_List().IntList().size());
			//获取管理员系统推荐数据
			request.setAttribute("AdminList",new Index_servlet_List().AdminList());
			System.out.println("系统管理员推荐领养猫咪数量为"+new Index_servlet_List().AdminList().size());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
