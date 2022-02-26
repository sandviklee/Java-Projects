package oving4.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoffeeCupTest {
    private CoffeeCup coffeecup;

    public double ci = 3;
    public double cv = 3;
    public double c = 5;
    public double dv = 2;
    public double fv = 2;
    
    @BeforeEach
    public void setup() {
        coffeecup = new CoffeeCup(c, cv);
    }
    
    
    @Test
    public void testCoffeCup() {
        assertEquals(cv, coffeecup.getCurrentVolume()); //Checks if the current volume is correct.
        assertEquals(c, coffeecup.getCapacity()); //Checks if the capcaity is correct.
        assertThrows(IllegalArgumentException.class, () -> {
            coffeecup = new CoffeeCup(-1, -1); }
            , "Should not be able to give negative values.");
    }


    @Test
    public void testIncreaseCupSize() {
        coffeecup.increaseCupSize(ci);
        double origcapacity = coffeecup.getCapacity();

        assertEquals(ci + c, origcapacity); //Checks if increasing cupsize is doable.
        coffeecup.increaseCupSize(-1);
        assertEquals(origcapacity, coffeecup.getCapacity()); //Checks if trying to add negative cupsize is being ignored.
    }


    @Test
    public void testdrinkCoffee() {
        coffeecup = new CoffeeCup(c, cv);
        coffeecup.drinkCoffee(dv);
        assertEquals(cv-dv, coffeecup.getCurrentVolume()); //Checks if drinkCoffee decreases current volume.
        assertThrows(IllegalArgumentException.class, () -> {
            coffeecup = new CoffeeCup(c, cv);
            coffeecup.drinkCoffee(-1);}
            , "Can't drink negative volume.");
    }


    @Test
    public void fillCoffee() {
        coffeecup = new CoffeeCup(c, cv);
        coffeecup.fillCoffee(fv);
        assertEquals(fv + cv, coffeecup.getCurrentVolume());
        assertThrows(IllegalArgumentException.class, () -> {
            coffeecup = new CoffeeCup(c, cv);
            coffeecup.fillCoffee(3);}
            , "Throws IllegalArgEx when fill volume is a negative value or if it is more than capacity.");
        
    }

}
