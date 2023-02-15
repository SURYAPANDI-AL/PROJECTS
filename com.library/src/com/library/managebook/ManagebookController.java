package com.library.managebook;

import java.util.TreeMap;

import com.library.managebook.ManagebookModel.ManageBookModelControllerCallBack;

public class ManagebookController implements ManagebookControllerCallBack,ManageBookModelControllerCallBack{

	private ManagebookViewCallBack managebookView;

	private ManagebookModelCallBack managebookModel;

	public ManagebookController(ManagebookViewCallBack managebookView) {
		this.managebookView = managebookView;
		this.managebookModel = new ManagebookModel(this);
	}

	public void rack(int bookId, String bookName) {
		if (checkBookId(bookId)) {
			managebookView.idExist();
		} else {
			managebookModel.rack(bookId, bookName);
		}
	}

	public boolean checkBookId(int bookId) {
		return managebookModel.checkBookId(bookId);
	}

	public void successfulAdd(String bookName) {
		managebookView.successfulAdd(bookName);
	}

	public void validateChoice(String choice) {
		if (choice.toLowerCase().equals("yes")) {
			managebookView.addbook();
		} 
		else if(choice.toLowerCase().equals("list")) {
			managebookModel.listBooks();
		}
		else {
			managebookView.defaultStatement();
		}
			

	}

	public void listBooks(TreeMap<Integer, String> listOfBooks) {
		managebookView.listBooks(listOfBooks);
		
	}

}
