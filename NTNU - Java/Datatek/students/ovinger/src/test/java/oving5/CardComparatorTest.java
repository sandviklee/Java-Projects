package oving5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardComparatorTest {
	CardDeck deck;
	Card s1;
	Card h1;
	Card d1;
	Card c1;
	Card s13;
	Card h13;
	Card d13;
	Card c13;
	List<Card> cards;
	Collection<Card> expected;

	@BeforeEach
	public void setUp() {
		s1 = new Card('S', 1);
		h1 = new Card('H', 1);
		d1 = new Card('D', 1);
		c1 = new Card('C', 1);
		s13 = new Card('S', 13);
		h13 = new Card('H', 13);
		d13 = new Card('D', 13);
		c13 = new Card('C', 13);
		cards = new ArrayList<Card>(List.of(s1, s13, h1, h13, d1, d13, c1, c13));
	}

	@Test
	@DisplayName("Sjekk at kortstokken blir sortert til med ess som lavest")
	void testNormal() throws Exception {
		expected = new ArrayList<Card>(Arrays.asList(c1, c13, d1, d13, h1, h13, s1, s13));
		Collections.sort(cards, new CardComparator(false, ' '));
		testCards(cards, expected);
	}

	@Test
	@DisplayName("Sjekk at kortstokken blir sortert med ess som høyest")
	void testAceIsHighest() throws Exception {
		expected = new ArrayList<Card>(Arrays.asList(c13, c1, d13, d1, h13, h1, s13, s1));
		Collections.sort(cards, new CardComparator(true, ' '));
		testCards(cards, expected);
	}

	@Test
	@DisplayName("Sjekk at kortstokken blir sortert riktig med ruter som trumf")
	void testDiamondIsTrumph() throws Exception {
		expected = new ArrayList<Card>(Arrays.asList(c1, c13, h1, h13, s1, s13, d1, d13));
		Collections.sort(cards, new CardComparator(false, 'D'));
		testCards(cards, expected);
	}

	private void testCards(Collection<Card> actualCards, Collection<Card> expectedCards) {
		Iterator<Card> actual = actualCards.iterator();
		Iterator<Card> expected = expectedCards.iterator();
		while (expected.hasNext()) {
			assertTrue(actual.hasNext());
			Card expectedCard = expected.next();
			Card actualCard = actual.next();
			assertEquals(expectedCard.getSuit(), actualCard.getSuit(),
					String.format("Kortstokken skulle vært %s, men var %s", expectedCards, actualCards));
			assertEquals(expectedCard.getFace(), actualCard.getFace(),
					String.format("Kortstokken skulle vært %s, men var %s", expectedCards, actualCards));
		}
	}
}