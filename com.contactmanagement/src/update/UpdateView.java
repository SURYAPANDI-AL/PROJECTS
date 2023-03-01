package update;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import user_interface.HomeView;
import util.Validate;

public class UpdateView {
	private UpdateController updateController;
	private Scanner sc = new Scanner(System.in);
	Validate validate = new Validate();

	public UpdateView() {
		updateController = new UpdateController(this);
	}

	public void createContact() {
		List<String> numbers = new ArrayList();
		String name, choice;
		System.out.println("---->Create New Contact<-----");
		System.out.print("Enter Name : ");
		name = sc.next();
		do {
			numbers.add(addNumber());
			System.out.print("want to add another contact number:(y/n)");
			choice = sc.next();
		} while (choice.startsWith("y") || choice.startsWith("Y"));
		//System.out.print("want to add additional details:(y/n)");
		System.out.print("add additional details:\n");
		//choice = sc.next();
		choice="y";
		if (choice.startsWith("y") || choice.startsWith("Y"))
			addmore(name, numbers);
		else
			updateController.addContact(name, numbers);
	}

	private void addmore(String name, List<String> numbers) {
		String email, dob;
		do {
			System.out.println("Email id :");
			email = sc.next();
		} while (!validate.inputEmail(email));
		do {
			System.out.println("Date of birth :(yyyy-mm-dd)");
			dob = sc.next();
		} while (!validate.validateDate(dob));
		updateController.addFullContact(name, numbers, email, dob);
	}

	private String addNumber() {
		String number;
		do {
			System.out.print("Enter MblNo : ");
			number = sc.next();
		} while (!validate.inputMobileNumber(number));
		return number;
	}

	public void message(String msg) {
		System.out.println(msg);
		HomeView hv = new HomeView();
		hv.mainPage();
	}

	public void deleteContact() {
		System.out.println("---->Delete Contact<-----");
		String number;
		System.out.print("Enter Name : ");
		String name = sc.next();

		do {
			System.out.print("Enter MblNo : ");
			number = sc.next();
		} while (!validate.inputMobileNumber(number));
		updateController.deleteContact(number, name);

	}

}
