package com.flight_ticket_reservation_system.userRegistation;

public interface UserRegistationControllerCallBack {

	void checkCredentials(String name, Long phno, String email, String pwd, String cpwd);

}
