package uke8.car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlateTest {

    @Test
    public void correctPlateConstructed() {
        Plate plate = new Plate("AA41383");
        assertEquals("AA41383", plate.getSign());
    }

    @Test
    public void validPlateTestsTrue() {
        assertTrue(Plate.checkSign("AA41383"));
    }


    @Test
    public void invalidPlateTestsFalse() {
        assertFalse(Plate.checkSign("AA413834"));
        assertFalse(Plate.checkSign("aa41383"));
        assertFalse(Plate.checkSign("ZÅ41383"));
    }


    @Test
    public void constructurInvalidPlateThrowsISE() {
        Exception exception = Assertions.assertThrows(IllegalStateException.class, 
        () -> new Plate("AA4138338383"));
        assertTrue(exception.getMessage().startsWith("Feil i skilt"));
    }
    @Test
    public void constructurInvalidPlateThrowsISE_NO_LAMBDA() {
        try {
            Plate plate = new Plate("AA4138383838383");
            // Linjen under bør vi ikke komme til, siden konstruktøren skal utløse unntak.
            fail("Feil ved skilt burde utløst unntak!"); // Da feiler vi testen
        } catch (Exception e) {
            // Dette er her vi forventer at vi skal ende opp, så ikke noe her.
        }
        

    }
}
