package uke4.fasit;

/**
 * En veldig enkel Personklasse. Den har bare navn og alder, og gettere den trenger.
 * Den er derimot spennende når en ser på at den har tre konstruktører - der den ene 
 * bruker den andre, som igjen bruker den tredje.
 */
public class Person {

	String name;
	int age;
	
	
	public String getName() {
		return name;
	}


	public int getAge() {
		return age;
	}

	/**
	 * Konstruktører er fine - og en kan ha mange av dem. 
	 * en kan ha flere av dem. Det vanlige er å la ÉN av dem faktisk lage
	 * objektet, mens de andre peker til denne ved hjelp av this(). 
	 * I dette eksempelet vil konstruktøren uten parametre kalle den tar inn navn, da
	 * har den lagt på en standardverdi for navn. Konstruktøren som kun tar inn navn kaller igjen
	 * konstruktøren som tar inn navn og alder. Den sender med en standardverdi på alder.
	 * 
	 * Koden her avviker fra eksempelet jeg laget i forelesning. Kjør det og se om du forstår endringen i logikk.
	 * 
     * Når jeg gjør det på denne måten kan man ha verifikasjon av stuff på et
     * passende sted, og slippe å ha ting flere steder.
     * 
     * this(), altså kall av en annen konstruktør, i samme klasse. Det MÅ skje på første linje i
     * konstruktøren. Dette er akkurat likt som når en kaller super().
     * 
	 */

	 // Denne k får inn alt vi trenger for å lage et fullverdig objekt av typen Person  
	public Person(String name, int age) {
        this.name = name;
		this.age = age;
        System.out.println("Person: Inni 2 parameters konstruktør"); 
	}

	// Her mangler vi alder. Da må vi kalle k over, men med en standardverdi for alder 
	public Person(String name) { // Hvis ikke alder er nevnt, 0 år.
        this(name, 33); // Vi har ikke noen alder, sant? Da lager vi en standard da! 
		System.out.println("Person: Inni 1 parameters konstruktør");
	}

	// Her har vi ikkeno. Da kaller vi metoden rett over, med en standardverdi for navn.
	public Person() { 
		this("Wanda");
		System.out.println("Person: Inni 0 parameters konstruktør");

	}


	public static void main(String[] args) {
		Person p = new Person("Per",23);
		System.out.println(p.toString());
		System.out.println(new Person()); 
        /* På grunn av måten konstruktørene er laget her, så bør følgende nye Person
        ende opp med å skrive ut 0, 1, så 2 som konstruktørrekkefølge. Det er fordi
        vi kaller 2->1 og 1->0 FØR vi skriver ut at vi er inni konstruktørene.
        */

	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
