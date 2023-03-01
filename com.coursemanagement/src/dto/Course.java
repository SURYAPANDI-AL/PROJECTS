package dto;

import java.time.LocalDate;
import java.util.List;

public class Course {

	private String courseId;
	private String courseName;
	private String trainerId;
	private String trainerName;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDate lastDateToApply;
	private List<String> condent;
	private int totalSeats;
	private int bookedSeats;
	private float payment;

	public Course(String courseId, String courseName, String trainerId, String trainerName, LocalDate startDate,
			LocalDate endDate, LocalDate lastDateToApply, List<String> condent, int totalSeats, int bookedSeats,float payment) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.lastDateToApply = lastDateToApply;
		this.condent = condent;
		this.totalSeats = totalSeats;
		this.bookedSeats = bookedSeats;
		this.payment=payment;
	}

	public String getCourseId() {
		return courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getTrainerId() {
		return trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public LocalDate getLastDateToApply() {
		return lastDateToApply;
	}

	public List<String> getCondent() {
		return condent;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public int getBookedSeats() {
		return bookedSeats;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public void setLastDateToApply(LocalDate lastDateToApply) {
		this.lastDateToApply = lastDateToApply;
	}

	public void setCondent(List<String> condent) {
		this.condent = condent;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public float getPayment() {
		return payment;
	}

	public void setPayment(float payment) {
		this.payment = payment;
	}

}
