package uke11.iostreams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Flerkamp {

	
	List<Deltaker> deltakere = new ArrayList<>();

	private void readFile()  {

		try { // Påkrevd try siden en leser fra fil.
			// Setter den sammen av folderen til classfilene og pakkenavnet.
			URL classUrl = getClass().getResource("flerkamp.txt");
			System.out.println("URL: "+classUrl);
			System.out.println("Pakkenavn: "+getClass().getPackageName());
			Path path = Paths.get(classUrl.toURI());
			System.out.println("Path (URI): "+path);

			// Men man gjør gjerne dette på én gang, om en ikke skal noe mer med dem:		
			this.deltakere = Files.lines(Paths.get(getClass().getResource("flerkamp.txt").toURI()))
			// Nå er hvert objekt en String, linje fra filen.
			.skip(1) // Den første linjen er overskrift, dropper den.
			// n er linjen, n settes til kall på fromCols med en liste av strenger
			.map(l -> l.split(",\\s*"))
			.map(n -> fromCols(n)) // Splitter på "," og valgfritt antall mellomrom. (søk opp regexp)

			// fromCols lager Personer. La oss samle disse i en liste og returnere alle:
			.toList(); 
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		} finally {
			System.out.println("Jeg kalles uansett om try lykkes eller ikke...");
		}
	}

	// Annen måte - og statisk folderstruktur for å hente filen. 
	private void readFile_old() {
		File file = new File("C:/Users/borgeha/tdt4100-v2022/students/foreksempel/src/main/java/uke11/iostreams/flerkamp.txt"); 
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			br.readLine(); // Hopper over første linje.
			String str; 
			while ((str = br.readLine()) != null) 
				deltakere.add(fromCols(str.split(",\\s*")));
			br.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	} 



	// Denne brukes av begge readFile-variantene. Den parser en streng (linje fra filen) og oppretter et Deltakerobjekt.
	// Dette mates tilbake i strømmen.
	private Deltaker fromCols(String...cols) {
		return new Deltaker(cols[0], Integer.parseInt(cols[1]), 
				Double.parseDouble(cols[2]), Integer.parseInt(cols[3]), 
				Integer.parseInt(cols[4]), cols[5]);
	}


	private void scanner_read(InputStream is) {
		
		// Absolutt path blir litt mer som dette:
//        File text = new File("C:/temp/fil.txt");
//        Scanner scnr = new Scanner(text);
		System.out.println("Vi skanner og vi scanner...");
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)));
		scanner.useDelimiter("\n"); // Ellers splitter den på komma....
		
		// Hoppe over første linje.
		scanner.next();
		while (scanner.hasNext()) {
			String string = scanner.next();
			// System.out.println(string);
			String[] tmp = string.split(",\\s*");
			// System.out.println(tmp[0]);
			deltakere.add(fromCols(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5]));
			// System.out.println("yay: "+this.deltakere);
		}
		scanner.close();
	}

	public static void main(String[] args) throws URISyntaxException {
		Flerkamp fk = new Flerkamp();
		// fk.readFile(); // Leser via stream og legger Deltakere inn i fk!
		// fk.readFile_old();
		fk.scanner_read(fk.getClass().getResourceAsStream("flerkamp.txt"));

		System.out.println("antall deltakere: "+fk.deltakere.size());

		// Nå skal alle deltakerne ha blitt lagt inn i listen. Så en enkel stream-måte å skrive dem ut på,
		// println kaller toString i hvert Deltakerobjekt på veien.
		fk.deltakere.forEach(System.out::println);

		// System.out.println(fk.deltakere.get(3));


		// Hva med å skrive ut alle navnene til deltakerne? Tenk at data flyter fra venstre mot høyre og endres.
		System.out.println("Deltakere: "+fk.deltakere.stream()
		.map(x -> x.getName())
		.collect( Collectors.joining( ", " )));

		
		// Hva med å finne deltakerne som fikk minst 10 poeng på ballongskyting og poker?
		fk.deltakere.stream()  // Enhver Collection kan streames!
		.filter(x -> x.getBalloonshooting() >= 10 && x.getPoker() >= 10)
		.forEach(p -> System.out.println("\nMinst ti poeng i poker og ballongskyting: "+p.getName()));		

		
		// Til slutt et eksempel på bruk av scanner
		// fk.deltakere.clear();
		// fk.scanner_read(fk.getClass().getResourceAsStream("flerkamp.txt"));

		// fk.deltakere.stream()  // Enhver Collection kan streames! Som over.
		// .filter(x -> x.getBalloonshooting() >= 10 && x.getPoker() >= 10)
		// .forEach(p -> System.out.println("\nMinst ti poeng i poker og ballongskyting: "+p.getName()));		
	}


	@Override
	public String toString() {
		return "Flerkamp [deltakere=" + deltakere + "]";
	}
}
