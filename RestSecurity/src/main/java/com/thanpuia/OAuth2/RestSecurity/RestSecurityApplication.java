package com.thanpuia.OAuth2.RestSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.thanpuia.OAuth2.RestSecurity.Entity.User;
import com.thanpuia.OAuth2.RestSecurity.Repository.UserRepository;
import com.thanpuia.OAuth2.RestSecurity.Service.UserService;



@SpringBootApplication
public class RestSecurityApplication implements CommandLineRunner{

	
	
	@Autowired
	private UserService userService; 
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(RestSecurityApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		  {
    		  User newAdmin = new User("admin@gmail.com", "Admin", "123456");
    		  userService.createAdmin(newAdmin); 
    	  }
	}
	
	
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repo) throws Exception{
		
		builder.userDetailsService(new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException{
				
				
				return new CustomUserDetails(repo.findByEmail(s));
			}
		});
		
		
		
		
	}
}
