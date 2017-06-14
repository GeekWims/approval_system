package com.suyoung.web.doc;

public class AuthorityVO {
	private int id;
	private String role;
	private int employee;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getEmployee() {
		return employee;
	}
	public void setEmployee(int employee) {
		this.employee = employee;
	}
	
	@Override
	public String toString() {
		return "AuthorityVO [id=" + id + ", role=" + role + ", employee=" + employee + "]";
	}
	
}
