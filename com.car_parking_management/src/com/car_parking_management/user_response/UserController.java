package com.car_parking_management.user_response;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.car_parking_management.dto.Car;
import com.car_parking_management.dto.User;

public class UserController implements UserControllerCallBack, UserModelControllerCallBack {
	private UserViewCallBack userView;
	private UserModelCallBack userModel;

	public UserController(UserViewCallBack userView) {
		this.userView = userView;
		userModel = new UserModel(this);
	}

	public void validateChoice(int choice) {
		switch (choice) {
		case 1:
			userView.viewBills();
			break;
		case 2:
			userView.location();
		case 0:
			userView.exit();
		default:
			userView.errorMessage("Invalid data!");
		}

	}

	public List<Car> getCar(User user) {
		// List<Car> cars=
		// if(cars != null) {
		// return cars;
		// }
		return userModel.getCar(user);
	}

	public void availableLots(int choice) {
		int[][] lots = userModel.showLots(choice);
		if (lots != null)
			userView.showLots(lots);
		else
			userView.errorMessage("Invalid data");
	}

	public void bookLot(int row, int col, int days, int choice) {
		// TODO Auto-generated method stub
		if (userModel.bookLot(row - 1, col - 1, days, choice)) {
			userView.booked("lot booked successfully");
		} else {
			userView.errorMessage("Invalid data");
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

	public void addCar(String brand, String regno, String name, long mblno, int choice) {
		LocalTime lt = LocalTime.now();
		LocalDate ld = LocalDate.now();
		if (userModel.addCar(brand, regno, name, mblno, lt, ld, choice)) {
			userView.success("Parking successfully made...");
		} else {
			userView.errorMessage("Invalid data");
		}
	}
}
