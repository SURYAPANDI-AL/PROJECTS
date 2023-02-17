package com.flight_ticket_reservation_system.booking;



import java.util.List;

import com.flight_ticket_reservation_system.dto.Flight;
import com.flight_ticket_reservation_system.dto.Ticket;
import com.flight_ticket_reservation_system.dto.User;
import com.flight_ticket_reservation_system.repository.FlightTicketReservationSystemDataBase;

public class BookingModel implements BookingModelCallBack{
	
	private BookingModelControllerCallBack bookingController;

	public BookingModel(BookingModelControllerCallBack bookingController) {
		this.bookingController=bookingController;
	}

	public List<Flight> checkDestinationDb(String source,String destination) {
		return FlightTicketReservationSystemDataBase.getInstance().checkDestinationDb(source,destination);	
	}

	public List<Flight> availableService() {
		return FlightTicketReservationSystemDataBase.getInstance().availableService();
	}

	public int availableSeat(int flightId) {
		
		return FlightTicketReservationSystemDataBase.getInstance().availableSeat(flightId);
	}

	public void makeReservation(int count, int flightId) {
		FlightTicketReservationSystemDataBase.getInstance().makeReservation(count,flightId);
	}

	public Ticket ticketdetails(int flightId, User user, String name, String date) {
		return FlightTicketReservationSystemDataBase.getInstance().addTicket(flightId,user,name,date);
		
	}
	
}
