package home;

import java.util.Random;

import dto.Thirukkural;

public class HomeController implements HomeControllerCallBack, HomeModelControllerCallBack {
	private HomeViewCallBack homeView;
	private HomeModelCallBack homeModel;

	public HomeController(HomeViewCallBack homeView) {
		this.homeView = homeView;
		homeModel = new HomeModel(this);
	}

	public void inputValidation(String input) {
		int choice = 0;
		try {
			choice = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.err.println("enter valid input");
			homeView.homePage();
		} catch (Exception e) {
			System.err.println("enter valid input");
			homeView.homePage();
		}
	}

	public void getKural(int choice) {
		Thirukkural tkl = homeModel.getKural(choice - 1);
		homeView.viewKural(tkl);

	}

	public void getKuralOfTheDay() {
		Random random = new Random();
		int randomNumber = random.nextInt(1320);
		getKural(randomNumber);
	}

	public void getAthikaram(int choice) {
		choice = choice * 10 + 1;
		String athikaram = homeModel.getKuralAthikaram(choice + 2);
		;
		homeView.printAthikaram(athikaram);
		for (int i = 0; i < 10; i++) {
			getKural(choice + i);
		}
	}
}
