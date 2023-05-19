package com.pute.ZSGpute;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pute.Dao.Addpute;


@WebServlet("/AddPute")
public class AddPute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("zhiyuan_name");
		String address=request.getParameter("zhiyuan_address");
		String text=request.getParameter("zhiyuan_text");
		String phone=request.getParameter("zhiyuan_phone");	
		Addpute a=new Addpute();
			if(a.addPute(name,address,text,phone)) {
				System.out.println("新增成功");
			}else {
				System.out.println("新增失败");
			}
		request.getRequestDispatcher("ShowAll_index").forward(request, response);
	}

}
