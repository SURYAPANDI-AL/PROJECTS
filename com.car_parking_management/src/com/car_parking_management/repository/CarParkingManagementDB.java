package com.car_parking_management.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.car_parking_management.dto.Admin;
import com.car_parking_management.dto.Car;
import com.car_parking_management.dto.Location;
import com.car_parking_management.dto.User;

public class CarParkingManagementDB {
	private static CarParkingManagementDB carParkingManagementDBInstance;
	private int parkingNumber = 1;
	private List<Car> parkingDetails = new ArrayList<>();
	private List<User> userDetails = new ArrayList<>();
	private List<Admin> adminDetails = new ArrayList<>();
	private List<Location> locations = new ArrayList<>();

	private CarParkingManagementDB() {

	}

	public static CarParkingManagementDB getInstance() {
		if (carParkingManagementDBInstance == null) {
			carParkingManagementDBInstance = new CarParkingManagementDB();
			carParkingManagementDBInstance.initialSetup();
		}
		return carParkingManagementDBInstance;
	}

	// initial setup for basic data.
	private void initialSetup() {
		parkingDetails.add(new Car("BMW", "TN63-0000", "SURYA", 9600550779L, LocalTime.now(), LocalDate.now(), null,
				null, parkingNumber++));
		parkingDetails.add(new Car("AADI", "TN63-0001", "PANDI", 9600793906L, LocalTime.now(), LocalDate.now(), null,
				null, parkingNumber++));
		userDetails.add(new User("zsgs", 9600550779L, "zoho@zsgs.com", "12345"));
		adminDetails.add(new Admin("admin", "1234"));
		locations.add(new Location("Mall", new int[3][10], 20f, 1));
		locations.add(new Location("theatre", new int[3][10], 20f, 2));
		locations.add(new Location("hotel", new int[3][10], 20f, 3));
		locations.add(new Location("railway station", new int[4][10], 20f, 4));
	}

	public boolean addCar(String brand, String registerNumber, String owner, long contactNumber, LocalTime inTime,
			LocalDate inDate) {
		for (Car e : parkingDetails) {
			if (e.getRegisterNumber().equals(registerNumber)) {
				return false;
			}
		}
		parkingDetails
				.add(new Car(brand, registerNumber, owner, contactNumber, inTime, inDate, null, null, parkingNumber++));
		return true;
	}

	public boolean manageCar(String registerNumber) {
		for (Car e : parkingDetails) {
			if (e.getRegisterNumber().equals(registerNumber)) {
				e.setOutTime(LocalTime.now());
				e.setOutDate(LocalDate.now());
				return true;
			}
		}
		return false;
	}

	public Car searchCar(int parkingNumber) {
		for (Car e : parkingDetails) {
			if (e.getParkingNumber() == parkingNumber) {
				return e;
			}
		}
		return null;
	}

	public List<User> registedUser() {
		return userDetails;
	}

	public int totalEntry() {
		// TODO Auto-generated method stub
		return parkingDetails.size();
	}

	public int todayEntry() {
		int count = 0;
		for (Car e : parkingDetails) {
			if (LocalDate.now().compareTo(e.getInDate()) == 0) {
				count++;
			}
		}
		return count;
	}

	public int yesterdayEntry() {
		int count = 0;
		for (Car e : parkingDetails) {
			if (LocalDate.now().compareTo(e.getInDate()) == 1) {
				count++;
			}
		}
		return count;
	}

	public int lastSevendayEntry() {
		int count = 0;
		for (Car e : parkingDetails) {
			if (LocalDate.now().compareTo(e.getInDate()) <= 7) {
				count++;
			}
		}
		return count;
	}

	public boolean addUser(String name, String email, String pwd, long mblno) {
		for (User e : userDetails) {
			if (e.getContactNumber() == mblno) {
				return false;
			}
		}
		userDetails.add(new User(name, mblno, email, pwd));
		return true;
	}

	public boolean validateAdmin(String name, String pwd) {
		for (Admin e : adminDetails) {
			if (e.getAdminId().equals(name) && e.getPassword().equals(pwd)) {
				return true;
			}
		}
		return false;
	}

	public User validateUser(String name, String pwd) {
		// TODO Auto-generated method stub
		for (User e : userDetails) {
			if (e.getUserName().equals(name) && e.getPassword().equals(pwd)) {
				return e;
			}
		}
		return null;
	}

	public List<Car> getCarByUser(User user) {
		List<Car> cars = new ArrayList();
		for (Car e : parkingDetails) {
			if (e.getContactnumber() == user.getContactNumber()) {
				cars.add(e);
			}
		}
		return cars;
	}

	public int[][] showLots(int choice) {
		// TODO Auto-generated method stub
		for (Location e : locations) {
			if (e.getParkingId() == choice) {
				return e.getLots();
			}
		}
		return null;
	}

	public boolean bookSlot(int row, int col, int days, int choice) {
		// TODO Auto-generated method stub
		for (Location e : locations) {
			if (e.getParkingId() == choice) {
				int[][] slot = e.getLots();
				slot[row][col] = 1;
				e.setLots(slot);

				return true;
			}
		}
		return false;

	}

	public boolean addCarOnline(String brand, String registerNumber, String owner, long contactNumber, LocalTime inTime,
			LocalDate inDate, int choice) {
		for (Car e : parkingDetails) {
			if (e.getRegisterNumber().equals(registerNumber)) {
				return false;
			}
		}
		parkingDetails.add(new Car(brand, registerNumber, owner, contactNumber, inTime, inDate, null, null,
				(choice * 1000 + parkingNumber++)));
		return true;
	}
}
