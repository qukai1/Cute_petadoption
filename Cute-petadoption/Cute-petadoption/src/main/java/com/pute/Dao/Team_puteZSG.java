package com.pute.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.pute.DButils.DBConn;
import com.pute.Entity.pute_team;
import com.pute.Entity.team_pute;

public class Team_puteZSG {
	//获取数据库连接
	static Connection conn=null;
	//获取sql初始化对象
	static PreparedStatement pst=null;
	//集合对象
	static ResultSet rs=null;
	
	 
	 //查询单个团队宠物信息
	public static team_pute update(int id) throws SQLException, Exception {
		String sql="select * from team_pute where teamid=?";
		team_pute p=new team_pute();
		rs=puteDao.setSql(sql,id).executeQuery();
		while (rs.next()) {
			p.setTeamid(rs.getInt("Teamid"));
			p.setTeam_name(rs.getString("Team_name"));
			p.setTeam_sex(rs.getString("Team_sex"));
			p.setTeam_age(rs.getInt("Team_age"));
			p.setTeam_type(rs.getString("Team_type"));
			p.setTeam_text(rs.getString("Team_text"));
			p.setTeam_address(rs.getString("Team_address"));
			p.setTeam_imgw(rs.getString("Team_img"));
			p.setUser_id(rs.getInt("User_id"));
			p.setTeam_id(rs.getInt("team_id"));
			p.setTeam_ski(rs.getInt("Team_ski"));
			p.setTeam_date(rs.getString("Team_date"));
			p.setTeam_iux(rs.getInt("team_iux"));
		}
		return p;
	}

	//更新团队宠物信息
	public static boolean UpdateTeam_pute(team_pute t) throws Exception {
		String sql="UPDATE `pute_mysql`.`team_pute` SET `team_name` = ?, `team_age` =?, `team_type` = ?, `team_sex` = ? WHERE `teamid` = ?";
		
		return puteDao.setSql(sql,t.getTeam_name(),t.getTeam_age(),t.getTeam_type(),t.getTeam_sex(),t.getTeamid()).executeUpdate()>0;
	}

	//团队注销
	public static boolean DelteLink(int id) throws Exception {
		//获取对应的userid
		String sql="delete from pute_team where pute_team_id=?";
		return puteDao.setSql(sql,id).executeUpdate()>0;
	}
	//获取单个id的详细团队信息
	public static pute_team querById(int id) throws SQLException, Exception {
		String sql="select * from pute_team where pute_team_id=?";
		rs=puteDao.setSql(sql,id).executeQuery();
		pute_team s=new pute_team();
		while(rs.next()) {
			s.setTeam_id(rs.getInt("pute_team_id"));
			s.setTeam_name(rs.getString("pute_team_name"));
			s.setTeam_text(rs.getString("pute_team_text"));
			s.setTeam_img(rs.getString("pute_team_img"));
			s.setTeam_date(rs.getString("pute_team_date"));
			s.setTeam_address(rs.getString("pute_team_address"));
			s.setTeam_phone(rs.getString("pute_phone"));
			s.setUserid(rs.getInt("userid"));
			s.setPute_num(rs.getInt("pute_num"));
			s.setTeam_num(rs.getInt("team_num"));
		}
		return s;
	}
	//修改团队信息
	public static boolean UpdatePute_team(pute_team t) throws SQLException, Exception {
		String sql="UPDATE `pute_mysql`.`pute_team` SET `pute_team_name` = ?, `pute_team_address` = ?, `pute_team_text` = ?, `pute_phone` = ? WHERE `pute_team_id` = ?";
		return puteDao.setSql(sql,t.getTeam_name(),t.getTeam_address(),t.getTeam_text(),t.getTeam_phone(),t.getTeam_id()).executeUpdate()>0;
	}  
	
}
