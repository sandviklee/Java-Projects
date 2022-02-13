package oving4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TweetTest {
	TwitterAccount nils;
	TwitterAccount ole;
	TwitterAccount kari;
	Tweet tweet, retweet1, retweet2;

	@BeforeEach
	public void setup() {
		nils = new TwitterAccount("Nils");
		ole = new TwitterAccount("Ole");
		kari = new TwitterAccount("Kari");

		tweet = new Tweet(nils, "Kvitre!");
		retweet1 = null;
		retweet2 = null;
	}

	@Test
	void constructorNewTweet() {
		assertEquals("Kvitre!", tweet.getText(), "Konstruktøren initialiserte tweeten med feil tekst");
		assertEquals(nils, tweet.getOwner(), "Konstruktøren initialiserte tweeten med feil eier");
	}

	@Test
	@DisplayName("Sjekk at retweet har samme tekst, men forskjellig eier")
	void constructorRetweet() {
		retweet1 = new Tweet(ole, tweet);
		assertEquals("Kvitre!", retweet1.getText());
		assertEquals(ole, retweet1.getOwner());
		assertThrows(RuntimeException.class, () -> {
			new Tweet(nils, tweet);
		}, "En person skal ikke kunne retweete seg selv");
	}

	@Test
	@DisplayName("Sjekk at originaltweet alltid er riktig")
	void getOriginalTweet() {
		assertNull(tweet.getOriginalTweet());
		retweet1 = new Tweet(ole, tweet);
		assertEquals(tweet, retweet1.getOriginalTweet());
		assertEquals(retweet1.getOriginalTweet().getText(), retweet1.getText());
		retweet2 = new Tweet(kari, tweet);
		assertEquals(tweet, retweet1.getOriginalTweet());
		assertEquals(retweet1.getOriginalTweet().getText(), retweet1.getText());
	}

	@Test
	@DisplayName("Sjekk at retweetcount øker når en tweet retweetes")
	void getRetweetCount() {
		assertEquals(0, tweet.getRetweetCount());
		new Tweet(ole, tweet);
		assertEquals(1, tweet.getRetweetCount());
		new Tweet(kari, tweet);
		assertEquals(2, tweet.getRetweetCount());
	}
}
