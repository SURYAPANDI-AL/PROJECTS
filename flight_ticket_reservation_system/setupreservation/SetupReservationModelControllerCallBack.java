package com.flight_ticket_reservation_system.setupreservation;

import com.flight_ticket_reservation_system.dto.ReservationOption;

public interface SetupReservationModelControllerCallBack {

	void correctChoice(ReservationOption option);

	void incorrectChoice(String string);

}
