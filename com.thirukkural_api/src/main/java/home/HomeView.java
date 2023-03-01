package home;

import java.util.Scanner;

import dto.Thirukkural;

public class HomeView implements HomeViewCallBack {
	private HomeControllerCallBack homeController;
	private Scanner sc = new Scanner(System.in);

	public HomeView() {
		homeController = new HomeController(this);
	}

	public void homePage() {
		System.out.println("\t\t------->திருக்குறள் செயலி<--------\n");

		System.out.println();
		System.out.println("\n1. எண் வாரியாக தேட ");
		System.out.println("2. அதிகாரங்கள் வாரியாக பார்க்க ");
		System.out.println("3. அன்றைய திருக்குறள் பார்க்க\n");

		String sChoice = sc.next();
		homeController.inputValidation(sChoice);
		int choice = Integer.parseInt(sChoice);
		switch (choice) {
		case 1:
			thirukkuralByNumber();
			break;
		case 2:
			thirukkuralByList();
			break;
		case 3:
			kuralOfDay();
			break;
		default:
			exit();
		}
	}

	private void thirukkuralByList() {
		System.out.println("------------->அதிகாரங்கள்  தேடல்<--------------\n");
		System.out.print("அதிகாரங்கள் எண்(1/133)   :");
		String sChoice = sc.next();
		homeController.inputValidation(sChoice);
		int choice = Integer.parseInt(sChoice);
		if (choice > 133 || choice < 1) {
			System.out.println("தவறான தரவு..");
			thirukkuralByList();
			return;
		}
		homeController.getAthikaram(choice);
		homePage();
	}

	private void kuralOfDay() {
		homeController.getKuralOfTheDay();
	}

	private void thirukkuralByNumber() {
		System.out.println("------------->திருக்குறள்  தேடல்<--------------\n");
		System.out.print("திருக்குறள் எண் (1/1330)   :");
		String sChoice = sc.next();
		homeController.inputValidation(sChoice);
		int choice = Integer.parseInt(sChoice);
		if (choice > 1333 || choice < 1) {
			System.out.println("தவறான தரவு..");
			thirukkuralByNumber();
			return;
		}
		homeController.getKural(choice);
		homePage();
	}

	public void viewKural(Thirukkural kural) {
		if (kural == null) {
			System.out.println("இணையத் துண்டிப்பு ஏற்பட்டுள்ளது");
		} else {
			for (int i = 0; i < 500; i++)
				System.out.print("*");
			System.out.println();
			System.out.println("\nகுறள் எண்  :[" + kural.getNumber() + "]");
			System.out.println("\nகுறள் \t  :" + kural.getKuralFirstLine() + "\n\t\t" + kural.getKuralSecondLine());
			System.out.println("\nதமிழ் விளக்கம்: " + kural.getMeaningFirstLine() + "\n\t\t"
					+ kural.getMeaningSecondLine() + "\n\t\t" + kural.getMeaningThirdLine() + "\n");
			for (int i = 0; i < 500; i++)
				System.out.print("-");
			System.out.println();
			System.out.println(
					"\nTranslation :" + kural.getTranslationFirstLine() + "\n\t\t" + kural.getTranlationSecondLine());
			for (int i = 0; i < 500; i++)
				System.out.print("*");
			System.out.println();
		}

	}

	private void exit() {
		System.out.println("\r\n" + "நன்றி!!!!!");
		System.exit(0);
	}

	public void printAthikaram(String athikaram) {
		for (int i = 0; i < 500; i++)
			System.out.print("+");
		System.out.println();
		System.out.println("\t\t" + athikaram);
		for (int i = 0; i < 500; i++)
			System.out.print("+");
		System.out.println();
	}

}
