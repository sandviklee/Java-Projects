package uke6.kino3;

public class Kino {

	public static void main(String[] args) {
		Film alexander = new Film("Alexander", 15, "USA");
		Film badsanta = new Film("Bad Santa", 11, "USA");
		Sal nova3 = new Sal("Nova 3", 200);
		Sal prinsen4 = new Sal("Prinsen 4", 120);
		Sal prinsen7 = new Sal("Prinsen 7", 43);
		
		
		Filmvisning fv1 = new Filmvisning(nova3, "20:00", 85, alexander);
		Filmvisning fv2 = new Filmvisning(prinsen4, "17:00", 75, alexander);
		Filmvisning fv3 = new Filmvisning(prinsen4, "20:30", 85, alexander);
		// Den neste går på grunn av at jeg har laget enda en konstruktør, men det er usikkert om det er lurt.
//		Filmvisning fv4 = new Filmvisning("Prinsen 7", "20:30", 12, "Fantorangen har bursdag", 3, "Norsk");
		System.out.println(fv1);
		System.out.println(fv2);
		System.out.println(fv3);
//		System.out.println(fv4);

	}

}
