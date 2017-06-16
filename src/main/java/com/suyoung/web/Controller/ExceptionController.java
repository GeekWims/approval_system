package com.suyoung.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.suyoung.web.exception.PageNotFoundException;

@Controller
@RequestMapping("/error")
public class ExceptionController {

	@RequestMapping("/404")
	public void error404() throws Exception {
		throw (new PageNotFoundException());
	}
}
