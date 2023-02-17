package com.flight_ticket_reservation_system.userLogin;

import com.flight_ticket_reservation_system.dto.Admin;
import com.flight_ticket_reservation_system.dto.User;
import com.flight_ticket_reservation_system.repository.FlightTicketReservationSystemDataBase;

public class UserLoginModel implements UserLoginModelCallBack {
	private UserLoginModelControllerCallBack userLoginController;
	public UserLoginModel(UserLoginModelControllerCallBack userLoginController) {
		this.userLoginController=userLoginController;
	}
	public void checkCredentialsDb(String userId, String password) {
		User user = FlightTicketReservationSystemDataBase.getInstance().checkValidUser(userId,password);
		if (user !=null) {
			userLoginController.loginSuccess(user);
		} else {
			userLoginController.loginFailiure("\nInvalid Credentials. Please try again!!\n");
		}
	}
}