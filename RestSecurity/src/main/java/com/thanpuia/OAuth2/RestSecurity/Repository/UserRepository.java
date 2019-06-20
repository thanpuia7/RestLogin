package com.thanpuia.OAuth2.RestSecurity.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thanpuia.OAuth2.RestSecurity.Entity.User;


@Repository
public interface UserRepository  extends JpaRepository<User, String> {

	List<User> findByNameLike(String name);

	User findByEmail(String email); 

}
