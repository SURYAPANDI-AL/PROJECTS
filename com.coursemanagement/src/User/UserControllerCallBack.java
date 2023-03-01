package User;

import java.util.List;

import dto.Course;
import dto.Trainer;
import dto.User;

public interface UserControllerCallBack {

	void inputValidation(String sChoice);

	boolean validateMyChoice(int choice, int size);

	Course getMyCourseUsingCourseId(String courseSelected);

	Trainer getTrainer(String trainerId);

	float getPayment(String selectedCourseId);

	boolean checkAvailableSeats(String selectedCourseId);

	void checkFloatInput(String sInput);

	boolean addMyCourse(User user, String selectedCourseId);

	List<String> getUserCourses(String userId);

	List<Course> showCourse();

}
