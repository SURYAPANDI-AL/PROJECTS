package Admin;

import java.time.LocalDate;
import java.util.List;

import dto.Course;
import dto.Trainer;
import dto.TrainerCredentials;
import repository.CourseManagementDataBase;

public class AdminModel implements AdminModelCallBack{
	
	private AdminModelControllerCallBack adminController;
	private CourseManagementDataBase cmdb=CourseManagementDataBase.getInstance();
	
	public AdminModel(AdminModelControllerCallBack adminController) {
		this.adminController=adminController;
	}

	public String getkey() {
		
		return cmdb.getKey();
	}

	public boolean checkAdmin(String name, String pwd) {
		return cmdb.checkAdmin(name,pwd);
	}

	public boolean addAdmin(String adminId, String name, String pwd) {
		
		return cmdb.addAdmin(adminId,name,pwd);
	}

	public boolean checkTrainer(long mblNo, String email) {
		return cmdb.checkTrainer(mblNo,email);
	}

	public boolean addTrainer(String trainerId, String email, List<String> skillSet, String name,long mblNo, String pwd) {
		return cmdb.addTrainer(trainerId,email,skillSet,name,mblNo,pwd);
	}

	public boolean checkTrainerUsingId(String trainerId) {
		return cmdb.checkTrainerUsingId(trainerId);
	}

	public boolean removeTrainer(String trainerId) {
		return cmdb.removeTrainer(trainerId);
	}

	public List<TrainerCredentials> showTrainers() {
		return cmdb.showTrainers();
	}

	public boolean checkCourseUsingId(String courseId) {
		return cmdb.checkCourseUsingId(courseId);
	}

	public boolean removeCourse(String courseId) {
		return cmdb.removeCourse(courseId);
	}

	public List<Course> showCourse() {
		return cmdb.showCourse();
	}

	public String getTrainerName(String trainerId2) {
		return cmdb.getTrainerName(trainerId2);
	}

	public boolean addCourse(String courseId, String course, String trainerId2, String trainerName, LocalDate sDate,
			LocalDate eDate, LocalDate dDate, List<String> lectures, int totalSeats,float payment) {
		return cmdb.addCourse(courseId ,course,trainerId2,trainerName,sDate,eDate,dDate,lectures,totalSeats,payment);
	}

}
