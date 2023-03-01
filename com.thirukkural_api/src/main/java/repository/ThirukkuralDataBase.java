package repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import dto.Thirukkural;

public class ThirukkuralDataBase {

	private static ThirukkuralDataBase thirukuralDataBase;

	private ThirukkuralDataBase() {

	}

	public static ThirukkuralDataBase getInstance() {
		if (thirukuralDataBase == null) {
			thirukuralDataBase = new ThirukkuralDataBase();
		}
		return thirukuralDataBase;
	}

	public Thirukkural getKural(int number) {
		// TODO Auto-generated method stub
		JSONParser jsonparser = new JSONParser();
		Thirukkural gettedKural = null;
		try {
			FileReader reader = new FileReader(
					"E:\\Suryapandi\\eclipse\\com.thirukkural_api\\jasonfiles\\thirukkural.json");
			Object obj = null;
			try {
				obj = jsonparser.parse(reader);
			} catch (IOException | ParseException e) {
				// return null;
				e.printStackTrace();
			}
			JSONObject thirukuralJson = (JSONObject) obj;
			JSONArray array = (JSONArray) thirukuralJson.get("kural");
			JSONObject kuraljsonObject = (JSONObject) array.get(number);
			Long num = (Long) kuraljsonObject.get("Number");
			Long num1 = (Long) kuraljsonObject.get("Number");
			String line1 = (String) kuraljsonObject.get("Line1");
			String line2 = (String) kuraljsonObject.get("Line2");
			String trans = (String) kuraljsonObject.get("Translation");
			String mv = (String) kuraljsonObject.get("mv");
			String sp = (String) kuraljsonObject.get("sp");
			String mk = (String) kuraljsonObject.get("mk");
			String exp = (String) kuraljsonObject.get("explanation");
			String coup = (String) kuraljsonObject.get("couplet");
			String trans1 = (String) kuraljsonObject.get("transliteration1");
			String trans2 = (String) kuraljsonObject.get("transliteration2");
			String athikaram = (String) kuraljsonObject.get("adikaram_name");
			gettedKural = new Thirukkural(num1, line1, line2, trans, mv, sp, mk, exp, coup, trans1, trans2, athikaram);

		} catch (FileNotFoundException e) {
			// return null;
			e.printStackTrace();
		}
		return gettedKural;
	}

	public String getAthikaram(int choice) {
		Thirukkural tkl = getKural(choice);
		return tkl.getAdthikaram();
	}

}
