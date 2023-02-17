package com.flight_ticket_reservation_system.login;

import com.flight_ticket_reservation_system.dto.Admin;

public interface LoginModelControllerCallBack {

	void loginSuccess(Admin adminUser);

	void loginFailiure(String string);

}
