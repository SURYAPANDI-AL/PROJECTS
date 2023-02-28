package com.car_parking_management.login;

import java.util.Scanner;

public class LoginView implements LoginViewCallBack {
	private LoginControllerCallBack loginController;
	private Scanner sc = new Scanner(System.in);

	public LoginView() {
		loginController = new LoginController(this);
	}

	public static void main(String[] args) {
		LoginView lv = new LoginView();
		lv.create();
	}

	private void create() {
		System.out.println("CAR PARKING MANAGEMENT:\n\n");
		option();
	}

	public void option() {
		System.out.print("1.Admin login\n2.User login\n3.User Registation\n\nEnter Choice : ");
		String sChoice = sc.next();
		loginController.inputValidation(sChoice);
		int choice = Integer.parseInt(sChoice);
		System.out.println();
		loginController.choiceMade(choice);
	}

	public void adminLogin() {
		String name, pwd;
		System.out.print("User Name : ");
		name = sc.next();
		System.out.print("password : ");
		pwd = sc.next();
		loginController.validateAdmin(name, pwd);
	}

	public void userLogin() {
		String name, pwd;
		System.out.print("User Name : ");
		name = sc.next();
		System.out.print("password : ");
		pwd = sc.next();
		loginController.validateUser(name, pwd);
	}

	// name/mobile no/email address/password /confirm password
	public void userRegistation() {
		String name, email, pwd, confirmPwd;
		long mblno;
		System.out.println("CREATE YOUR ACCOUNT:\n");
		System.out.print("Name  : ");
		name = sc.next();
		do {
			System.out.print("Mobile No : ");
			mblno = sc.nextLong();
		} while (!loginController.validateMblno(mblno));
		do {
			System.out.print("Email address : ");
			email = sc.next();
		} while (!loginController.validateEmail(email));
		do {
			System.out.print("Password : ");
			pwd = sc.next();
			System.out.print("Confirm password : ");
			confirmPwd = sc.next();
		} while (!loginController.validatepwd(pwd, confirmPwd));
		loginController.addUser(name, email, pwd, mblno);
	}

	public void message(String message) {
		System.out.println(message);
		System.out.println();
		option();

	}
}
