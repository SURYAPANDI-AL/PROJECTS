package User;

import java.util.ArrayList;
import java.util.List;

import dto.Course;
import dto.Trainer;
import dto.User;
import repository.CourseManagementDataBase;

public class UserModel implements UserModelCallBack {

	private UserModelControllerCallBack userController;
	private CourseManagementDataBase cmdb=CourseManagementDataBase.getInstance();
	
	public UserModel(UserModelControllerCallBack userController) {
		this.userController=userController;
	}

	public List<Course> showCourse() {
		return cmdb.showCourse();
	}

	public List<String> getUserCourses(String userId) {
		List<String> myCourse = new ArrayList();
		List<String> course=cmdb.getUserCourses(userId);
		if(course!=null) {
			for(String e:course) {
				myCourse.add(e);
			}
			return myCourse;
		}
		return null;
	}

	public float getPayment(String selectedCourseId) {
		
		return cmdb.getPayment( selectedCourseId);
	}

	public boolean addMyCourse(User user, String selectedCourseId) {
		List<String> temp=cmdb.addMyCourse(user,selectedCourseId);
		List<String> myCourse=new ArrayList();
		if(temp!=null) {
			for(String e:temp) {
				if(e!=null)
					myCourse.add(e);
			}
		}
		myCourse.add(selectedCourseId);
		
		return cmdb.updateMyCourse(user.getUserId(),myCourse);
	}

	public Trainer getTrainer(String trainerId) {
		
		return cmdb.getTrainerWithId(trainerId);
	}

	public boolean checkSeats(String courseId) {
		
		return cmdb.checkSeats(courseId);
	}

	public Course getMyCourseUsingCourseId(String courses) {
		return cmdb.getMyCourseUsingCourseId(courses);
	}
}
