 package com.yc.smms.entity;

 public class Grade{
	 private Integer gid;
	 private Integer sno;
	 private Integer cno;
	 private Integer score;
	 
	 
	public Grade() {
 	}
	
	public Grade(Integer gid, Integer sno, Integer cno, Integer score) {
 		this.gid = gid;
		this.sno = sno;
		this.cno = cno;
		this.score = score;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public Integer getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Grade [gid=" + gid + ", sno=" + sno + ", cno=" + cno
				+ ", score=" + score + "]";
	}
	 
	 
	 
	 
 }
 