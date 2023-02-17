package com.flight_ticket_reservation_system.dto;

public class ReservationOption {
	private int choice;
	private String service;
	public int getChoice() {
		return choice;
	}
	public void setChoice(int choice) {
		this.choice = choice;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public ReservationOption(int choice, String service) {
		super();
		this.choice = choice;
		this.service = service;
	}

}
