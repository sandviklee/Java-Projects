package uke5.fasit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Car {
    
    private int seats;
    private Plate plate;
    private Person driver;
    Collection<Person> passengers = new ArrayList<>();

    public Car(String sign, int seats) {
        this.seats = seats;
        this.plate = new Plate(sign);
    }


    // Denne er endret - her bruker vi en ofte benyttet metode for å lage strenger, StringBuilder.
    // Men vi må huske sb.toString til slutt.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(plate+" ("+seats+")\n");
        if (this.driver != null) sb.append("Driver: "+driver+"\n");
        if (!this.passengers.isEmpty()) sb.append("Passengers: "+passengers);
        return sb.toString();
    }

    public void removePassenger(Person person) {
        if (passengers.remove(person)) {
            System.out.println("Ble kastet ut: "+person);
        }
        else {
            System.out.println(person + "satt ikke på");
        }
    }

    // Brukes ikke ennå -  men når en tenker innkapsling, da kan en ikke returnere sin egne lister men kopier av dem.
    public Collection<Person> getPassengers() {
        // Søk opp denne - immutable. MEN: Hvis en har en liste av lister, så vil en kunne få endret innhold der...
        return List.copyOf(this.passengers); 
    }

    // Her videresender vi bare ansvaret for svaret til skiltet selv:
    public String getSign() {
        return plate.getSign();
    }

    // Denne sjekker bare for passasjerer, da. Men det er greit det, for dette formålet.
    public boolean isFull() {
        return (passengers.size() == this.seats - 1);
    }

    public static void main(String[] args) {
        Car car = new Car("AA41383",4);
        Person p1 = new Person();
        car.setDriver(p1);
        System.out.println(car);
        Person jakob = new Person("Jakob", 11);
        car.setDriver(jakob);
        System.out.println(car);
        car.addPassenger(jakob);
        System.out.println(car);
        Person jens = new Person("Jens", 48);
        Person jensotto = new Person("Jens Otto", 49);
        car.addPassenger(jens);
        car.addPassenger(jensotto);
        car.removePassenger(jens);
        car.addPassenger(jensotto);
        car.addPassenger(new Person("William",87));

        System.out.println(car.findPerson("Jakob"));
        System.out.println(car);
        Collection<Person> foo = car.getPassengers();
        // foo.add(new Person("Ane",23)); // Dette vil ikke gå, siden den ikke kan endres på.
        System.out.println(foo);
        System.out.println(car.getPassengers());
        System.out.println(car.isFull());

    }



    public Person findPerson(String name) {

        // Første sjekke om vi _har_ en fører. Deretter sjekker vi navnet.
        // Den andre sjekken utføres KUN hvis den første faktisk er sann. Topp!
        if (this.driver != null && this.driver.getName().equals(name))
            return this.driver;
    
        // Så må vi lete igjennom alle passasjerene.
        for (Person person : this.passengers) {
            if (person.getName().equals(name))
                return person;
        }
        return null; // Fant aldri noen passasjer som het det...
    }



    void addPassenger(Person person) {
        if (this.passengers.size() == this.seats -1) {
            System.out.println("Full. Vent på neste, "+person);
        }
        else {
            this.passengers.add(person);
            System.out.println(person + "fikk plass!");
        }
    }


    void setDriver(Person driver) {
        if (driver.getAge() > 17) {
            this.driver = driver;
            System.out.println(driver+" kjører nå bilen.");
        }
        else {
            System.out.println(driver + "Er ikke gammel nok til å kjøre. Buhu.");
        }
    }

    public int getTotalAge() {
        int total = 0;
        if (driver != null) total+= driver.getAge();
        for (Person person : passengers) {
            total += person.getAge();
        }
        return total;

    }
    
}
