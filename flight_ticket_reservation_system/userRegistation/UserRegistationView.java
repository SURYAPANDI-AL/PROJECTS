package com.flight_ticket_reservation_system.userRegistation;

import java.util.Scanner;

import com.flight_ticket_reservation_system.login.LoginView;

public class UserRegistationView implements UserRegistationViewCallBack {
	
	private UserRegistationControllerCallBack userRegitationController;
	
	public UserRegistationView() {
		userRegitationController=new UserRegistationController(this);
	}

	private Scanner scanner=new Scanner(System.in);
	public void create() {
		System.out.println("---->User Registation<----");
		userRegistationSetup();
	}

	private void userRegistationSetup() {
		System.out.println("Enter the details:");
		System.out.println("name:");
		String name=scanner.next();
		System.out.println("phone number:");
		Long phno=scanner.nextLong();
		System.out.println("Email Id:");
		String email=scanner.next();
		System.out.println("password:");
		String pwd=scanner.next();
		System.out.println("confirm password:");
		String cpwd=scanner.next();
		userRegitationController.checkCredentials(name,phno,email,pwd,cpwd);
		System.out.println("Registered Successfully\n\n");
		LoginView login=new LoginView();
		login.create();
	}

	public void invalidData(String errorMessage) {
		System.out.println(errorMessage);
		userRegistationSetup();
	}
	
	
}
