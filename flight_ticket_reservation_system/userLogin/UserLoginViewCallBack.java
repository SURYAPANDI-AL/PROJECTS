package com.flight_ticket_reservation_system.userLogin;

import com.flight_ticket_reservation_system.dto.User;

public interface UserLoginViewCallBack {

	void loginSuccess(User user);

	void loginFailure(String errorMessage);

}
