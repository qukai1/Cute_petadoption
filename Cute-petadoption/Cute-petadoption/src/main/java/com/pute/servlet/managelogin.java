package com.pute.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pute.Dao.Index_servlet_List;
import com.pute.Dao.puteDao;
import com.pute.Entity.User;



/**
 * Servlet implementation class managelogin
 */
@WebServlet("/managelogin")
public class managelogin extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		   PrintWriter out =response.getWriter();
		   request.setCharacterEncoding("UTF-8");
		   String name=request.getParameter("login-name");
		   String password=request.getParameter("login-pwd");
		   System.out.println(name+password);
		   boolean flg=false;
		   int team_id=0;
		   System.out.println("加载中");
  				//进行user表验证是否通过，通过了在验证是否为团队管理员
  					try {
						for (User s:puteDao.querUser()) {
							if (s.getName().equals(name)&&s.getPwd().equals(password)) {
								flg=true; 	
								team_id=s.getId();
								break;
							}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
  					if (flg) {
						try {
							if (Index_servlet_List.Admin_querTeam(team_id)) {
								//所有验证通过进入团队管理页面
								request.getSession().setAttribute("team_id",team_id);
								request.getSession().setAttribute("pute-name",name);
				   				request.getRequestDispatcher("Team_puteAdmin").forward(request, response);
							}else {
								request.setAttribute("error","抱歉您不是团队管理员！");
			  					request.getRequestDispatcher("ManageLogin.jsp").forward(request, response);					
			  					}	
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else {
						request.setAttribute("error","账号密码输入错误！，请检查！");
	  					request.getRequestDispatcher("ManageLogin.jsp").forward(request, response);					}	
  				
     }

}