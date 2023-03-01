package user_interface;

import java.util.List;

import dto.Contact;

public interface HomeViewCallBack {

	void searchContacts();

	void exit();

	void mainPage();

	void printContacts(List<Contact> contactList);

	void message(String string);

	void byName();

	void byNumber();

	void printOneContact(Contact contacts);

}
