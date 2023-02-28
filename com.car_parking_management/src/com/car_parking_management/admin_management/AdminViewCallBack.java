package com.car_parking_management.admin_management;

import com.car_parking_management.dto.Car;

public interface AdminViewCallBack {

	void addCar();

	void manageCar();

	void searchCar();

	void registedUser();

	void errorMessage(String string);

	void exit();

	void success(String string);

	void printDetails(Car car);

}
