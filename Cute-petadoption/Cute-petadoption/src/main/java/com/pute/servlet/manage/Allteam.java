package com.pute.servlet.manage;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pute.Dao.puteDao;

/**
 * Servlet implementation class Allteam
 */
@WebServlet("/Allteam")
public class Allteam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  try {
			request.setCharacterEncoding("utf-8");
			String name=request.getParameter("suosi");
			if (name==null) {
				request.setAttribute("allteam",new puteDao().Allteam());
				System.out.println("所有团队数量是"+new puteDao().Allteam().size());
				request.getRequestDispatcher("Allteam.jsp").forward(request, response);
			} else {
				if (new puteDao().AllteamLike(name).size()==0) {
					request.setAttribute("allteam",new puteDao().Allteam());
					System.out.println("所有团队数量是"+new puteDao().Allteam().size());
					request.getRequestDispatcher("Allteam.jsp").forward(request, response);
				}else {
					request.setAttribute("allteam",new puteDao().AllteamLike(name));
					System.out.println("模糊查询团队数量是"+new puteDao().Allteam().size());
					request.getRequestDispatcher("Allteam.jsp").forward(request, response);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
