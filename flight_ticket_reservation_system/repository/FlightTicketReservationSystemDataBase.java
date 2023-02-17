package com.flight_ticket_reservation_system.repository;

import java.util.List;
import java.util.ArrayList;

import com.flight_ticket_reservation_system.dto.Admin;
import com.flight_ticket_reservation_system.dto.AdminCredentials;
import com.flight_ticket_reservation_system.dto.Flight;
import com.flight_ticket_reservation_system.dto.ReservationOption;
import com.flight_ticket_reservation_system.dto.Ticket;
import com.flight_ticket_reservation_system.dto.User;

public class FlightTicketReservationSystemDataBase {

	private static FlightTicketReservationSystemDataBase flightTicketReservationSystemDbInstance;
	private int ticketId = 1;
	private long supremeId = 123456789;
	private List<AdminCredentials> adminCredentials = new ArrayList<>();
	private List<ReservationOption> reservationOptions = new ArrayList<>();
	private List<Flight> flightDetail = new ArrayList<>();
	private List<User> userdata = new ArrayList<>();
	private List<Ticket> ticket = new ArrayList<>();

	private FlightTicketReservationSystemDataBase() {

	}

	public static FlightTicketReservationSystemDataBase getInstance() {
		if (flightTicketReservationSystemDbInstance == null) {
			flightTicketReservationSystemDbInstance = new FlightTicketReservationSystemDataBase();
			flightTicketReservationSystemDbInstance.initialSetup();
		}
		return flightTicketReservationSystemDbInstance;
	}

	private void initialSetup() {
		userdata.add(new User("user","user@gmail.com",9005090050L,"password"));
		adminCredentials.add(new AdminCredentials("1001", "SURYA", "password"));
		adminCredentials.add(new AdminCredentials("1002", "ADMIN", "password"));
		reservationOptions.add(new ReservationOption(1, "Booking tickets"));
		reservationOptions.add(new ReservationOption(2, "Cancel ticket"));
		reservationOptions.add(new ReservationOption(3, "Thakkal booking"));
		reservationOptions.add(new ReservationOption(4, "Exit"));
		flightDetail.add(new Flight(111, "AirIndia", "chennai", "london", 12.00f, 20, 5));
		flightDetail.add(new Flight(121, "AirIndia", "chennai", "london", 6.50f, 20, 5));
		flightDetail.add(new Flight(131, "KeyTakeaways", "chennai", "dubai", 18.30f, 20, 5));
		flightDetail.add(new Flight(141, "KeyTakeaways", "chennai", "dubai", 12.00f, 20, 5));
		flightDetail.add(new Flight(151, "AirAsia", "chennai", "pakistan", 23.30f, 20, 5));
	}

	public Admin checkValidAdmin(String userId, String password) {
		for (AdminCredentials credential : adminCredentials) {
			if (credential.getUserId().equals(userId) && credential.getPassword().equals(password)) {
				return credential;
			}
		}
		return null;
	}

	public User checkValidUser(String userId, String password) {
		for (User credential : userdata) {
			if (credential.getUsername().equals(userId) && credential.getPassword().equals(password)) {
				return credential;
			}
		}
		return null;
	}

	public ReservationOption validateOption(int choice) {
		for (ReservationOption option : reservationOptions) {
			if (option.getChoice() == choice) {
				return option;
			}
		}
		return null;
	}

	public List<Flight> checkDestinationDb(String source, String destination) {
		List<Flight> availableflights = new ArrayList<>();
		for (Flight flight : flightDetail) {
			if (source.toLowerCase().equals(flight.getSource())
					&& destination.toLowerCase().equals(flight.getDestination())) {
				availableflights.add(flight);
			}
		}
		return availableflights;
	}

	public List<Flight> availableService() {

		return flightDetail;
	}

	public int availableSeat(int flightId) {
		for (Flight flight : flightDetail) {
			if (flightId == flight.getFlightnumber()) {
				return flight.getSeats();
			}
		}
		return 0;
	}

	public void makeReservation(int count, int flightId) {
		for (Flight flight : flightDetail) {
			if (flightId == flight.getFlightnumber()) {
				flight.setSeats(flight.getSeats() - count);
			}
		}
	}

	public void addUser(String name, Long phno, String email, String pwd) {

		userdata.add(new User(name, email, phno, pwd));
	}

	public void addFlight(int flightNumber, String flightName, String source, String destination, Float depatureTime,
			int seats, int thakkalseats) {
		flightDetail.add(new Flight(flightNumber, flightName, source, destination, depatureTime, seats, thakkalseats));
	}

	public Ticket addTicket(int flightId, User user, String name, String date) {
		Ticket sampleticket = null;
		for (Flight flight : flightDetail) {
			if (flightId == flight.getFlightnumber()) {
				sampleticket = new Ticket(ticketId++, flight.getFlightnumber(), name, flight.getFlightName(),
						flight.getDepatureTime(), flight.getDepatureTime() + 2.00f, date, user.getPassword());
				ticket.add(sampleticket);
				break;
			}
		}
		return sampleticket;
	}

	public int availableSeatthakkal(int flightId) {
		for (Flight flight : flightDetail) {
			if (flightId == flight.getFlightnumber()) {
				return flight.getThakkalSeats();
			}
		}
		return 0;
	}

	public void makeReservationthakkal(int count, int flightId) {
		for (Flight flight : flightDetail) {
			if (flightId == flight.getFlightnumber()) {
				flight.setSeats(flight.getThakkalSeats() - count);
			}
		}
	}

	public boolean cancelTicket(String pwd, int id, String name, String type) {
		int i = 0, flightId = 0;

		for (Ticket currentTicket : ticket) {
			if (currentTicket.getTicketId() == id && currentTicket.getPassenger().equals(name)
					&& currentTicket.getUserpassword().equals(pwd)) {
				flightId = currentTicket.getFlightId();
				ticket.remove(i);
				break;
			}
			i++;
		}
		for (Flight flight : flightDetail) {
			if (flightId == flight.getFlightnumber()) {
				if (type.toLowerCase().equals("normal")) {
					flight.setSeats(flight.getSeats() + 1);
				} else {
					flight.setSeats(flight.getThakkalSeats() + 1);
				}
			}
		}
		if (i == ticket.size() + 1)
			return false;
		return true;
	}

	public boolean addAdmin(long sId,String id, String name, String pwd) {
		if(supremeId==sId) {
			adminCredentials.add(new AdminCredentials(id,name,pwd));
			return true;
		}
			return false; 
	}
}
