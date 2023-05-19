package com.pute.Entity;
	//�û�ʵ����
public class User {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String name;
	private String pwd;
	private int userID;//�û�id�ж��û��Ƿ�Ϊ����Ա2
	private String phone;
	private String address;
	private String text;
	private String img;
	private int state;
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	

public User(int id, String name, String pwd, int userID, String phone, String address, String text, String img,
			int state) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.userID = userID;
		this.phone = phone;
		this.address = address;
		this.text = text;
		this.img = img;
		this.state = state;
	}
public User() {
	// TODO Auto-generated constructor stub
}
}
