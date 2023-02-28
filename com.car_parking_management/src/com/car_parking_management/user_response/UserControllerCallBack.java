package com.car_parking_management.user_response;

import java.util.List;

import com.car_parking_management.dto.Car;
import com.car_parking_management.dto.User;

public interface UserControllerCallBack {

	void validateChoice(int choice);

	List<Car> getCar(User user);

	void availableLots(int choice);

	boolean validateMblno(long mblno);

	void bookLot(int floorNumber, int slotNumber, int days, int choice);

	void addCar(String brand, String regno, String name, long mblno, int choice);

}
