package login;


import dto.Admin;
import dto.Trainer;
import dto.User;
import repository.CourseManagementDataBase;

public class LoginModel implements LoginModelCallBack{

	private LoginControllerCallBack loginController;
	private CourseManagementDataBase cmdb=CourseManagementDataBase.getInstance();
	
	public LoginModel(LoginControllerCallBack loginController) {
		
		this.loginController=loginController;
	}

	public Admin validAdmin(String adminId, String adminPwd) {
		return cmdb.getAdmin(adminId,adminPwd);
	}

	public Trainer validTrainer(String trainerId, String trainerPwd) {
		return cmdb.getTrainer(trainerId,trainerPwd);
	}

	public User validUser(String userId, String userPwd) {
		return cmdb.getUser(userId,userPwd);
	}
	public boolean checkUser(String email, long mblno) {
		
		return cmdb.checkUser(email,mblno);
	}

	public boolean addUser(String id, String name, String email, String pwd, long mblno) {
		return cmdb.addUser(id,name,email,pwd,mblno);
	}
}
