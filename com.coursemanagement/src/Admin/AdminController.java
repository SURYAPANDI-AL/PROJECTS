package Admin;

import java.time.LocalDate;
import java.util.List;

import dto.Course;
import dto.Trainer;
import dto.TrainerCredentials;

public class AdminController implements AdminControllerCallBack,AdminModelControllerCallBack{
	
	private AdminViewCallBack adminView;
	private AdminModelCallBack adminModel;
	private static int adminId=2;
	private static int trainerId=4;
	private static int courseId=11;

	public AdminController(AdminViewCallBack adminView2) {
		
		this.adminView=adminView2;
		adminModel=new AdminModel(this);
	}
	public void inputValidation(String input ) {
		int choice = 0;
		try {
			choice=Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.err.println("enter valid input");
			adminView.adminHomePage();
		}catch(Exception e) {
			System.err.println("enter valid input");
			adminView.adminHomePage();
		}
	}
	public void inputMobileValidation(String smblNo) {
		long choice = 0;
		try {
			choice=Long.parseLong(smblNo);
		} catch (NumberFormatException e) {
			System.err.println("enter valid input");
			adminView.adminHomePage();
		}catch(Exception e) {
			System.err.println("enter valid input");
			adminView.adminHomePage();
		}
	}
	public boolean validateMblno(long mblno) {
		int digit;
		for(digit=0;mblno!=0;digit++)mblno/=10;
		if(digit==10)return true;
		return false;
	}

	public boolean validateEmail(String email) {
		if(email.contains("@") && email.contains("."))return true;
		return false;
	}

	public boolean validatepwd(String pwd, String confirmPwd) {
		if(pwd.equals(confirmPwd))return true;
		return false;
	}
	public void validateKey(String key) {
		if(!adminModel.getkey().equals(key)) {
			adminView.message("Sorry.Key is not valid..");
			adminView.adminHomePage();
		}
	}
	public void addAdmin(String name, String pwd) {
		
		if(!adminModel.checkAdmin(name,pwd) && adminModel.addAdmin("SP00"+ adminId ,name,pwd)) {
			adminView.message("Your account hasbeen created successfully...\nUSER ID :SP00"+adminId++);
		}
		else adminView.message("Already regitered");
		adminView.adminHomePage();
	}
	
public void addTrainer(String name,String  email,String pwd,long mblNo, List<String> skillSet) {
		
		if(!adminModel.checkTrainer(mblNo, email) && adminModel.addTrainer("ZTR00"+ trainerId ,email,skillSet,name,mblNo,pwd)) {
			adminView.message("Trainer has been created successfully...\nUSER ID :ZTR00"+trainerId++ +"\ndefault PASSWORD :000000");
		}
		else adminView.message("Already regitered");
		adminView.adminHomePage();
	}
public void removeTrainer(String trainerId2) {
	if(!adminModel.checkTrainerUsingId(trainerId2) && adminModel.removeTrainer(trainerId2)) { 
		adminView.message(trainerId2+" account has successfully removed..");
	}
	else {
		adminView.message("Invalid Credentials.");
	}
	adminView.adminHomePage();
}
public List<TrainerCredentials> showTrainers() {
	return adminModel.showTrainers();
}
public void removeCourse(String courseId) {
	if(!adminModel.checkCourseUsingId(courseId) && adminModel.removeCourse(courseId)) { 
		adminView.message(courseId+" account has successfully removed..");
	}
	else {
		adminView.message("Invalid Credentials.");
	}
	adminView.adminHomePage();
}
public List<Course> showCourse() {
	return adminModel.showCourse();
}
//+++++++++++++++++date Validation+++++++++++++++++++++++++++++++++++++++++++
public void validateDate(String input) {
	try{
		LocalDate date =LocalDate.parse(input);
	}catch(Exception e){
		System.err.println("enter valid input");
		adminView.addCourse();
	}
}
public void addCourse(String course, String trainerId2, LocalDate sDate, LocalDate eDate, LocalDate dDate,
		List<String> lectures, int totalSeats,float payment) {
	if(adminModel.checkTrainerUsingId(trainerId2)) {
		String trainerName=adminModel.getTrainerName(trainerId2);
		if((trainerName!=null)&& (adminModel.addCourse("CS00"+ courseId ,course,trainerId2,trainerName,sDate,eDate,dDate,lectures,totalSeats,payment)) && validateDate(sDate,eDate,dDate)) {
			adminView.message("Course created successfully...\nCourse ID :CS00"+courseId++);
		}
		else {
			adminView.message("invalid data..");
			}
	}
	adminView.adminHomePage();
}
private boolean validateDate(LocalDate sDate, LocalDate eDate, LocalDate dDate) {
	LocalDate currentDate=LocalDate.now();
	if((sDate.compareTo(currentDate)>=0) && (eDate.compareTo(sDate)>=0) && (dDate.compareTo(sDate)<=0)) {
		return true;
	}
	
	return false;
}
public void checkFloatInput(String sInput) {
	float choice = 0;
	try {
		choice=Float.parseFloat(sInput);
	} catch (NumberFormatException e) {
		System.err.println("enter valid input");
		adminView.adminHomePage();
	}
}

}
