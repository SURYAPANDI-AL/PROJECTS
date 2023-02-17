package com.flight_ticket_reservation_system.dto;

public class Ticket {
	
	private int ticketId;
	private int flightId;
	private String passenger;
	private String flightname;
	private float starttime;
	private float reachtime;
	private String date;
	private String userpassword;
	
	public Ticket(int ticketId, int flightId, String passenger, String flightname, float starttime, float reachtime,
			String date,String userpassword) {
		super();
		this.ticketId = ticketId;
		this.flightId = flightId;
		this.passenger = passenger;
		this.flightname = flightname;
		this.starttime = starttime;
		this.reachtime = reachtime;
		this.date = date;
		this.userpassword=userpassword;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getPassenger() {
		return passenger;
	}
	public void setPassenger(String passenger) {
		this.passenger = passenger;
	}
	public String getFlightname() {
		return flightname;
	}
	public void setFlightname(String flightname) {
		this.flightname = flightname;
	}
	public float getStarttime() {
		return starttime;
	}
	public void setStarttime(float starttime) {
		this.starttime = starttime;
	}
	public float getReachtime() {
		return reachtime;
	}
	public void setReachtime(float reachtime) {
		this.reachtime = reachtime;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
