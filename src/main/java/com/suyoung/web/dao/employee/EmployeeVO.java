package com.suyoung.web.dao.employee;

import java.util.List;

public class EmployeeVO {
	private int id;
	private String name;
	private String phone;
	private String username;
	private String password;
	private String team;
	
	// Foreign key
	private int order; 
	private List<AuthorityVO> authorities;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AuthorityVO> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<AuthorityVO> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "EmployeeVO [id=" + id + ", name=" + name + ", phone=" + phone + ", username=" + username + ", password="
				+ password + ", authorities=" + authorities + "]";
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
}
