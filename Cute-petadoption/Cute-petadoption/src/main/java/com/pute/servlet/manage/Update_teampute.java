package com.pute.servlet.manage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pute.Dao.Team_puteZSG;
import com.pute.Entity.team_pute;

/**
 * Servlet implementation class Update_teampute
 */
@WebServlet("/Update_teampute")
public class Update_teampute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		team_pute t=new team_pute();
		t.setTeamid(Integer.parseInt(request.getParameter("teamid")));
		t.setTeam_name(request.getParameter("team_name"));
		t.setTeam_sex(request.getParameter("team_sex"));
		t.setTeam_age(Integer.parseInt(request.getParameter("team_age")));
		t.setTeam_type(request.getParameter("team_type"));
		try {
			if (Team_puteZSG.UpdateTeam_pute(t)) {
				response.sendRedirect("Team_puteAdmin");
			}else {
				request.setAttribute("id",t.getTeamid());
				request.getRequestDispatcher("Team_puteUpdateServlet");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
