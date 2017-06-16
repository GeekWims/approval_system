package com.suyoung.web.command;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.suyoung.web.dao.document.DocVO;

public class DocValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return DocVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		DocVO doc = (DocVO) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "required");

	}

}
