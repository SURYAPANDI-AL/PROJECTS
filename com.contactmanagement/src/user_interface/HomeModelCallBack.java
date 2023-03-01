package user_interface;

import java.util.List;

import dto.Contact;

public interface HomeModelCallBack {

	List<Contact> allAvailableContacts();

	List<Contact> searchByName(String name);

	Contact searchByNumber(String number);

}
