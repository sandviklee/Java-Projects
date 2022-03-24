package uke12.delegering.kokk;

public class Kokk2 implements Chef {
	
	// Kanskje kokk2 kan sette bort arbeidet til enda en kokk, skjult for sjefen?
	// Dobbeldelegering!
	Chef kokk3 = new Kokk3();
	
	// Denne kokken setter bare bort mekking av saus til kokk3.
	@Override
	public String makeSauce() {
		return kokk3.makeSauce();
	}

	@Override
	public String makeMain() {
		return "entrecôte";
	}

	@Override
	public String makePotatoes() {
		return "hasselbackpoteter";
	}

}
