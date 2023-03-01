package Admin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import dto.Admin;
import dto.Course;
import dto.Trainer;
import dto.TrainerCredentials;
import login.LoginView;

public class AdminView implements AdminViewCallBack{

	private AdminControllerCallBack adminController;
	private Scanner sc = new Scanner(System.in);
	private Admin admin;

	public AdminView() {
		adminController = new AdminController(this);
	}

	public void create(Admin admin) {
		this.admin = admin;
		adminHomePage();
	}

	public void adminHomePage() {
		System.out.println("------------>Admin HomePage<----------");
		System.out.println("1.Add Admin\n2.Modify Course\n3.Modify Trainer\n0.LogOut");
		String sChoice = sc.next();
		adminController.inputValidation(sChoice);
		int choice = Integer.parseInt(sChoice);
		switch (choice) {
		case 1:
			addAdmin();
			break;
		case 2:
			modifyCourse();
			break;
		case 3:
			modifyTrainer();
			break;
		case 0:
			LoginView lv = new LoginView();
			lv.homePage();
		default:
			System.out.println("Invalid input.");
			adminHomePage();
		}
	}

	private void addAdmin() {
		String name, pwd, confirmPwd;
		long mblno;
		System.out.println("-------->New Admin Registation<---------");
		System.out.print("Supreme Key\t: ");
		String key = sc.next();
		adminController.validateKey(key);
		System.out.print("Admin Name\t: ");
		name = sc.next();
		do {
			System.out.print("Password\t: ");
			pwd = sc.next();
			System.out.print("Confirm password: ");
			confirmPwd = sc.next();
		} while (!adminController.validatepwd(pwd, confirmPwd));
		adminController.addAdmin(name, pwd);
	}

	private void modifyTrainer() {
		System.out.println("------------>Trainer Acess<----------");
		System.out.println("1.Add Trainer\n2.Remove Trainer\n3.Trainers List\n0.Go back");
		String sChoice = sc.next();
		adminController.inputValidation(sChoice);
		int choice = Integer.parseInt(sChoice);
		switch (choice) {
		case 1:
			addTrainer();
			break;
		case 2:
			removeTrainer();
			break;
		case 3:
			trainerList();
			break;
		case 0:
			adminHomePage();
		default:
			System.out.println("Invalid input.");
			for (int i = 0; i < 1000; i++)
				;
			modifyTrainer();
		}
	}

	private void trainerList() {
		List<TrainerCredentials> trainers = adminController.showTrainers();
		if (trainers != null) {
			int i = 1;
			System.out.println(
					"+---------------------------------Trainer List-----------------------------------------------------------------------------------+");
			System.out.printf("%-5S  :  %-10S  :  %-10S  :  %-15S  :  %-15S", "sno", "id", "name", "mobile_number",
					"skillset");
			System.out.println(
					"\n+--------------------------------------------------------------------------------------------------------------------------------+");
			for (Trainer e : trainers) {
				System.out.printf("\n%-5S  :  %-10S  :  %-15S  :  %-15S  :  %-15S", i++, e.getTrainerId(),
						e.getTrainerName(), e.getMobileNumber(), e.getSkillSet());
			}
			System.out.println(
					"+--------------------------------------------------------------------------------------------------------------------------------+");
		} else {
			System.out.println("List is Empty");
		}
		for (int i = 0; i < 1000; i++)
			;
		adminHomePage();
	}

	private void removeTrainer() {
		System.out.println("-------------->Trainer Management<-------------------");
		System.out.print("Trainer Id\t: ");
		String trainerId = sc.next();
		adminController.removeTrainer(trainerId);
	}

