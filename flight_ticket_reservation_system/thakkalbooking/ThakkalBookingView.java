package com.flight_ticket_reservation_system.thakkalbooking;

import java.util.List;
import java.util.Scanner;

import com.flight_ticket_reservation_system.booking.BookingView;
import com.flight_ticket_reservation_system.dto.Flight;
import com.flight_ticket_reservation_system.dto.Ticket;
import com.flight_ticket_reservation_system.dto.User;
import com.flight_ticket_reservation_system.setupreservation.SetupReservationView;

public class ThakkalBookingView implements ThakkalBookingViewCallBack{
	private User user;
	private int seats;
	private int count;
	private int flightId;
	private ThakkalBookingControllerCallBack thakkalBookingController;
	private Scanner scanner = new Scanner(System.in);

	public ThakkalBookingView() {
		thakkalBookingController = new ThakkalBookingController(this);
	}

	public void create(User user) {
		this.user = user;
		availabeService();
	}

	private void bookingSetup() {
		System.out.println("\n--->Make Journey<---");
		System.out.println("Enter the Starting location:");
		String source = scanner.next();
		System.out.println("Enter the Destination:");
		String destination = scanner.next();
		thakkalBookingController.checkDestination(source, destination);

	}

	public void availablePlanes(List<Flight> availableflights) {
		System.out.println(
				"_____________________________________________________________________________________________________");
		System.out.println("Flightnumber" + "\t| " + "Name" + "\t| "+ "From" + "\t| " + "To" + "\t| " + "Time");
		for (Flight flight : availableflights) {
			System.out.println(flight.getFlightnumber() + "\t| " + flight.getFlightName() + "\t| " + flight.getSource()
					+ "\t| " + flight.getDestination() + "\t| " + flight.getDepatureTime() + "0" + "\n");
			System.out.println(
					"_____________________________________________________________________________________________________");
		}
		bookingChoice();
	}

	private void bookingChoice() {
		System.out.println("Do you wish to continue.....(y/n)");
		char choice = scanner.next().charAt(0);
		thakkalBookingController.continueChoice(choice);
	}

	public void noPlanesAvailable(String errorMessage) {
		System.out.println(errorMessage);
		availabeService();
	}

	private void availabeService() {
		List<Flight> availableFlight=(List<Flight>) thakkalBookingController.availabeService();
		System.out.println(
				"_____________________________________________________________________________________________________");
		System.out.println("Flightnumber" + "\t| " + "Name" + "\t| "+ "From" + "\t| " + "To" + "\t| " + "Time");
		for (Flight flight : availableFlight) {
			System.out.println(flight.getFlightnumber() + "\t| " + flight.getFlightName() + "\t| " + flight.getSource()
			+ "\t| " + flight.getDestination() + "\t| " + flight.getDepatureTime() + "0" + "\n");
	System.out.println(
			"_____________________________________________________________________________________________________");
}
bookingSetup();
	}

	public void bookticket() {
		System.out.println("EnterFlightId:");
		flightId = scanner.nextInt();
		seats = thakkalBookingController.availableSeats(flightId);
		System.out.println("Available seats: " + seats + "\tbook tickets within range.\n");
		thakkalBookingController.noSeats(seats);
		System.out.println("Enter the count of tickets:");
		count = scanner.nextInt();
		thakkalBookingController.checkseats(seats, count);
	}

	public void exit() {
		System.out.println("Visit again..");
		SetupReservationView setup = new SetupReservationView();
		setup.create(user);
	}

	public void payment(int payment) {
		System.out.println("\nOne Ticket==Rs2500\nMake payment-->" + "Rs." + payment);
		int amount = scanner.nextInt();
		thakkalBookingController.checkpayment(amount, payment);
		thakkalBookingController.makeReservation(count, flightId);
		thakkalBookingController.ticketbooking(count);
		System.out.println("Thank you for making the transaction \n have a safe journey");
	}

	Ticket sample;

	public void ticketInfo() {
		System.out.println("--->Traveler Details<---");
		System.out.println("Enter passenger name:");
		String name = scanner.next();
		System.out.println("Enter travel date (yyyy-mm-dd):");
		String date = scanner.next();
		if(thakkalBookingController.checkDate(date)) {
		sample = thakkalBookingController.ticketdetails(flightId, user, name, date);
		ticketdisplay(sample);
		}
		else {
			System.out.println("Enter valid details !");
				ticketInfo();
			}
		}
	

	private void ticketdisplay(Ticket sample) {
		System.out.println("**********************************************************************************");
		System.out.println(
				" ------------------------->" + "  " + sample.getFlightname() + "  " + " <-------------------------\n");
		System.out.println(
				"TicketID:XXXX" + sample.getTicketId() + " 				Passenger Name:" + sample.getPassenger());
		System.out.println("\nFlightID:" + sample.getFlightId() + "\n\nDepature Time:" + sample.getStarttime()
				+ "0IST 			" + "Reach At:" + sample.getReachtime() + "0IST");
		System.out.println("\n\nDate:" + sample.getDate() + "   	DHAKAL BOOKING	  		Make A safe Trip.");
		System.out.println("\nOnBoarding Time:30mins before Depature                 Counter:1");
		System.out.println("\n\n**********************************************************************************");
	}
}
