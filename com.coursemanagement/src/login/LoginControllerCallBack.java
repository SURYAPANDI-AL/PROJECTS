package login;

public interface LoginControllerCallBack {

	void inputValidation(String sChoice);

	void validateTrainer(String trainerId, String trainerPwd);

	void inputMobileValidation(String smblNo);

	boolean validateMblno(long mblNo);

	boolean validatepwd(String pwd, String confirmPwd);

	boolean validateEmail(String email);

	void addUser(String name, String email, String pwd, long mblNo);

	void validateUser(String userId, String userPwd);

	void validateAdmin(String adminId, String adminPwd);

}