	private void addTrainer() {
		System.out.println("------------>TrainerRegistation<----------");
		String name, email, pwd, confirmPwd;
		List<String> skillSet = new LinkedList();
		System.out.print("Trainer Name\t\t: ");
		name = sc.next();
		long mblNo;
		do {
			System.out.print("Mobile No\t: ");
			String smblNo = sc.next();
			adminController.inputMobileValidation(smblNo);
			mblNo = Long.parseLong(smblNo);
		} while (!adminController.validateMblno(mblNo));
		do {
			System.out.print("Email address\t: ");
			email = sc.next();
		} while (!adminController.validateEmail(email));
		System.out.print("Skill count :");
		String sChoice = sc.next();
		adminController.inputValidation(sChoice);
		int choice = Integer.parseInt(sChoice);
		for (int i = 0; i < choice; i++) {
			System.out.print(i + 1 + ". ");
			skillSet.add(sc.next());
		}
		// do {
		// System.out.print("Password\t: ");
		// pwd = sc.next();
		// System.out.print("Confirm password: ");
		// confirmPwd = sc.next();
		// } while (!adminController.validatepwd(pwd, confirmPwd));
		adminController.addTrainer(name, email, "000000", mblNo, skillSet);
	}

	
	private void modifyCourse() {
		System.out.println("------------>Course HomePage<----------");
		System.out.println("1.Add Course\n2.Remove Course\n3.Course List\n0.LogOut");
		String sChoice = sc.next();
		adminController.inputValidation(sChoice);
		int choice = Integer.parseInt(sChoice);
		switch (choice) {
		case 1:
			addCourse();
			break;
		case 2:
			removeCourse();
			break;
		case 3:
			courseList();
			break;
		case 0:
			adminHomePage();
		default:
			System.out.println("Invalid input.");
			for (int i = 0; i < 1000; i++)
				;
			modifyCourse();
		}
	}

	
	private void courseList() {
		List<Course> course = adminController.showCourse();
		if (course != null) {
			int i = 1;
			System.out.println(
					"+-----------------------------------------------------------------Course List-----------------------------------------------------------------------------------+");
			System.out.printf("%-5S  :  %-10S  :  %-15S  :  %-15S : %-15S  :  %-15S : %-15S :  %-15S :  %-15S\n", "sno",
					"course_id", "course_name", "trainer_name", "StartDate", "endDate", "Apply_due_date", "Bookedseats",
					"totalseats");
			System.out.println(
					"+----------------------------------------------------------------------------------------------------------------------------------------------------------------+");
			for (Course e : course) {
				System.out.printf("%-5S  :  %-10S  :  %-15S  :  %-15S  %-15S  :  %-15S : %-15S :  %-15S :  %-15S\n", i++, e.getCourseId(),
						e.getCourseName(), e.getTrainerName(), e.getStartDate(), e.getEndDate(), e.getLastDateToApply(),
						e.getBookedSeats(), e.getTotalSeats());
				System.out.println(
						"+----------------------------------------------------------------------------------------------------------------------------------------------------------------+");
			}
			System.out.println(
					"+----------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		} else {
			System.out.println("List is Empty");
		}
		for (int i = 0; i < 1000; i++)
			;
		adminHomePage();
	}

	private void removeCourse() {
		System.out.println("-------------->Course Management<-------------------");
		System.out.print("Course Id\t: ");
		String courseId = sc.next();
		adminController.removeCourse(courseId);
	}

	// currently working______________________________________________*****************************
	public void addCourse() {
		String course,trainerId,startDateS,endDateS,lastDatetoApplyS;
		int totalSeats;
		LocalDate localDate = null;
		List<String> lectures=new ArrayList();
		System.out.println("--------->New Course AddingPage<-----------");
		System.out.print("Course Name : ");
		course=sc.next();
		System.out.print("Trainer ID :");
		trainerId=sc.next();
		System.out.print("Number of Lectures :");
		String sChoice = sc.next();
		adminController.inputValidation(sChoice);
		int choice = Integer.parseInt(sChoice);
		System.out.println("Course Lecture list:");
		for (int i = 0; i < choice; i++) {
			System.out.print(i + 1 + ". ");
			lectures.add("Day"+(i+1)+" : "+sc.next());
		}
		System.out.print("Formatt(yyyy-mm-dd)\nStart date : ");
		startDateS=sc.next();
		adminController.validateDate(startDateS);
		System.out.print("End date : ");
		endDateS=sc.next();
		adminController.validateDate(endDateS);
		System.out.println("Last date to Apply : ");
		lastDatetoApplyS=sc.next();
		adminController.validateDate(lastDatetoApplyS);
		System.out.print("Total Seats :");
		String sInput = sc.next();
		adminController.inputValidation(sInput);
		totalSeats = Integer.parseInt(sInput);
		System.out.print("Enrollment Fee :");
		sInput = sc.next();
		adminController.checkFloatInput(sInput);
		float payment=Float.parseFloat(sInput);
		adminController.addCourse(course,trainerId,localDate.parse(startDateS),localDate.parse(endDateS),localDate.parse(lastDatetoApplyS),lectures,totalSeats,payment);
	}

	/// *************************************************************************************************************
	public void message(String msg) {
		System.out.println(msg);
	}

}
