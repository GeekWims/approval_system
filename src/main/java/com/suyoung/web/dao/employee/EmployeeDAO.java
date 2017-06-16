package com.suyoung.web.dao.employee;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	public EmployeeVO getEmployeeByUsername(String username) {
		return mybatis.selectOne("EmployeeDAO.selectEmployeeByUsername", username);
	}

	public EmployeeVO getEmployeeById(int id) {
		return mybatis.selectOne("EmployeeDAO.selectEmployeeById", id);
	}
	
	public EmployeeVO getSuperior(EmployeeVO e) {
		return mybatis.selectOne("EmployeeDAO.getSuperior", e);
	}
}
