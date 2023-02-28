package com.car_parking_management.user_response;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.car_parking_management.dto.Car;
import com.car_parking_management.dto.User;

public interface UserModelCallBack {

	List<Car> getCar(User user);

	int[][] showLots(int choice);

	boolean bookLot(int i, int j, int days, int choice);

	boolean addCar(String brand, String regno, String name, long mblno, LocalTime lt, LocalDate ld, int choice);

}
