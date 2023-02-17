package com.flight_ticket_reservation_system.dto;

public class Flight {
	private int flightnumber;
	private String flightName;
	private String source;
	private int seats;
	private String destination;
	private float depatureTime;
	private int thakkalSeats;
	

	public Flight(int flightnumber, String flightName, String source,  String destination, float depatureTime,int seats,
			int thakkalSeats) {
		super();
		this.flightnumber = flightnumber;
		this.flightName = flightName;
		this.source = source;
		this.seats = seats;
		this.destination = destination;
		this.depatureTime = depatureTime;
		this.thakkalSeats = thakkalSeats;
	}

	
	

	public String getSource() {
		return source;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public void setSource(String source) {
		this.source = source;
	}
	public int getFlightnumber() {
		return flightnumber;
	}

	public void setFlightnumber(int flightnumber) {
		this.flightnumber = flightnumber;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public float getDepatureTime() {
		return depatureTime;
	}

	public void setDepatureTime(float depatureTime) {
		this.depatureTime = depatureTime;
	}

	
	

	public int getThakkalSeats() {
		return thakkalSeats;
	}

	public void setThakkalSeats(int thakkalSeats) {
		this.thakkalSeats = thakkalSeats;
	}
}
