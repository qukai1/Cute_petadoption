package com.pute.Entity;

public class pute_team {
	private int team_id;
	private String team_name;
	private String team_date;
	private String team_img;
	private String team_address;
	private String team_text;
	private String team_phone;
	private int userid;
	private int team_num;
	private int pute_num;
	public int getTeam_num() {
		return team_num;
	}
	public void setTeam_num(int team_num) {
		this.team_num = team_num;
	}
	public int getPute_num() {
		return pute_num;
	}
	public void setPute_num(int pute_num) {
		this.pute_num = pute_num;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getTeam_phone() {
		return team_phone;
	}
	public void setTeam_phone(String team_phone) {
		this.team_phone = team_phone;
	}
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getTeam_date() {
		return team_date;
	}
	public void setTeam_date(String team_date) {
		this.team_date = team_date;
	}
	public String getTeam_img() {
		return team_img;
	}
	public void setTeam_img(String team_img) {
		this.team_img = team_img;
	}
	public String getTeam_address() {
		return team_address;
	}
	public void setTeam_address(String team_address) {
		this.team_address = team_address;
	}
	public String getTeam_text() {
		return team_text;
	}
	public void setTeam_text(String team_text) {
		this.team_text = team_text;
	}
	public pute_team(int team_id, String team_name, String team_date, String team_img, String team_address,
			String team_text,String phone,int userid,int team_num,int pute_num) {
		super();
		this.team_id = team_id;
		this.team_name = team_name;
		this.team_date = team_date;
		this.team_img = team_img;
		this.team_address = team_address;
		this.team_text = team_text;
		this.team_phone=phone;
		this.userid=userid;
		this.pute_num=pute_num;
		this.team_num=team_num;
	}
public pute_team() {
	// TODO Auto-generated constructor stub
}
}
