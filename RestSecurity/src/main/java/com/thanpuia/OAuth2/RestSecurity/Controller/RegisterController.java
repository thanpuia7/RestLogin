package com.thanpuia.OAuth2.RestSecurity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.thanpuia.OAuth2.RestSecurity.Entity.User;
import com.thanpuia.OAuth2.RestSecurity.Repository.UserRepository;
import com.thanpuia.OAuth2.RestSecurity.Service.UserService;

@RestController
@RequestMapping("/register")
public class RegisterController {

	

	@Autowired
	private UserService userService;
	
	
	private UserRepository userRepository;
	
	
	@Autowired
	public RegisterController(UserRepository theuserRepository) {
		userRepository = theuserRepository;
	}
	
	
	@PostMapping("/users")
	public String addUser(@RequestBody User theUser) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
//		theUser.setId(0);
		
		if(userService.isUserPresent(theUser.getEmail())) 

			return "ex";

	else
				
		userService.createUser(theUser);
		
		return "User added successfull";
		
	}

	
	// add mapping for PUT /users - update existing employee
	
		@PutMapping("/users")
		public User updateEmployee(@RequestBody User theUser) {
			
			userRepository.save(theUser);
			
			return theUser;
		}
		
	
		
	}


