package repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dto.Admin;
import dto.AdminCredentials;
import dto.Course;
import dto.Trainer;
import dto.TrainerCredentials;
import dto.User;
import dto.UserCredentials;

public class CourseManagementDataBase {

	private static CourseManagementDataBase courseManagementDB;
	private final String SUPREME_KEY = "#@!123";

	private List<AdminCredentials> adminCredentials = new ArrayList();
	private List<UserCredentials> userCredentials = new ArrayList();
	private List<TrainerCredentials> trainerCredentials = new ArrayList();
	private List<Course> courseList = new ArrayList();

	private CourseManagementDataBase() {

	}

	public static CourseManagementDataBase getInstance() {
		if (courseManagementDB == null) {
			courseManagementDB = new CourseManagementDataBase();
			courseManagementDB.initialSetup();
		}
		return courseManagementDB;
	}

	private void initialSetup() {
		adminCredentials.add(new AdminCredentials("SP001", "suryapandi", "1234"));
		userCredentials.add(new UserCredentials("Dharanish", "ZSGS001", "dharun@gmail.com", null, 1234567890L, "1234"));
		courseList.add(new Course("CS001", "java", "ZSGS001", "Dharanish", LocalDate.parse("2023-03-03"),
				LocalDate.parse("2023-03-03"), LocalDate.parse("2023-03-03"), null, 10, 0, 1000f));
		trainerCredentials
				.add(new TrainerCredentials("sathish", "ZTR001", "sathish@gmail.com", null, 9876543210L, "1234"));
	}

	public Admin getAdmin(String adminId, String adminPwd) {
		for (AdminCredentials e : adminCredentials) {
			if (e.getAdminId().equals(adminId) && e.getAdminPwd().equals(adminPwd)) {
				return e;
			}
		}
		return null;
	}

	public Trainer getTrainer(String trainerId, String trainerPwd) {
		for (TrainerCredentials e : trainerCredentials) {
			if (e.getTrainerId().equals(trainerId) && e.getTrainerPwd().equals(trainerPwd)) {
				return e;
			}
		}
		return null;
	}

	public User getUser(String userId, String userPwd) {
		for (UserCredentials e : userCredentials) {
			if (e.getUserId().equals(userId) && e.getUserpwd().equals(userPwd)) {
				return e;
			}
		}
		return null;
	}

	public boolean checkUser(String email, long mblno) {
		for (User e : userCredentials) {
			if (e.getUserMobileNumber() == mblno || e.getEmailId().equals(email)) {
				return true;
			}
		}
		return false;
	}

	public boolean addUser(String id, String name, String email, String pwd, long mblno) {
		userCredentials.add(new UserCredentials(name, id, email, null, mblno, pwd));
		return true;
	}

	public String getKey() {
		return SUPREME_KEY;
	}

	public boolean checkAdmin(String name, String pwd) {
		for (AdminCredentials e : adminCredentials) {
			if (e.getAdminName().equals(name) && e.getAdminPwd().equals(pwd)) {
				return true;
			}
		}
		return false;
	}

	public boolean addAdmin(String adminId, String adminName, String adminPwd) {
		adminCredentials.add(new AdminCredentials(adminId, adminName, adminPwd));
		return true;
	}

	public boolean checkTrainer(long mblNo, String email) {
		for (Trainer e : trainerCredentials) {
			if (e.getEmailId().equals(email) || e.getMobileNumber() == mblNo) {
				return true;
			}
		}
		return false;
	}

	public boolean addTrainer(String trainerId, String email, List<String> skillSet, String name, long mblNo,
			String pwd) {
		trainerCredentials.add(new TrainerCredentials(name, trainerId, email, skillSet, mblNo, pwd));
		return true;
	}

	public boolean checkTrainerUsingId(String trainerId) {
		for (Trainer e : trainerCredentials) {
			if (e.getTrainerId().equals(trainerId)) {
				return true;
			}
		}
		return false;
	}

