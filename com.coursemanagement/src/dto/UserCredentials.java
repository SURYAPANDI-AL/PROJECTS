package dto;

import java.util.List;

public class UserCredentials extends User {
	private String UserPwd;

	public UserCredentials(String userName, String userId, String emailId, List<String> signedUpCourses,
			Long userMobileNumber, String userpwd) {
		super(userName, userId, emailId, signedUpCourses, userMobileNumber);
		UserPwd = userpwd;
	}
	
	public String getUserpwd() {
		return UserPwd;
	}

	public void setUserpwd(String userpwd) {
		UserPwd = userpwd;
	}

}
