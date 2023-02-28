package com.car_parking_management.user_response;

public interface UserViewCallBack {

	void viewBills();

	void location();

	void exit();

	void errorMessage(String string);

	void showLots(int[][] lots);

	void booked(String string);

	void success(String string);

}
