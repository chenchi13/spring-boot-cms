package com.example.demo.viewmodels;

public class UserViewModel {
	private Long id;
	private String username;
	private String password;
	private Boolean admin;
	
	public UserViewModel(Long id, String username, String password, Boolean admin) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.admin = admin;
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
	
	
}
