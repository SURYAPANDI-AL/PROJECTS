package trainer;

import java.util.List;

import dto.Course;
import dto.Trainer;

public class TrainerController implements TrainerControllerCallBack,TrainerModelControllerCallBack{

	private TrainerViewCallBack trainerView;
	private TrainerModelCallBack trainerModel;
	
public TrainerController(TrainerViewCallBack adminView) {
		
		this.trainerView=trainerView;
		trainerModel=new TrainerModel(this);
	}

public void inputValidation(String input ) {
	int choice = 0;
	try {
		choice=Integer.parseInt(input);
	} catch (NumberFormatException e) {
		System.err.println("enter valid input");
		trainerView.trainerHomePage();
	}catch(Exception e) {
		System.err.println("enter valid input");
		trainerView.trainerHomePage();
	}
}

	public void addSkills(Trainer trainer, List<String> skills) {
		trainerModel.addSkills(trainer,skills);
		trainerView.message("Skill added Successfully.");
		trainerView.trainerHomePage();
	}

	public List<Course> mySpecificCourseTrainer(String trainerId) {
		return trainerModel.mySpecificCourseTrainer(trainerId);
	}

	public boolean setPwd(String pwd, String rpwd, Trainer trainer) {
		if(pwd.equals(rpwd)) {
			trainerModel.setPwd(pwd,trainer);
			return true;
		}
		return false;
	}

}
