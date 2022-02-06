package oving3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardTest {

	private boolean checkState(Card card, char suit, int face) {
		return card.getSuit() == suit && card.getFace() == face;
	}

	@Test
	@DisplayName("Constructor")
	public void testConstructor() {
		Assertions.assertTrue(checkState(new Card('S', 1), 'S', 1));
		Assertions.assertTrue(checkState(new Card('S', 13), 'S', 13));
		Assertions.assertTrue(checkState(new Card('H', 1), 'H', 1));
		Assertions.assertTrue(checkState(new Card('H', 13), 'H', 13));
		Assertions.assertTrue(checkState(new Card('D', 1), 'D', 1));
		Assertions.assertTrue(checkState(new Card('D', 13), 'D', 13));
		Assertions.assertTrue(checkState(new Card('C', 1), 'C', 1));
		Assertions.assertTrue(checkState(new Card('C', 13), 'C', 13));

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Card('X', 1);
		});

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Card('S', 0);
		});

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Card('C', 14);
		});
	}

	@Test
	@DisplayName("#toString()")
	public void testToString() {
		Assertions.assertEquals("S1", new Card('S', 1).toString());
		Assertions.assertEquals("H13", new Card('H', 13).toString());
	}
}
