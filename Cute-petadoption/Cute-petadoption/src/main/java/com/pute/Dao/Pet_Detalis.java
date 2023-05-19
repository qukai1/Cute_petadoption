package com.pute.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.pute.DButils.DBConn;
import com.pute.Entity.User;
import com.pute.Entity.Zhiyuanzhe;
import com.pute.Entity.admin_pute;
import com.pute.Entity.lingyang;
import com.pute.Entity.pute_Entily;
import com.pute.Entity.pute_team;
import com.pute.Entity.team_pute;
import com.pute.lingyang.Iingyang;

//宠物详细信息方法类
public class Pet_Detalis {
	//获取数据库连接
		static Connection conn=null;
		//获取sql初始化对象
		static PreparedStatement pst=null;
		//集合对象
		static ResultSet rs=null;
		//用户点击查看宠物详细信息
		public  pute_Entily pute_petID(int id) throws Exception {
			conn=DBConn.getConn();
			String sql="select * from pute_pet where pute_id=?";
			rs=new puteDao().setSql(sql,id).executeQuery();
			pute_Entily p=new pute_Entily();
			while(rs.next()) {
				p.setId(rs.getInt("pute_id"));
				p.setPute_name(rs.getString("pute_name"));
				p.setPute_sex(rs.getString("pute_sex"));
				p.setPute_age(rs.getInt("pute_age"));
				p.setPute_type(rs.getString("pute_type"));
				p.setPute_text(rs.getString("pute_text"));
				p.setPute_address(rs.getString("pute_address"));
				p.setPute_img(rs.getString("pute_img"));
				p.setUser_id(rs.getInt("user_id"));
				p.setPute_ski(rs.getInt("pute_ski"));
				p.setPute_date(rs.getString("pute_date"));
			}
			return p;
		}
		//用户点击查看宠物详情所属人信息
		public static User userID(int user_id) throws SQLException, Exception {
			//准备sql
			String sql="select * from user where user_id= ? ";
			//ִ执行sql
			rs=new puteDao().setSql(sql,user_id).executeQuery();
			//创建集合对象
			User uli=new User();
			while(rs.next()) {
				uli.setId(rs.getInt("user_id"));
				uli.setName(rs.getString("name"));
				uli.setPwd(rs.getString("pwd"));
				uli.setUserID(rs.getInt("userid"));
				uli.setAddress(rs.getString("address"));
				uli.setPhone(rs.getString("phone"));
				uli.setText(rs.getString("text"));
				uli.setImg(rs.getString("img"));
			}
			return uli;
		}
		
