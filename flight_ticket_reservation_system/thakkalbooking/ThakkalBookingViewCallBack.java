package com.flight_ticket_reservation_system.thakkalbooking;

import java.util.List;

import com.flight_ticket_reservation_system.dto.Flight;

public interface ThakkalBookingViewCallBack {

	void availablePlanes(List<Flight> availableflights);

	void noPlanesAvailable(String string);

	void bookticket();

	void exit();

	void payment(int payment);

	void ticketInfo();

}
