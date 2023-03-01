package login;

import java.util.Scanner;

public class LoginView implements LoginViewCallBack{

	private LoginControllerCallBack loginController;
	private Scanner sc=new Scanner(System.in);
	
	public LoginView() {
		loginController = new LoginController(this);
	}

	public void homePage() {
		
		System.out.println("------>Welcome to New Learning Course<------");
		System.out.println("1.Admin Login\n2.Student Login\n3.New Student\n4.Trainer Login");
		String sChoice=sc.next();
		loginController.inputValidation(sChoice);
		int choice= Integer.parseInt(sChoice);
		switch(choice) {
			case 1:
				adminLogIn();
				break;
			case 2:
				userLogIn();
				break;
			case 3:
				userRegistation();
				break;
			case 4:
				trainerLogIn();
			default:
				exit();
		}
	}

	private void trainerLogIn() {
		System.out.println("---------->Trainer<-------------");
		System.out.print("Trainer Id: ");
		String trainerId=sc.next();
		System.out.print("Password: ");
		String trainerPwd=sc.next();
		loginController.validateTrainer(trainerId, trainerPwd);
	}

	private void userRegistation() {
		System.out.println("------------>StudentRegistation<----------");
		String name,email,pwd,confirmPwd;
		long mblno;
		System.out.print("Name\t\t: ");
		name=sc.next();
		long mblNo;
		do {
			System.out.print("Mobile No\t: ");
			String smblNo=sc.next();
			loginController.inputMobileValidation(smblNo);
			mblNo=Long.parseLong(smblNo);
		}while(!loginController.validateMblno(mblNo));
		do {
			System.out.print("Email address\t: ");
			email=sc.next();
		}while(!loginController.validateEmail(email));
		do {
			System.out.print("Password\t: ");
			pwd=sc.next();
			System.out.print("Confirm password: ");
			confirmPwd=sc.next();
		}while(!loginController.validatepwd(pwd,confirmPwd));
		loginController.addUser(name,email,pwd,mblNo);
	}
	

	private void userLogIn() {
		System.out.println("---------->Student<-------------");
		System.out.print("Student Id: ");
		String userId=sc.next();
		System.out.print("Password: ");
		String userPwd=sc.next();
		loginController.validateUser(userId, userPwd);
	}

	private void adminLogIn() {
		System.out.println("---------->Admin<-------------");
		System.out.print("Admin Id: ");
		String adminId=sc.next();
		System.out.print("Password: ");
		String adminPwd=sc.next();
		loginController.validateAdmin(adminId, adminPwd);
	}
	
	private void exit() {
		System.out.println("-->ThankYou<--");
		System.exit(0);
	}

	public void message(String message) {
		System.out.println(message);
		userLogIn();
	}

}
