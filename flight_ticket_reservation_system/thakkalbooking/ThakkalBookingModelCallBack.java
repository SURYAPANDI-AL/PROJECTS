package com.flight_ticket_reservation_system.thakkalbooking;

import java.util.Collection;
import java.util.List;

import com.flight_ticket_reservation_system.dto.Flight;
import com.flight_ticket_reservation_system.dto.Ticket;
import com.flight_ticket_reservation_system.dto.User;

public interface ThakkalBookingModelCallBack {

	Collection checkDestinationDb(String source, String destination);

	List<Flight> availableService();

	int availableSeatthakkal(int flightId);

	void makeReservationthakkal(int count, int flightId);

	Ticket ticketdetailsthakkal(int flightId, User user, String name, String date);

}
