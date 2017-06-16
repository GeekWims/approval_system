<<<<<<< HEAD:src/main/java/com/suyoung/web/dao/employee/AuthorityVO.java
package com.suyoung.web.dao.employee;
=======
package com.suyoung.web.doc;
>>>>>>> 61e684d19d8f059d0f7e0f8dc59f5eadf3f1b7db:src/main/java/com/suyoung/web/doc/AuthorityVO.java

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
