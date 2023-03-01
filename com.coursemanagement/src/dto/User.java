package dto;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String userName;
	private String userId;
	private String emailId;
	private List<String> signedUpCourses=new ArrayList();
	private Long userMobileNumber;

	public User(String userName, String userId, String emailId, List<String> signedUpCourses, Long userMobileNumber) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.emailId = emailId;
		this.signedUpCourses = signedUpCourses;
		this.userMobileNumber = userMobileNumber;
	}
	


	public String getUserName() {
		return userName;
	}

	public String getUserId() {
		return userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public List<String> getSignedUpCourses() {
		return signedUpCourses;
	}

	public Long getUserMobileNumber() {
		return userMobileNumber;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setSignedUpCourses(List<String> signedUpCourses) {
		this.signedUpCourses = signedUpCourses;
	}

	public void setUserMobileNumber(Long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}

}
