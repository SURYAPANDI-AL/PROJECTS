package com.flight_ticket_reservation_system.userLogin;

import com.flight_ticket_reservation_system.dto.User;

public interface UserLoginModelControllerCallBack {

	void loginSuccess(User user);

	void loginFailiure(String string);

}
