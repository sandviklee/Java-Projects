package uke2; // Dette sier at klassen Frukt hører til i 'pakken' uke2. 

// Vi bestemmer oss for å lage en egen klasse, Frukt. Den kan holde styr på hva
// den heter, og hvor mange det er av den. Lite praktisk eksempel, men tror det
// skal hjelpe til med å forklare sånn noenlunde! 
public class Frukt {

	String type;   // Navnet på hver frukt 
	double antall; // Mengden. Double betyr flyttall. int for bare hele frukt.

	// Dette kalles en konstruktør. Den sier noe om hvordan man kan lage nye
	// objekter av typen Frukt. Vi kan ha flere av dem. Her er det bare en,
	// med to parametre. Det betyr at vi bare kan lage slik: new Frukt("eple",2)
	public Frukt(String type, double antall) {
		this.antall = antall;
		this.type = type;
	}

	// Dette kalles en getter. Det er ikke høflig, ei heller mulig (ofte) å spørre
	// en frukt hvor mange den er, sånn direkte. Man må gå via en getter.
	public double getAntall() {
		return antall;
	}

	// Det samme som for get Antall
	public String getType() {
		return type;
	}

	public void leggTil(double antall) {
		this.antall += antall; // Oppdater denne frukten med antall
	}

	// Følgende metode er spesiell. Inntil videre kan dere bare tenke at det er main-
	// metoden som kjøres når en velger 'run'. Så det er der en må lage objektene, i alle fall
	// til å begynne med.
	public static void main(String[] args) {
		// La oss lage to frukter!
		Frukt f1 = new Frukt("Appelsin", 2);
		Frukt f2 = new Frukt("Banan", 1);
		// Slik må en skrive ut i Java. Heldigvis hjelper VS Code deg litt... 
		System.out.println("Skrive ut objektreferanser:");
		// Følgende to utskrifter ser ikke helt bra ut. Det skrives ut hvilket objekt
		// hver variabel er. For oss mennesker betyr det ikke spesielt mye.
		// Legg merke til at begge er uke2.Frukt. Kjør programmet en gang til, og se at
		// tegnene etter @ endrer seg. Det er referansen til hvert enkelt fruktobjekt.
		System.out.println(f1);
		System.out.println(f2);

		System.out.println("Skrive ut objektinnhold.");
		// For å se det faktiske inneholdet av objektene må vi spørre etter dem (vi kan
		// også gjør frukten mer presentabel, men det blir senere!)
		System.out.println(f1.getType() + " : " + f1.getAntall());
		System.out.println(f2.getType() + " : " + f2.getAntall());

		// La oss legge til flere bananer!
		f2.leggTil(2);
		System.out.println(f2.getType() + " : " + f2.getAntall()); // Skal være 3.
		// ...og bruke en halv appelsin
		f1.leggTil(-0.5); // Et lite hack å legge til negative tall, kanskje?
		System.out.println(f1.getType() + " : " + f1.getAntall()); // Skal være 3.
	}

}
