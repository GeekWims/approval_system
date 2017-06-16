package com.suyoung.web.service.approval;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suyoung.web.dao.approval.ApprovalDAO;
import com.suyoung.web.dao.approval.ApprovalVO;
import com.suyoung.web.dao.document.DocDAO;
import com.suyoung.web.dao.employee.EmployeeDAO;
import com.suyoung.web.dao.employee.EmployeeVO;
import com.suyoung.web.security.UserInfo;

@Service
public class ApprovalService {

	@Autowired
	private DocDAO docDAO;
	
	@Autowired
	private ApprovalDAO approvalDAO;
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	public int createNextApproval(int docid, int userid) {
		
		EmployeeVO e = employeeDAO.getEmployeeById(userid); 
		
		EmployeeVO superior = employeeDAO.getSuperior(e);
		
		if (superior == null) {
			
			docDAO.updateStatus(docid, "최종 승인");
			
			return 0;
		}
		
		ApprovalVO approvalVO = new ApprovalVO(); 
		
		approvalVO.setPersonInCharge(superior.getId());
		approvalVO.setDocId(docid);
		approvalVO.setStatus("대기");
		
		return approvalDAO.insert(approvalVO);
	}
	
	
	public List<ApprovalVO> getApprovalList(int docId) {
		return approvalDAO.getApprovalList(docId);
	}


	public void approval(int docId, UserInfo userInfo) {
		
		ApprovalVO vo = new ApprovalVO();
		
		vo.setDocId(docId);
		vo.setPersonInCharge(userInfo.getId());
		vo.setStatus("승인");
		
		approvalDAO.updateStatus(vo);
		
		createNextApproval(docId, userInfo.getId());
	}


	public void reject(int docId, UserInfo userInfo) {
		// TODO Auto-generated method stub

		ApprovalVO vo = new ApprovalVO();
		
		vo.setDocId(docId);
		vo.setPersonInCharge(userInfo.getId());
		vo.setStatus("반려");
		
		approvalDAO.updateStatus(vo);

		docDAO.updateStatus(docId, "반려");
	}
}
