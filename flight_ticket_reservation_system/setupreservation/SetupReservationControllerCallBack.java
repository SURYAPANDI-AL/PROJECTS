package com.flight_ticket_reservation_system.setupreservation;

import com.flight_ticket_reservation_system.dto.User;

public interface SetupReservationControllerCallBack {

	void setUser(User currentuser);

	void validateChoice(int choice);

}
