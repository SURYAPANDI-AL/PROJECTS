package com.flight_ticket_reservation_system.setupreservation;

import com.flight_ticket_reservation_system.dto.ReservationOption;
import com.flight_ticket_reservation_system.repository.FlightTicketReservationSystemDataBase;

public class SetupReservationModel implements SetupReservationModelCallBack {

	private SetupReservationModelControllerCallBack setupReservationController;
	public SetupReservationModel(SetupReservationModelControllerCallBack setupReservationController) {
		this.setupReservationController=setupReservationController;
	}
	public  void validateChoiceDb(int choice) {
		ReservationOption option=FlightTicketReservationSystemDataBase.getInstance().validateOption(choice);
		if(option!=null) {
			setupReservationController.correctChoice(option);
		}else {
			setupReservationController.incorrectChoice("\nInvalid choice. Please try again!\n");
		}
	}

}
