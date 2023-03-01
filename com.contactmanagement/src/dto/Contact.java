package dto;

import java.util.List;

public class Contact {

	private String name;
	private List<String> number;
	private String emailId;
	private String dateOfBirth;

	public Contact(String name, List<String> number, String emailId, String dateOfBirth) {
		super();
		this.name = name;
		this.number = number;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public List<String> getNumber() {
		return number;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumber(List<String> number) {
		this.number = number;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
