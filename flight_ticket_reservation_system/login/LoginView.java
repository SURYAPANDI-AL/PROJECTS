package com.flight_ticket_reservation_system.login;

import java.util.Scanner;

import com.flight_ticket_reservation_system.dto.Admin;
import com.flight_ticket_reservation_system.setupreservation.SetupReservationView;

public class LoginView implements LoginViewCallBack {
	private LoginControllerCallBack loginController;
	private Scanner scanner = new Scanner(System.in);

	public LoginView() {
		loginController = new LoginController(this);
	}

	public static void main(String args[]) {
		LoginView loginView = new LoginView();
		loginView.create();
	}

	public void create() {
		checkForLogin();
	}

	private void checkForLogin() {
		System.out.println("\t-ZSGS Airport-");
		System.out.println(" Airport Reservation Service\n---------------------------------");
		System.out.println("1.user login\n2.admin login\n3.new regitation");
		int choice = scanner.nextInt();
		loginController.checkChoice(choice);
		System.out.println("Enter user ID:");
		String userId = scanner.next();
		System.out.println("Enter password:");
		String password = scanner.next();
		loginController.checkCredentials(userId, password);
	}

	public void loginSuccess(Admin adminUser) {
		System.out.println("\n-->Welcome " + adminUser.getUserName() + "<--\nHope you have a good day.");
		SetupReservationView setupReservation = new SetupReservationView();
		System.out.println("\nMake Choice:\n1-Add flight\n2-Remove Flight\n3-Transactions\n4-Alter Flight Service\n5-Add new Admin\n6-Exit");
		int choice=scanner.nextInt();
		loginController.checkAdminChoice(choice);
	}
	public void addFlight() {
		System.out.println("--->Add a new AirService<---");
		System.out.println("Airplane Id:");
		int flightNumber = scanner.nextInt();
		System.out.println("Airplane name:");
		String flightName = scanner.next();
		System.out.println("Airplane Journey from:");
		String source = scanner.next();
		System.out.println("Number of ordinary seats:");
		int seats = scanner.nextInt();
		System.out.println("Airplane Journey to:");
		String destination = scanner.next();
		System.out.println("Airplane depature time:");
		Float depatureTime = scanner.nextFloat();
		System.out.println("Number of thakkal seats:");
		int thakkalseats = scanner.nextInt();
		loginController.addFlight(flightNumber, flightName, source, destination, depatureTime, seats, thakkalseats);
		System.out.println("New service created SuccessFully.");
		checkForLogin();
	}

	public void loginFailure(String errorMessage) {
		System.out.println(errorMessage);
		checkForLogin();

	}

	@Override
	public void removeFlight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transactions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFlight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAdmin() {
		// TODO Auto-generated method stub
		System.out.println("Supreme Admin password:");
		long sId=scanner.nextLong();
		System.out.print("Enter Admin name: ");
		String name=scanner.next();
		System.out.print("Generate ID: ");
		String id=scanner.next();
		System.out.println("Generate Password(use @,#,*): ");
		String pwd=scanner.next();
		loginController.addAdmin(sId,id,name,pwd);
	}

	@Override
	public void Exit() {
		// TODO Auto-generated method stub
		
	}
}