		//管理员宠物信息
		public admin_pute admin_puteID(int id) throws Exception {
			conn=DBConn.getConn();
			String sql="select * from admin_pute where admin_id=?";
			rs=new puteDao().setSql(sql,id).executeQuery();
			admin_pute p=new admin_pute();
			while(rs.next()) {
				p.setAdmin_id(rs.getInt("Admin_id"));
				p.setAdmin_name(rs.getString("Admin_name"));
				p.setAdmin_sex(rs.getString("Admin_sex"));
				p.setAdmin_age(rs.getInt("Admin_age"));
				p.setAdmin_type(rs.getString("Admin_type"));
				p.setAdmin_text(rs.getString("Admin_text"));
				p.setAdmin_address(rs.getString("Admin_address"));
				p.setAdmin_img(rs.getString("Admin_img"));
				p.setUserid(rs.getInt("userid"));
				p.setAdmin_ski(rs.getInt("Admin_ski"));
				p.setAdmin_date(rs.getString("Admin_date"));
			}
			return p;
		}   
		//团队宠物信息
		public static team_pute team_puteID(int id) throws Exception {
			conn=DBConn.getConn();
			String sql="select * from team_pute where teamid=?";
			rs=new puteDao().setSql(sql,id).executeQuery();
			team_pute p=new team_pute();
			while(rs.next()) {
				p.setTeamid(rs.getInt("Teamid"));
				p.setTeam_name(rs.getString("Team_name"));
				p.setTeam_sex(rs.getString("Team_sex"));
				p.setTeam_age(rs.getInt("Team_age"));
				p.setTeam_type(rs.getString("Team_type"));
				p.setTeam_text(rs.getString("Team_text"));
				p.setTeam_address(rs.getString("Team_address"));
				p.setTeam_imgw(rs.getString("team_img"));
				p.setUser_id(rs.getInt("User_id"));
				p.setTeam_id(rs.getInt("team_id"));
				p.setTeam_ski(rs.getInt("Team_ski"));
				p.setTeam_date(rs.getString("Team_date"));
			}
			return p;
		}
		//宠物所属团队信息
		public pute_team QTeamID(int team_id) throws Exception {
			System.out.println("团队管理员id"+team_id);
			conn=DBConn.getConn();
			String sql="select * from pute_team where pute_team_id=?";
			rs=new puteDao().setSql(sql,team_id).executeQuery();
			pute_team p=new pute_team();
			while(rs.next()) {
				p.setTeam_id(rs.getInt("pute_team_id"));
				p.setTeam_name(rs.getString("pute_team_name"));
				p.setTeam_text(rs.getString("pute_team_text"));
				p.setTeam_address(rs.getString("pute_team_address"));
				p.setTeam_img(rs.getString("pute_team_img"));
				p.setTeam_phone(rs.getString("pute_phone"));
				p.setTeam_date(rs.getString("pute_team_date"));
			}
			return p;
		} 
		//重写方法
		public pute_team QTeamIDE(int team_id) throws Exception {
			System.out.println("团队管理员id"+team_id);
			conn=DBConn.getConn();
			String sql="select * from pute_team where userid=?";
			rs=new puteDao().setSql(sql,team_id).executeQuery();
			pute_team p=new pute_team();
			while(rs.next()) {
				p.setTeam_id(rs.getInt("pute_team_id"));
				p.setTeam_name(rs.getString("pute_team_name"));
				p.setTeam_text(rs.getString("pute_team_text"));
				p.setTeam_address(rs.getString("pute_team_address"));
				p.setTeam_img(rs.getString("pute_team_img"));
				p.setTeam_phone(rs.getString("pute_phone"));
				p.setTeam_date(rs.getString("pute_team_date"));
			}
			return p;
		} 
		//根据团队管理员所在的团队查询该团队下所有的宠物信息
		public List<team_pute> Team_puteAll(int id) throws Exception {
			conn=DBConn.getConn();
			String sql="select * from team_pute where team_id=?";
			rs=new puteDao().setSql(sql,id).executeQuery();
			List<team_pute> te=new ArrayList<team_pute>();
			while(rs.next()) {
				team_pute p=new team_pute();
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
				te.add(p);
			}
			return te;
		}
		//领养信息状态表
		public static lingyang QuerLingyangBiaoID(int parseInt) throws Exception {
			conn=DBConn.getConn();
			String sql="select * from lingyangbiao where biaoid=?";
			pst=(PreparedStatement) conn.prepareStatement(sql);
			pst.setInt(1,parseInt);
			rs=pst.executeQuery();
			lingyang i=new lingyang();
			while(rs.next()) {
				i.setLingyangid(rs.getInt("id"));
				i.setLingyangrenid(rs.getInt("lingyangrenid"));
				i.setSuoshubiao(rs.getString("suoshubiao"));
				i.setSuoshurenid(rs.getInt("suoshurenid"));
				i.setBiaoid(rs.getInt("biaoid"));
			}
			return i;
		}
		public static lingyang QuerLingyangID(int parseInt) throws Exception {
			conn=DBConn.getConn();
			String sql="select * from lingyangbiao where id=?";
			pst=(PreparedStatement) conn.prepareStatement(sql);
			pst.setInt(1,parseInt);
			rs=pst.executeQuery();
			lingyang i=new lingyang();
			while(rs.next()) {
				i.setLingyangid(rs.getInt("id"));
				i.setLingyangrenid(rs.getInt("lingyangrenid"));
				i.setSuoshubiao(rs.getString("suoshubiao"));
				i.setSuoshurenid(rs.getInt("suoshurenid"));
				i.setBiaoid(rs.getInt("biaoid"));
			}
			return i;
		}
		//查询该团队下的所有成员
		public List<Zhiyuanzhe> Team_puteChengyuanAll(int team_id) throws Exception {
			conn=DBConn.getConn();
			String sql="select * from zhiyuanzhe WHERE suoshu_team_id=?";
			pst=(PreparedStatement) conn.prepareStatement(sql);
			pst.setInt(1,team_id);
			rs=pst.executeQuery();
			List<Zhiyuanzhe> zl=new ArrayList<Zhiyuanzhe>();
			while (rs.next()) {
				Zhiyuanzhe z=new Zhiyuanzhe();
				z.setName(rs.getString("zhiyuan_name"));
				z.setAge(rs.getInt("zhiyuan_age"));
				z.setSex(rs.getString("zhiyuan_sex"));
				z.setPhone(rs.getString("zhiyuan_phone"));
				z.setAddress(rs.getString("zhiyuan_address"));
				z.setId(rs.getInt("zhiyuan_id"));
				zl.add(z);
			}	
			return zl;
		}
		
}
