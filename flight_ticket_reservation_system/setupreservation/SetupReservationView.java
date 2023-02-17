package com.flight_ticket_reservation_system.setupreservation;

import java.util.Scanner;

import com.flight_ticket_reservation_system.dto.User;

public class SetupReservationView implements SetupReservationViewCallBack{
	private User currentuser;
	private SetupReservationControllerCallBack setupReservationController;
	private Scanner scanner=new Scanner(System.in);
	public SetupReservationView() {
		setupReservationController=new SetupReservationController(this);
	}

	public void create(User user2) {
		currentuser=user2;
		setupReservation();
	}
	public void setUser() {
		setupReservationController.setUser(currentuser);
	}
	private void setupReservation() {
		setUser();
		System.out.println("Make the choice:");
		System.out.println("1-Book tickets.\n2-Cancel ticket.\n3-Dhakal booking.\n4-Exit.");
		int choice=scanner.nextInt();
		setupReservationController.validateChoice(choice);
	}
	
	public void incorrectChoice(String errorMessage) {
		System.out.println(errorMessage);
		setupReservation();
		
	}

	public void exit() {
		System.out.println("Thanks For Visiting!-good day");
		System.exit(0);
	}
	
}
