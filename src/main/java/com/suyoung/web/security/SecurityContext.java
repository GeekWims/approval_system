package com.suyoung.web.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityContext {

	public static UserInfo getLoginUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		return (UserInfo) auth.getPrincipal();
	}
}
