package com.generation.IntegraJa.seguranca;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Edgar Soares Marinho
 * @version 0.0.1
 * @since 0.0.1 - 04/02/2022 
 * 
 * */

public class UserDetailsImpl implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	private String email;
	private String senha;
	
	public UserDetailsImpl(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public UserDetailsImpl() {}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
