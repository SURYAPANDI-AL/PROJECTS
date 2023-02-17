package com.flight_ticket_reservation_system.userLogin;

import java.util.Scanner;

import com.flight_ticket_reservation_system.dto.Admin;
import com.flight_ticket_reservation_system.dto.User;
import com.flight_ticket_reservation_system.login.LoginController;
import com.flight_ticket_reservation_system.login.LoginView;
import com.flight_ticket_reservation_system.setupreservation.SetupReservationView;

public class UserLoginView implements UserLoginViewCallBack{
	private UserLoginControllerCallBack userloginController;
	private Scanner scanner = new Scanner(System.in);

	public UserLoginView() {
		userloginController = new UserLoginController(this);
	}

	public void create() {
		checkForlogin();
	}

	private void checkForlogin() {
		System.out.println("\t-ZSGS Airport-");
		System.out.println(" Airport Reservation Service\n---------------------------------");
		System.out.println("Enter user name:");
		String userId = scanner.next();
		System.out.println("Enter password:");
		String password = scanner.next();
		userloginController.checkCredentials(userId, password);
	}

	public void loginSuccess(User user) {
		System.out.println("\n\t\t-->Welcome " + user.getUsername()
				+ "<--\n\tYou are at the Reservation service\n-->Enjoy your vacation with a memorable trip<--");
		SetupReservationView setupReservation = new SetupReservationView();
		setupReservation.create(user);
	}

	public void loginFailure(String errorMessage) {
		System.out.println(errorMessage);
		LoginView loginView = new LoginView();
		loginView.create();

	}
}
