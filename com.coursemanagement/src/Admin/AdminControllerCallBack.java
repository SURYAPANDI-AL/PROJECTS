package Admin;

import java.time.LocalDate;
import java.util.List;

import dto.Course;
import dto.TrainerCredentials;

public interface AdminControllerCallBack {

	void inputValidation(String sChoice);

	void validateKey(String key);

	boolean validatepwd(String pwd, String confirmPwd);

	void addAdmin(String name, String pwd);

	List<TrainerCredentials> showTrainers();

	void removeTrainer(String trainerId);

	boolean validateMblno(long mblNo);

	boolean validateEmail(String email);

	void addTrainer(String name, String email, String string, long mblNo, List<String> skillSet);

	List<Course> showCourse();

	void removeCourse(String courseId);

	void validateDate(String startDateS);

	void checkFloatInput(String sInput);

	void addCourse(String course, String trainerId, LocalDate parse, LocalDate parse2, LocalDate parse3,
			List<String> lectures, int totalSeats, float payment);

	void inputMobileValidation(String smblNo);

}
