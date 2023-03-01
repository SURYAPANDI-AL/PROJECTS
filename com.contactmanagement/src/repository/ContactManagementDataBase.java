package repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dto.Contact;

public class ContactManagementDataBase {
	private static String url = "jdbc:mysql://localhost:3306/contacts";
	private static String username = "root";
	private static String password = "Surya@2000";
	private static Connection conn = null;
	private static Statement stmt = null;

	private static ContactManagementDataBase contactManagementDataBase;

	private ContactManagementDataBase() {

	}

	public static ContactManagementDataBase getInstance() {

		if (contactManagementDataBase == null) {
			contactManagementDataBase = new ContactManagementDataBase();
			try {
				conn = DriverManager.getConnection(url, username, password);
				stmt = conn.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return contactManagementDataBase;

	}

	public List<Contact> allAvailableContacts() {
		List<Contact> contacts = new ArrayList<>();

		try {
			String s = "SELECT contactdetails.name, contactdetails.emailId, contactdetails.date_of_birth, GROUP_CONCAT(phonenumber.phone_number) AS phone_numbers "
					+ "FROM contactdetails "
					+ "LEFT JOIN phonenumber ON contactdetails.serialnumber = phonenumber.serialnumber "
					+ "GROUP BY contactdetails.serialnumber " + "ORDER BY contactdetails.name";
			ResultSet rs = stmt.executeQuery(s);

			while (rs.next()) {
				String name = rs.getString("name");
				String emailId = rs.getString("emailId");
				String dob = rs.getString("date_of_birth");
				String phoneNumbersString = rs.getString("phone_numbers");
				List<String> phoneNumbers = new ArrayList<>();
				if (phoneNumbersString != null) {
					for (String phoneNumber : phoneNumbersString.split(",")) {
						phoneNumbers.add(phoneNumber);
					}
				}
				contacts.add(new Contact(name, phoneNumbers, emailId, dob));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contacts;
	}

	public void addContact(String name, List<String> numbers, String email, LocalDate date) {

		try {
			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO contactdetails (name, emailId, date_of_birth) VALUES (?,?,?)");
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setDate(3, java.sql.Date.valueOf(date));

			stmt.executeUpdate();
			PreparedStatement pst = conn
					.prepareStatement("SELECT serialnumber FROM contactdetails WHERE emailId =\"" + email + "\"");
			ResultSet rs2 = pst.executeQuery();
			int serialnumber = 0;
			if (rs2.next()) {
				serialnumber = rs2.getInt("serialnumber");
			}
			PreparedStatement stmt3 = conn
					.prepareStatement("INSERT INTO phonenumber (serialnumber, phone_number) VALUES (?, ?)");
			stmt3.setInt(1, serialnumber);
			for (String number : numbers) {
				stmt3.setString(2, number);
				stmt3.executeUpdate();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteFullContact(String number, String name) {
		try {
			String s = "DELETE  FROM contactdetails WHERE name=\"" + name + "\"";
			String s2 = "DELETE  FROM phonenumber WHERE phone_number=\"" + number + "\"";
			stmt.execute(s2);
			stmt.execute(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteContact(String number, String name) {
		try {
			String s2 = "DELETE  FROM phonenumber WHERE phone_number=\"" + number + "\"";
			stmt.execute(s2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Contact search(String number, String name) {
		Contact contact = null;
		List<String> numbers = new ArrayList<>();
		try {
			String s = "select serialnumber from phonenumber where phone_number=\"" + number + "\"";
			ResultSet rs = stmt.executeQuery(s);
			rs.next();
			int serial = rs.getInt("serialnumber");
			String s1 = "select phone_number from phonenumber where serialnumber=" + serial;
			ResultSet rs1 = stmt.executeQuery(s1);
			while (rs1.next()) {
				numbers.add(rs1.getString("phone_number"));
			}
			String s2 = "select * from contactdetails where serialnumber=" + serial;
			ResultSet rs2 = stmt.executeQuery(s2);
			rs2.next();
			contact = new Contact(rs2.getString("name"), numbers, rs2.getString("emailId"),
					rs2.getString("date_of_birth"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contact;
	}

	public void updateContact(Contact contact, String oldNumber, String newNumber) {
		try {
			String s = "update phonenumber set phone_number=\"" + newNumber + "\"where phone_number=\"" + oldNumber
					+ "\"";
			stmt.execute(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
