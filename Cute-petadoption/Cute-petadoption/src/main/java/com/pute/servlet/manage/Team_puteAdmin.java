package com.pute.servlet.manage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pute.Dao.Pet_Detalis;
import com.pute.Entity.pute_team;

/**
 * Servlet implementation class Team_puteAdmin
 */
@WebServlet("/Team_puteAdmin")
public class Team_puteAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id=0;
		//2种方式进入团队管理页面
		if (request.getSession().getAttribute("team_id")!=null) {
			id=(int)request.getSession().getAttribute("team_id");
		} else if (request.getParameter("id")!=null){
			id=Integer.parseInt(request.getParameter("id"));
		}else {
			//最后一种情况进入团队管理
			id=(int) request.getSession().getAttribute("id");
		}
		System.out.println("进入团队管理页面的是："+id);
		try {
			pute_team te=new Pet_Detalis().QTeamIDE(id);
			System.out.println("团队是否为空"+te.getTeam_id());
			request.setAttribute("pute_team",te);
			request.setAttribute("team_pute",new Pet_Detalis().Team_puteAll(te.getTeam_id()));
			System.out.println("所进入的团队是否为空"+new Pet_Detalis().Team_puteAll(te.getTeam_id()).size());
			request.setAttribute("chengyuan",new Pet_Detalis().Team_puteChengyuanAll(te.getTeam_id()));
			request.getRequestDispatcher("团队管理页面.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
