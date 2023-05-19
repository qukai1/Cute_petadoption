package com.pute.ZSGpute;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pute.Dao.BaDao;

/**
 * 用户删除宠物
 */
@WebServlet("/delputeServlet")
public class delputeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("utf-8");
				String bookid=request.getParameter("id");
				//执行删除
				System.out.println("所删除的id是"+bookid);
				//显示删除成功次数
				int coun=1;
				String[] delsID=new String[] {};
				delsID=bookid.split(":");
				int len=delsID.length;
				System.out.println("删除的表id是"+delsID[len-1]);
				if (delsID[len-1].equals("pute_put")) {
					System.out.println("删除pute");
					for (int i = 0; i < delsID.length; i++) {
						try {
							if (new BaDao().delid(delsID[i])) {
								System.out.println("删除成功"+(coun++)+"次");
							} else {
								System.out.println("");
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					response.sendRedirect("User_detailed_information");
				} else {
					System.out.println("删除team");
					for (int i = 0; i < delsID.length; i++) {
						try {
							if (new BaDao().delidTeam(delsID[i])) {
								System.out.println("删除成功"+(coun++)+"次");
							} else {
								System.out.println("");
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
