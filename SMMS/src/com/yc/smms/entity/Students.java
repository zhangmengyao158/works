package com.yc.smms.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Students {

	private Integer sno;
 	private String clname;	
	private String sname;	
	private String ssex;	
	private Date bornDate; 
	private String tel;	
	private String address;	
	private Date  ru_date;	
 	 
	public Students() {
 	}
	

	public Students(Integer sno, String clname, String sname, String ssex,
			Date bornDate, String tel, String address, Date ru_date) {
		this.sno = sno;
		this.clname = clname;
		this.sname = sname;
		this.ssex = ssex;
		this.bornDate = bornDate;
		this.tel = tel;
		this.address = address;
		this.ru_date = ru_date;
	}


	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public String getClname() {
		return clname;
	}

	public void setClname(String clname) {
		this.clname = clname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSsex() {
		return ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getRu_date() {
		return ru_date;
	}

	public void setRu_date(Date ru_date) {
		this.ru_date = ru_date;
	}

	@Override
	public String toString() {
		return "Students [sno=" + sno + ", clname=" + clname + ", sname="
				+ sname + ", ssex=" + ssex + ", bornDate=" + bornDate
				+ ", tel=" + tel + ", address=" + address + ", ru_date="
				+ ru_date + "]";
	}
	
	
	 
	 
	
	
	
 
}
