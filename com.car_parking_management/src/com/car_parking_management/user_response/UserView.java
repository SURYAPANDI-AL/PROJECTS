package com.car_parking_management.user_response;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.car_parking_management.dto.Car;
import com.car_parking_management.dto.User;
import com.car_parking_management.login.LoginView;

public class UserView implements UserViewCallBack {
	private User user;
	private UserControllerCallBack userController;
	private int floorNumber, slotNumber;
	private Scanner sc = new Scanner(System.in);
	private int choice;
	private float cash = 20f;

	public UserView() {
		userController = new UserController(this);
	}

	public static void main(String[] args) {
		UserView uv = new UserView();
		uv.create(new User("zsgs", 9600550779L, "zoho@zsgs.com", "12345"));
	}

	public void create(User user) {
		this.user = user;
		System.out.println("CAR PARKING MANAGEMENT:");
		option();
	}

	private void option() {
		int choice;
		System.out.print("\n1.View Bills\n2.Location\n0.Exit\n\nEnter Choice : ");
		choice = sc.nextInt();
		userController.validateChoice(choice);
	}

	public void viewBills() {
		List<Car> cars = userController.getCar(user);
		if (cars == null) {
			errorMessage("nothing to show");
		} else {
			for (Car car : cars) {
				System.out.println("\t->CAR PARKING BILL TOKEN<-\n\nPARKING NUM	: 0" + car.getParkingNumber()
						+ "\n\nCAR OWNER	: " + car.getOwner() + "\n\nCAR BRAND	: " + car.getBrand()
						+ "\n\nREGISTER NUM	: " + car.getRegisterNumber() + "\n\nCONTACT NUM	: "
						+ car.getContactnumber() + "\n\nIN TIME		: " + car.getInTime() + "\n\nIN DATE		: "
						+ car.getInDate() + "\n\nOUT TIME	: " + car.getOutTime() + "\n\nOUT DATE	: "
						+ car.getOutDate());
			}
		}
		option();
	}

	public void exit() {
		LoginView lv = new LoginView();
		lv.option();
	}

	public void errorMessage(String errorMessage) {
		System.out.println(errorMessage);
		option();
	}

	public void location() {
		// TODO Auto-generated method stub
		System.out.print(
				"\n1.City Mall\n2.jazz cinemas LUXE\n3.GRK Residency\n4.Egmore railway station\nEnter Choice : ");
		choice = sc.nextInt();
		userController.availableLots(choice);
	}

	public void showLots(int[][] lots) {
		// TODO Auto-generated method stub
		System.out.println("slot Details:\n");
		System.out.print("slot: ");
		for (int k = 0; k < lots[0].length; k++) {
			System.out.print(k + 1 + "   ");
		}
		System.out.println("\n");

		for (int i = 0; i < lots.length; i++) {
			System.out.print("f" + (i + 1) + "  : ");
			for (int j = 0; j < lots[0].length; j++) {
				if (lots[i][j] == 1) {
					System.out.print("X   ");
				} else {
					System.out.print("O   ");
				}
			}
			System.out.println("\n");
		}
		System.out.println("availabe=[0]	booked=[X]");
		do {
			System.out.print("enter floor number: ");
			floorNumber = sc.nextInt();
			System.out.print("enter slot number: ");
			slotNumber = sc.nextInt();
		} while (floorNumber > lots.length || slotNumber > lots[0].length);
		System.out.println("from date : " + LocalDate.now());
		System.out.print("Number of days : ");
		int days = sc.nextInt();
		addCar(floorNumber, slotNumber, days);
	}

	public void booked(String message) {
		// TODO Auto-generated method stub
		System.out.println(message);

	}

	public void addCar(int floorNumber2, int slotNumber2, int days) {
		String brand, regno, name;
		long mblno;
		System.out.print("Car Brand : ");
		brand = sc.next();
		System.out.print("Registation No : ");
		regno = sc.next();
		System.out.print("Owner name : ");
		name = sc.next();
		do {
			System.out.print("Contact No : ");
			mblno = sc.nextLong();
		} while (!userController.validateMblno(mblno));
		payment(days);
		userController.bookLot(floorNumber, slotNumber, days, choice);
		userController.addCar(brand, regno, name, mblno, choice);
	}

	private void payment(int days) {
		System.out.println("\nMake payment(20 per day):\nBill amount:" + (days * 20));
		do {
			System.out.print(" pay cash:");
			cash = sc.nextInt();
		} while (cash != days * 20);
		// make acknowledgement.
	}

	public void success(String string) {
		System.out.println(string);
		System.out.println();
		viewBills();
	}

}
