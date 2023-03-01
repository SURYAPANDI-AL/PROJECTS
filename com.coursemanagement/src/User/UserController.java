package User;

import java.util.List;

import dto.Course;
import dto.Trainer;
import dto.User;

public class UserController implements UserControllerCallBack,UserModelControllerCallBack{
	
	private UserViewCallBack userView;
	private UserModelCallBack userModel;
	public UserController(UserViewCallBack userView) {
		
		this.userView=userView;
		userModel=new UserModel(this);
	}
	public void inputValidation(String input ) {
		int choice = 0;
		try {
			choice=Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.err.println("enter valid input");
			userView.userHomePage();
		}
	}
	public List<Course> showCourse() {
		return userModel.showCourse();
	}
	public List<String> getUserCourses(String userId) {
		return userModel.getUserCourses(userId);
	}
	public void checkFloatInput(String sInput) {
		float choice = 0;
		try {
			choice=Float.parseFloat(sInput);
		} catch (NumberFormatException e) {
			System.err.println("enter valid input");
			userView.userHomePage();
		}
	}
	public float getPayment(String selectedCourseId) {
		return userModel.getPayment(selectedCourseId);
	}
	public boolean addMyCourse(User user, String selectedCourseId) {
		return userModel.addMyCourse(user,selectedCourseId);
	}
	public boolean validateMyChoice(int choice, int size) {
		if(choice>=1 && choice<=size)return true;
		return false;
	}
	public Trainer getTrainer(String trainerId) {
		return  userModel.getTrainer(trainerId);
	}
	public boolean checkAvailableSeats(String selectedCourseId) {
		return userModel.checkSeats(selectedCourseId);
	}
	public Course getMyCourseUsingCourseId(String courses) {
		 Course myCourse=userModel.getMyCourseUsingCourseId(courses);
		 return myCourse;
	}
}
