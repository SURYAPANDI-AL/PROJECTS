package dto;

import java.util.List;

public class Trainer {

	private String trainerName;
	private String trainerId;
	private String emailId;
	private List<String> skillSet;
	private Long mobileNumber;

	public Trainer(String trainerName, String trainerId, String emailId, List<String> skillSet, Long mobileNumber) {
		super();
		this.trainerName = trainerName;
		this.trainerId = trainerId;
		this.emailId = emailId;
		this.skillSet = skillSet;
		this.mobileNumber = mobileNumber;
	}
	public void addSkill(String skill) {
		skillSet.add(skill);
	}
	public String getTrainerName() {
		return trainerName;
	}

	public String getTrainerId() {
		return trainerId;
	}

	public String getEmailId() {
		return emailId;
	}

	public List<String> getSkillSet() {
		return skillSet;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setSkillSet(List<String> skillSet) {
		this.skillSet = skillSet;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
