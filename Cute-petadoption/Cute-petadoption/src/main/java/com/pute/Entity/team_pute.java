package com.pute.Entity;

public class team_pute {
   private int teamid;
   private String team_name;
   private int team_age;
   private String team_type;
   private String team_sex;
   private String team_address;
   private String team_text;
   private String team_imgw;
   private int team_id;
   private int team_ski;
   private String team_date;
   private int team_iux;
public int getTeam_iux() {
	return team_iux;
}
public void setTeam_iux(int team_iux) {
	this.team_iux = team_iux;
}
public int getTeamid() {
	return teamid;
}
public void setTeamid(int teamid) {
	this.teamid = teamid;
}
public String getTeam_name() {
	return team_name;
}
public void setTeam_name(String team_name) {
	this.team_name = team_name;
}
public int getTeam_age() {
	return team_age;
}
public void setTeam_age(int team_age) {
	this.team_age = team_age;
}
public String getTeam_type() {
	return team_type;
}
public void setTeam_type(String team_type) {
	this.team_type = team_type;
}
public String getTeam_sex() {
	return team_sex;
}
public void setTeam_sex(String team_sex) {
	this.team_sex = team_sex;
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
public String getTeam_imgw() {
	return team_imgw;
}
public void setTeam_imgw(String team_imgw) {
	this.team_imgw = team_imgw;
}
public int getTeam_id() {
	return team_id;
}
public void setTeam_id(int team_id) {
	this.team_id = team_id;
}
public int getTeam_ski() {
	return team_ski;
}
public void setTeam_ski(int team_ski) {
	this.team_ski = team_ski;
}
public String getTeam_date() {
	return team_date;
}
public void setTeam_date(String team_date) {
	this.team_date = team_date;
}
public team_pute() {
	// TODO Auto-generated constructor stub
}
public team_pute(int teamid, String team_name, int team_age, String team_type, String team_sex, String team_address,
		String team_text, String team_imgw, int team_id, int team_ski, String team_date,int user_id,int team_iux) {
	super();
	this.teamid = teamid;
	this.team_name = team_name;
	this.team_age = team_age;
	this.team_type = team_type;
	this.team_sex = team_sex;
	this.team_address = team_address;
	this.team_text = team_text;
	this.team_imgw = team_imgw;
	this.team_id = team_id;
	this.team_ski = team_ski;
	this.team_date = team_date;
	this.user_id=user_id;
	this.team_iux=team_iux;
}
private int user_id;
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}



}
