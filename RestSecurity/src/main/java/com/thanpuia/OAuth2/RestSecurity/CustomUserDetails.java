package com.thanpuia.OAuth2.RestSecurity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.thanpuia.OAuth2.RestSecurity.Entity.Role;
import com.thanpuia.OAuth2.RestSecurity.Entity.User;

public class CustomUserDetails implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String userpassword;
	
	Collection<?extends GrantedAuthority> authorities;
	
	public CustomUserDetails(User byUseremail)
	{
		this.username=byUseremail.getEmail();
		this.userpassword=byUseremail.getPassword();
		List<GrantedAuthority>auths=new ArrayList<>();
		for (Role role: byUseremail.getRoles())
			auths.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
		this.authorities=auths;
		
		

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userpassword;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
