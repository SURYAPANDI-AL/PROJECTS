package trainer;

import java.util.List;

import dto.Course;
import dto.Trainer;

public interface TrainerControllerCallBack {

	void inputValidation(String sChoice);

	boolean setPwd(String pwd, String rpwd, Trainer trainer);

	List<Course> mySpecificCourseTrainer(String trainerId);

	void addSkills(Trainer trainer, List<String> skills);

}
