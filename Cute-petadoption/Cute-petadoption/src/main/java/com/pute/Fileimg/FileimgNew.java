package com.pute.Fileimg;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
//图片上传处理类
public class FileimgNew {
	//图片访问路径
	String imgu=null;
		//创建一个工厂类
			FileItemFactory factory=new DiskFileItemFactory();
			//创建一个文件上传处理器
			ServletFileUpload upload=new ServletFileUpload(factory);
			//写入用户上传的图片
			public String[] ChuliImg(HttpServletRequest request) throws Exception {
				String neirong="";
				//返回获取的字符串内容
				String[] value=new String[] {};
				//返回获取的字符串内容
				String img_url=request.getParameter("pute_url");
				//获取请求并且绑定输入内容
				String val=request.getParameter("");
				//解析请求
				List<FileItem> items=upload.parseRequest(request);
				for(FileItem item:items) {
					if(item.isFormField()) {
						//文本类型
						String filename=item.getFieldName();
						val=item.getString("UTF-8");
						neirong+=val+":";
					}else {
						//获取文件后缀名
						String imgtype=item.getName().substring(item.getName().lastIndexOf("."));
						//重新命名
						String imgName=UUID.randomUUID()+imgtype;
						System.out.println(imgName);
						String path="F:/Ctea_pute/Cute-petadoption/Cute-petadoption/src/main/webapp/img/webimg/";
						//保存到服务器
							item.write(new File(path,imgName));
						//把服务器路径添加到数据库
						String sqlPath=null;
						sqlPath="F:/Ctea_pute/Cute-petadoption/Cute-petadoption/src/main/webapp/img/webimg/"+imgName;
						imgu=imgName;
						System.out.println(sqlPath);
						System.out.println("访问路径："+sqlPath);
					}
				}
				//处理内容
				System.out.println("所有的值是："+neirong);
				value=neirong.split(":");
				return value;
				}
		//返回图片路径
		public String getUrl() {
			return  this.imgu;
		}
			}


