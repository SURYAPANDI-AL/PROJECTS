package dto;

public class Thirukkural {

	private Long number;
	private String kuralFirstLine;
	private String kuralSecondLine;
	private String translation;
	private String meaningFirstLine;
	private String meaningSecondLine;
	private String meaningThirdLine;
	private String explanationFirstLine;
	private String explanationSecondLine;
	private String translationFirstLine;
	private String tranlationSecondLine;
	private String adthikaram;

	public Thirukkural(Long number, String kuralFirstLine, String kuralSecondLine, String translation,
			String meaningFirstLine, String meaningSecondLine, String meaningThirdLine, String explanationFirstLine,
			String explanationSecondLine, String translationFirstLine, String tranlationSecondLine, String adthikaram) {
		super();
		this.number = number;
		this.kuralFirstLine = kuralFirstLine;
		this.kuralSecondLine = kuralSecondLine;
		this.translation = translation;
		this.meaningFirstLine = meaningFirstLine;
		this.meaningSecondLine = meaningSecondLine;
		this.meaningThirdLine = meaningThirdLine;
		this.explanationFirstLine = explanationFirstLine;
		this.explanationSecondLine = explanationSecondLine;
		this.translationFirstLine = translationFirstLine;
		this.tranlationSecondLine = tranlationSecondLine;
		this.adthikaram = adthikaram;
	}

	public String getAdthikaram() {
		return adthikaram;
	}

	public void setAdthikaram(String adthikaram) {
		this.adthikaram = adthikaram;
	}

	public Long getNumber() {
		return number;
	}

	public String getKuralFirstLine() {
		return kuralFirstLine;
	}

	public String getKuralSecondLine() {
		return kuralSecondLine;
	}

	public String getTranslation() {
		return translation;
	}

	public String getMeaningFirstLine() {
		return meaningFirstLine;
	}

	public String getMeaningSecondLine() {
		return meaningSecondLine;
	}

	public String getMeaningThirdLine() {
		return meaningThirdLine;
	}

	public String getExplanationFirstLine() {
		return explanationFirstLine;
	}

	public String getExplanationSecondLine() {
		return explanationSecondLine;
	}

	public String getTranslationFirstLine() {
		return translationFirstLine;
	}

	public String getTranlationSecondLine() {
		return tranlationSecondLine;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public void setKuralFirstLine(String kuralFirstLine) {
		this.kuralFirstLine = kuralFirstLine;
	}

	public void setKuralSecondLine(String kuralSecondLine) {
		this.kuralSecondLine = kuralSecondLine;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public void setMeaningFirstLine(String meaningFirstLine) {
		this.meaningFirstLine = meaningFirstLine;
	}

	public void setMeaningSecondLine(String meaningSecondLine) {
		this.meaningSecondLine = meaningSecondLine;
	}

	public void setMeaningThirdLine(String meaningThirdLine) {
		this.meaningThirdLine = meaningThirdLine;
	}

	public void setExplanationFirstLine(String explanationFirstLine) {
		this.explanationFirstLine = explanationFirstLine;
	}

	public void setExplanationSecondLine(String explanationSecondLine) {
		this.explanationSecondLine = explanationSecondLine;
	}

	public void setTranslationFirstLine(String translationFirstLine) {
		this.translationFirstLine = translationFirstLine;
	}

	public void setTranlationSecondLine(String tranlationSecondLine) {
		this.tranlationSecondLine = tranlationSecondLine;
	}

}