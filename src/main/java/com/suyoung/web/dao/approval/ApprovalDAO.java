package com.suyoung.web.dao.approval;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ApprovalDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int insert(ApprovalVO approvalVO) {
		// TODO Auto-generated method stub
		return mybatis.insert("ApprovalDAO.insert", approvalVO);
	}

	public List<ApprovalVO> getApprovalList(int docId) {
		// TODO Auto-generated method stub
		return mybatis.selectList("ApprovalDAO.selectListByDocId", docId);
	}

	public int updateStatus(ApprovalVO approvalVO) {
		// TODO Auto-generated method stub
		
		return mybatis.update("ApprovalDAO.updateStatus", approvalVO);
	}
}
