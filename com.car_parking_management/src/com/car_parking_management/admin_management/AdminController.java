package com.car_parking_management.admin_management;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.car_parking_management.dto.Car;
import com.car_parking_management.dto.User;

public class AdminController implements AdminControllerCallBack, AdminModelControllerCallBack {
	private AdminViewCallBack adminView;
	private AdminModelCallBack adminModel;

	public AdminController(AdminViewCallBack adminView) {
		this.adminView = adminView;
		adminModel = new AdminModel(this);
	}

	public void validateChoice(int choice) {
		switch (choice) {
		case 1:
			adminView.addCar();
			break;
		case 2:
			adminView.manageCar();
			break;
		case 3:
			adminView.searchCar();
			break;
		case 4:
			adminView.registedUser();
			break;
		case 0:
			adminView.exit();
		default:
			adminView.errorMessage("Invalid data!");
		}

	}

	public boolean validateMblno(long mblno) {
		int digit;
		for (digit = 0; mblno != 0; digit++)
			mblno /= 10;
		if (digit == 10)
			return true;
		return false;
	}

	public void addCar(String brand, String regno, String name, long mblno) {
		LocalTime lt = LocalTime.now();
		LocalDate ld = LocalDate.now();
		if (adminModel.addCar(brand, regno, name, mblno, lt, ld)) {
			adminView.success("Parking successfully made...");
		} else
			adminView.addCar();
	}

	public void manageCar(String registerNumber) {
		if (adminModel.manageCar(registerNumber)) {
			adminView.success("parking lot is cleared...");
		}
		adminView.manageCar();
	}

	public void searchCar(int parkingNumber) {
		Car car = adminModel.searchCar(parkingNumber);
		if (car != null) {
			adminView.printDetails(car);
		}
		adminView.errorMessage("Parking number doesn't exist.");
	}

	public List<User> registedUser() {
		return adminModel.resistedUser();
	}

	public int totalEntry() {
		return adminModel.totalEntry();
	}

	public int todayEntry() {
		// TODO Auto-generated method stub
		return adminModel.todayEntry();
	}

	public int yesterdayEntry() {
		// TODO Auto-generated method stub
		return adminModel.yesterdayEntry();
	}

	public int lastSevendayEntry() {
		// TODO Auto-generated method stub
		return adminModel.lastSevendayEntry();
	}
}
