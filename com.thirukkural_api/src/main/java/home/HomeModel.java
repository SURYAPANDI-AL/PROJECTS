package home;

import dto.Thirukkural;
import repository.ThirukkuralDataBase;

public class HomeModel implements HomeModelCallBack {

	private ThirukkuralDataBase tdb = ThirukkuralDataBase.getInstance();
	private HomeModelControllerCallBack homeController;

	public HomeModel(HomeModelControllerCallBack homeController) {
		this.homeController = homeController;
	}

	public Thirukkural getKural(int kuralNumber) {
		Thirukkural trk = tdb.getKural(kuralNumber);
		return trk;
	}

	public String getKuralAthikaram(int choice) {
		return tdb.getAthikaram(choice);
	}
}
