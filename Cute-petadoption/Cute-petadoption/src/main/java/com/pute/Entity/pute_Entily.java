package com.pute.Entity;

public class pute_Entily {
	//宠物信息实体类
	private int id;
	private String pute_name;
	private String pute_sex;
	private int pute_age;
	private String pute_type;
	private String pute_text;
	private String pute_address;
	private String pute_img;
	private int user_id;
	private int pute_ski;
	private String pute_date;
	private int pute_iux;
	public int getPute_iux() {
		return pute_iux;
	}
	public void setPute_iux(int pute_iux) {
		this.pute_iux = pute_iux;
	}
	public String getPute_date() {
		return pute_date;
	}
	public void setPute_date(String pute_date) {
		this.pute_date = pute_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPute_name() {
		return pute_name;
	}
	public void setPute_name(String pute_name) {
		this.pute_name = pute_name;
	}
	public String getPute_sex() {
		return pute_sex;
	}
	public void setPute_sex(String pute_sex) {
		this.pute_sex = pute_sex;
	}
	public int getPute_age() {
		return pute_age;
	}
	public void setPute_age(int pute_age) {
		this.pute_age = pute_age;
	}
	public String getPute_type() {
		return pute_type;
	}
	public void setPute_type(String pute_type) {
		this.pute_type = pute_type;
	}
	public String getPute_text() {
		return pute_text;
	}
	public void setPute_text(String pute_text) {
		this.pute_text = pute_text;
	}
	public String getPute_address() {
		return pute_address;
	}
	public void setPute_address(String pute_address) {
		this.pute_address = pute_address;
	}
	public String getPute_img() {
		return pute_img;
	}
	public void setPute_img(String pute_img) {
		this.pute_img = pute_img;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getPute_ski() {
		return pute_ski;
	}
	public void setPute_ski(int pute_ski) {
		this.pute_ski = pute_ski;
	}
	public pute_Entily(int id, String pute_name, String pute_sex, int pute_age, String pute_type, String pute_text,
			String pute_address, String pute_img, int user_id,int pute_ski,String pute_date,int pute_iux) {
		super();
		this.id = id;
		this.pute_name = pute_name;
		this.pute_sex = pute_sex;
		this.pute_age = pute_age;
		this.pute_type = pute_type;
		this.pute_text = pute_text;
		this.pute_address = pute_address;
		this.pute_img = pute_img;
		this.user_id = user_id;
		this.pute_ski = pute_ski;
		this.pute_date=pute_date;
		this.pute_iux=pute_iux;
	}
public pute_Entily() {
	// TODO Auto-generated constructor stub
}
}
