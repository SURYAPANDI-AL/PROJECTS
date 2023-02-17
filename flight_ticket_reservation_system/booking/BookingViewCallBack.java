package com.flight_ticket_reservation_system.booking;

import java.util.List;

import com.flight_ticket_reservation_system.dto.Flight;

public interface BookingViewCallBack {

	void availablePlanes(List<Flight> availableflights);

	void noPlanesAvailable(String string);

	void bookticket();

	void exit();

	void payment(int payment);

	void ticketInfo();

}
