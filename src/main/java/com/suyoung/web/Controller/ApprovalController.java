package com.suyoung.web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.suyoung.web.security.SecurityContext;
import com.suyoung.web.security.UserInfo;
import com.suyoung.web.service.approval.ApprovalService;

@Controller
public class ApprovalController {

	
	@Autowired
	private ApprovalService approvalService;

	@RequestMapping("/approval/{docId}")
	public String approval(@PathVariable int docId) {
		
		UserInfo userInfo = SecurityContext.getLoginUser();
		
		approvalService.approval(docId, userInfo);
		
		return "redirect:/doc/view/" + docId;
	}
	
	@RequestMapping("/reject/{docId}")
	public String reject(@PathVariable int docId) {
		
		UserInfo userInfo = SecurityContext.getLoginUser();
		
		approvalService.reject(docId, userInfo);
		
		return "redirect:/doc/view/" + docId;
	}
}
