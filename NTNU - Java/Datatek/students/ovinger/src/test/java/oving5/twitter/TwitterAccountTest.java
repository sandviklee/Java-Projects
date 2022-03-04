package oving5.twitter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TwitterAccountTest {
	TwitterAccount nils;
	TwitterAccount ole;

	@BeforeEach
	public void setup() {
		nils = new TwitterAccount("Nils");
		ole = new TwitterAccount("Ole");
	}

	private void checkFollow(TwitterAccount accountA, TwitterAccount accountB, boolean AfollowsB, boolean BfollowsA) {
		if (AfollowsB) {
			assertTrue(accountA.isFollowing(accountB),
					String.format("%s skulle fulgt %s", accountA.getUserName(), accountB.getUserName()));
			assertTrue(accountB.isFollowedBy(accountA),
					String.format("%s skulle vært fulgt av %s", accountB.getUserName(), accountA.getUserName()));
		} else {
			assertFalse(accountA.isFollowing(accountB),
					String.format("%s skulle ikke fulgt %s", accountA.getUserName(), accountB.getUserName()));
			assertFalse(accountB.isFollowedBy(accountA),
					String.format("%s skulle ikke vært fulgt av %s", accountB.getUserName(), accountA.getUserName()));
		}
		if (BfollowsA) {
			assertTrue(accountB.isFollowing(accountA),
					String.format("%s skulle fulgt %s", accountB.getUserName(), accountA.getUserName()));
			assertTrue(accountA.isFollowedBy(accountB),
					String.format("%s skulle vært fulgt av %s", accountA.getUserName(), accountB.getUserName()));
		} else {
			assertFalse(accountB.isFollowing(accountA),
					String.format("%s skulle ikke fulgt %s", accountB.getUserName(), accountA.getUserName()));
			assertFalse(accountA.isFollowedBy(accountB),
					String.format("%s skulle ikke vært fulgt av %s", accountA.getUserName(), accountB.getUserName()));
		}
	}

	@Test
	@DisplayName("Sjekk at konstruktør setter opp kontoen riktig")
	void testConstructor() {
		assertEquals("Nils", nils.getUserName());
		assertEquals(0, nils.getTweetCount());
		assertEquals("Ole", ole.getUserName());
		assertEquals(0, ole.getTweetCount());
	}

	@Test
	@DisplayName("Follow")
	void testFollow() {
		nils.follow(ole);
		checkFollow(nils, ole, true, false);

		ole.follow(nils);
		checkFollow(nils, ole, true, true);
	}

	@Test
	@DisplayName("Unfollow")
	void testUnfollow() {
		checkFollow(nils, ole, false, false);

		nils.follow(ole);
		checkFollow(nils, ole, true, false);

		nils.unfollow(ole);
		checkFollow(nils, ole, false, false);
	}

	@Test
	@DisplayName("Tester at ny tweet er riktig")
	void testNewTweet() {
		nils.tweet("Kvitre!");
		assertEquals(1, nils.getTweetCount(), "Tweetcounten til Nils skulle vært 1");
		assertEquals("Kvitre!", nils.getTweet(1).getText(), "Teksten skulle vært Kvitre");
		nils.tweet("Kvitre igjen!");
		assertEquals(2, nils.getTweetCount());
		assertEquals("Kvitre igjen!", nils.getTweet(1).getText());
		assertEquals("Kvitre!", nils.getTweet(2).getText());
	}

	@Test
	@DisplayName("Tester unntak for ullovlige tweets")
	void testIllegalTweet() {
		assertThrows(RuntimeException.class, () -> {
			nils.getTweet(1);
		}, "Skal ikke kunne hente en tweet som ikke fins");
		assertThrows(RuntimeException.class, () -> {
			nils.getTweet(-1);
		}, "Skal ikke kunne hente en tweet som ikke fins");
		nils.tweet("Kvitre!");
		assertThrows(RuntimeException.class, () -> {
			nils.getTweet(2);
		}, "Skal ikke kunne hente en tweet som ikke fins");
		assertThrows(RuntimeException.class, () -> {
			nils.getTweet(-1);
		}, "Skal ikke kunne hente en tweet som ikke fins");
	}

	@Test
	@DisplayName("Sjekk at retweet funker, også med retweet av retweet")
	void testRetweet() {
		TwitterAccount kari = new TwitterAccount("Kari");

		nils.tweet("Kvitre!");
		assertEquals(1, nils.getTweetCount());
		assertEquals("Kvitre!", nils.getTweet(1).getText());

		ole.retweet(nils.getTweet(1));
		assertEquals(1, nils.getTweetCount());
		assertEquals(1, nils.getRetweetCount());
		assertEquals(1, ole.getTweetCount());
		assertEquals(0, ole.getRetweetCount());
		assertEquals("Kvitre!", ole.getTweet(1).getText());
		assertEquals(nils.getTweet(1), ole.getTweet(1).getOriginalTweet());

		kari.retweet(ole.getTweet(1));
		assertEquals(1, nils.getTweetCount());
		assertEquals(2, nils.getRetweetCount());
		assertEquals(1, ole.getTweetCount());
		assertEquals(0, ole.getRetweetCount());
		assertEquals(1, kari.getTweetCount());
		assertEquals(0, kari.getRetweetCount());
		assertEquals("Kvitre!", kari.getTweet(1).getText());
		assertEquals(nils.getTweet(1), kari.getTweet(1).getOriginalTweet());
	}
}
