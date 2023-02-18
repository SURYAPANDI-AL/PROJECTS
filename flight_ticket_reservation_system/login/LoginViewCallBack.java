package com.flight_ticket_reservation_system.login;

import com.flight_ticket_reservation_system.dto.Admin;

public interface LoginViewCallBack {

	void loginSuccess(Admin adminUser);

	void loginFailure(String errorMessage);

	void addFlight();

	void removeFlight();

	void setFlight();

	void addAdmin();

	void Exit();

	void savings();

}
