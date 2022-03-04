package oving5.twitter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FollowersCountComparatorTest {
	TwitterAccount aaron;
	TwitterAccount ben;
	TwitterAccount charlie;
	FollowersCountComparator comparator;

	@BeforeEach
	public void SetUp() {
		aaron = new TwitterAccount("aaron");
		ben = new TwitterAccount("ben");
		charlie = new TwitterAccount("charlie");
		comparator = new FollowersCountComparator();
	}

	@Test
	@DisplayName("Sjekk at sammenlikningen basert på følgere")
	void testCompare() throws Exception {
		aaron.follow(ben);
		ben.follow(aaron);
		assertEquals(0, comparator.compare(aaron, ben), "Aaron og Ben skulle vært like");
		charlie.follow(ben);
		assertTrue(comparator.compare(aaron, ben) > 0, "Aaron skulle vært etter Ben ");
		assertTrue(comparator.compare(ben, aaron) < 0, "Ben skulle vært før Aaron");
	}

}