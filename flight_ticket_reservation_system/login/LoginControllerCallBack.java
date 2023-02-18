package com.flight_ticket_reservation_system.login;

public interface LoginControllerCallBack {

	void checkChoice(int choice);

	void checkCredentials(String userId, String password);

	void addFlight(int flightNumber, String flightName, String source, String destination, Float depatureTime,
			int seats, int thakkalseats);

	void checkAdminChoice(int choice);

	void addAdmin(long sId, String id, String name, String pwd);

	long savings();

	boolean removeFlight(int flightNumber);

	

}
