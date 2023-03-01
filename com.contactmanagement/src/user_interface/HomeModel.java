package user_interface;

import java.util.ArrayList;
import java.util.List;

import dto.Contact;
import repository.ContactManagementDataBase;

public class HomeModel implements HomeModelCallBack {

	private HomeModelControllerCallBack homeController;
	private ContactManagementDataBase cmdb = ContactManagementDataBase.getInstance();

	public HomeModel(HomeModelControllerCallBack homeController) {

		this.homeController = homeController;
	}

	public List<Contact> allAvailableContacts() {
		return cmdb.allAvailableContacts();
	}

	public List<Contact> searchByName(String name) {
		List<Contact> contacts = cmdb.allAvailableContacts();
		List<Contact> myContacts = new ArrayList();
		if (contacts != null) {
			for (Contact e : contacts) {
				if (e.getName().toLowerCase().startsWith(name.toLowerCase())) {
					myContacts.add(e);
				}
			}
		}
		return myContacts;
	}

	public Contact searchByNumber(String number) {
		List<Contact> contacts = cmdb.allAvailableContacts();
		Contact c = null;
		if (contacts != null) {
			for (Contact element : contacts) {
				List<String> numbers = element.getNumber();
				for (String num : numbers) {
					if (num.equals(number)) {
						return c = element;
					}
				}
			}
		}
		return c;
	}

}
