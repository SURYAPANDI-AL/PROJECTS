package com.library.login;

import com.library.login.LoginModel.LoginModelControllerCallBack;

public class LoginController implements LoginControllerCallBack,LoginModelControllerCallBack{

	private LoginViewCallBack loginView;
	
	private LoginModelCallBack loginModel;
	
	public LoginController(LoginViewCallBack loginView) {
		
		this.loginView=loginView;
		loginModel=new LoginModel(this);
	}

	public void checkCredentialssOnline(String userName, String password) {
		loginModel.checkCredentials(userName,password);
	}
	public void loginSucess(String userName)
	{
		loginView.loginSuccess(userName);
	}
	public void loginFail(String errorMessage)
	{
		loginView.loginFail(errorMessage);
	}
}
