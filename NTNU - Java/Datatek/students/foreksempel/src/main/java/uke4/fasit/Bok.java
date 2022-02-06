package uke4.fasit;


public class Bok{

	/**
	 * Vi har tre variable som lagrer tilstanden. Legg merke til at
	 * man ikke kan endre navn på boken eller antall sider etter at
	 * Boken er opprettet. Man kan derimot endre hvor langt man har kommet.
	 * Dette gjøres gjennom en set-metode (lest(int mengde)) som sjekker om
	 * kallet er lovlig eller ikke. 
	 */
	private String tittel;
	private int sider;
	private int hvor = 0;
	
	// Denne er enkel: returnere akkurat det som er tittelen. 
	public String getTittel() {
		return tittel;
	}

	// Hvor mange sider har en lest? 'hvor' vet det.
	public int getHvor() {
		return hvor;
	}

	private boolean kanLese(int mengde) {
		return hvor + mengde > sider;
	}


	/**
	 * Utløs unntak hvis en hevder å ha lest flere sider av boken
	 * enn det er igjen av boken. Oppdaterer ellers hvilken side
	 * en nå er på i boken.
	 * @param mengde er antall sider som er lest denne gangen.
	 */
	public void lest(int mengde) {
		if (kanLese(mengde))
			throw new IllegalArgumentException("Nope.");
		hvor += mengde;
	}
		
	// Denne gidder jeg ikke forklare.
	public int getSider() {
		return sider;
	}
	
	public static void main(String[] args) {
		Bok b = new Bok("Krig og fred", 4343);
		System.out.println(b);
		b.lest(45);
		b.lest(54);
		System.out.println(b);
		b.lest(54);
		// b.lest(545654); // Bør utløse unntak
		System.out.println(b);
	}

	// Det er så kjipt med toString() fra Object-klassen, så la oss overskrive den med en egen variant.
	// Les dere opp på toString, dette er en fin beskrivelse: https://stackoverflow.com/review/late-answers/10049440
	@Override
	public String toString() {
		return "Bok [tittel=" + tittel + ", sider=" + sider + ", hvor=" + hvor + "]";
	}


	// Konstruktøren. En vet alltid hva tittelen er, og hvor mange sider boken har.
	public Bok(String tmptittel, int sider) {
		super(); // HOld musa over super og se hva den peker på.
		System.out.println("Her er jeg"); // dette skrives ut to ganger!
		tittel = tmptittel; // En måte å separere objektets og Konstruktørens tittel
		this.sider = sider; // En annen måte. Samme navn, men separerer med this for objektet
	}

	// Den tomme konstruktøren kaller rett og slett bare den andre med et sett standardverdier.
	// Teit med tanke på at det er bøker, men finn på noe bedre selv! ;)
	// Den tomme konstruktøren her er kun til for å vise at man kan ha flere, og kalle en annen.
	public Bok() {
		this("Java for dummies", 345);
	}
	
	
	/* Dette må du installere PlantUML for å kunne lese. Bruker på forelesning.
@startuml

class Bok {
  __ private data __
  - String tittel
  - int sider
  - int hvor
  .. Konstruktører ..
  + Bok(String tittel, int sider)
  + Bok()
  .. Gettere ..
  + String getTittel()
  + int getHvor()
  + int getSider()
  .. Metoder ..
  + boolean lest(int sider)
  + String toString()
}

@enduml

	*/
	
}
