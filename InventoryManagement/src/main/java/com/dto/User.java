package com.dto;

public class User {

	int userId;
	String name;
	String storeName;
	String email;
	long phNo;
	String password;
	public User(int userId, String name, String storeName, String email, long phNo) {
		super();
		this.userId = userId;
		this.name = name;
		this.storeName = storeName;
		this.email = email;
		this.phNo = phNo;
	}
	public User(String name, String storeName, String email, long phNo, String password) {
		super();
		this.name = name;
		this.storeName = storeName;
		this.email = email;
		this.phNo = phNo;
		this.password = password;
	}
	public User(int userId, String name, String storeName, String email, long phNo, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.storeName = storeName;
		this.email = email;
		this.phNo = phNo;
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhNo() {
		return phNo;
	}
	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
