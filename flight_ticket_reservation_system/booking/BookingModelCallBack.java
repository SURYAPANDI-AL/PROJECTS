package com.flight_ticket_reservation_system.booking;

import java.util.Collection;
import java.util.List;

import com.flight_ticket_reservation_system.dto.Flight;
import com.flight_ticket_reservation_system.dto.Ticket;
import com.flight_ticket_reservation_system.dto.User;

public interface BookingModelCallBack {

	List<Flight> availableService();

	int availableSeat(int flightId);

	void makeReservation(int count, int flightId);

	Ticket ticketdetails(int flightId, User user, String name, String date);

	Collection checkDestinationDb(String source, String destination);

}
