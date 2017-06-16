package com.suyoung.web.security;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityImpl implements GrantedAuthority {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
	
=======
>>>>>>> 61e684d19d8f059d0f7e0f8dc59f5eadf3f1b7db
	private String authority;
	
	

	public GrantedAuthorityImpl(String authority) {
		super();
		this.authority = authority;
	}


	public void setAuthority(String authority) {
		this.authority = authority;
	}


	@Override
	public String getAuthority() {
		return authority;
	}

}
