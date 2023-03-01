package edit;

import user_interface.HomeView;

public class EditController implements EditControllerCallBack, EditModelControllerCallBack {

	private EditViewCallBack editView;
	private EditModelCallBack editModel;

	public EditController(EditViewCallBack editView) {
		this.editView = editView;
		editModel = new EditModel(this);
	}

	public void editContact(String name, String oldNumber, String newNumber) {
		if (editModel.editContact(name, oldNumber, newNumber)) {
			editView.message("Contact Edited Successfully");
		} else {
			editView.message("No Such Contact in DataBase");
		}
		HomeView hv = new HomeView();
		hv.mainPage();
	}

}
