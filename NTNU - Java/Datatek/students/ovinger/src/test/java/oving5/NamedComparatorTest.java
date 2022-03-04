package oving5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NamedComparatorTest {

	private NamedComparator comparator;
	private Person1 p1;
	private Person2 p2;

	@BeforeEach
	public void setup() {
		comparator = new NamedComparator();
		p1 = new Person1("Hallvard", "Trætteberg");
		p2 = new Person2("Jens Trætteberg");
	}

	@Test
	@DisplayName("Sjekk at personer med samme navn er ekvivalente")
	public void testSameFullName() {
		Assertions.assertEquals(0, comparator.compare(p1, p1));
		Assertions.assertEquals(0, comparator.compare(p2, p2));
	}

	@Test
	@DisplayName("Sjekk at fornavn sammenliknes når det er samme etternavn")
	public void testSameFamilyName() {
		// Return positive since first givenName is after second
		Assertions.assertTrue(comparator.compare(p2, p1) > 0, "Hallvard skal etter Jens");

		// Return negative since first givenName is before second
		Assertions.assertTrue(comparator.compare(p1, p2) < 0, "Jens skal før Hallvard");
	}

	@Test
	@DisplayName("Sjekk at etternavn sammenlignes riktig")
	public void testDifferentFamilyName() {
		p2.setFamilyName("Hansen");

		// Return negative since first familyName is before second
		Assertions.assertTrue(comparator.compare(p2, p1) < 0, "Hansen skal før Trætteberg");

		// Return positive since first familyName is after second
		Assertions.assertTrue(comparator.compare(p1, p2) > 0, "Trætteberg skal etter Hansen");
	}

}
