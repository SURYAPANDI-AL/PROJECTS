package com.car_parking_management.admin_management;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.car_parking_management.dto.Admin;
import com.car_parking_management.dto.Car;
import com.car_parking_management.dto.User;
import com.car_parking_management.login.LoginView;

public class AdminView implements AdminViewCallBack {
	private AdminControllerCallBack adminController;
	private Scanner sc = new Scanner(System.in);
	private Admin admin;

	public AdminView() {
		adminController = new AdminController(this);
	}

	public void create(Admin admin) {
		this.admin = admin;
		System.out.println("\nWelcome....\n");
		dashboard();
	}

	private void dashboard() {
		int totalEntry = 0, todayEntry = 0, yesterdayEntry = 0, lastSevenDayEntry = 0;
		totalEntry = adminController.totalEntry();
		todayEntry = adminController.todayEntry();
		yesterdayEntry = adminController.yesterdayEntry();
		lastSevenDayEntry = adminController.lastSevendayEntry();
		System.out.println("\t\t*************DASH_BOARD*******");
		System.out.println(LocalDate.now());
		System.out.println(
				"---------------------------------------------------------------------------------------------------------");
		System.out.println("|	today vehicle	|	yesterday vehicle	|	last seven days	|	total vehicle	|");
		System.out.println("|	entry		|	entry			|	entry		|	entry		|");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------");
		System.out.println("|	" + todayEntry + "		|	" + yesterdayEntry + "			|	" + lastSevenDayEntry
				+ "		|	" + totalEntry + "		|");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------\n");
		option();
	}

	private void option() {
		int choice;
		System.out.print("1.Add Car\n2.Manage Car\n3.Search Car\n4.Registed Users\n\n0.Go Back\n\n\nEnter Choice : ");
		choice = sc.nextInt();
		adminController.validateChoice(choice);
	}

	public void addCar() {
		String brand, regno, name;
		long mblno;
		System.out.println("\nCAR DETAILS:");
		System.out.print("Car Brand : ");
		brand = sc.next();
		System.out.print("Registation No : ");
		regno = sc.next();
		System.out.print("Owner name : ");
		name = sc.next();
		do {
			System.out.print("Contact No : ");
			mblno = sc.nextLong();
		} while (!adminController.validateMblno(mblno));
		adminController.addCar(brand, regno, name, mblno);
	}

	public void manageCar() {
		String num;
		System.out.print("\nEnter Registation Number : ");
		num = sc.next();
		adminController.manageCar(num);
	}

	public void searchCar() {
		int parkno;
		System.out.println("Enter the parking number:");
		parkno = sc.nextInt();
		adminController.searchCar(parkno);
	}

	public void registedUser() {
		List<User> user = adminController.registedUser();
		int sNo = 1;
		System.out.println(
				"---------------------------------------------------------------------------------------------------------");
		System.out.println("|	S.NO		|	Name			|	contact no	|	Mail Id |");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------");
		for (User e : user) {
			System.out.println("|	" + sNo++ + "		|	" + e.getUserName() + "			|	" + e.getContactNumber()
					+ "	|	" + e.getMailId() + "		|");
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------\n");
		option();
	}

	public void exit() {
		LoginView lv = new LoginView();
		lv.option();
	}

	public void errorMessage(String errorMessage) {
		System.out.println(errorMessage);
		option();
	}

	public void success(String message) {
		System.out.println(message);
		create(admin);
	}

	public void printDetails(Car car) {

		System.out.println("\t->CAR DETAILS<-\nCAR OWNER	: " + car.getOwner() + "\n\nPARKING NUM	: 0"
				+ car.getParkingNumber() + "\n\nCAR BRAND	: " + car.getBrand() + "\n\nREGISTER NUM	: "
				+ car.getRegisterNumber() + "\n\nCONTACT NUM	: " + car.getContactnumber() + "\n\nIN TIME		: "
				+ car.getInTime() + "\n\nIN DATE		: " + car.getInDate() + "\n\nOUT TIME	: " + car.getOutTime()
				+ "\n\nOUT DATE	: " + car.getOutDate());
		option();
	}
}
