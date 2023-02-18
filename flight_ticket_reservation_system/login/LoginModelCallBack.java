package com.flight_ticket_reservation_system.login;

public interface LoginModelCallBack {

	void checkCredentialsDb(String userId, String password);

	void addFlight(int flightNumber, String flightName, String source, String destination, Float depatureTime,
			int seats, int thakkalseats);

	

	boolean addAdmin(long sId, String id, String name, String pwd);

	long savings();

	boolean removeFlight(int flightId);

}
