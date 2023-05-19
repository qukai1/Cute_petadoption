package com.pute.lingyang;

import com.pute.Dao.puteDao;
import com.pute.Entity.lingyang;
//领养申请状态类
public class Iingyang {

	//添加进领养表，并在对应领养宠物进行标记提醒
	public boolean LingYang(lingyang ly) throws Exception {
		String sql="INSERT INTO `pute_mysql`.`lingyangbiao`(`lingyangrenid`, `suoshurenid`, `suoshubiao`, `biaoid`) VALUES (?,?,?,?)";
		//调用对应宠物表进行领养有人申请状态更改
		if (ly.getSuoshubiao().equals("team_pute")) {
			team_pute(ly.getLingyangrenid(),ly.getBiaoid());
		} else if(ly.getSuoshubiao().equals("pute_pet")){
			pute_pet(ly.getLingyangrenid(),ly.getBiaoid());
		}
		return puteDao.zsg(sql,ly.getLingyangrenid(),ly.getSuoshurenid(),ly.getSuoshubiao(),ly.getBiaoid());
	}
	
	

	private void pute_pet(int lingyangrenid, int lingyangid) throws Exception {
		String sql="UPDATE `pute_mysql`.`pute_pet` SET `pute_iux` = ? WHERE `pute_id` = ?";
		System.out.println("pute_pet宠物申请状态"+puteDao.zsg(sql,lingyangrenid,lingyangid));
	}
	//执行更新操作将领养人id插入到team_ux状态表中方便后续绑定
	private void team_pute(int lingyangrenid,int team_id) throws Exception {
		String sql="UPDATE `pute_mysql`.`team_pute` SET `team_iux` =? WHERE `teamid` = ?";
		System.out.println("team_pute宠物申请状态"+puteDao.zsg(sql,lingyangrenid,team_id));
	}

}
