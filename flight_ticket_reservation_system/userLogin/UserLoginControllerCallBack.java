package com.flight_ticket_reservation_system.userLogin;

import com.flight_ticket_reservation_system.dto.User;

public interface UserLoginControllerCallBack {

	void checkCredentials(String userId, String password);

}
