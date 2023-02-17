package com.flight_ticket_reservation_system.booking;

import com.flight_ticket_reservation_system.dto.Ticket;
import com.flight_ticket_reservation_system.dto.User;

public interface BookingControllerCallBack {

	void checkDestination(String source, String destination);

	void continueChoice(char choice);

	Object availabeService();

	int availableSeats(int flightId);

	void noSeats(int seats);

	void checkseats(int seats, int count);

	Ticket ticketdetails(int flightId, User user, String name, String date);

	void checkpayment(int amount, int payment);

	void makeReservation(int count, int flightId);

	void ticketbooking(int count);

}
