package com.thanpuia.OAuth2.RestSecurity.Service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.thanpuia.OAuth2.RestSecurity.Entity.Role;
import com.thanpuia.OAuth2.RestSecurity.Entity.User;
import com.thanpuia.OAuth2.RestSecurity.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void createUser(User user) {
		BCryptPasswordEncoder  encoder = new  BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword())); 
		Role userRole = new Role("USER");
		List<Role> role = new ArrayList<>();
		role.add(userRole);
		user.setRoles(role);
		userRepository.save(user);
	}
	
	public void createAdmin(User user) {
		BCryptPasswordEncoder  encoder = new  BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword())); 
		Role userRole = new Role("ADMIN");
		List<Role> role = new ArrayList<>();
		role.add(userRole);
		user.setRoles(role);
		userRepository.save(user);
	}
	
	public User findOne(String email) {
		
	  return userRepository.findByEmail(email);
	}

	public boolean isUserPresent(String email) {
		// TODO Auto-generated method stub
		User u=userRepository.findByEmail(email);
		if(u!=null)
			return true;
		
		return false;
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		return  userRepository.findByNameLike("%"+name+"%");
	}

}
