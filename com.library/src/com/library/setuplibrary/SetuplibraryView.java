package com.library.setuplibrary;

import java.util.Scanner;
import com.library.managebook.*;

public class SetuplibraryView implements SetuplibraryViewCallBack{
	
	private SetuplibraryControllerCallBack setupLibraryController;
	Scanner scanner=new Scanner(System.in);
	
	public SetuplibraryView()
	{
		setupLibraryController=new SetuplibraryController(this);
	}
	public void gotoLibrary()
	{
		System.out.println("Enter details-->");
		System.out.println("Library name: ");
		String library_name=scanner.next();
		System.out.println("City name:");
		String city_name=scanner.next();
		setupLibraryController.checkLibrary(library_name,city_name);
	}
	public void validLibrary(String library_name) {
		System.out.println("Welcome to "+library_name);
		new ManagebookView().addbook();
	}
	public void invalidLibrary(String errormessage)
	{
		System.out.println(errormessage);
		gotoLibrary();
	}
}
