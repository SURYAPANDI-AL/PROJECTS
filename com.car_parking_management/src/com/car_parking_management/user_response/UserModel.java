package com.car_parking_management.user_response;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.car_parking_management.dto.Car;
import com.car_parking_management.dto.User;
import com.car_parking_management.repository.CarParkingManagementDB;

public class UserModel implements UserModelCallBack, UserModelControllerCallBack {
	private UserModelControllerCallBack userController;

	public UserModel(UserModelControllerCallBack userController) {
		this.userController = userController;
	}

	public List<Car> getCar(User user) {

		return CarParkingManagementDB.getInstance().getCarByUser(user);
	}

	public int[][] showLots(int choice) {
		return CarParkingManagementDB.getInstance().showLots(choice);
	}

	public boolean bookLot(int row, int col, int days, int choice) {

		return CarParkingManagementDB.getInstance().bookSlot(row, col, days, choice);
	}

	public boolean addCar(String brand, String registerNumber, String owner, long contactNumber, LocalTime inTime,
			LocalDate inDate, int choice) {
		return CarParkingManagementDB.getInstance().addCarOnline(brand, registerNumber, owner, contactNumber, inTime,
				inDate, choice);

	}

}
