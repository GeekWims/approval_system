package com.suyoung.web.dao.document;

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
	
	public int insert(DocVO vo) {
		return mybatis.insert("DocDAO.insert", vo);
	}

	public List<String> getDocTypeList() {
		return mybatis.selectList("DocDAO.getAllDocTypes");
	}

	public DocVO getDocList(int docId) {
		return mybatis.selectOne("DocDAO.getDoc", docId);
	}

	public List<DocVO> getRequestDocList(int userid) {
		return mybatis.selectList("DocDAO.getRequestDocs", userid);
	}

	public void updateStatus(int docid, String string) {
		
		DocVO vo = new DocVO();
		
		vo.setId(docid);
		vo.setStatus(string);
		
		mybatis.update("DocDAO.updateStatus", vo);
	}

	public List<DocVO> getMyDocList(DocVO vo) {
		
		return mybatis.selectList("DocDAO.getMyDocList", vo);
	}

	public void update(DocVO vo) {
		mybatis.update("DocDAO.update", vo);
	}
	
	public void delete(int id) {
		mybatis.update("DocDAO.delete", id);
	}
}
