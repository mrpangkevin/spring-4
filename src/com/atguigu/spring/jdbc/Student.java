package com.atguigu.spring.jdbc;

public class Student {
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + name + ", gender=" + gender + "]";
	}
	private Integer sid;
	private String name;
	private String gender;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return name;
	}
	public void setSname(String sname) {
		this.name = sname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
