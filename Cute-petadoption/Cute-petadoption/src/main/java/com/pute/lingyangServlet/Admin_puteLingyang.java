package com.pute.lingyangServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pute.Dao.Pet_Detalis;
import com.pute.Entity.admin_pute;
import com.pute.Entity.lingyang;
import com.pute.Entity.pute_Entily;
import com.pute.Entity.team_pute;
import com.pute.lingyang.Iingyang;

/**
 * Servlet implementation class Admin_puteLingyang
 */
@WebServlet("/Admin_puteLingyang")
public class Admin_puteLingyang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
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
			ly.setSuoshubiao("pute_pet");//个人宠物
			ly.setSuoshurenid(Integer.parseInt(xinxi[1]));//所属个人id
			//写入领养表
			try {
				if (new Iingyang().LingYang(ly)) {
					//宠物详细对象
					pute_Entily pE = new Pet_Detalis().pute_petID(Integer.parseInt(xinxi[0]));
					request.setAttribute("pute_Entliy",pE);
					request.setAttribute("pute","pute");
					//宠物所属人信息对象
					request.setAttribute("user",new Pet_Detalis().userID(pE.getUser_id()));
					System.out.println(new Pet_Detalis().userID(pE.getUser_id()).getName());
					request.setAttribute("ski","领养成功");
					//转发页面
					request.getRequestDispatcher("猫咪详细页面.jsp").forward(request, response);
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
