package User;

import java.util.List;
import java.util.Scanner;

import dto.Course;
import dto.Trainer;
import dto.User;
import login.LoginView;

public class UserView implements UserViewCallBack {
	private UserControllerCallBack userController;
	private Scanner sc = new Scanner(System.in);
	private User user;

	public UserView() {
		userController = new UserController(this);
	}

	public void create(User user) {
		this.user = user;
		userHomePage();
	}

	public void userHomePage() {
		System.out.println("------------>User HomePage<----------");
		System.out.println("1.View Profile\n2.Enroll Course\n3.Available Course\n4.Enrolled Course\n0.LogOut");
		String sChoice = sc.next();
		userController.inputValidation(sChoice);
		int choice = Integer.parseInt(sChoice);
		switch (choice) {
		case 1:
			viewProfile();
			break;
		case 2:
			enrollCourse();
			break;
		case 3:
			courseList();
			break;
		case 4:
			enrolledCourses();
		case 0:
			LoginView lv = new LoginView();
			lv.homePage();
		default:
			System.out.println("Invalid input.");
			userHomePage();
		}
	}

	private void enrolledCourses() {
		System.out.println("----->My Courses<------");
		int i = 1;
		if (user.getSignedUpCourses() == null) {
			System.out.println("Nothing to Show");
			userHomePage();
		} else {
			for (String e : user.getSignedUpCourses()) {
				System.out.println(i++ + "." + e);
			}
			System.out.println("choose Course  :");
			String sChoice = sc.next();
			userController.inputValidation(sChoice);
			int choice = Integer.parseInt(sChoice);
			if (userController.validateMyChoice(choice, user.getSignedUpCourses().size())) {
				fullCourseVideos(choice - 1);
			}
		}
	}

	private void fullCourseVideos(int choice) {
		String courseSelected = user.getSignedUpCourses().get(choice);
		System.out.println("COURSE ID :" + courseSelected);
		Course course = userController.getMyCourseUsingCourseId(courseSelected);
		Trainer trainer = userController.getTrainer(course.getTrainerId());
		if (course.getCondent() != null) {
			System.out.println("\t------>Lecture Videos<-----------");
			for (String video : course.getCondent()) {
				System.out.println("(=|>) Play :" + video);
			}
			System.out.println("\n");
			System.out.println("For doubts contact: " + course.getTrainerName() + "\nPhNo     : "
					+ trainer.getMobileNumber() + "\nemail.Id : " + trainer.getEmailId());
			System.out.println("\nTrainer Only Available:Mrg 9am to 6pm \nwithin the Duration Of:"
					+ course.getStartDate() + "  -  " + course.getEndDate() + "\n");

		} else {
			System.out.println("nothing to show..");
		}
		userHomePage();
	}

	private void enrollCourse() {
		System.out.println("---->Enroll Page<-----");
		System.out.print("Enter Course Id : ");
		String selectedCourseId = sc.next();
		float payment = userController.getPayment(selectedCourseId);
		if (payment == 0) {
			System.out.println("Invalid data");
			userHomePage();
		} else if (!userController.checkAvailableSeats(selectedCourseId)) {
			System.out.println("No seats Available...");
			userHomePage();
		} else if (user.getSignedUpCourses().contains(selectedCourseId)) {
			System.out.println("Already registered to this course...");
			userHomePage();
		} else {
			System.out.println("Pay enrollment fees : " + payment + "\n1.Gpay\n2.PhonePay");
			String sChoice = sc.next();
			userController.inputValidation(sChoice);
			int choice = Integer.parseInt(sChoice);
			if (choice == 1 || choice == 2) {
				System.out.print("Enter amount : ");
				String sInput = sc.next();
				userController.checkFloatInput(sInput);
				float userPayment = Float.parseFloat(sInput);
				if (payment == userPayment) {
					if (userController.addMyCourse(user, selectedCourseId)) {
						System.out.println("payment made Successfully.");
					}
				}
			}
		}
		userHomePage();
	}

	private void viewProfile() {
		List<String> list = userController.getUserCourses(user.getUserId());

		System.out.println("+--------------------------------------------------------+\n\t\tSTUDENT PROFILE");
		System.out.printf("\n* %-10S:%-10S\n* %-10S:%-10S\n* %-10S:%-10S\n* %-10S:%-10S\n* %-10S:%-10S\n", "name",
				user.getUserName(), "trainer id", user.getUserId(), "mobile number", user.getUserMobileNumber(),
				"Email Id", user.getEmailId(), "Enrolled Courses", list);
		System.out.println("+--------------------------------------------------------+");
		for (int i = 0; i < 1000; i++)
			;
		userHomePage();
	}

	private void courseList() {
		List<Course> course = userController.showCourse();
		if (course != null) {
			int i = 1;
			System.out.println(
					"+----------------------------------------------------------------------------------------Course List-----------------------------------------------------------------------------------+");
			System.out.printf("%-5S  :  %-10S  :  %-15S  :  %-15S  %-15S  :  %-15S : %-15S :  %-15S :  %-15S : %-5S\n",
					"sno", "course_id", "course_name", "trainer_name", "StartDate", "endDate", "Apply_due_date",
					"Bookedseats", "totalseats", "Enrollfee");
			System.out.println(
					"+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
			for (Course e : course) {
				System.out.printf(
						"\"%-5S  :  %-10S  :  %-15S  :  %-15S  %-15S  :  %-15S : %-15S :  %-15S :  %-15S: %-2f\n", i++,
						e.getCourseId(), e.getCourseName(), e.getTrainerName(), e.getStartDate(), e.getEndDate(),
						e.getLastDateToApply(), e.getBookedSeats(), e.getTotalSeats(), e.getPayment());
				System.out.println(
						"+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
			}
			System.out.println(
					"+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		} else {
			System.out.println("List is Empty");
		}
		for (int i = 0; i < 1000; i++)
			;
		userHomePage();
	}

}
