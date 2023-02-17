package com.flight_ticket_reservation_system.booking;

import java.util.ArrayList;
import java.util.List;

import com.flight_ticket_reservation_system.dto.Flight;
import com.flight_ticket_reservation_system.dto.Ticket;
import com.flight_ticket_reservation_system.dto.User;

public class BookingController implements BookingControllerCallBack,BookingModelControllerCallBack{
	
	private BookingViewCallBack bookingView;
	private BookingModelCallBack bookingModel;

	public BookingController(BookingViewCallBack bookingView) {
		this.bookingView=bookingView;
		bookingModel=new BookingModel(this);
	}

	public void checkDestination(String source,String destination) {
		List<Flight> availableflights=new ArrayList(bookingModel.checkDestinationDb(source,destination));
		if(! (availableflights.isEmpty())) {
			bookingView.availablePlanes(availableflights);
		}
		else {
			bookingView.noPlanesAvailable("There is no available service to the detination you have entered");
		}
	}

	public List<Flight> availabeService() {
		return bookingModel.availableService();
		
		
	}

	public void continueChoice(char choice) {
		if(choice=='y') {
			bookingView.bookticket();
		}
		else {
			bookingView.exit();
		}
	}

	public int availableSeats(int flightId) {
		return bookingModel.availableSeat(flightId);
	}

	public void noSeats(int seats) {
		if(seats==0) {
			bookingView.exit();
		}
	}

	public void checkseats(int seats, int count) {
		if(seats>=count) {
			int payment=count*1000;
			bookingView.payment(payment);
		}
		bookingView.exit();
	
	}

	public void checkpayment(int amount, int payment) {
		if(payment!=amount) {
			bookingView.exit();
		}
	}

	public void makeReservation(int count,int flightId) {
		bookingModel.makeReservation(count,flightId);
	}

	public void ticketbooking(int count) {
		while(count!=0) {
			bookingView.ticketInfo();
			count--;
		}
		
	}

	public Ticket ticketdetails(int flightId, User user, String name, String date) {
		return bookingModel.ticketdetails(flightId,user,name,date);
	}

	
}
