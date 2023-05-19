package com.pute.lingyangServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pute.Dao.Pet_Detalis;
import com.pute.Entity.lingyang;
import com.pute.Entity.team_pute;
import com.pute.ZSGpute.Add_pute_pet;
import com.pute.lingyang.Iingyang;

/**
 * 领养servlet
 */
@WebServlet("/lingyangServlet")
public class lingyangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取传入的领养宠物的id以及所属团队id的信息
		String id=request.getParameter("iduser");
		lingyang ly=new lingyang();
		String[] xinxi=new String[] {};
		xinxi=id.split(":");
		System.out.println(xinxi[0]);
		if (request.getSession().getAttribute("id")!=null) {
			ly.setBiaoid(Integer.parseInt(xinxi[0]));//领养的宠物id
			int userID=(int) request.getSession().getAttribute("id");
			System.out.println("申请领养人id是："+userID);
			ly.setLingyangrenid(userID);//领养人id
			ly.setSuoshubiao("team_pute");//团队宠物
			ly.setSuoshurenid(Integer.parseInt(xinxi[1]));//所属团队id
			//写入领养表
			try {
				if (new Iingyang().LingYang(ly)) {
					//宠物详细对象
					team_pute Te = new Pet_Detalis().team_puteID(Integer.parseInt(xinxi[0]));
					request.setAttribute("pute_Entliy",Te);
					//团队宠物所属信息对象
					request.setAttribute("Team",new Pet_Detalis().QTeamID(Te.getTeam_id()));
					System.out.println("所属团队是"+new Pet_Detalis().QTeamID(Te.getTeam_id()).getTeam_name());
					request.setAttribute("user",new Pet_Detalis().userID(Te.getUser_id()));
					System.out.println(new Pet_Detalis().userID(Te.getUser_id()).getName());
					request.setAttribute("ski","领养成功");
					//转发页面
					request.getRequestDispatcher("团队猫咪详细端.jsp").forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			response.sendRedirect("loginandregistration.jsp");
		}
		
	}

}
