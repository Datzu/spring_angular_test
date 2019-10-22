package com.example.demo.api.model;

public class UserLogin {
	
    private final String username;
    private final String password;
    
	public UserLogin() {
		super();
		this.username = "";
		this.password = "";
	}
    
	public UserLogin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "UserLogin [username=" + username + ", password=" + password + "]";
	}
    
}
