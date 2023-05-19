package com.pute.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.pute.DButils.DBConn;
import com.pute.Entity.admin_pute;
import com.pute.Entity.pute_Entily;
import com.pute.Entity.pute_team;
import com.pute.Entity.team_pute;

//首页数据重载类
public class Index_servlet_List {
	//获取数据库连接
	static Connection conn=null;
	//获取sql初始化对象
	static PreparedStatement pst=null;
	//集合对象
	static ResultSet rs=null;
	//团队推荐领养猫咪
	public List<team_pute> SystemList() throws Exception {
		conn=DBConn.getConn();
		String sql="select * from team_pute WHERE team_ski=1 LIMIT 8";
		rs=conn.prepareStatement(sql).executeQuery();
		List<team_pute> tp=new ArrayList<team_pute>();
		while(rs.next()) {
			team_pute t=new team_pute();
			t.setTeamid(rs.getInt("teamid"));
			t.setTeam_name(rs.getString("team_name"));
			t.setTeam_age(rs.getInt("team_age"));
			t.setTeam_type(rs.getString("team_type"));
			t.setTeam_sex(rs.getString("team_sex"));
			t.setTeam_address(rs.getString("team_address"));
			t.setTeam_text(rs.getString("team_text"));
			t.setTeam_imgw(rs.getString("team_img"));
			t.setTeam_id(rs.getInt("team_id"));
			t.setTeam_ski(rs.getInt("team_ski"));
			t.setTeam_date(rs.getString("team_date"));
			tp.add(t);
		}
		return tp;
	}
	//个人转养
	public List<pute_Entily> IntList() throws Exception {
		conn=DBConn.getConn();
		String sql="select * from pute_pet WHERE pute_ski=1 LIMIT 1,8";
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
   
	//个人转养所有宠物
		public List<pute_Entily> IntLists() throws Exception {
			conn=DBConn.getConn();
			String sql="select * from pute_pet ";
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
//系统推荐领养
	public List<pute_Entily> AdminList() throws Exception {
		conn=DBConn.getConn();
		String sql="select * from pute_pet WHERE pute_ski=1 LIMIT 8,40";
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
	//页面加载写入团队宠物人数数量
	public static void countNumTeam() throws Exception {
		conn=DBConn.getConn();
		//获取团队总数
		String sql="SELECT pute_team_id FROM pute_team";
		List<pute_team> numTeam=new ArrayList<pute_team>();
		pst=(PreparedStatement) conn.prepareStatement(sql);
		rs=pst.executeQuery();
		while(rs.next()) {
			pute_team t=new pute_team();
			t.setTeam_id(rs.getInt("pute_team_id"));
			numTeam.add(t);
		}
		System.out.println("团队总数是："+numTeam.size());
		
		//进行循环写入数据
		for (pute_team t:numTeam) {
			xieruNumpute_team(t.getTeam_id());
			xieruNumteam_pute(t.getTeam_id());
		}
	}
	
	private static void xieruNumteam_pute(int team_id) throws Exception {
		int num=0;
		conn=DBConn.getConn();
		//获取团队总数
		String sql="SELECT COUNT(team_id) FROM  team_pute WHERE team_id=?";
		pst=(PreparedStatement) conn.prepareStatement(sql);
		pst.setInt(1,team_id);
		rs=pst.executeQuery();
		while (rs.next()) {
			num=rs.getInt("COUNT(team_id)");
		}
		String sql2="UPDATE `pute_mysql`.`pute_team` SET `pute_num` = ? WHERE `pute_team_id` = ?";
		pst=(PreparedStatement) conn.prepareStatement(sql2);
		pst.setInt(1,num);
		pst.setInt(2,team_id);
		if (pst.executeUpdate()>0) {
			System.out.println("团队宠物数量更新成功");
		}else {
			System.out.println("团队宠物数量更新失败");
		}
	}
	private static void xieruNumpute_team(int team_id) throws Exception {
		int num=0;
		conn=DBConn.getConn();
		//获取团队总数
		String sql="SELECT COUNT(zhiyuan_id) FROM  zhiyuanzhe WHERE suoshu_team_id=?";
		pst=(PreparedStatement) conn.prepareStatement(sql);
		pst.setInt(1,team_id);
		rs=pst.executeQuery();
		while (rs.next()) {
			num=rs.getInt("COUNT(zhiyuan_id)");
		}
		String sql2="UPDATE `pute_mysql`.`pute_team` SET `team_num` = ? WHERE `pute_team_id` = ?";
		pst=(PreparedStatement) conn.prepareStatement(sql2);
		pst.setInt(1,num);
		pst.setInt(2,team_id);
		if (pst.executeUpdate()>0) {
			System.out.println("团队人数更新成功");
		}else {
			System.out.println("团队人数更新失败");
		}
	}
	//查询用户是否是团队管理员
	public static boolean Admin_querTeam(int id) throws SQLException, Exception {
		System.out.println(id);
		boolean flg=false;
		conn=DBConn.getConn();
		String sql="select * from pute_team where userid=?";
		rs=new puteDao().setSql(sql,id).executeQuery();
		while(rs.next()) {
			if (rs.getInt("userid")==id) {
				flg=true;
			}
		}
		return flg;
	}
}
