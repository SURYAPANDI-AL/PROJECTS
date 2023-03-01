package dto;

public class AdminCredentials extends Admin {

	private String adminPwd;

	public AdminCredentials(String adminId, String adminName, String adminPwd) {
		super(adminId, adminName);
		this.adminPwd = adminPwd;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

}
