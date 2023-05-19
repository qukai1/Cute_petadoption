package com.pute.ZSGpute;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pute.Dao.BaDao;
import com.pute.Dao.Pet_Detalis;
import com.pute.Dao.puteDao;
import com.pute.Entity.User;
import com.pute.Entity.lingyang;
import com.pute.lingyang.Iingyang;

/**
 * Servlet implementation class guanlichongwu
 */
@WebServlet("/guanlichongwu")
public class guanlichongwu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("xinxi")!=null) {
			//分离内容
			String[] strVal=new String[] {};
			String val=request.getParameter("xinxi");
			strVal=val.split(":");
			int len=strVal.length;
			//查找领养单表
			try {
				if (strVal[len-1].equals("team")) {
					lingyang l=Pet_Detalis.QuerLingyangBiaoID(Integer.parseInt(strVal[0]));
					User u=Pet_Detalis.userID(l.getLingyangrenid());
					String PuteName=puteDao.querTeamName(Integer.parseInt(strVal[0]));
					//转发数据展示页面
					request.setAttribute("lingyangbiao", l);
					request.setAttribute("userbiao",u);
					request.setAttribute("pute_name", PuteName);
					request.getRequestDispatcher("领养同意表.jsp").forward(request, response);
				} else {
					lingyang l=Pet_Detalis.QuerLingyangBiaoID(Integer.parseInt(strVal[0]));
					User u=Pet_Detalis.userID(l.getLingyangrenid());
					String PuteName=puteDao.querPuteName(Integer.parseInt(strVal[0]));
					//转发数据展示页面
					request.setAttribute("lingyangbiao", l);
					request.setAttribute("userbiao",u);
					request.setAttribute("pute_name", PuteName);
					request.getRequestDispatcher("领养同意表.jsp").forward(request, response);
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			if (request.getParameter("id")!=null) {
				//执行删除状态表，更该宠物有人领养的状态表
				try {
					lingyang l=Pet_Detalis.QuerLingyangID(Integer.parseInt(request.getParameter("id")));
					//进行判断是那张宠物表
					if (l.getSuoshubiao().equals("pute_pet")) {
						//进行宠物表修改
						BaDao.UpdateJuLi(l);
						//领养状态表变更
						BaDao.DeleteLingyangbiao(l);
						response.sendRedirect("User_detailed_information");
					} else if (l.getSuoshubiao().equals("team_pute")){

					}else if (l.getSuoshubiao().equals("admin_pute")){
						
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				//用户同意领养猫咪所属人变更，领养信息表变更，宠物领养状态变更，宠物有人领养状态变更 
				//获取领养表信息
				try {
					lingyang l=Pet_Detalis.QuerLingyangBiaoID(Integer.parseInt(request.getParameter("ux")));
					//进行判断是那张宠物表
					if (l.getSuoshubiao().equals("pute_pet")) {
						//进行宠物表修改
						BaDao.UpdateLi(l);
						//领养状态表变更
						BaDao.UpdateLingyangbiao(l);
						response.sendRedirect("User_detailed_information");
					} else if (l.getSuoshubiao().equals("team_pute")){
						//进行判断是那张宠物表
							//进行宠物表修改
							BaDao.UpdateLiZTeam(l);
							//领养状态表变更
							BaDao.UpdateLingyangbiao(l);
							response.sendRedirect("Team_puteAdmin");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
