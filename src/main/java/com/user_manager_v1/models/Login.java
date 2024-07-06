package com.user_manager_v1.models;

public class Login {

	private String email;
	private String password;
	
	// Get Methods
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	
	// Set Methods
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
