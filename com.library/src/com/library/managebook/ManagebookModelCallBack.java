package com.library.managebook;

public interface ManagebookModelCallBack {

	void rack(int bookId, String bookName);

	boolean checkBookId(int bookId);

	void listBooks();

}
