package com.car_parking_management.admin_management;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.car_parking_management.dto.Car;
import com.car_parking_management.dto.User;
import com.car_parking_management.repository.CarParkingManagementDB;

public class AdminModel implements AdminModelCallBack {
	private AdminModelControllerCallBack adminController;

	public AdminModel(AdminModelControllerCallBack adminController) {
		this.adminController = adminController;
	}

	public boolean addCar(String brand, String registerNumber, String owner, long contactNumber, LocalTime inTime,
			LocalDate inDate) {
		return CarParkingManagementDB.getInstance().addCar(brand, registerNumber, owner, contactNumber, inTime, inDate);

	}

	public boolean manageCar(String registerNumber) {
		return CarParkingManagementDB.getInstance().manageCar(registerNumber);
	}

	public Car searchCar(int parkingNumber) {
		return CarParkingManagementDB.getInstance().searchCar(parkingNumber);
	}

	public List<User> resistedUser() {
		return CarParkingManagementDB.getInstance().registedUser();
	}

	public int totalEntry() {
		// TODO Auto-generated method stub
		return CarParkingManagementDB.getInstance().totalEntry();
	}

	public int todayEntry() {
		// TODO Auto-generated method stub
		return CarParkingManagementDB.getInstance().todayEntry();
	}

	public int yesterdayEntry() {
		// TODO Auto-generated method stub
		return CarParkingManagementDB.getInstance().yesterdayEntry();
	}

	public int lastSevendayEntry() {
		// TODO Auto-generated method stub
		return CarParkingManagementDB.getInstance().lastSevendayEntry();
	}
}
