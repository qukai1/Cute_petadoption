package com.pute.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.pute.DButils.DBConn;
import com.pute.Entity.User;
import com.pute.Entity.pute_Entily;
import com.pute.Entity.pute_team;

public class puteDao {
	//获取数据库连接
	static Connection conn=null;
	//获取sql初始化对象
	static PreparedStatement pst=null;
	//集合对象
	static ResultSet rs=null;   
	
	public static void colsePrk() throws SQLException {
		String sql="SET FOREIGN_KEY_CHECKS = 0";
		conn.prepareStatement(sql).executeUpdate();
	}
	public static void statarPrk() throws SQLException {
		String sql="SET FOREIGN_KEY_CHECKS = 1";
		conn.prepareStatement(sql).executeUpdate();
	}
	
	//查询所有用户
	public static List<User> querUser() throws Exception{
		//
		conn=DBConn.getConn();
		//
		String sql="select * from user";
		pst=(PreparedStatement) conn.prepareStatement(sql);
		//ִ
		rs=pst.executeQuery();
		//
		List<User> ulist=new ArrayList<User>();
		while(rs.next()) {
			User s=new User();
			s.setId(rs.getInt("user_id"));
			s.setName(rs.getString("name"));
			s.setPwd(rs.getString("pwd"));
			s.setAddress(rs.getString("address"));
			s.setPhone(rs.getString("phone"));
			s.setUserID(rs.getInt("userID"));
			s.setImg(rs.getString("img"));
			s.setState(rs.getInt("state"));
			ulist.add(s);
		}
		return ulist;
		
	}
	//通用增删改
		public static boolean  zsg(String sql,Object...objects) throws Exception {
			//
			conn=DBConn.getConn();
			try {
				pst=(PreparedStatement) conn.prepareStatement(sql);
				//
			   if(objects!=null) {
				   for (int i = 0; i < objects.length; i++) {
					pst.setObject(i+1, objects[i]);
				}
			   }
			   int result=pst.executeUpdate();//ִ
			   return result>0;
			
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					DBConn.colse(rs,pst, conn);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return false;
		}
		
		//用户查询个人信息
		public User NameQuer(String name) throws Exception {
			//准备sql
			String sql="select * from user where name= ? ";
			//ִ执行sql
			rs=setSql(sql,name).executeQuery();
			//创建集合对象
			User uli=new User();
			while(rs.next()) {
				uli.setId(rs.getInt("user_id"));
				uli.setName(rs.getString("name"));
				uli.setPwd(rs.getString("pwd"));
				uli.setUserID(rs.getInt("userid"));
				uli.setAddress(rs.getString("address"));
				uli.setPhone(rs.getString("phone"));
				uli.setImg(rs.getString("img"));
				uli.setText(rs.getString("text"));
			}
			return uli!=null?uli:null;
		}
		//通用的sql处理语句
		public static PreparedStatement setSql(String sql,Object...obj) throws Exception {
			conn=DBConn.getConn();
			pst=(PreparedStatement) conn.prepareStatement(sql);
			if (obj!=null) {
				for (int i = 0; i < obj.length; i++) {
					pst.setObject(i+1, obj[i]);
				}
			}
			return pst;
		}
		//查询已领养猫咪
		public List<pute_Entily> NameLiQuer(int id) throws Exception {
			//获取数据库连接
			conn=DBConn.getConn();
			//准备sql
			String sql="select * from pute_pet where user_id=? AND pute_ski=?";
			//ִ执行sql
			rs=setSql(sql, id,0).executeQuery();
			List<pute_Entily> plist=new ArrayList<pute_Entily>();
			while(rs.next()) {
				pute_Entily p=new pute_Entily();
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
				plist.add(p);
			}
			return plist;
			
		}
		//查询已转养猫咪
		public List<pute_Entily> NameZhuanQuer(int id) throws Exception {
			//获取数据库连接
			conn=DBConn.getConn();
			//准备sql
			String sql="select * from pute_pet where user_id=? AND pute_ski=?";
			//ִ执行sql
			rs=setSql(sql, id,1).executeQuery();
			List<pute_Entily> ulist=new ArrayList<pute_Entily>();
			while(rs.next()) {
				pute_Entily p=new pute_Entily();
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
				p.setPute_iux(rs.getInt("pute_iux"));
				ulist.add(p);
			}
			return ulist;
		}
		//首页模糊查询
		public List<pute_Entily> LikeNamePute(String name) throws Exception {
			conn=DBConn.getConn();
			String sql="select * from pute_pet WHERE pute_ski=1 and pute_name like ? LIMIT 20";
			pst=(PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1,"%"+name+"%");
			rs=pst.executeQuery();
			List<pute_Entily> tp=new ArrayList<pute_Entily>();
			while(rs.next()) {
				pute_Entily t=new pute_Entily();
				t.setId(rs.getInt("pute_id"));
				t.setPute_name(rs.getString("pute_name"));
				t.setPute_sex(rs.getString("pute_sex"));
				t.setPute_age(rs.getInt("pute_age"));
				t.setPute_type(rs.getString("pute_type"));
				t.setPute_text(rs.getString("pute_text"));
				t.setPute_address(rs.getString("pute_address"));
				t.setPute_img(rs.getString("pute_img"));
				t.setUser_id(rs.getInt("user_id"));
				t.setPute_ski(rs.getInt("pute_ski"));
				t.setPute_date(rs.getString("pute_date"));
				tp.add(t);
			}
			return tp;
		}
		//查询所有的团队
		public List<pute_team> Allteam() throws Exception{
			conn=DBConn.getConn();
			String sql="select * from pute_team";
			rs=conn.prepareStatement(sql).executeQuery();
			List<pute_team> ulist=new ArrayList<pute_team>();
			while(rs.next()) {
				pute_team s=new pute_team();
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
				ulist.add(s);
			}
			return ulist;
		}
		//模糊查询所有的团队
		public List<pute_team> AllteamLike(String name) throws Exception{
			conn=DBConn.getConn();
			String sql="select * from pute_team where pute_team_name like ?";
			pst=(PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1,"%"+name+"%");
			rs=pst.executeQuery();
			List<pute_team> ulist=new ArrayList<pute_team>();
			while(rs.next()) {
				pute_team s=new pute_team();
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
				ulist.add(s);
			}
			return ulist;
		}
		//根据id查询宠物名字
		public static String querPuteName(int parseInt) throws SQLException, Exception {
			String sql="select pute_name FROM pute_pet WHERE pute_id=?";
			rs=setSql(sql,parseInt).executeQuery();
			String name="";
			while(rs.next()) {
				name=rs.getString("pute_name");
			}
			return name;
		}
		//根据id查询宠物名字
				public static String querTeamName(int parseInt) throws SQLException, Exception {
					String sql="select team_name FROM team_pute WHERE teamid=?";
					rs=setSql(sql,parseInt).executeQuery();
					String name="";
					while(rs.next()) {
						name=rs.getString("team_name");
					}
					return name;
				}
		//系统推荐
		public List<pute_Entily> LikeNamePutexitong() throws Exception {
			conn=DBConn.getConn();
			String sql="select * from pute_pet WHERE pute_ski=1 LIMIT 20";
			rs=conn.prepareStatement(sql).executeQuery();
			List<pute_Entily> tp=new ArrayList<pute_Entily>();
			while(rs.next()) {
				pute_Entily t=new pute_Entily();
				t.setId(rs.getInt("pute_id"));
				t.setPute_name(rs.getString("pute_name"));
				t.setPute_sex(rs.getString("pute_sex"));
				t.setPute_age(rs.getInt("pute_age"));
				t.setPute_type(rs.getString("pute_type"));
				t.setPute_text(rs.getString("pute_text"));
				t.setPute_address(rs.getString("pute_address"));
				t.setPute_img(rs.getString("pute_img"));
				t.setUser_id(rs.getInt("user_id"));
				t.setPute_ski(rs.getInt("pute_ski"));
				t.setPute_date(rs.getString("pute_date"));
				tp.add(t);
			}
			return tp;
		}
}
