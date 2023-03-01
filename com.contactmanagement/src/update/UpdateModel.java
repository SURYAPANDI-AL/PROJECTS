package update;

import java.time.LocalDate;
import java.util.List;

import dto.Contact;
import repository.ContactManagementDataBase;
import user_interface.HomeController;

public class UpdateModel {

	private UpdateController updateController;
	private ContactManagementDataBase cmdb = ContactManagementDataBase.getInstance();

	public UpdateModel(UpdateController updateController) {

		this.updateController = updateController;
	}

	public void addContact(String name, List<String> numbers) {
		cmdb.addContact(name, numbers, null, null);
	}

	public void addFullContact(String name, List<String> numbers, String email, String dob) {
		cmdb.addContact(name, numbers, email, LocalDate.parse(dob));
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

	public void deleteFullContact(String number, String name) {
		cmdb.deleteFullContact(number, name);
	}

	public void deleteContact(String number, String name) {
		cmdb.deleteContact(number, name);
	}

	public Contact search(String number, String name) {
		return cmdb.search(number, name);
	}
}
