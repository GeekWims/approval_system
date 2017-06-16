package com.suyoung.web.service.document;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suyoung.web.dao.document.DocDAO;
import com.suyoung.web.dao.document.DocVO;
import com.suyoung.web.security.UserInfo;
import com.suyoung.web.service.approval.ApprovalService;

@Service
public class DocService {
	
	@Autowired
	private DocDAO docDAO;
	
	@Autowired
	private ApprovalService approvalService;
	
	public void create(DocVO cmd) {
		
		cmd.setStatus("진행중");
		
		int docID = docDAO.insert(cmd);
		
		System.out.println(cmd.toString());
		
		approvalService.createNextApproval(cmd.getId(), cmd.getWriter());
	}

	public List<String> getDocTypes() {
		return docDAO.getDocTypeList();
	}

	public DocVO getDoc(int docId) {
		
		return docDAO.getDocList(docId);
	}

	public List<DocVO> getRequestDocList(UserInfo user) {
		
		return docDAO.getRequestDocList(user.getId());
	}

	public void update(DocVO docVO) {
		docDAO.update(docVO);
	}
	
	public void delete(int id) {
		docDAO.delete(id);
	}
}
