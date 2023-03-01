package edit;

import java.util.Scanner;
import util.Validate;;

public class EditView implements EditViewCallBack {

	private Scanner sc = new Scanner(System.in);
	private EditControllerCallBack editController;

	public EditView() {
		editController = new EditController(this);
	}

	public void editContacts() {

		System.out.println("---->Edit Contacts<-----");

		System.out.print("Enter name : ");
		String name = sc.next();
		String oldNumber;
		do {
			System.out.print("Enter Old Number :");
			oldNumber = sc.next();
		} while (!Validate.inputMobileNumber(oldNumber));
		String newNumber;
		do {
			System.out.print("Enter New Number :");
			newNumber = sc.next();
		} while (!Validate.inputMobileNumber(newNumber));

		editController.editContact(name, oldNumber, newNumber);
	}

	public void message(String message) {
		System.out.println(message);
	}

}
