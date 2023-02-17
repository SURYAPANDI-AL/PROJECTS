package com.flight_ticket_reservation_system.dto;

public class User {
	private String username;
	private String emailId;
	private long phoneNo;
	private String password;
	
	public User(String username, String emailId, long phoneNo, String password) {
		super();
		this.username = username;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
