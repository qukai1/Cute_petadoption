package com.pute.ZSGpute;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pute.Dao.BaDao;

/**
 * Servlet implementation class UpdateCheServlet
 */
@WebServlet("/UpdateCheServlet")
public class UpdateCheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String bookid=request.getParameter("id");
		//执行删除
		System.out.println("所撤销的id是"+bookid);
		//显示删除成功次数
		int coun=1;
		String[] delsID=new String[] {};
		delsID=bookid.split(":");
		int len=delsID.length;
		System.out.println("撤销的表id是"+delsID[len-1]);
		if (delsID[len-1].equals("pute_put")) {
			System.out.println("撤销pute_put");
			for (int i = 0; i < delsID.length; i++) {
				try {
					if (new BaDao().Chexiao(delsID[i])) {
						System.out.println("撤销成功"+(coun++)+"次");
					} else {
						System.out.println("撤销失败");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			response.sendRedirect("User_detailed_information");
		} else {
			System.out.println("撤销team");
			for (int i = 0; i < delsID.length; i++) {
				try {
					if (new BaDao().ChexiaoTeam(delsID[i])) {
						System.out.println("撤销成功"+(coun++)+"次");
					} else {
						System.out.println("撤销失败");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			response.sendRedirect("Team_puteAdmin");
		}
		
	}
	}
