package com.library.setuplibrary;

public class SetuplibraryModel implements SetuplibraryModelCallBack{
	
	private SetuplibraryModelControllerCallBack setuplibraryController;

	public SetuplibraryModel(SetuplibraryModelControllerCallBack setuplibraryController) {
		this.setuplibraryController=setuplibraryController;
	}
	public void checkLibraryOnline(String library_name, String city_name) {
		if(library_name.equals("zsgs_library") && city_name.equals("chennai"))
		{
			setuplibraryController.validLibrary(library_name);
		}
		else
		{
			setuplibraryController.invalidLibrary("Library name or city doesn't exist.");
		}
	}
	interface SetuplibraryModelControllerCallBack{
		
		void validLibrary(String library_name);

		void invalidLibrary(String string);

	}
}
