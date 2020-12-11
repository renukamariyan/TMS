 package com.tms.model;

public class CustomerLogin {
	private int userId;
	private String userPassword;
	
	public CustomerLogin() {
		
	}
	public CustomerLogin(int userId, String userPassword) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getuserPassword() {
		return userPassword;
	}
	public void setuserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
}
