package com.pute.ZSGpute;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.pute.Dao.Addpute;
import com.pute.Entity.lingyang;
import com.pute.Entity.pute_Entily;
import com.pute.Fileimg.FileimgNew;

/**
 * 添加转养宠物信息
 */
@WebServlet("/Add_pute_pet")
public class Add_pute_pet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sid=request.getSession();
		request.setCharacterEncoding("utf-8");
		pute_Entily pe=new pute_Entily();
		//处理上传图片
		try {
			FileimgNew imgN=new FileimgNew();
			String[] strValue=imgN.ChuliImg(request);
			System.out.println("用户添加的访问路径是："+imgN.getUrl());
			pe.setPute_address(strValue[5]);
			pe.setPute_age(Integer.parseInt(strValue[2]));
			pe.setPute_img(imgN.getUrl());
			pe.setPute_name(strValue[0]);
			pe.setPute_sex(strValue[1]);
			pe.setPute_ski(0);
			pe.setPute_text(strValue[4]);
			pe.setPute_type(strValue[3]);
			pe.setUser_id(Integer.parseInt(strValue[6]));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//执行sql
		try {
			if (new Addpute().Addpute_pet(pe)) {
				System.out.println("添加成功");
				response.sendRedirect("User_detailed_information");
			}else {
				System.out.println("添加失败");
				request.getRequestDispatcher("UserAddPute_pet.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
