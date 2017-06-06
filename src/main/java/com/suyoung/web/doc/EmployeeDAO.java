package com.suyoung.web.doc;

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
}
