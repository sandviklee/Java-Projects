package uke4.fasit;

import java.util.regex.Pattern;

// Vi velger å ikke ha noen setSign, da en ikke skifter regnr på et skilt. En skifter skilt.
public class Plate {

	private String sign;


	/**
	 * Den bruker regex, som er på utsiden av
	 * pensum, jeg har lagt ved en SVÆRT enkel metode som gjør det
	 * annerledes like under.
	 * @param sign regnr vi ønsker å sjekke
	 * @return Statisk metode som returnerer om en streng passer med norske
	 * registreringsnummer. Siden den er statisk trenger 
	 */
	private static boolean checkSign(String sign) {
		return Pattern.matches("[A-Z]{2}[0-9]{5}", sign);
	}

	// Samme metode som over, men uten regex. Synes den over er litt mer ok...
	private static boolean checkSignNonRegex(String plate) {
		if (Character.isLetter(plate.charAt(0))  &&
				Character.isLetter(plate.charAt(1)) &&
				Character.isDigit(plate.charAt(2)) &&
				Character.isDigit(plate.charAt(3)) &&
				Character.isDigit(plate.charAt(4)) &&
				Character.isDigit(plate.charAt(5)) &&
				Character.isDigit(plate.charAt(6)) &&
				plate.length() == 7) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param sign regnr som et skilt M lages med.
     * Vi kunne ha løst dette på en litt annen måte. Vi kunne brukt at Plate.checkSign 
     * er en statisk, 'public' metode. Da hadde man kunnet sjekke i Bil om
     * regnr faktisk er ok før en velger å lage et nytt Plateobjekt. Vi måtte allikevel hatt
     * sjekken i Plate, for en skal jo ikke bare stole blindt på fremmede objekter som lover
     * 'at de skal gjøre det, altså'.
	 */
	public Plate(String sign) {
		super();
		if (checkSign(sign)) {
			this.sign = sign;
		}
		else {
			throw new IllegalArgumentException(sign + " er ikke et gyldig regnr.");
		}
	}

	public String getSign() {
		return sign;
	}


	public static void main(String[] args) {
		Plate p = new Plate("AA41383");
		System.out.println(p);
        // Plate p2 = new Plate("AA413832"); // Utløser unntak
		if (!p.getSign().equals("AA41383")) {
			System.out.println("Bør være AA41383, er " + p.getSign());
		}
	}

	@Override
	public String toString() {
		return this.getSign();
	}

}
