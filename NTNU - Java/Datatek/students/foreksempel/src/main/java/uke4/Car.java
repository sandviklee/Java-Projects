package uke4;

import java.util.ArrayList;
import java.util.Collection;

public class Car {
    
    private int seats;
    private Plate plate;
    private Person driver;
    Collection<Person> passengers = new ArrayList<>();

    public Car(String sign, int seats) {
        this.seats = seats;
        this.plate = new Plate(sign);
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
        Car car = new Car("AA41383",3);
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
