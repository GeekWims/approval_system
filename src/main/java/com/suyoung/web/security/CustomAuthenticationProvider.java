package com.suyoung.web.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.suyoung.web.doc.AuthorityVO;
import com.suyoung.web.doc.EmployeeDAO;
import com.suyoung.web.doc.EmployeeVO;

@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private EmployeeDAO employeeDao;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		
		UserInfo userInfo = findUser(token.getName());
		
		if (userInfo == null) throw new UsernameNotFoundException(token.getName());
		
		if (!matchPassword(userInfo.getPassword(), token.getCredentials())) {
			throw new BadCredentialsException("not matching username or password");
		}
		
		List<GrantedAuthority> authorities = getAuthorities(userInfo); 
		
		userInfo.setPassword(null);
		
		return new UsernamePasswordAuthenticationToken(userInfo, null, authorities);
	}

	private UserInfo findUser(String name) {
		
		UserInfo userInfo = new UserInfo();
		EmployeeVO employee = employeeDao.getEmployeeByUsername(name);
		
		if (employee == null) return null;
		
		userInfo.setId(employee.getId());
		userInfo.setName(employee.getName());
		userInfo.setPhone(employee.getPhone());
		userInfo.setUsername(employee.getUsername());
		userInfo.setPassword(employee.getPassword());
		
		List<String> authorities = new ArrayList<>();
		employee.getAuthorities().forEach((AuthorityVO t) -> {
			authorities.add(t.getRole());
		});
		
		userInfo.setAuthorities(authorities);
		
		return userInfo;
	}

	private boolean matchPassword(String pw, Object credentials) {
		return pw.equals(credentials);
	}
	
	private List<GrantedAuthority> getAuthorities(UserInfo userInfo) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		userInfo.getAuthorities().forEach((String t) -> {
			authorities.add(new GrantedAuthorityImpl(t));
		});
		
		return authorities;
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
	
}
