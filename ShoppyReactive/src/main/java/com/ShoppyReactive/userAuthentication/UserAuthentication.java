package com.ShoppyReactive.userAuthentication;

public class UserAuthentication {

	private String email;
	private String password;
	public UserAuthentication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserAuthentication(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
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
	@Override
	public String toString() {
		return "UserAuthentication [email=" + email + ", password=" + password + "]";
	}
	
	
	
}
