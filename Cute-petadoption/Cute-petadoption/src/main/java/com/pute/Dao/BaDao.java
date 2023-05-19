package com.pute.Dao;

import com.pute.DButils.DBConn;
import com.pute.Entity.User;
import com.pute.Entity.lingyang;
import com.pute.Entity.team_pute;

public class BaDao {
	//注册普通用户
	public static boolean insUser(User u) throws Exception {
		String sql="INSERT into user(name,pwd,userID,phone,address,text)values(?,?,?,?,?,?);";
		return puteDao.zsg(sql,u.getName(),u.getPwd(),u.getUserID(),"fsfer","fserew","fsere");
	}
	//用户删除自己的宠物
	public boolean delid(String string) throws Exception {
		String sql="DELETE FROM `pute_mysql`.`pute_pet` WHERE `pute_id` = ?";
		return puteDao.zsg(sql,string);
	}
	//用户转养自己的宠物
	public boolean Zhuanyan(String string) throws Exception {
		String sql="UPDATE `pute_mysql`.`pute_pet` SET `pute_ski` = '1' WHERE `pute_id` = ?";
		return puteDao.zsg(sql,string);
	}
	//用户撤销转养自己的宠物
	public boolean Chexiao(String string) throws Exception {
		String sql="UPDATE `pute_mysql`.`pute_pet` SET `pute_ski` = '0' WHERE `pute_id` = ?";
		return puteDao.zsg(sql,string);
	}
	//用户注销账号
	public static boolean deleUserid(int id) throws Exception {
		//关闭外键检查
		puteDao.colsePrk();
		String sql="DELETE FROM `pute_mysql`.`user` WHERE `user_id` = ?";
		return puteDao.zsg(sql,id);
	}
	//用户注销账号删除该用户关联的宠物信息
	public static boolean deletePute(int id) throws Exception {
		String sql="DELETE FROM `pute_mysql`.`pute_pet` WHERE `user_id` = ?";
		return puteDao.zsg(sql,id);
	}
	//用户同意领养修改宠物信息
	public static void UpdateLi(lingyang l) throws Exception {
		String sql="UPDATE `pute_mysql`.`pute_pet` SET `user_id` =?, `pute_ski` = '0', `pute_iux` = 0 WHERE `pute_id` =?";
		if (puteDao.zsg(sql,l.getLingyangrenid(),l.getBiaoid())) {
			System.out.println("更改成功！");
		} else {
			System.out.println("宠物信息更改失败");
		}
	}
	//用户同意领养修改宠物信息
		public static void UpdateLiZTeam(lingyang l) throws Exception {
			//关闭数据库外键检查
			puteDao.colsePrk();
			team_pute team=Pet_Detalis.team_puteID(l.getBiaoid());
			if (team_puteid(team,l.getLingyangrenid())) {
				System.out.println("信息转载成功！");
				String sql="DELETE FROM `pute_mysql`.`team_pute` WHERE `teamid` = ?";
				if (puteDao.zsg(sql,l.getBiaoid())) {
					System.out.println("原有team删除成功！");
				} else {
					System.out.println("原有team删除失败！");
				}
			}else {
				System.out.println("信息转载失败！");
			}
		}
		//同意领养将团队表宠物信息转载到用户宠物表
	private static Boolean team_puteid(team_pute team, int i) throws Exception {
		System.out.println("转载的用户id是"+i);
		String sql="INSERT INTO `pute_mysql`.`pute_pet`(`pute_name`, `pute_sex`, `pute_age`, `pute_type`, `pute_text`, `pute_address`, `pute_img`, `user_id`, `pute_ski`, `pute_date`, `pute_iux`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		return puteDao.zsg(sql,team.getTeam_name(),team.getTeam_sex(),team.getTeam_age(),team.getTeam_type(),team.getTeam_text(),team.getTeam_address(),team.getTeam_imgw(),i,0,team.getTeam_date(),0);
	}
	//用户拒绝领养修改宠物信息
		public static void UpdateJuLi(lingyang l) throws Exception {
			String sql="UPDATE `pute_mysql`.`pute_pet` SET  `pute_iux` =0  WHERE `pute_id` =?";
			System.out.println("更改表的id是"+l.getBiaoid());
			if (puteDao.zsg(sql,l.getBiaoid())) {
				System.out.println("拒绝领养更改成功！");
			} else {
				System.out.println("拒绝领养更改失败");
			}
		}
	//领养状态表更改
	public static void UpdateLingyangbiao(lingyang l) throws Exception {
		String sql="UPDATE `pute_mysql`.`lingyangbiao` SET `lingyang_ski` = 1 WHERE `id` =?";
		if (puteDao.zsg(sql,l.getLingyangid())) {
			System.out.println("更改成功！");
		} else {
			System.out.println("领养状态信息更改失败");
		}
	}
	//用户拒绝领养删除该状态信息
	public static void DeleteLingyangbiao(lingyang l) throws Exception {
		String sql="DELETE FROM `pute_mysql`.`lingyangbiao` WHERE `id` = ?";
		System.out.println("删除的领养表id是"+l.getLingyangid());
		if (puteDao.zsg(sql,l.getLingyangid())) {
			System.out.println("拒绝成功！");
		} else {
			System.out.println("拒绝失败");
		}
	}
	//团队管理员删除团队宠物
	public boolean delidTeam(String string) throws Exception {
		String sql="DELETE FROM `pute_mysql`.`team_pute` WHERE `teamid` = ?";
		return puteDao.zsg(sql,string);
	}
	//团队管理员转养宠物
	public boolean ZhuanyanTeam(String string) throws Exception {
		String sql="UPDATE `pute_mysql`.`team_pute` SET `team_ski` = 1 WHERE `teamid` = ?";
		return puteDao.zsg(sql,string);
	}
	//管理员撤销操作
	public boolean ChexiaoTeam(String string) throws Exception {
		String sql="UPDATE `pute_mysql`.`team_pute` SET `team_ski` = 0 WHERE `teamid` = ?";
		return puteDao.zsg(sql,string);
	}
	
}	
