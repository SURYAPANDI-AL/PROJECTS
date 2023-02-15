package com.library.login;

import java.util.Scanner;
import com.library.setuplibrary.*;

public class LoginView implements LoginViewCallBack{
	
	//create instance of LoginController to access LoginController.
		private LoginControllerCallBack loginController;
		private Scanner scanner=new Scanner(System.in);
		public LoginView()
		{
			loginController = new LoginController(this);
		}
		public static void main(String[]args)
		{
			LoginView loginView=new LoginView();
			loginView.checkForLogin();
		}
		public void checkForLogin()
		{
			System.out.println("Welcome to library Management system\n---------------------------------");
			System.out.println("Enter UserName:");
			String userName=scanner.next();
			System.out.println("Enter password:");
			String password=scanner.next();
			loginController.checkCredentialssOnline(userName,password);
		}
		public void loginSuccess(String userName)
		{
			System.out.println("-->welcome "+userName+"<--");
			System.out.println("Thanks for login");
			
			new SetuplibraryView().gotoLibrary();
		}
		public void loginFail(String errorMessage)
		{
			System.out.println(errorMessage);
			checkForLogin();
		}
}
