package com.car_parking_management.dto;

public class User {
	//user->name,contact number,mail,password.
	private String userName;
	private long contactNumber;
	private String mailId;
	private String password;
	public User(String userName, long contactNumber, String mailId, String password) {
		super();
		this.userName = userName;
		this.contactNumber = contactNumber;
		this.mailId = mailId;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
