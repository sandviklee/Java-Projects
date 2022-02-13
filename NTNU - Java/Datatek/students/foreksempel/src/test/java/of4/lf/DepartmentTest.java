package of4.lf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class DepartmentTest {

    @Test
    public void testConstructor() {
        Department oop = new Department();
        Department oopMini = new Department(oop);

        assertEquals(oop, oopMini.getParentDepartment());
        assertNull(oop.getParentDepartment());
    }

    @Test
    public void testDepartmentContains() {
        Department oop = new Department();
        Department oopNorway = new Department(oop);
        Department oopMini = new Department(oopNorway);
        Department oopSweden = new Department(oop);

        assertTrue(oop.contains(oopNorway), "OOP Norway should be a sub department of OOP International");
        assertTrue(oop.contains(oopMini), "OOP mini should be a sub department of OOP International");
        assertFalse(oopMini.contains(oopSweden), "OOP Sweden should not be a sub department of OOP mini");
    }

    @Test
    public void testPromote() {
        Department oop = new Department();
        Department oopMini = new Department(oop);

        Employee employee = new Employee(oopMini);

        assertTrue(employee.getDepartment() == oopMini, "Before promoting the employee should belong to OOP mini");

        employee.promote();

        assertFalse(employee.getDepartment() == oopMini, "After promoting the employee should not belong to OOP mini");
        assertTrue(employee.getDepartment() == oop, "After promoting the employee should belong to the university");

        // Her kan man i JUnit 5 benytte seg av assertThrows i stedet for å sjekke om en
        // metode utløser et unntak. Eksempelet ble laget til en eldre versjon av Junit,
        // men assertThrows er å foretrekke når dere skal skrive tester selv.
        try {
            employee.promote();
            fail("Promotion should throw an IllegalStateException when not possible");
        } catch (IllegalStateException e) {
            assertTrue(employee.getDepartment() == oop,
                    "After a failed promotion the employee should still belong to OOP");
        } catch (Exception e) {
            fail("Promotion should throw an IllegalStateException when not possible");
        }
    }

    // Oppgave 9
    @Test
    public void testEmployeeQuit() {
        Department oop = new Department();
        Employee employee = new Employee(oop);

        employee.quit();
        assertFalse(employee.getDepartment() == oop, "After quitting, the employee should not belong to OOP anymore");

        try {
            employee.quit();
            fail("Quitting with no current employer should throw an IllegalStateException");
        } catch (IllegalStateException e) {
            // Do nothing
        } catch (Exception e) {
            fail("Promotion should throw an IllegalStateException when not possible");
        }
    }

    // Oppgave 10 (ekstraoppgave)
    @Test
    public void testDepartmentMove() {
        Department oop = new Department();
        Department oopNorway = new Department(oop);
        Department oopMini = new Department(oopNorway);
        Department oopSweden = new Department(oop);

        oopMini.moveToDepartment(oopSweden);
        assertTrue(oopMini.getParentDepartment() == oopSweden, "OOP mini should be part of OOP Sweden after move");
        assertFalse(oopNorway.contains(oopMini), "oopNorway should not contain OOP mini after move");
        assertTrue(oopSweden.contains(oopMini), "IV should contain OOP mini after move");
        oopMini.moveToDepartment(null);
        assertFalse(oopMini.getParentDepartment() == oopSweden, "OOP mini should not be part of OOP Sweden after move");
        assertFalse(oopSweden.contains(oopMini), "OOP Sweden should not contain OOP mini after move");
        try {
            oopMini.moveToDepartment(oopMini);
            fail("Should not be able to move OOP mini to be child itself");
        } catch (IllegalArgumentException e) {
            // Do nothing
        }
        oopMini.moveToDepartment(oopNorway);
        try {
            oopMini.moveToDepartment(oopNorway);
            fail("Should not be able to move OOP mini to OOP Norway when it is already part of OOP Norway");
        } catch (IllegalArgumentException e) {
            // Do nothing
        }

        // This sequence of operations should ordinarily not fail
        // They may fail if encapsulation is not done properly:
        oopMini.moveToDepartment(oop);
        oopMini.moveToDepartment(oopNorway);
    }

}
