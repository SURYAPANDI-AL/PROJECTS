package trainer;

import java.util.List;

import dto.Course;
import dto.Trainer;
import repository.CourseManagementDataBase;

public class TrainerModel implements TrainerModelCallBack{

	private TrainerControllerCallBack trainerController;
	private CourseManagementDataBase cmdb=CourseManagementDataBase.getInstance();
	
	public TrainerModel(TrainerControllerCallBack trainerController) {
		this.trainerController=trainerController;
	}

	public void addSkills(Trainer trainer, List<String> skills) {
		cmdb.addSkills(trainer,skills);
	}

	public List<Course> mySpecificCourseTrainer(String trainerId) {
		return cmdb.mySpecificCourseTrainer(trainerId);
	}

	public void setPwd(String pwd, Trainer trainer) {
		cmdb.setPwd(pwd,trainer);
	}
}
