package oving5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Person2Test {

	private String h, t;
	private Person2 person1;

	@BeforeEach
	public void setup() {
		h = "Hallvard";
		t = "Trætteberg";
		person1 = new Person2(h + " " + t);
	}

	private void testName(Person2 person, String givenName, String lastName) {
		assertEquals(givenName, person.getGivenName());
		assertEquals(lastName, person.getFamilyName());
		assertEquals(String.format("%s %s", givenName, lastName), person.getFullName());
	}

	@Test
	@DisplayName("Sjekk at konstruktøren gir personen riktig navn")
	public void testConstructor() {
		testName(person1, h, t);
	}

	@Test
	@DisplayName("Sjekk at setGivenName() gir riktig navn")
	public void testSetGivenName() {
		String j = "Jens";
		person1.setGivenName(j);
		testName(person1, j, t);
	}

	@Test
	@DisplayName("Sjekk at setFamilyName() gir riktig navn")
	public void testSetFamilyName() {
		String o = "Olsen";
		person1.setFamilyName(o);
		testName(person1, h, o);
	}

	@Test
	@DisplayName("Sjekk at setFullName() gir riktig navn")
	public void testSetFullName() {
		String l = "Lisa";
		String e = "Eriksen";
		String fullName = l + " " + e;
		person1.setFullName(fullName);
		testName(person1, l, e);
	}
}