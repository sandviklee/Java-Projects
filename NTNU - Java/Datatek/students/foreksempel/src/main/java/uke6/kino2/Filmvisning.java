package uke6.kino2;

public class Filmvisning {

	String sal;
	String tid;
	int pris;
	Film film;

	/**
	 * Denne tar inn en Film. Det betyr at en m� lage Film-objekter p� utsiden av Filmvisning, og s� sende
	 * dem inn n�r en lager en visning.
	 * @param sal
	 * @param tid
	 * @param pris
	 * @param film
	 */
	public Filmvisning(String sal, String tid, int pris, Film film) {
		super();
		this.sal = sal;
		this.tid = tid;
		this.pris = pris;
		this.film = film;
	}


	/**
	 * Er denne m�ten � gj�re det p� noe smart? Det kan v�re tidspunkt der det ikke er s� farlig hvordan en lager
	 * objekter. Andre ganger kan det v�re viktig. Kanskje kinoen �nsker � ha en liste over alle filmene som g�r
	 * til enhver tid? Da m� kinoen lage Film-objekter, og da er det like smart � bare tillate innlegging av nye
	 * Filmvisninger gjennom referanse til en Film.
	 * @param sal
	 * @param tid
	 * @param pris
	 * @param tittel
	 * @param aldersgrense
	 * @param nasjonalitet
	 */
	public Filmvisning(String sal, String tid, int pris, String tittel, int aldersgrense, String nasjonalitet) {
		// P� forelesningen viste jeg det som er kommentert ut. En kan like gjerne kalle den andre konstrukt�ren:
//		super();
//		Film film = new Film(tittel, aldersgrense, nasjonalitet);
//		this.sal = sal;
//		this.tid = tid;
//		this.pris = pris;
//		this.film = film;
		this(sal, tid, pris, new Film(tittel, aldersgrense, nasjonalitet));
	
	}


	public static void main(String[] args) {
		Film alexander = new Film("Alexander", 15, "USA");
		Film badsanta = new Film("Bad Santa", 11, "USA");
		Filmvisning fv1 = new Filmvisning("Nova 3", "20:00", 85, alexander);
		Filmvisning fv2 = new Filmvisning("Prinsen 4", "17:00", 75, alexander);
		Filmvisning fv3 = new Filmvisning("Prinsen 4", "20:30", 85, alexander);
		// Den neste g�r p� grunn av at jeg har laget enda en konstrukt�r, men det er usikkert om det er lurt.
		Filmvisning fv4 = new Filmvisning("Prinsen 7", "20:30", 12, "Fantorangen har bursdag", 3, "Norsk");
		System.out.println(fv1);
		System.out.println(fv2);
		System.out.println(fv3);
		System.out.println(fv4);
	}


	@Override
	public String toString() {
		return "Filmvisning [sal=" + sal + ", tid=" + tid + ", pris=" + pris + ", film=" + film + "]";
	}

	

}
