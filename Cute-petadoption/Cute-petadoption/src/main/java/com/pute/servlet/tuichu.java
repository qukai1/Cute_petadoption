package com.pute.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class tuichu
 */
@WebServlet("/tuichu")
public class tuichu extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("pute-name",null);
		request.getSession().setAttribute("id",null);
		request.getSession().setAttribute("userimg",null);
		response.sendRedirect("loginandregistration.jsp");
	}

}
