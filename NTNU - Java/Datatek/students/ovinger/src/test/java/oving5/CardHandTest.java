package oving5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardHandTest {
	CardHand hand;
	Card s1;
	Card c2;
	Collection<Card> expected;

	@BeforeEach
	public void setUp() {
		hand = new CardHand();
		s1 = new Card('S', 1);
		c2 = new Card('C', 2);
		expected = new ArrayList<Card>(Arrays.asList(s1, c2));
	}

	@Test
	@DisplayName("Sjekker at CardContainer fungerer med CardHand")
	void testCardContainer() throws Exception {
		hand.addCard(s1);
		hand.addCard(c2);
		testCards(hand, expected);
	}

	@Test
	@DisplayName("Sjekker at iterator fungerer med CardHand")
	void testDeckIterator() throws Exception {
		hand.addCard(s1);
		hand.addCard(c2);
		testCards(hand, expected.iterator());
	}

	private void testCards(CardContainer it, Collection<Card> expected) {
		assertEquals(expected.size(), it.getCardCount());
		Iterator<Card> expectedIt = expected.iterator();
		int i = 0;
		while (expectedIt.hasNext()) {
			Card expectedCard = expectedIt.next();
			Card actualCard = it.getCard(i);
			assertEquals(expectedCard.getSuit(), actualCard.getSuit(),
					String.format("Kort nummer %d skulle vært %s men var %s ", i + 1, expectedCard, actualCard));
			assertEquals(expectedCard.getFace(), actualCard.getFace(),
					String.format("Kort nummer %d skulle vært %s men var %s ", i + 1, expectedCard, actualCard));
			i++;
		}
	}

	private void testCards(Iterable<Card> actual, Iterator<Card> expected) {
		Iterator<Card> actualIt = actual.iterator();
		while (expected.hasNext()) {
			assertTrue(actualIt.hasNext());
			Card expectedCard = expected.next();
			Card actualCard = actualIt.next();
			assertEquals(expectedCard.getSuit(), actualCard.getSuit(),
					String.format("Kortet skulle vært %s men var %s ", expectedCard, actualCard));
			assertEquals(expectedCard.getFace(), actualCard.getFace(),
					String.format("Kortet skulle vært %s men var %s", expectedCard, actualCard));
		}
	}
}