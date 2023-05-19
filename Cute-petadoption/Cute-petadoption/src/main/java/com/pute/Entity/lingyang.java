package com.pute.Entity;
//领养状态表
public class lingyang {
	private int lingyangid;//当前表id
	private int lingyangrenid;//领养人id
	private int suoshurenid;//所属人id
	private String suoshubiao;//所属表
	private int biaoid;//所属表id
	public int getLingyangid() {
		return lingyangid;
	}
	public void setLingyangid(int lingyangid) {
		this.lingyangid = lingyangid;
	}
	public int getLingyangrenid() {
		return lingyangrenid;
	}
	public void setLingyangrenid(int lingyangrenid) {
		this.lingyangrenid = lingyangrenid;
	}
	public int getSuoshurenid() {
		return suoshurenid;
	}
	public void setSuoshurenid(int suoshurenid) {
		this.suoshurenid = suoshurenid;
	}
	public String getSuoshubiao() {
		return suoshubiao;
	}
	public void setSuoshubiao(String suoshubiao) {
		this.suoshubiao = suoshubiao;
	}
	public int getBiaoid() {
		return biaoid;
	}
	public void setBiaoid(int biaoid) {
		this.biaoid = biaoid;
	}
public lingyang() {
	// TODO Auto-generated constructor stub
}
public lingyang(int lingyangid, int lingyangrenid, int suoshurenid, String suoshubiao, int biaoid) {
	super();
	this.lingyangid = lingyangid;
	this.lingyangrenid = lingyangrenid;
	this.suoshurenid = suoshurenid;
	this.suoshubiao = suoshubiao;
	this.biaoid = biaoid;
}

}
