package uke12.delegering.kokk;

import java.util.Random;

/*
 * Hovedkokken har ansatt to kokker til å gjøre arbeidet sitt. Det
 * er jo det delegering handler om! I tillegg er det tilfeldig hvilken
 * av de to kokkene som faktisk lager maten. Legg merke til at this.makeSauce()
 * dermed knyttes direkte videre til underkokk.makeSauce(). Husk også at en kan
 * gjøre litt mer, en trenger ikke ha en helt dum metode for å kalle det 
 * delegering. ChefdelaChef gjør noe - hen velger hvilken kokk som skal lage
 * maten.
 */
public class ChefdelaChef implements Chef{

	Chef kokk1 = new Kokk1();
	Chef kokk2 = new Kokk2();
	final Random random = new Random();


	public String todaysMenu() {

		String menu = "Dagens rett er ";
		menu += this.makeMain();
		menu += " med ";
		menu += this.makePotatoes();
		menu += " og ";
		menu += this.makeSauce();
		menu += ".";
		return menu;
	}


	/* 
	 * ChefDelaChef har to kokker. Og velger tilfeldig hvilken av de to som
	 * faktisk lager maten. Det kan gi opphav til spesielle kombinasjoner...
	 */
	@Override
	public String makeMain() {
		return random.nextBoolean()? kokk1.makeMain():kokk2.makeMain();
	}

	@Override
	public String makeSauce() {
		return random.nextBoolean()? kokk1.makeSauce():kokk2.makeSauce();
	}

	@Override
	public String makePotatoes() {
		return random.nextBoolean()? kokk1.makePotatoes():kokk2.makePotatoes();
	}

	
	public static void main(String[] args) {

		ChefdelaChef dude = new ChefdelaChef();
		System.out.println(dude.todaysMenu());

	}


}
