package user_interface;

import java.util.List;

import dto.Contact;
import edit.EditView;
import update.UpdateView;

public class HomeController implements HomeControllerCallBack, HomeModelControllerCallBack {

	private HomeViewCallBack homeView;
	private HomeModelCallBack homeModel;

	public HomeController(HomeViewCallBack homeView) {

		this.homeView = homeView;
		homeModel = new HomeModel(this);
	}

	public void goPage(int myChoice) {
		UpdateView uv = new UpdateView();
		switch (myChoice) {
		case 1:
			showContacts();
			break;
		case 2:
			uv.createContact();
			;
			break;
		case 3:
			uv.deleteContact();
			break;
		case 4:
			EditView ev = new EditView();
			ev.editContacts();
			break;
		case 5:
			homeView.searchContacts();
			break;
		case 0:
			homeView.exit();
			break;
		default:
			System.exit(0);

		}
	}

	private void showContacts() {
		List<Contact> contactList = homeModel.allAvailableContacts();
		if (contactList == null) {
			homeView.message("Your Contact List is Empty...");
			homeView.mainPage();
		} else {
			homeView.printContacts(contactList);
			homeView.mainPage();
		}
	}

	public void searchContact(int myChoice) {
		switch (myChoice) {
		case 1:
			homeView.byName();
			break;
		case 2:
			homeView.byNumber();
			break;
		case 3:
			homeView.mainPage();
			break;
		default:
			homeView.searchContacts();

		}
	}

	public void searchByName(String name) {
		List<Contact> contacts = homeModel.searchByName(name);
		if (contacts == null) {
			homeView.message("No such Contacts exist...");
			homeView.byName();
		} else {
			homeView.printContacts(contacts);
			homeView.mainPage();
		}
	}

	public void searchByNumber(String number) {
		Contact contacts = homeModel.searchByNumber(number);
		if (contacts == null) {
			homeView.message("No such Contact exist...");
			homeView.byNumber();
		} else {
			homeView.printOneContact(contacts);
			homeView.mainPage();
		}
	}

}
