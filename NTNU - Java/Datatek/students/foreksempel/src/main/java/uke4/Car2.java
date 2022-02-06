package uke4;

import java.util.ArrayList;
import java.util.Collection;



/**
 * Denne bilen er litt annerledes. Det som skiller den fra Car er at vi her lagrer regnr som
 * en vanlig streng inni Car2. Vi lagrer altså ikke noe Plate-objekt. MEN. Fordi metoden
 * Plate.checkSign(sign) er statisk, da kan vi kalle den HER for å sjekke om vi har et 
 * legitimt regnr før vi lagrer! 
 * 
 * Det morsomme er at endringen ikke medførte fryktelig mye styr ellers i koden. Til og med toString()
 * virket som den skulle, siden det tidligere regnr og den nye strenger har samme variabelnavn! 
 */
public class Car2 {
    
    private int seats;
    private String plate;
    private Person driver;
    Collection<Person> passengers = new ArrayList<>();

    public Car2(String sign, int seats) {
        if (Plate.checkSign(sign)) {
            this.seats = seats;
            this.plate = sign;
        }
        else throw new IllegalStateException("Feil ved oppretting av nummer: "+sign);

    }



    @Override
    public String toString() {
        return "Car [driver=" + driver + ", passengers=" + passengers + ", plate=" + plate + ", seats=" + seats + "]";
    }

    public void removePassenger(Person person) {
        if (passengers.remove(person)) {
            System.out.println("Ble kastet ut: "+person);
        }
        else {
            System.out.println(person + "satt ikke på");
        }

    }

    public static void main(String[] args) {
        // Car2 car = new Car2("AA4138333",3); // Kjør denne linjen for å se at det feiler.
        Car2 car = new Car2("AA41383",3);
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

    }



    private void addPassenger(Person person) {
        if (this.passengers.size() == this.seats -1) {
            System.out.println("Full. Vent på neste, "+person);
        }
        else {
            this.passengers.add(person);
            System.out.println(person + "fikk plass!");
        }
    }


    private void setDriver(Person driver) {
        if (driver.getAge() > 17) {
            this.driver = driver;
            System.out.println(driver+" kjører nå bilen.");
        }
        else {
            System.out.println(driver + "Er ikke gammel nok til å kjøre. Buhu.");
        }
    }
    
}
