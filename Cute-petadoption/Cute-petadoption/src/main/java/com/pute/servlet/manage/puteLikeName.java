package com.pute.servlet.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pute.Dao.puteDao;
import com.pute.Entity.pute_Entily;

/**
 * Servlet implementation class puteLikeName
 */
@WebServlet("/puteLikeName")
public class puteLikeName extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("suosi");
		System.out.println("查询的内容是："+name);
		//执行模糊查询
		try {
			//如果用户输入不正确或者查询为空则显示系统默认推荐宠物
			List<pute_Entily> Like=new puteDao().LikeNamePute(name);
			if (Like.size()!=0) {
				System.out.println("查询结果为"+Like.size());
				request.setAttribute("likePute",Like);
				request.getRequestDispatcher("LikeName.jsp").forward(request, response);
			} else {
				System.out.println("用户输入为空或者查询返回空");
				request.setAttribute("likePute",new puteDao().LikeNamePutexitong());
				request.getRequestDispatcher("LikeName.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
