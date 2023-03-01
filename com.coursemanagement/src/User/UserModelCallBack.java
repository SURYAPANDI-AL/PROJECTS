package User;

import java.util.List;

import dto.Course;
import dto.Trainer;
import dto.User;

public interface UserModelCallBack {

	List<Course> showCourse();

	List<String> getUserCourses(String userId);

	float getPayment(String selectedCourseId);

	boolean addMyCourse(User user, String selectedCourseId);

	Trainer getTrainer(String trainerId);

	boolean checkSeats(String selectedCourseId);

	Course getMyCourseUsingCourseId(String courses);

}
