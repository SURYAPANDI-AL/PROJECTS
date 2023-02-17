package com.flight_ticket_reservation_system.userRegistation;

import com.flight_ticket_reservation_system.repository.FlightTicketReservationSystemDataBase;

public class UserRegistationModel implements  UserRegistationModelCallBack {
	private UserRegistationModelControllerCallBack userRegistationController;
	public UserRegistationModel(UserRegistationModelControllerCallBack userRegistationController) {
		this.userRegistationController=userRegistationController;
	}
	public void addUser(String name, Long phno, String email, String pwd) {
		FlightTicketReservationSystemDataBase.getInstance().addUser( name,  phno,  email,  pwd);
	}

}
