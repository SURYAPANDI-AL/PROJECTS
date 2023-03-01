package trainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.Course;
import dto.Trainer;
import login.LoginView;

public class TrainerView implements TrainerViewCallBack{
	private TrainerControllerCallBack trainerController;
	private Scanner sc = new Scanner(System.in);
	private Trainer trainer;

	public TrainerView() {
		trainerController = new TrainerController(this);
	}

	public void create(Trainer trainer) {
		this.trainer=trainer;
		trainerHomePage();
	}

	public void trainerHomePage() {
		System.out.println("------>Trainer HomePage<--------");
		System.out.println("1.View Profile\n2.Update Skills\n3.Assigned Courses\n4.ResetPassWord\n0.LogOut");
		String sChoice = sc.next();
		trainerController.inputValidation(sChoice);
		int choice = Integer.parseInt(sChoice);
		switch (choice) {
		case 1:
			viewProfile();
			break;
		case 2:
			addSkills();
			break;
		case 3:
			viewAssignedCourses();
			break;
		case 4:
			resetPassWord();
		case 0:
			LoginView lv = new LoginView();
			lv.homePage();
		default:
			System.out.println("Invalid input.");
			trainerHomePage();
		}
	}
private void resetPassWord() {
		System.out.print("Enter new password : ");
		String pwd=sc.next();
		System.out.print("re-Enter password : ");
		String rpwd=sc.next();
		if(trainerController.setPwd(pwd,rpwd,trainer)) {
			System.out.println("password updated Successfully.");
			trainerHomePage();
		}
		else {
			System.err.println("invalid Credentials");
			resetPassWord();
		}
	}

//*************************************currrent
	private void viewAssignedCourses() {
		System.out.println("------>Your Course Details<-------------------");
		List<Course> course=trainerController.mySpecificCourseTrainer(trainer.getTrainerId());
		if(course != null) {
			int i = 1;
			System.out.println(
					"+---------------------------------Course List-----------------------------------------------------------------------------------+");
			System.out.printf("%-5S  :  %-10S  :  %-15S  :  %-15S  %-15S  :  %-15S : %-15S :  %-15S :  %-15S\n", "sno",
					"course_id", "course_name", "trainer_name", "StartDate", "endDate", "Apply_due_date", "Bookedseats",
					"totalseats");
			System.out.println(
					"+--------------------------------------------------------------------------------------------------------------------------------+");
			for (Course e : course) {
				System.out.printf("\"%-5S  :  %-10S  :  %-15S  :  %-15S  %-15S  :  %-15S : %-15S :  %-15S :  %-15S\n", i++, e.getCourseId(),
						e.getCourseName(), e.getTrainerName(), e.getStartDate(), e.getEndDate(), e.getLastDateToApply(),
						e.getBookedSeats(), e.getTotalSeats());
				System.out.println(
						"\n+--------------------------------------------------------------------------------------------------------------------------------+");
			}
			System.out.println(
					"\n+--------------------------------------------------------------------------------------------------------------------------------+");
		}else {
			System.out.println("Nothing to show.");
		}
		trainerHomePage();
		
	}

	private void addSkills() {
		
		List<String> skills=new ArrayList();
		int choice;
		do {
			System.out.print("Enter new Skill : ");
			String skill=sc.next();
			skills.add(skill);
			System.out.print("[Skills+1]enter key 1 \n EnterChoice : ");
			String sChoice = sc.next();
			trainerController.inputValidation(sChoice);
			choice = Integer.parseInt(sChoice);
			
		}while(choice==1);
		trainerController.addSkills(trainer,skills);
	}

	private void viewProfile() {
		List<String> list=trainer.getSkillSet();
		System.out.println("+--------------------------------------------------------+\n\t\tCOURSE TRAINER\n");
		System.out.printf("\n* %-10S:%-10S\n* %-10S:%-10S\n* %-10S:%-10S\n* %-10S:%-10S\n* %-10S:%-10S\n","name",trainer.getTrainerName(),
				"trainer id",trainer.getTrainerId(),"mobile number",trainer.getMobileNumber(),"Email Id",trainer.getEmailId(),"SkillSet",list);
		System.out.println("+--------------------------------------------------------+");
		for(int i=0;i<1000;i++);
		trainerHomePage();
		
	}

	public void message(String msg) {
		System.out.println(msg);
	}


	
}
