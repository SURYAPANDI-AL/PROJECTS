package update;

import java.util.List;

import dto.Contact;
import user_interface.HomeModel;
import user_interface.HomeView;

public class UpdateController {
	private UpdateView updateView;
	private UpdateModel updateModel;

	public UpdateController(UpdateView updateView) {

		this.updateView = updateView;
		updateModel = new UpdateModel(this);
	}

	public void addContact(String name, List<String> numbers) {
		updateModel.addContact(name, numbers);
		updateView.message("Added Successfully...");
	}

	public void addFullContact(String name, List<String> numbers, String email, String dob) {
		updateModel.addFullContact(name, numbers, email, dob);
		updateView.message("Added Successfully...");
	}

	public int search(String number, String name) {
		Contact contacts = updateModel.search(number,name);
		if (contacts == null) {
			updateView.message("No such Contact exist...");
			return 0;
		} else {
			int size = contacts.getNumber().size();
			return size;
		}
	}

	public void deleteContact(String number, String name) {
		int val = search(number, name);
		if (val == 0)
			return;
		else if (val == 1) {
			updateModel.deleteFullContact(number,name);
			updateView.message("contact deleted successfully");
		} else {
			updateModel.deleteContact(number,name);
			updateView.message("contact number deleted successfully");
		}
	}
}
