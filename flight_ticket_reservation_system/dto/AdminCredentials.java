package com.flight_ticket_reservation_system.dto;

public class AdminCredentials extends Admin{
	private String password;
	
	public AdminCredentials(String userId, String userName, String password) {
		super.setUserId(userId);
		super.setUserName(userName);
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

