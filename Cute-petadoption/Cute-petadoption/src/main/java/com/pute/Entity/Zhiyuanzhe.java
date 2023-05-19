package com.pute.Entity;

public class Zhiyuanzhe {
	private int id;
	private String name;
	private String img;
	private String address;
	private String text;
	private int age;
	private String sex;
	private String phone;
	private int team_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	public Zhiyuanzhe(int id, String name, String img, String address, String text, int age, String sex, String phone,
			int team_id) {
		super();
		this.id = id;
		this.name = name;
		this.img = img;
		this.address = address;
		this.text = text;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
		this.team_id = team_id;
	}
public Zhiyuanzhe() {
	// TODO Auto-generated constructor stub
}
}
