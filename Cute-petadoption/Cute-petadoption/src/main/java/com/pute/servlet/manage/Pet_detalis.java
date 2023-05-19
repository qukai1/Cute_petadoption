package com.pute.servlet.manage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pute.Dao.Pet_Detalis;
import com.pute.Entity.admin_pute;
import com.pute.Entity.pute_Entily;
import com.pute.Entity.team_pute;

/**
 * Servlet implementation class Pet_detalis
 */
@WebServlet("/Pet_detalis")
public class Pet_detalis extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 根据用户点击传入的宠物id查询宠物的详细信息，进行显示跟查询宠物所属主人信息
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		//分离字符串
		String[] str=new String[] {};
		str=id.split(":");
		System.out.println(id);
		int Id=Integer.parseInt(str[0]);
		String DB_bate=str[1];
		System.out.println("用户点击的id是"+Id+"查询的表是"+DB_bate);
			try {
				if (DB_bate.equals("pute")) {
					System.out.println("执行1");
					//宠物详细对象
					pute_Entily pE = new Pet_Detalis().pute_petID(Id);
					request.setAttribute("pute_Entliy",pE);
					request.setAttribute("pute","pute");
					//宠物所属人信息对象
					request.setAttribute("user",new Pet_Detalis().userID(pE.getUser_id()));
					System.out.println(new Pet_Detalis().userID(pE.getUser_id()).getName());
					//转发页面
					request.getRequestDispatcher("猫咪详细页面.jsp").forward(request, response);
				} else if (DB_bate.equals("team")){
					System.out.println("执行2");
					//宠物详细对象
					team_pute Te = new Pet_Detalis().team_puteID(Id);
					request.setAttribute("pute_Entliy",Te);
					System.out.println("团队id是："+Te.getTeam_id());
					//团队宠物所属信息对象
					request.setAttribute("Team",new Pet_Detalis().QTeamID(Te.getTeam_id()));
					System.out.println("所属团队是"+new Pet_Detalis().QTeamID(Te.getTeam_id()).getTeam_name());
					request.setAttribute("user",new Pet_Detalis().userID(Te.getUser_id()));
					System.out.println(new Pet_Detalis().userID(Te.getUser_id()).getName());
					//转发页面
					request.getRequestDispatcher("团队猫咪详细端.jsp").forward(request, response);
				}else if(DB_bate.equals("admin")) {
					System.out.println("执行3");
					//宠物详细对象
					pute_Entily pE = new Pet_Detalis().pute_petID(Id);
					request.setAttribute("pute_Entliy",pE);
					request.setAttribute("pute","pute");
					//宠物所属人信息对象
					request.setAttribute("user",new Pet_Detalis().userID(pE.getUser_id()));
					System.out.println(new Pet_Detalis().userID(pE.getUser_id()).getName());
					//转发页面
					request.getRequestDispatcher("猫咪详细页面.jsp").forward(request, response);
				}
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

}
