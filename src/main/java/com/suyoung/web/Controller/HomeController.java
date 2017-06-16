package com.suyoung.web.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.suyoung.web.dao.document.DocDAO;
import com.suyoung.web.dao.document.DocVO;
import com.suyoung.web.dao.employee.EmployeeDAO;
import com.suyoung.web.exception.PageNotFoundException;
import com.suyoung.web.security.SecurityContext;
import com.suyoung.web.security.UserInfo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private DocDAO docDAO;
	
	@Autowired
	private EmployeeDAO employeeDao;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		UserInfo userInfo = SecurityContext.getLoginUser();
		DocVO vo = new DocVO();
		
		vo.setTitle("%%");
		vo.setWriter(userInfo.getId());
		
		List<DocVO> docList = docDAO.getMyDocList(vo);
		
		logger.info("DocList : {}", docList.toString());
		model.addAttribute("docList", docList);
		
		return "documentList";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Locale locale, Model model) throws PageNotFoundException {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		DocVO vo = new DocVO();		
		vo.setTitle("%%");
		
		List<DocVO> docList = docDAO.getDocList(vo);
		
		logger.info("DocList : {}", docList.toString());
		model.addAttribute("docList", docList);
		
		logger.info("User : {}", employeeDao.getEmployeeByUsername("suyoung154"));
		
		throw (new PageNotFoundException());
		
	}
	
}
