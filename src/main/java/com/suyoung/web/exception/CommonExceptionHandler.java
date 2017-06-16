package com.suyoung.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {

	@ExceptionHandler(PageNotFoundException.class)
	public String pageNotFoundException() {
		return "error";
	}
}
