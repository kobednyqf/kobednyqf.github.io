package com.model;
 

public class User {
	 
	private String username;
	private String password; 
	  
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
	 
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User( String username,
			String password) {
		// TODO Auto-generated constructor stub 
		this.username = username;
		this.password = password;
	} 
  
	 

}
