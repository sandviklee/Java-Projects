package oving4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardTest {

	private void checkCard(Card card, char suit, int face) {
		Assertions.assertEquals(card.getSuit(), suit);
		Assertions.assertEquals(card.getFace(), face);
	}

	@Test
	@DisplayName("Sjekk at konstruktøren oppretter Card-objekter med riktige verdier")
	public void testConstructor() {
		checkCard(new Card('S', 1), 'S', 1);
		checkCard(new Card('S', 13), 'S', 13);
		checkCard(new Card('H', 1), 'H', 1);
		checkCard(new Card('H', 13), 'H', 13);
		checkCard(new Card('D', 1), 'D', 1);
		checkCard(new Card('D', 13), 'D', 13);
		checkCard(new Card('C', 1), 'C', 1);
		checkCard(new Card('C', 13), 'C', 13);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Card('X', 1);
		}, "Skal ikke kunne lage et kort av typen X");

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Card('S', 0);
		}, "Skal ikke kunne lage et kort med verdi 0");

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Card('C', 14);
		}, "Skal ikke kunne lage et kort med verdi 14");
	}

	@Test
	@DisplayName("Sjekk at toString fungerer som forventet")
	public void testToString() {
		Assertions.assertEquals("S1", new Card('S', 1).toString());
		Assertions.assertEquals("H13", new Card('H', 13).toString());
	}
}
