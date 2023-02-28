package com.car_parking_management.login;

import com.car_parking_management.dto.User;
import com.car_parking_management.repository.CarParkingManagementDB;

public class LoginModel implements LoginModelCallBack{
	private LoginModelControllerCallBack loginController;
	public LoginModel(LoginModelControllerCallBack loginController) {
		this.loginController=loginController;
	}
	public boolean addUser(String name, String email, String pwd, long mblno) {
		
		return CarParkingManagementDB.getInstance().addUser(name,email,pwd,mblno);
	}
	public boolean validateAdmin(String name, String pwd) {
		// TODO Auto-generated method stub
		return CarParkingManagementDB.getInstance().validateAdmin(name,pwd);
	}
	public User validateUser(String name, String pwd) {
		// TODO Auto-generated method stub
		return CarParkingManagementDB.getInstance().validateUser(name,pwd);
	}
}
