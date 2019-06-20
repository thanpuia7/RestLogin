package com.thanpuia.OAuth2.RestSecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thanpuia.OAuth2.RestSecurity.Entity.Role;

@Repository
public interface RoleRepository  extends JpaRepository<Role, String>{
	 
}

