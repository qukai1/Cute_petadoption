package com.pute.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.pute.Entity.User;
import com.pute.Entity.pute_Entily;

public class Addpute {
	//用户转养宠物
	public boolean Addpute_pet(pute_Entily pe) throws Exception {
		String sql="INSERT INTO `pute_mysql`.`pute_pet`(`pute_name`, `pute_sex`, `pute_age`, `pute_type`, `pute_text`, `pute_address`, `pute_img`, `user_id`, `pute_ski`, `pute_date`) VALUES (?, ?, ?,?, ?,?,?,?, ?,now())";
		return puteDao.zsg(sql,pe.getPute_name(),pe.getPute_sex(),pe.getPute_age(),pe.getPute_type(),pe.getPute_text(),pe.getPute_address(),pe.getPute_img(),pe.getUser_id(),pe.getPute_ski());
	}
	//用户更新宠物资料
	public boolean Updatepute_pet(pute_Entily pe) throws Exception {
		String sql="UPDATE `pute_mysql`.`pute_pet` SET pute_name = ?,pute_sex =?, `pute_age` = ?, `pute_type` = ?, `pute_text` = ?, `pute_address` = ?, `pute_img` = ? WHERE `pute_id` = ?";
		return puteDao.zsg(sql,pe.getPute_name(),pe.getPute_sex(),pe.getPute_age(),pe.getPute_type(),pe.getPute_text(),pe.getPute_address(),pe.getPute_img(),pe.getId());
	}
	//用户修改自己的资料
	public boolean Updatepute_User(User pe) throws Exception {
		String sql="UPDATE `pute_mysql`.`user` SET `name` = ?, `pwd` = ?, `Phone` = ?, `address` = ?, `text` = ?, `img` = ?  WHERE `user_id` = ? ";
		return puteDao.zsg(sql,pe.getName(),pe.getPwd(),pe.getPhone(),pe.getAddress(),pe.getText(),pe.getImg(),pe.getId());
	}
	//志愿者申请
		public boolean addPute(String name, String address, String text, String phone) {
			Connection conn = null;
			PreparedStatement pStat = null;
			try {
				String sql = "INSERT zhiyuanzhe(zhiyuan_name,zhiyuan_address,zhiyuan_text,zhiyuan_phone) VALUES(?,?,?,?)";
				conn = com.pute.DButils.DBConn.getConn();
				pStat = (PreparedStatement) conn.prepareStatement(sql);
				pStat.setString(1, name);
				pStat.setString(2, address);
				pStat.setString(3, text);
				pStat.setString(4, phone);
				if (pStat.executeUpdate() > 0) {
					return true;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return false;
		}
}
