package com.library.managebook;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ManagebookModel implements ManagebookModelCallBack{

	private ManageBookModelControllerCallBack managebookController;

	private Map<Integer, String> rack = new HashMap();

	public ManagebookModel(ManageBookModelControllerCallBack managebookController) {
		this.managebookController = managebookController;
	}

	public void rack(int bookId, String bookName) {
		rack.put(bookId, bookName);
		managebookController.successfulAdd(bookName);
	}

	public boolean checkBookId(int bookId) {
		if (rack.containsKey(bookId))
			return true;
		return false;
	}

	public void listBooks() {
		TreeMap<Integer,String>listOfBooks=new TreeMap(rack);
		managebookController.listBooks(listOfBooks);
	}
	interface ManageBookModelControllerCallBack {

		void successfulAdd(String bookName);

		void listBooks(TreeMap<Integer, String> listOfBooks);

	}

}
