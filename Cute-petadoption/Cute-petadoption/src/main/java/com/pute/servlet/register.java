package com.pute.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.pute.Dao.BaDao;
import com.pute.Entity.User;

/**
 * ע�������Servlet
 */
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�ַ�����
		request.setCharacterEncoding("utf-8");
		// ��ȡ�û��������Ƹ�����
		String name = request.getParameter("rest-name");
		String pwd = request.getParameter("rest-pwd");
		request.setAttribute("error","注册失败");
		//������ӷ���
		try {
			if (BaDao.insUser(new User(0,name,pwd,1,null,null,null,null, 0))) {
				//ע��ɹ���ת��ҳ
				request.getSession().setAttribute("userID",name);
				response.sendRedirect("ShowAll_index");
			} else {
				//���ע��ʧ������תע��ҳ��
				request.getRequestDispatcher("loginandregistration.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
