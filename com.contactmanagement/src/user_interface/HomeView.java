package user_interface;

import java.util.List;
import java.util.Scanner;

import dto.Contact;
import util.Validate;

public class HomeView implements HomeViewCallBack {

	private HomeControllerCallBack homeController;
	private Scanner sc = new Scanner(System.in);
	Validate validate = new Validate();

	public HomeView() {
		homeController = new HomeController(this);
	}

	public static void main(String[] args) {
		HomeView hv = new HomeView();
		hv.mainPage();
	}

	public void mainPage() {
		String choice;
		System.out.println("-------->Cotact Management<-------");

		System.out.print(
				"\n1.Show Contacts\n2.Add New Contact\n3.Remove Exisiting Contact\n4.Edit Contact\n5.Search Contact\n0.Exit\nEnter Choice : ");

		do {
			choice = sc.next();
		} while (!validate.inputInteger(choice));
		int myChoice = Integer.parseInt(choice);
		homeController.goPage(myChoice);
	}

	public void exit() {
		System.out.println("Visit again...");
		System.exit(0);
	}

	public void searchContacts() {
		System.out.print("---->Search Page<----\n1.By Name\n2.By Number\n3.GoBack ");
		String choice;
		do {
			System.out.print("\nEnter choice :");
			choice = sc.next();
		} while (!validate.inputInteger(choice));
		int myChoice = Integer.parseInt(choice);
		homeController.searchContact(myChoice);
	}

	public void printContacts(List<Contact> contactList) {
		Contact c = null;
		List<Contact> myContacts = contactList;
		System.out.println("\n+---------------------------------+");
		System.out.printf("|    %-10SCONTACTS%-10S |", "", "");
		System.out.println("\n+---------------------------------+");
		System.out.printf("|     %-10S |     %-10S |", "Name", "Number");
		System.out.println("\n+---------------------------------+");
		for (int i = 0; i < myContacts.size(); i++) {
			c = myContacts.get(i);
			System.out.printf("|%-15S |%-15S |", c.getName(), "call:");
			List<String> num = c.getNumber();
			for (int j = 0; j < num.size(); j++) {
				System.out.printf("\n|%-15s | %-14s |", "", num.get(j));
			}
			System.out.println("\n+---------------------------------+");
		}
	}

	public void message(String message) {
		System.out.println(message);
	}

	public void byName() {
		System.out.println("Enter Contact Name :");
		String name = sc.next();
		homeController.searchByName(name);
	}

	public void byNumber() {
		System.out.println("---->Search Contact By Number<-----");
		String number;
		do {
			System.out.print("\nEnter Number :");
			number = sc.next();
		} while (!validate.inputMobileNumber(number));
		homeController.searchByNumber(number);
	}

	public void printOneContact(Contact contact) {
		System.out.println("----->Contact Details<-----");
		System.out.printf("%-10S : %S\n%-10S : %S\n%-10S : %s\n%-10S :\n", "name", contact.getName(), "dob",
				contact.getDateOfBirth(), "email-id", contact.getEmailId(), "Ph.numbers");
		List<String> num = contact.getNumber();
		for (int j = 0; j < num.size(); j++) {
			System.out.printf("%-10s | %s\n", "", num.get(j));
		}
	}
}
