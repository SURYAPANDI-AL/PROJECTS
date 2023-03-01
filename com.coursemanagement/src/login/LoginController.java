package login;

import Admin.AdminView;
import User.UserView;
import dto.Admin;
import dto.Trainer;
import dto.User;
import trainer.TrainerView;

public class LoginController implements LoginControllerCallBack,LoginModelControllerCallBack{

	private LoginViewCallBack loginView;
	private LoginModelCallBack loginModel;
	private static int id=1;
	
	public LoginController(LoginViewCallBack loginView) {
		
		this.loginView=loginView;
		loginModel=new LoginModel(this);
	}
	public void inputMobileValidation(String smblNo) {
		long choice = 0;
		try {
			choice=Long.parseLong(smblNo);
		} catch (NumberFormatException e) {
			System.err.println("enter valid input");
			loginView.homePage();
		}catch(Exception e) {
			System.err.println("enter valid input");
			loginView.homePage();
		}
	}
	public void inputValidation(String input ) {
		int choice = 0;
		try {
			choice=Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.err.println("enter valid input");
			loginView.homePage();
		}catch(Exception e) {
			System.err.println("enter valid input");
			loginView.homePage();
		}
	}
	public void validateAdmin(String adminId,String adminPwd) {
		
		Admin admin=loginModel.validAdmin(adminId,adminPwd);
		if(admin!=null) {
			AdminView av=new AdminView();
			av.create(admin);
		}else {
			loginView.homePage();
		}
	}
	public void validateTrainer(String trainerId,String trainerPwd) {
		
		Trainer trainer=loginModel.validTrainer(trainerId,trainerPwd);
		if(trainer!=null) {
			TrainerView tv=new TrainerView();
			tv.create(trainer);
		}else {
			loginView.homePage();
		}
	}
//*******************************User******************************************
	public void validateUser(String userId,String userPwd) {
		
		User user=loginModel.validUser(userId,userPwd);
		if(user!=null) {
			UserView uv=new UserView();
			uv.create(user);
		}else {
			loginView.homePage();
		}
	}
	public boolean validateMblno(long mblno) {
		int digit;
		for(digit=0;mblno!=0;digit++)mblno/=10;
		if(digit==10)return true;
		return false;
	}

	public boolean validateEmail(String email) {
		if(email.contains("@") && email.contains("."))return true;
		return false;
	}

	public boolean validatepwd(String pwd, String confirmPwd) {
		if(pwd.equals(confirmPwd))return true;
		return false;
	}

	public void addUser(String name, String email, String pwd, long mblno) {
		
		if(!loginModel.checkUser(email,mblno) && loginModel.addUser("ZSGS00"+ id ,name,email,pwd,mblno)) {
			loginView.message("Your account hasbeen created successfully...\nUSER ID :ZSGS00"+id++);
		}
		else loginView.message("Already regitered");
	}
}
