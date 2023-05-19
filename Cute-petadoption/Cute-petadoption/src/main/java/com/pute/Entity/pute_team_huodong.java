package com.pute.Entity;
//团队活动信息实体表
public class pute_team_huodong {
	private int huodong_id;
	private String huodong_name;
	private String state;
	private String eng;
	private String houdong_status;
	private String houdong_baifen;
	private int pute_team_id;
	public int getHuodong_id() {
		return huodong_id;
	}
	public void setHuodong_id(int huodong_id) {
		this.huodong_id = huodong_id;
	}
	public String getHuodong_name() {
		return huodong_name;
	}
	public void setHuodong_name(String huodong_name) {
		this.huodong_name = huodong_name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEng() {
		return eng;
	}
	public void setEng(String eng) {
		this.eng = eng;
	}
	public String getHoudong_status() {
		return houdong_status;
	}
	public void setHoudong_status(String houdong_status) {
		this.houdong_status = houdong_status;
	}
	public String getHoudong_baifen() {
		return houdong_baifen;
	}
	public void setHoudong_baifen(String houdong_baifen) {
		this.houdong_baifen = houdong_baifen;
	}
	public int getPute_team_id() {
		return pute_team_id;
	}
	public void setPute_team_id(int pute_team_id) {
		this.pute_team_id = pute_team_id;
	}
	public pute_team_huodong(int huodong_id, String huodong_name, String state, String eng, String houdong_status,
			String houdong_baifen, int pute_team_id) {
		super();
		this.huodong_id = huodong_id;
		this.huodong_name = huodong_name;
		this.state = state;
		this.eng = eng;
		this.houdong_status = houdong_status;
		this.houdong_baifen = houdong_baifen;
		this.pute_team_id = pute_team_id;
	}
	public pute_team_huodong() {
		// TODO Auto-generated constructor stub
	}
}
