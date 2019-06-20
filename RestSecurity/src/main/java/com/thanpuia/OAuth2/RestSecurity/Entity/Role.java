package com.thanpuia.OAuth2.RestSecurity.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Role {
	

	@Id
	@Column(name="name")
	private String name;
	
	
	@ManyToMany(mappedBy = "role")
	private List<User> user;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return user;
	}

	public void setUsers(List<User> user) {
		this.user = user;
	}

	public Role(String name, List<User> user) {
		this.name = name;
		this.user = user;
	}

	public Role() {
	}

	public Role(String name) {
		this.name = name;
	}


}
