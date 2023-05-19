package com.pute.ZSGpute;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pute.Dao.BaDao;

/**
 * Servlet implementation class ZhuanyangServlet
 */
@WebServlet("/ZhuanyangServlet")
public class ZhuanyangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String bookid=request.getParameter("id");
		//执行删除
		System.out.println("所转养的id是"+bookid);
		//显示删除成功次数
		int coun=1;
		String[] delsID=new String[] {};
		delsID=bookid.split(":");
		int len=delsID.length;
		System.out.println("转养的表id是"+delsID[len-1]);
		if (delsID[len-1].equals("pute_put")) {
			System.out.println("更改pute_put");
			for (int i = 0; i < delsID.length; i++) {
				try {
					if (new BaDao().Zhuanyan(delsID[i])) {
						System.out.println("更改成功"+(coun++)+"次");
					} else {
						System.out.println("更改失败");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			response.sendRedirect("User_detailed_information");
		} else {
			System.out.println("更改team");
			for (int i = 0; i < delsID.length; i++) {
				try {
					if (new BaDao().ZhuanyanTeam(delsID[i])) {
						System.out.println("更改成功"+(coun++)+"次");
					} else {
						System.out.println("更改失败");
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


