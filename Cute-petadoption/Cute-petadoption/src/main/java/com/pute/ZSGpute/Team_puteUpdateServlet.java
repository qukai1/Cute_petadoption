package com.pute.ZSGpute;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pute.Dao.Team_puteZSG;
import com.pute.Entity.team_pute;


@WebServlet("/Team_puteUpdateServlet")
public class Team_puteUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		//获取修改信息
		try {
			team_pute t=Team_puteZSG.update(id);
			request.setAttribute("team_pute", t);
			System.out.println("进入修改页面");
			request.getRequestDispatcher("/WEB-INF/Team_pute/updateTeam_pute.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
