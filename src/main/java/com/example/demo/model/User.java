package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String password;
	private Boolean admin;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = 
	@JoinColumn(name = "user_id"), inverseJoinColumns = 
	@JoinColumn(name = "role_id"))
	private List<Role> roles;
	
	public User() {
		// empty
	}
	
	public User(String username, String password, Boolean admin) {
		this.username = username;
		this.password = password;
		this.admin = admin;
	}
	
	public User(String username, String password, Boolean admin, List<Role> roles) {
		this.username = username;
		this.password = password;
		this.admin = admin;
		this.roles = roles;
	}
	
	public User(User user) {
		this.id = user.id;
		this.username = user.username;
		this.password = user.password;
		this.admin = user.admin;
		this.roles = user.roles;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
