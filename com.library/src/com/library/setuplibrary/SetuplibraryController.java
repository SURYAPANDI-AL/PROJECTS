package com.library.setuplibrary;

import com.library.setuplibrary.SetuplibraryModel.SetuplibraryModelControllerCallBack;


public class SetuplibraryController implements SetuplibraryControllerCallBack,SetuplibraryModelControllerCallBack{

	private SetuplibraryViewCallBack setuplibraryView;
	
	private SetuplibraryModelCallBack setupLibraryModel;
	
	public SetuplibraryController(SetuplibraryViewCallBack setuplibraryView) {
		this.setuplibraryView=setuplibraryView;
		setupLibraryModel=new SetuplibraryModel(this);
	}

	public void checkLibrary(String library_name, String city_name) {
		setupLibraryModel.checkLibraryOnline(library_name,city_name);
		
	}

	public void validLibrary(String library_name) {
		setuplibraryView.validLibrary(library_name);
	}

	public void invalidLibrary(String errorMessage) {
		setuplibraryView.invalidLibrary(errorMessage);
	}

}
