package com.car_parking_management.login;

public interface LoginControllerCallBack {

	void choiceMade(int choice);

	void validateAdmin(String name, String pwd);

	void validateUser(String name, String pwd);

	boolean validateMblno(long mblno);

	boolean validateEmail(String email);

	boolean validatepwd(String pwd, String confirmPwd);

	void addUser(String name, String email, String pwd, long mblno);

	void inputValidation(String sChoice);
	
}
