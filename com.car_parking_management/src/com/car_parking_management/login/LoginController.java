package com.car_parking_management.login;

import com.car_parking_management.admin_management.AdminView;
import com.car_parking_management.dto.Admin;
import com.car_parking_management.dto.User;
import com.car_parking_management.user_response.UserView;

public class LoginController implements LoginControllerCallBack, LoginModelControllerCallBack {
	private LoginViewCallBack loginView;
	private LoginModelCallBack loginModel;

	public LoginController(LoginViewCallBack loginView) {
		this.loginView = loginView;
		loginModel = new LoginModel(this);
	}

	public void inputValidation(String input) {
		int choice = 0;
		try {
			choice = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.err.println("enter valid input");
			System.exit(0);
		}

	}

	// initial page choice choose
	public void choiceMade(int choice) {
		switch (choice) {
		case 1:
			loginView.adminLogin();
			break;
		case 2:
			loginView.userLogin();
			break;
		case 3:
			loginView.userRegistation();
			break;
		default:
			loginView.message("Invalid data!");
		}
	}

	// check mobile number has 10 digits.
	public boolean validateMblno(long mblno) {
		int digit;
		for (digit = 0; mblno != 0; digit++)
			mblno /= 10;
		if (digit == 10)
			return true;
		return false;
	}

	public boolean validateEmail(String email) {
		if (email.contains("@") && email.contains("com"))
			return true;
		return false;
	}

	public boolean validatepwd(String pwd, String confirmPwd) {
		if (pwd.equals(confirmPwd))
			return true;
		return false;
	}

	public void addUser(String name, String email, String pwd, long mblno) {
		if (loginModel.addUser(name, email, pwd, mblno)) {
			loginView.message("Your account hasbeen created successfully...");
		} else
			loginView.message("Already regitered");
	}

	public void validateAdmin(String name, String pwd) {
		if (loginModel.validateAdmin(name, pwd)) {
			AdminView av = new AdminView();
			av.create(new Admin(name, pwd));
		} else
			loginView.message("Invalid credentials");
	}

	public void validateUser(String name, String pwd) {
		User user = loginModel.validateUser(name, pwd);
		if (user != null) {
			UserView uv = new UserView();
			uv.create(user);
		} else
			loginView.message("Invalid credentials");
	}
}
