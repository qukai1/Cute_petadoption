package com.pute.Dao.AdminDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.pute.DButils.DBConn;
import com.pute.Entity.pute_team_huodong;

public class AdminDaoInfo {
	//获取数据库连接
		static Connection conn=null;
		//获取sql初始化对象
		static PreparedStatement pst=null;
		//集合对象
		static ResultSet rs=null;
		
		//获取团队活动信息表
		public List<pute_team_huodong> allhuodong() throws Exception{
			String sql="select * from pute_team_huodong";
			conn=DBConn.getConn();
			rs=conn.prepareStatement(sql).executeQuery();
			List<pute_team_huodong> ps=new ArrayList<pute_team_huodong>();
			while(rs.next()) {
				pute_team_huodong c=new pute_team_huodong();
				c.setHuodong_id(rs.getInt("huodong_id"));
				c.setHuodong_name(rs.getString("huodong_name"));
				c.setState(rs.getString("huodong_state"));
				c.setEng(rs.getString("huodong_eng"));
				c.setHoudong_status(rs.getString("huodong_status"));
				c.setHoudong_baifen(rs.getString("huodong_baifen"));
				c.setPute_team_id(rs.getInt("pute_team_id"));
				ps.add(c);
			}
			return ps;
		}
}
