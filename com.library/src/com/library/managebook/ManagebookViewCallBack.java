package com.library.managebook;

import java.util.TreeMap;

public interface ManagebookViewCallBack {

	void idExist();

	void successfulAdd(String bookName);

	void addbook();

	void defaultStatement();

	void listBooks(TreeMap<Integer, String> listOfBooks);

}
