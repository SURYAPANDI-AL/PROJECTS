package trainer;

import java.util.List;

import dto.Course;
import dto.Trainer;

public interface TrainerModelCallBack {

	void addSkills(Trainer trainer, List<String> skills);

	List<Course> mySpecificCourseTrainer(String trainerId);

	void setPwd(String pwd, Trainer trainer);

}
