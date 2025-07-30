package com.example.maverickBank.dto;

public class AuthRequest {
	private String email;
	private String password;
	
	//Getters and Setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	//Constructors
	public AuthRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public AuthRequest() {
		// TODO Auto-generated constructor stub
	}
}
