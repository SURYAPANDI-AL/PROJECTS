package util;

import java.time.LocalDate;

public class Validate {

	public static boolean inputMobileNumber(String smblNo) {
		long choice = 0;
		try {
			choice=Long.parseLong(smblNo);
		} catch (NumberFormatException e) {
			System.err.println("enter valid input");
			return false;
		}catch(Exception e) {
			System.err.println("enter valid input");
			return false;
		}
		int digit;
		choice=Long.parseLong(smblNo);
		for(digit=0;choice!=0;digit++)choice/=10;
		if(digit!=10)return false;
		return true;
	}
	public static boolean inputInteger(String input ) {
		int choice = 0;
		try {
			choice=Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.err.println("enter valid input");
			return false;
		}catch(Exception e) {
			System.err.println("enter valid input");
			return false;
		}
		return true;
	}
	public static boolean inputEmail(String email) {
		if(email.contains("@") && email.contains("."))return true;
		return false;
	}
	public static boolean inputpassWord(String pwd, String confirmPwd) {
		if(pwd.equals(confirmPwd))return true;
		return false;
	}
	public static boolean validateDate(String input) {
		try{
			LocalDate date =LocalDate.parse(input);
		}catch(Exception e){
			System.err.println("enter valid input");
			return false;
		}
		return true;
	}
}
