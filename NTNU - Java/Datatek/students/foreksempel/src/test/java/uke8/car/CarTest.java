package uke8.car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
    
    Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("AA41383",3);
    }

    @Test
    public void PlateIsRemembered() {
        assertEquals("AA41383",car.getSign());
    }

    // Denne leder til en ny metode i Car!
    @Test
    public void NewCarNoDriver() {
        // assertNull(car.getDriver());
    }

    @Test
    public void NewCarNoPassengers() {
        assertEquals(0,car.getPassengers().size());
    }

    @Test
    public void NewCarOnePassengerOkay() {
        car.addPassenger(new Person());
        assertEquals(1,car.getPassengers().size());
    }

    @Test
    public void NewCarTwoPassengersOkay() {
        car.addPassenger(new Person("Ichi",1));
        car.addPassenger(new Person("Ni",2));
        assertEquals(2,car.getPassengers().size());
    }

    @Test
    public void NewCarThreePassengersNotOkay() {
        car.addPassenger(new Person("Ichi",1));
        car.addPassenger(new Person("Ni",2));
        car.addPassenger(new Person("San",3));
        assertEquals(2,car.getPassengers().size());
    }

    @Test
    public void NewCarRemovePassengerOkay() {
        car.addPassenger(new Person());
        car.removePassenger("Wanda");
        assertEquals(0,car.getPassengers().size());
    }
}
