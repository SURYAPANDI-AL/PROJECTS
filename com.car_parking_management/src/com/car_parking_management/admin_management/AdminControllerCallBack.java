package com.car_parking_management.admin_management;

import java.util.List;

import com.car_parking_management.dto.User;

public interface AdminControllerCallBack {

	void validateChoice(int choice);

	boolean validateMblno(long mblno);

	void addCar(String brand, String regno, String name, long mblno);

	void manageCar(String num);

	void searchCar(int parkno);

	List<User> registedUser();

	int totalEntry();

	int todayEntry();

	int yesterdayEntry();

	int lastSevendayEntry();

}
