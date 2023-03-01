package Admin;

import java.time.LocalDate;
import java.util.List;

import dto.Course;
import dto.TrainerCredentials;

public interface AdminModelCallBack {

	Object getkey();

	boolean checkAdmin(String name, String pwd);

	boolean addAdmin(String string, String name, String pwd);

	boolean checkTrainer(long mblNo, String email);

	boolean addTrainer(String string, String email, List<String> skillSet, String name, long mblNo, String pwd);

	boolean checkTrainerUsingId(String trainerId2);

	boolean removeTrainer(String trainerId2);

	List<TrainerCredentials> showTrainers();

	boolean checkCourseUsingId(String courseId);

	boolean removeCourse(String courseId);

	List<Course> showCourse();

	String getTrainerName(String trainerId2);

	boolean addCourse(String string, String course, String trainerId2, String trainerName, LocalDate sDate,
			LocalDate eDate, LocalDate dDate, List<String> lectures, int totalSeats, float payment);

}
