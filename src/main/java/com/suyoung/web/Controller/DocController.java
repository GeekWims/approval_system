package com.suyoung.web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.suyoung.web.command.DocValidator;
import com.suyoung.web.dao.approval.ApprovalVO;
import com.suyoung.web.dao.document.DocDAO;
import com.suyoung.web.dao.document.DocVO;
import com.suyoung.web.security.SecurityContext;
import com.suyoung.web.security.UserInfo;
import com.suyoung.web.service.approval.ApprovalService;
import com.suyoung.web.service.document.DocService;

@Controller
@RequestMapping("/doc")
public class DocController {

	@Autowired
	private DocService docService;
	
	@Autowired
	private ApprovalService approvalService;
	
	@ModelAttribute("docTypeList")
	public List<String> docTypeList() {
		return docService.getDocTypes();
	}
	

	@RequestMapping("/insert")
	public String insert(@ModelAttribute("doc") DocVO docVO) {
		
		return "docForm";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insertProc(@ModelAttribute("doc") DocVO docVO, BindingResult bindingResult) {
		
		new DocValidator().validate(docVO, bindingResult);
		
		if (bindingResult.hasErrors()) {
			return "docForm";
		}
		
		docVO.setWriter(SecurityContext.getLoginUser().getId());
		
		docService.create(docVO);
		
		return "redirect:/";
	}
	

	@RequestMapping("/update/{docId}")
	public String update(@PathVariable int docId, Model model) {
				
		model.addAttribute("doc", docService.getDoc(docId));
		
		return "docForm";
	}
	
	@RequestMapping(value="/update/{docId}", method=RequestMethod.POST)
	public String updateProc(@ModelAttribute("doc") DocVO docVO, BindingResult bindingResult, @PathVariable int docId) {
		
		new DocValidator().validate(docVO, bindingResult);
		
		if (bindingResult.hasErrors()) {
			return "docForm";
		}
		
		docVO.setWriter(SecurityContext.getLoginUser().getId());
		
		docVO.setId(docId);
		docService.update(docVO);
		
		return "redirect:/";
	}
	

	@RequestMapping("/view/{docId}")
	public String view(@PathVariable int docId, Model model) {
		
		UserInfo user = SecurityContext.getLoginUser();
		DocVO doc = docService.getDoc(docId);
		
		List<ApprovalVO> approvalList = approvalService.getApprovalList(docId); 
		
		model.addAttribute("doc", doc);
		model.addAttribute("approvalList", approvalList);
		model.addAttribute("loginUser", user);
		
		boolean isInCharge = false; // 본인이 책임자인지 여부
		boolean isAllowed = (user.getId() == doc.getWriter());  // 수정 가능한지 여부
		
		for (ApprovalVO approval : approvalList) {
			if ("대기".equals(approval.getStatus()) && approval.getPersonInCharge() == user.getId()) {
				isInCharge = true;
			}
			
			if ("승인".equals(approval.getStatus())) {
				isAllowed = false;
			}
		}
		
		model.addAttribute("isInCharge", isInCharge);
		model.addAttribute("isAllowed", isAllowed);
		
		return "docView";
	}


	@RequestMapping("/delete/{docId}")
	public String delete(@PathVariable int docId, Model model) {

		List<ApprovalVO> approvalList = approvalService.getApprovalList(docId); 

		boolean isAllowed = true;  // 수정 가능한지 여부
		
		for (ApprovalVO approval : approvalList) {			
			if ("승인".equals(approval.getStatus())) {
				isAllowed = false;
			}
		}
		
		if (!isAllowed) return "redirect:/";
		
		docService.delete(docId);
		
		return "redirect:/";
	}
	
	@RequestMapping("/request")
	public String request(Model model) {
				
		UserInfo user = SecurityContext.getLoginUser();
		
		model.addAttribute("loginUser", user);
		model.addAttribute("docList", docService.getRequestDocList(user));
		
		return "requestList";
	}
}
