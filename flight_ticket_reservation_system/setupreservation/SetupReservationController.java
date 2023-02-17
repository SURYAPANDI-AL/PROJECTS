package com.flight_ticket_reservation_system.setupreservation;

import com.flight_ticket_reservation_system.booking.BookingView;
import com.flight_ticket_reservation_system.cancelticket.CancelTicketView;
import com.flight_ticket_reservation_system.dto.ReservationOption;
import com.flight_ticket_reservation_system.dto.User;
import com.flight_ticket_reservation_system.thakkalbooking.ThakkalBookingView;

public class SetupReservationController implements SetupReservationControllerCallBack,SetupReservationModelControllerCallBack {
	private User user;
	private SetupReservationViewCallBack setupReservationView;
	private SetupReservationModelCallBack setupReservationModel;
	public SetupReservationController(SetupReservationViewCallBack setupReservationView) {
		this.setupReservationView=setupReservationView;
		setupReservationModel=new SetupReservationModel(this);
	}
	public void validateChoice(int choice) {
		setupReservationModel.validateChoiceDb(choice);
	}
	public void incorrectChoice(String errorMessage) {
		setupReservationView.incorrectChoice(errorMessage);
		
	}
	public void correctChoice(ReservationOption option) {
		int choice=option.getChoice();
		switch(choice) {
		case 1:{
			BookingView bookingView=new BookingView();
			bookingView.create(user);
			break;
			}
		case 2:{
			CancelTicketView cancelTicketView=new CancelTicketView();
			cancelTicketView.create(user);
			break;
		}
		case 3:{
			ThakkalBookingView thakkalBookingView=new ThakkalBookingView();
			thakkalBookingView.create(user);
			break;
		}
		case 4:{
			setupReservationView.exit();
		}
		}
		
	}
	public void setUser(User user) {
		this.user=user;
	}
		
}
