package com.flight_ticket_reservation_system.thakkalbooking;

import java.util.List;

import com.flight_ticket_reservation_system.dto.Flight;
import com.flight_ticket_reservation_system.dto.Ticket;
import com.flight_ticket_reservation_system.dto.User;
import com.flight_ticket_reservation_system.repository.FlightTicketReservationSystemDataBase;

public class ThakkalBookingModel implements ThakkalBookingModelCallBack{
	private ThakkalBookingModelControllerCallBack thakkalBookingController;
	public ThakkalBookingModel( ThakkalBookingModelControllerCallBack thakkalBookingController) {
		this.thakkalBookingController=thakkalBookingController;
	}
	public List<Flight> checkDestinationDb(String source,String destination) {
		return FlightTicketReservationSystemDataBase.getInstance().checkDestinationDb(source,destination);	
	}

	public List<Flight> availableService() {
		return FlightTicketReservationSystemDataBase.getInstance().availableService();
	}

	public int availableSeatthakkal(int flightId) {
		
		return FlightTicketReservationSystemDataBase.getInstance().availableSeatthakkal(flightId);
	}

	public void makeReservationthakkal(int count, int flightId) {
		FlightTicketReservationSystemDataBase.getInstance().makeReservationthakkal(count,flightId);
	}

	public Ticket ticketdetailsthakkal(int flightId, User user, String name, String date) {
		return FlightTicketReservationSystemDataBase.getInstance().addTicket(flightId,user,name,date);
		
	}
	
}

