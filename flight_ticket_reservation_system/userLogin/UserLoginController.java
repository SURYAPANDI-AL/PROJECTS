package com.flight_ticket_reservation_system.userLogin;

import com.flight_ticket_reservation_system.dto.Admin;
import com.flight_ticket_reservation_system.dto.User;
import com.flight_ticket_reservation_system.userRegistation.UserRegistationView;

public class UserLoginController implements UserLoginControllerCallBack,UserLoginModelControllerCallBack {
	private UserLoginViewCallBack userLoginView;
	private UserLoginModelCallBack userLoginModel;
	public UserLoginController(UserLoginViewCallBack userLoginView) {
		this.userLoginView=userLoginView;
		userLoginModel=new UserLoginModel(this);
	}
	public void checkCredentials(String userId, String password) {
		userLoginModel.checkCredentialsDb(userId,password);
	}
	public void loginSuccess(User user) {
		userLoginView.loginSuccess(user);
		
	}
	public void loginFailiure(String errorMessage) {
		userLoginView.loginFailure(errorMessage);
		
	}

}

