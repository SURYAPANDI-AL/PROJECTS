package dto;

import java.util.List;

public class TrainerCredentials extends Trainer {

	private String trainerPwd;

	public TrainerCredentials(String trainerName, String trainerId, String emailId, List<String> skillSet,
			Long mobileNumber, String trainerPwd) {
		super(trainerName, trainerId, emailId, skillSet, mobileNumber);
		this.trainerPwd = trainerPwd;
	}

	public String getTrainerPwd() {
		return trainerPwd;
	}

	public void setTrainerPwd(String trainerPwd) {
		this.trainerPwd = trainerPwd;
	}

}
