package com.pute.Entity;
//管理员宠物
public class admin_pute {
	private int admin_id;
	private String admin_name;
	private String admin_sex;
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_sex() {
		return admin_sex;
	}
	public void setAdmin_sex(String admin_sex) {
		this.admin_sex = admin_sex;
	}
	public int getAdmin_age() {
		return admin_age;
	}
	public void setAdmin_age(int admin_age) {
		this.admin_age = admin_age;
	}
	public String getAdmin_address() {
		return admin_address;
	}
	public void setAdmin_address(String admin_address) {
		this.admin_address = admin_address;
	}
	public String getAdmin_type() {
		return admin_type;
	}
	public void setAdmin_type(String admin_type) {
		this.admin_type = admin_type;
	}
	public String getAdmin_img() {
		return admin_img;
	}
	public void setAdmin_img(String admin_img) {
		this.admin_img = admin_img;
	}
	public String getAdmin_text() {
		return admin_text;
	}
	public void setAdmin_text(String admin_text) {
		this.admin_text = admin_text;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getAdmin_ski() {
		return admin_ski;
	}
	public void setAdmin_ski(int admin_ski) {
		this.admin_ski = admin_ski;
	}
	public String getAdmin_date() {
		return admin_date;
	}
	public void setAdmin_date(String admin_date) {
		this.admin_date = admin_date;
	}
	private int admin_age;
	private String admin_address;
	private String admin_type;
	private String admin_img;
	private String admin_text;
	private int userid;
	private int admin_ski;
	private String admin_date;
public admin_pute() {
	// TODO Auto-generated constructor stub
}
public admin_pute(int admin_id, String admin_name, String admin_sex, int admin_age, String admin_address,
		String admin_type, String admin_img, String admin_text, int userid, int admin_ski, String admin_date) {
	super();
	this.admin_id = admin_id;
	this.admin_name = admin_name;
	this.admin_sex = admin_sex;
	this.admin_age = admin_age;
	this.admin_address = admin_address;
	this.admin_type = admin_type;
	this.admin_img = admin_img;
	this.admin_text = admin_text;
	this.userid = userid;
	this.admin_ski = admin_ski;
	this.admin_date = admin_date;
}

}
