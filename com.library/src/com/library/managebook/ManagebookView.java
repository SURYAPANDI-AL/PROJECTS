package com.library.managebook;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ManagebookView implements ManagebookViewCallBack{

	private ManagebookControllerCallBack managebookController;

	private Scanner scanner = new Scanner(System.in);

	public ManagebookView() {
		managebookController = new ManagebookController(this);
	}

	public void addbook() {
		System.out.println("Enter book ID:");
		int bookId = scanner.nextInt();
		System.out.println("Enter the book name:");
		String bookName = scanner.next();
		managebookController.rack(bookId, bookName);
	}

	public void idExist() {
		System.out.println("book ID already exit,plz enter new ID.");
		addbook();
	}

	public void successfulAdd(String bookName) {
		System.out.println(bookName + "-->added successfully to the rack.");
		System.out.println("To list all available books-->(list)");
		System.out.println("Add another book-->(yes/no)\nEnter the choice:");
		String choice = scanner.next();
		managebookController.validateChoice(choice);
	}

	public void defaultStatement() {
		System.out.println("Thank You!");

	}

	public void listBooks(TreeMap<Integer, String> listOfBooks) {
		int count=1;
		System.out.println("SNo"+"	"+"Book ID"+"	"+"BookName");
		for(Map.Entry<Integer,String> entry:listOfBooks.entrySet())
		{
			System.out.println(count++ +"	"+entry.getKey()+"	"+entry.getValue());
		}
		defaultStatement();
	}
}
