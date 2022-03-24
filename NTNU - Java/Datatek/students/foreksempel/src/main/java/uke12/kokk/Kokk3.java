package uke12.kokk;

public class Kokk3 implements Chef {
	
	// Kanskje kokk2 kan sette bort arbeidet til enda en kokk, skjult for sjefen?
	@Override
	public String makeSauce() {
		return "ketchup";
	}

	@Override
	public String makeMain() {
		return "ostesmørbrød";
	}

	@Override
	public String makePotatoes() {
		return "kokte poteter";
	}

}
