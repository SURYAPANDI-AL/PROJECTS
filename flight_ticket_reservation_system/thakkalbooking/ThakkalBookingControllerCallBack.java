package com.flight_ticket_reservation_system.thakkalbooking;

import com.flight_ticket_reservation_system.dto.Ticket;
import com.flight_ticket_reservation_system.dto.User;

public interface ThakkalBookingControllerCallBack {

	void checkDestination(String source, String destination);

	void continueChoice(char choice);

	Object availabeService();

	int availableSeats(int flightId);

	void noSeats(int seats);

	void checkseats(int seats, int count);

	void checkpayment(int amount, int payment);

	void makeReservation(int count, int flightId);

	void ticketbooking(int count);

	Ticket ticketdetails(int flightId, User user, String name, String date);

}
