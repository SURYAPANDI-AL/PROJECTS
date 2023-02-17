package com.flight_ticket_reservation_system.thakkalbooking;

import java.util.ArrayList;
import java.util.List;

import com.flight_ticket_reservation_system.dto.Flight;
import com.flight_ticket_reservation_system.dto.Ticket;
import com.flight_ticket_reservation_system.dto.User;

public class ThakkalBookingController implements ThakkalBookingModelControllerCallBack,ThakkalBookingControllerCallBack{
	private ThakkalBookingViewCallBack thakkalBookingView;
	private ThakkalBookingModelCallBack thakkalBookingModel;
	public ThakkalBookingController(ThakkalBookingViewCallBack thakkalBookingView) {
		this.thakkalBookingView=thakkalBookingView;
		thakkalBookingModel=new ThakkalBookingModel(this);
	}
	public void checkDestination(String source,String destination) {
		List<Flight> availableflights=new ArrayList(thakkalBookingModel.checkDestinationDb(source,destination));
		if(! (availableflights.isEmpty())) {
			thakkalBookingView.availablePlanes(availableflights);
		}
		else {
			thakkalBookingView.noPlanesAvailable("There is no available service to the detination you have entered");
		}
	}

	public List<Flight> availabeService() {
		return thakkalBookingModel.availableService();
		
		
	}

	public void continueChoice(char choice) {
		if(choice=='y') {
			thakkalBookingView.bookticket();
		}
		else {
			thakkalBookingView.exit();
		}
	}

	public int availableSeats(int flightId) {
		return thakkalBookingModel.availableSeatthakkal(flightId);
	}

	public void noSeats(int seats) {
		if(seats==0) {
			thakkalBookingView.exit();
		}
	}

	public void checkseats(int seats, int count) {
		if(seats>=count) {
			int payment=count*2500;
			thakkalBookingView.payment(payment);
		}
		thakkalBookingView.exit();
	
	}

	public void checkpayment(int amount, int payment) {
		if(payment!=amount) {
			thakkalBookingView.exit();
		}
	}

	public void makeReservation(int count,int flightId) {
		thakkalBookingModel.makeReservationthakkal(count,flightId);
	}

	public void ticketbooking(int count) {
		while(count!=0) {
			thakkalBookingView.ticketInfo();
			count--;
		}
		
	}

	public Ticket ticketdetails(int flightId, User user, String name, String date) {
		return thakkalBookingModel.ticketdetailsthakkal(flightId,user,name,date);
	}
}
