package com.car_parking_management.admin_management;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.car_parking_management.dto.Car;
import com.car_parking_management.dto.User;

public interface AdminModelCallBack {

	boolean addCar(String brand, String regno, String name, long mblno, LocalTime lt, LocalDate ld);

	boolean manageCar(String registerNumber);

	Car searchCar(int parkingNumber);

	List<User> resistedUser();

	int totalEntry();

	int todayEntry();

	int yesterdayEntry();

	int lastSevendayEntry();

}
