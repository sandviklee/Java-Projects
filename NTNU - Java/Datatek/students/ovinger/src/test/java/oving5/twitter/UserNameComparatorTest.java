package oving5.twitter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserNameComparatorTest {
	TwitterAccount aaron1;
	TwitterAccount aaron2;
	TwitterAccount ben;
	UserNameComparator comparator;

	@BeforeEach
	public void SetUp() {
		aaron1 = new TwitterAccount("aaron");
		aaron2 = new TwitterAccount("aaron");
		ben = new TwitterAccount("ben");
		comparator = new UserNameComparator();
	}

	@Test
	@DisplayName("Sjekk sammenlikning basert på brukernavn")
	void testCompare() throws Exception {
		assertTrue(comparator.compare(aaron1, ben) < 0, "aaron skulle blitt sortert før ben");
		assertTrue(comparator.compare(ben, aaron1) > 0, "ben skulle blitt sortert etter aaron");
		assertEquals(comparator.compare(aaron1, aaron2), 0, "To personer med samme navn skal være like");
	}

}