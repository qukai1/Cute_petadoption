package com.pute.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pute.Dao.Index_servlet_List;
import com.pute.Dao.puteDao;
import com.pute.Entity.User;

/**
 * 用户查看自己的信息
 */
@WebServlet("/User_detailed_information")
public class User_detailed_information extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("用户查看自己的详细信息");
		System.out.println("已登录的session的用户是"+request.getSession().getAttribute("pute-name"));
		String name=(String) request.getSession().getAttribute("pute-name");
		//获取用户详细信息,并且跳转页面
				try {
					User u=new puteDao().NameQuer(name);
					request.setAttribute("userList",u);
					System.out.println("用户名称是"+u.getName());
					request.setAttribute("li_pute",new puteDao().NameLiQuer(u.getId()));
					System.out.println("用户的领养宠物数量是"+new puteDao().NameLiQuer(u.getId()).size());
					request.setAttribute("Zhuan_pute",new puteDao().NameZhuanQuer(u.getId()));
					System.out.println("用户转养宠物的数量是"+new puteDao().NameZhuanQuer(u.getId()).size());
					//进行判断如果用户是团队管理员则在输出时候可以进入团队管理页面
					if (new Index_servlet_List().Admin_querTeam(u.getId())) {
						System.out.println("是团队管理员");
						request.setAttribute("team_admin","trsue");
					}
					//跳转个人显示页面
					request.getRequestDispatcher("普通用户转养跟收养宠物页面.jsp").forward(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

}
