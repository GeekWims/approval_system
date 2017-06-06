package com.suyoung.web.doc;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DocDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<DocVO> getDocList(DocVO vo) {
		return mybatis.selectList("DocDAO.getDocList", vo);
	}
}
