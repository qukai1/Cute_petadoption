package com.pute.DButils;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

//���ݿ�������
public class DBConn {
	private static final String DR="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql:///pute_mysql?useSSL=false&characterEncoding=UTF-8";
	private static final String Name="root";
	private static final String Pwd="181121";
	//����������
	static {
		try {
			Class.forName(DR);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//��ȡ���ݿ�����
	public static Connection getConn() throws Exception {
		Connection conn=null;
		conn=(Connection) DriverManager.getConnection(URL, Name, Pwd);
		return conn;
		
	}
	//�ر����ݿ�����
	public static void colse(ResultSet rs,Statement stat,Connection conn) throws Exception {
		if(rs!=null) {
			rs.close();
		}
		if(stat!=null) {
			stat.close();
		}
		if(conn!=null) {
			conn.close();
		}
	}
	//���ݿ��������
	public static void main(String[] args) throws Exception {
		System.out.println(new DBConn().getConn());
	}
}
