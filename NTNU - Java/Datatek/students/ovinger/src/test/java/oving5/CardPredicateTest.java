package oving5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardPredicateTest {
	CardDeck deck;

	@BeforeEach
	public void setUp() throws Exception {
		deck = new CardDeck(10);
	}

	@Test
	@DisplayName("Sjekk at hasCard() fungerer som den skal")
	public void testHasCard() {
		assertTrue(deck.hasCard(c -> c.getSuit() == 'S'));
		assertFalse(deck.hasCard(c -> c.getFace() == 13));
		assertTrue(deck.hasCard(c -> c.getSuit() == 'S' && c.getFace() == 8));
	}

	@Test
	@DisplayName("Sjekk at getCardCount() fungerer som den skal")
	public void testGetCardCount() {
		assertEquals(10, deck.getCardCount(c -> c.getSuit() == 'S'));
		assertEquals(4, deck.getCardCount(c -> c.getFace() == 4));
		assertEquals(1, deck.getCardCount(c -> c.getFace() == 4 && c.getSuit() == 'H'));
	}

	@Test
	@DisplayName("Sjekk at getCards() fungerer som den skal")
	public void testGetCards() {
		Card card = new Card('S', 4);
		Card card2 = new Card('S', 5);

		List<Card> matching = Arrays.asList(card, card2);
		assertEquals(matching.size(),
				deck.getCards(c -> (c.getFace() == 4 || c.getFace() == 5) && c.getSuit() == 'S').size(),
				"getCards skulle returnert to kort som var spar og hadde tall 4 eller 5");

		assertEquals(10, deck.getCards(c -> c.getSuit() == 'S').size(),
				"getCards skulle returnert 10 kort av typen spar");

	}

}
