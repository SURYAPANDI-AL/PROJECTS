package com.flight_ticket_reservation_system.userRegistation;

public class UserRegistationController implements UserRegistationControllerCallBack, UserRegistationModelControllerCallBack {

	private UserRegistationViewCallBack userRegistationView;
	private UserRegistationModelCallBack userRegistationModel;
	public UserRegistationController(UserRegistationViewCallBack userRegistationView) {
		this.userRegistationView=userRegistationView;
		userRegistationModel=new UserRegistationModel(this);
	}
	public void checkCredentials(String name, Long phno, String email, String pwd, String cpwd) {
		if(pwd.equals(cpwd)) {
			userRegistationModel.addUser(name,phno,email,pwd);
		}
		else
			userRegistationView.invalidData("Invalid data.");
	}

}