	public boolean removeTrainer(String trainerId) {
		for (Trainer e : trainerCredentials) {
			if (e.getTrainerId().equals(trainerId)) {
				trainerCredentials.remove(e);
				return true;
			}
		}
		return false;
	}

	public List<TrainerCredentials> showTrainers() {
		return trainerCredentials;
	}

	public boolean removeCourse(String courseId) {
		for (Course e : courseList) {
			if (e.getCourseId().equals(courseId)) {
				courseList.remove(e);
				return true;
			}
		}
		return false;
	}

	public boolean checkCourseUsingId(String courseId) {
		for (Course e : courseList) {
			if (e.getCourseId().equals(courseId)) {
				return true;
			}
		}
		return false;
	}

	public List<Course> showCourse() {
		return courseList;
	}

	public String getTrainerName(String trainerId) {
		for (Trainer e : trainerCredentials) {
			if (trainerId.equals(e.getTrainerId())) {
				return e.getTrainerName();
			}
		}
		return null;
	}

	public boolean addCourse(String courseId, String course, String trainerId2, String trainerName, LocalDate sDate,
			LocalDate eDate, LocalDate dDate, List<String> lectures, int totalSeats, float payment) {
		courseList.add(new Course(courseId, course, trainerId2, trainerName, sDate, eDate, dDate, lectures, totalSeats,
				0, payment));
		return true;
	}

	public void addSkills(Trainer trainer, List<String> skills) {
		for (String skill : skills)
			trainer.addSkill(skill);

	}

	public List<Course> mySpecificCourseTrainer(String trainerId) {
		List<Course> myCourse = new ArrayList();
		for (Course e : courseList) {
			if (e.getTrainerId().equals(trainerId)) {
				myCourse.add(e);
			}
		}
		return myCourse;
	}

	public List<String> getUserCourses(String userId) {
		List<String> courses = null;
		for (User e : userCredentials) {
			if (userId.equals(userId)) {
				courses = e.getSignedUpCourses();
			}
		}
		return courses;
	}

	public float getPayment(String selectedCourseId) {
		for (Course e : courseList) {
			if (e.getCourseId().equals(selectedCourseId)) {
				return e.getPayment();
			}
		}
		return 0;
	}

	public List<String> addMyCourse(User user, String selectedCourseId) {
		for (Course e : courseList) {
			if (e.getCourseId().equals(selectedCourseId)) {
				for (UserCredentials usertemp : userCredentials) {
					if (usertemp.getUserId().equals(user.getUserId())) {
						e.setBookedSeats(e.getBookedSeats() + 1);
						return usertemp.getSignedUpCourses();
					}
				}
			}
		}
		return null;
	}

	public Trainer getTrainerWithId(String trainerId) {
		for (Trainer e : trainerCredentials) {
			if (e.getTrainerId().equals(trainerId)) {
				return e;
			}
		}
		return null;
	}

	public boolean checkSeats(String courseId) {
		for (Course e : courseList) {
			if (courseId.equals(e.getCourseId()) && e.getTotalSeats() > e.getBookedSeats()) {
				return true;
			}
		}
		return false;
	}

	public void setPwd(String pwd, Trainer trainer) {
		for (TrainerCredentials e : trainerCredentials) {
			if (e.getTrainerId().equals(trainer.getTrainerId())) {
				e.setTrainerPwd(pwd);
			}
		}
	}

	public Course getMyCourseUsingCourseId(String courses) {
		for (Course e : courseList) {
			if (courses.equals(e.getCourseId())) {
				return e;
			}
		}
		return null;
	}

	public boolean updateMyCourse(String userId, List<String> myCourse) {
		for (UserCredentials usertemp : userCredentials) {
			if (usertemp.getUserId().equals(userId)) {
				usertemp.setSignedUpCourses(myCourse);
				System.out.println(usertemp.getSignedUpCourses());
				return true;
			}
		}
		return false;
	}

}
