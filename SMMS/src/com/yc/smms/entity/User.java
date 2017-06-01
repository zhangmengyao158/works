package com.yc.smms.entity;

public class User{
	private Integer usid;
	private String uname;
	private String upwd;
	private String sex;
	private Integer tel;
	private String user_drop;

	@Override
	public String toString() {
		return "User [usid=" + usid + ", uname=" + uname + ", upwd=" + upwd + ", sex=" + sex + ", tel=" + tel
				+ ", user_drop=" + user_drop + "]";
	}

	public String getUser_drop() {
		return user_drop;
	}

	public void setUser_drop(String user_drop) {
		this.user_drop = user_drop;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
 

	public Integer getTel() {
		return tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

	public Integer getUsid() {
		return usid;
	}
	public void setUsid(Integer usid) {
		this.usid = usid;
	}
	public String getUname() {
		return uname; 
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
 

	 
	
		
	 
}