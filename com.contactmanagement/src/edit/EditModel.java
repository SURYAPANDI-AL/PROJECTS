package edit;

import dto.Contact;
import repository.ContactManagementDataBase;

public class EditModel implements EditModelCallBack {

	@SuppressWarnings("unused")
	private EditModelControllerCallBack editController;
	private ContactManagementDataBase cmdb = ContactManagementDataBase.getInstance();

	public EditModel(EditModelControllerCallBack editController) {
		this.editController = editController;
	}

	public boolean editContact(String name, String oldNumber, String newNumber) {
		Contact contact = cmdb.search(oldNumber, name);
		if (contact == null) {
			return false;
		} else {
			cmdb.updateContact(contact, oldNumber, newNumber);
		}
		return true;
	}

}
