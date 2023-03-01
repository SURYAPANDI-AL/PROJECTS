package login;

import dto.Admin;
import dto.Trainer;
import dto.User;

public interface LoginModelCallBack {

	Admin validAdmin(String adminId, String adminPwd);

	Trainer validTrainer(String trainerId, String trainerPwd);

	boolean addUser(String string, String name, String email, String pwd, long mblno);

	User validUser(String userId, String userPwd);

	boolean checkUser(String email, long mblno);

}
