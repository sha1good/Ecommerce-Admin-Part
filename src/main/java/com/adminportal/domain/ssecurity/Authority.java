package com.adminportal.domain.ssecurity;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
	
	private final String authority;
	
	public Authority(String auth) {
		this.authority=auth;
	}

	@Override
	public String getAuthority() {
		
		return authority;
	}

}
