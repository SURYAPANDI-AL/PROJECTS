package com.flight_ticket_reservation_system.login;

import com.flight_ticket_reservation_system.dto.Admin;
import com.flight_ticket_reservation_system.userLogin.UserLoginView;
import com.flight_ticket_reservation_system.userRegistation.UserRegistationView;

public class LoginController implements LoginControllerCallBack,LoginModelControllerCallBack{
	private LoginViewCallBack loginView;
	private Admin user;
	private LoginModelCallBack loginModel;
	public LoginController(LoginView loginView) {
		this.loginView=loginView;
		loginModel=new LoginModel(this);
	}
	public void checkCredentials(String userId, String password) {
		loginModel.checkCredentialsDb(userId,password);
	}
	public void loginSuccess(Admin adminUser) {
		user=adminUser;
		loginView.loginSuccess(adminUser);
		
	}
	public void loginFailiure(String errorMessage) {
		loginView.loginFailure(errorMessage);
		
	}
	public void checkChoice(int choice) {
		if(choice==3)
		{
			UserRegistationView user=new UserRegistationView();
			user.create();
		}
		else if(choice==1) {
			UserLoginView user=new UserLoginView();
			user.create();
		}
		else if(choice>3) {
			loginView.loginFailure("sorry!");
		}
	}
	public void addFlight(int flightNumber, String flightName, String source, String destination, Float depatureTime,
			int seats, int thakkalseats) {
		loginModel.addFlight(flightNumber,flightName,source,destination,depatureTime,seats,thakkalseats);
		
	}
	@Override
	public void checkAdminChoice(int choice) {
		switch(choice)
		{
		case 1:
			loginView.addFlight();
			break;
		case 2:
			loginView.removeFlight();
			break;
		case 3:
			loginView.savings();
			break;
		case 4:
			loginView.addAdmin();
			break;
		case 6:
			loginView.Exit();
			break;
		default:
			loginView.loginSuccess(user);
		}
		
	}
	@Override
	public void addAdmin(long sId,String id, String name, String pwd) {
		// TODO Auto-generated method stub
		boolean isSuccess= loginModel.addAdmin(sId,id,name,pwd);
		if(isSuccess)loginView.loginSuccess(user);
		loginView.loginFailure("Warning!!!!..");
	}
	@Override
	public long savings() {
		// TODO Auto-generated method stub
		return loginModel.savings();
	}
	@Override
	public boolean removeFlight(int flightId) {
		// TODO Auto-generated method stub
		return loginModel.removeFlight(flightId);
	}

}
