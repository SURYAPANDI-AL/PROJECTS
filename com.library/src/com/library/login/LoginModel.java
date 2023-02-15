package com.library.login;

public class LoginModel implements LoginModelCallBack {
	
	private LoginModelControllerCallBack loginController;
	
	public LoginModel(LoginModelControllerCallBack loginController)
	{
		this.loginController=loginController;
	}

	public void checkCredentials(String userName, String password) {
		if(userName.equals("admin") && password.equals("zsgs"))
		{
			loginController.loginSucess(userName);
		}
		else
		{
			loginController.loginFail("Invalid Data!-please try again.");
		}
	}
	public interface LoginModelControllerCallBack{
		
		void loginSucess(String userName);
		
		void loginFail(String string);
	}
}
