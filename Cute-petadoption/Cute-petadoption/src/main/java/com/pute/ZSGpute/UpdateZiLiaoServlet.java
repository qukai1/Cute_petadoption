package com.pute.ZSGpute;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pute.Dao.Addpute;
import com.pute.Dao.Pet_Detalis;
import com.pute.Entity.pute_Entily;
import com.pute.Fileimg.FileimgNew;

/**
 * Servlet implementation class UpdateZiLiaoServlet
 */
@WebServlet("/UpdateZiLiaoServlet")
public class UpdateZiLiaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
			 String id=request.getParameter("id");
			 if (id!=null) {
				 try {
						System.out.println("执行修改宠物资料");
						request.setAttribute("pute_put",new Pet_Detalis().pute_petID(Integer.parseInt(id)));
						//查询宠物信息
						request.getRequestDispatcher("xiugaiziliao.jsp").forward(request, response);
					 } catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}else {
				//用户获取不到id则获取flg标记，如果2个获取都不到那就执行更改宠物资料操作
				if (request.getParameter("flg")!=null) {
					System.out.println("执行修改用户资料");
					String userid=request.getParameter("flg");
					try {
						request.setAttribute("user",new Pet_Detalis().userID(Integer.parseInt(userid)));
						request.getRequestDispatcher("xiugaiuser.jsp").forward(request, response);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//查询宠物信息
					request.getRequestDispatcher("xiugaiziliao.jsp").forward(request, response);
				}else {
					System.out.println("执行修改宠物资料2");
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
						pe.setPute_text(strValue[4]);
						pe.setPute_type(strValue[3]);
						System.out.println("更新的id是"+strValue[6]);
						pe.setId(Integer.parseInt(strValue[6]));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//执行sql
					try {
						if (new Addpute().Updatepute_pet(pe)) {
							System.out.println("更改成功");
							response.sendRedirect("User_detailed_information");
						}else {
							System.out.println("更改失败");
							response.sendRedirect("User_detailed_information");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		 
	}
}
