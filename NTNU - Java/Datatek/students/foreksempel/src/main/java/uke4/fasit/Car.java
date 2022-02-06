package uke4.fasit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Car {
    private Person driver;
	private Plate plate;
	private int seats;

	private Collection<Person> passengers = new ArrayList<>();

	public Car(String plate, int seats) {
		super();
		this.plate = new Plate(plate);
		this.seats = seats;
		System.out.println("Bil med regnr "+plate+" og "+ seats+" seter.");
	}



	

	@Override
	public String toString() {
		return "Car [driver=" + driver + ", plate=" + plate + ", seats=" + seats + ", passengers=" + passengers + "]";
	}



	void removePassenger(Person person) {
		if (passengers.remove(person)) {
			System.out.println(person.getName()+" hoppet av.");			
		}
		else {
			System.out.println(person.getName()+" satt aldri på!");
		}
	}

	/**
	 * Hjelpemetode som ikke ble med på forelesning.
	 * @return antallet passasjerer
	 */
	int getPassengerAmount() {
		return this.passengers.size();
	}
	
	
	public void addPassenger(Person person) {
		if (this.passengers.size() == this.seats -1) { // -1 siden vi har en førerplass
			System.out.println("Fullt. Vent på neste bil,"+ person.getName());
		}
		else {
			this.passengers.add(person);
			System.out.println(person.getName()+" sitter på.");
		}
	}

    /**
     * 
     * @param person Den som skal kjøre bilen. Må være minst 18 år gammel
     * Jeg har ikke valgt å utløse noen unntak her - men skriver i stedet ut en beskjed i terminalen.
     */
	public void setDriver(Person person) {
		if (person.getAge() > 17) {
			this.driver = person;
			System.out.println(this.driver.getName()+" kjører nå "+this.plate.getSign());
		}
		else {
			System.out.println(person.getName()+" er ikke gammel nok til å kjøre bilen.");
		}
	}

    /**
	 * Jeg har her skissert slik jeg ønsker at en bil skal oppføre seg.
	 * Så er det opp til meg å bestemme hvordan dette skal løses internt
	 * ved oppdeling av objekter og ansvar. 
	 * @param args
	 */
	public static void main(String[] args) {
		Car car = new Car("XY43171",5);
		// Car car2 = new Car("A465786",7); // Denne skal utløse et unntak.
		Person per= new Person("Per", 23);
		Person ida = new Person("Ida", 14);
		car.setDriver(ida);
		car.setDriver(per);
		car.addPassenger(ida);
        System.out.println("\nAntallet passasjerer: "+car.getPassengerAmount());
		car.removePassenger(ida);
		car.addPassenger(new Person("Jens",73));
		car.addPassenger(new Person("Åge",37));
		car.addPassenger(new Person());
        System.out.println("Antallet passasjerer: "+car.getPassengerAmount());
		System.out.println("\ncar1 ser nå slik ut:");
		System.out.println(car); // Her kalles Car sin egen toString()-metode. 
		
		System.out.println("\nSå bare noe jeg vil vise. Denne koden:");
		// Det under er for spesielt interesserte. Hvis du sliter litt nå, så er det ikke viktig å lese resten. Ennå!
        // Dette er bare en smakebit på hva dere kommer til å lære i løpet av våren. Dette er effektiv koding!
		// HUSK: DERE SKAL IKKE kunne det i løpet av uken, men tenk så kult det blir å kunne!
		car.passengers.stream() // Lag en 'strøm' av alle objektene som finnes i samlingen car1.passengers.
			.map(p -> p.getAge())         // For hver person, send bare dennes alder videre i strømmen
			.filter(n -> n > 17)          // Bare tall over 17 får bli med videre i strømmen
			.sorted((n1, n2) -> Integer.compare(n1, n2)) // Sorter tallene i strømmen etter størrelse
			.forEach(System.out::println);// Skriv ut hvert resultat på sin egen linje ETTER sortering
		
		System.out.println("...gir det samme som:");
		// Strømmen over gjør det samme som denne koden fra her...
		List<Integer> liste = new ArrayList<>();
		for (Person person : car.passengers) {
			int age = person.getAge();
			if (age > 17 ) {
				liste.add(age); 
			}
		}
		Collections.sort(liste); // Vi kaller sortering på samme måte som man i Python skriver sorted([3,6,1,2,8,5,4])
		for (Integer integer : liste) { // Python: for integer in liste:
			System.out.println(integer);
		}
		// ...til hit. Så kan du avgjøre selv hva som er mest forståelig når kommer til mai og skjønner alt.
		// streams har en drøss andre fordeler også, men det tar vi om en måned eller to!
	}
}
