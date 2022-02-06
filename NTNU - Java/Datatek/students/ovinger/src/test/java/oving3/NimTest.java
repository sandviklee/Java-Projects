package oving3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class NimTest {

	private Nim nim;

	private boolean checkValidMove(Nim game, int pieces, boolean legal) {
		return (legal == game.isValidMove(pieces, 0) && (legal == game.isValidMove(pieces, 1))
				&& (legal == game.isValidMove(pieces, 2)));
	}

	@BeforeEach
	public void setup() {
		nim = new Nim(5);
	}

	@Test
	@DisplayName("Constructor")
	public void testConstructor() {
		Assertions.assertEquals(5, nim.getPile(0));
		Assertions.assertEquals(5, nim.getPile(1));
		Assertions.assertEquals(5, nim.getPile(2));
	}

	@Test
	@DisplayName("Remove pieces")
	public void testRemovePieces() {
		nim.removePieces(3, 0);
		nim.removePieces(2, 1);
		nim.removePieces(1, 2);
		Assertions.assertEquals(2, nim.getPile(0));
		Assertions.assertEquals(3, nim.getPile(1));
		Assertions.assertEquals(4, nim.getPile(2));

		// Fjerne negativt antall gir feil
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			nim.removePieces(-1, 0);
		});

		// Fjerne for få brikker gir feil
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			nim.removePieces(0, 0);
		});

		// Fjerne for mange brukker gir feil
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			nim.removePieces(6, 0);
		});
	}

	@Test
	@DisplayName("Game over")
	public void testGameOver() {
		Assertions.assertFalse(nim.isGameOver());
		nim.removePieces(5, 0);
		Assertions.assertEquals(0, nim.getPile(0));
		Assertions.assertTrue(nim.isGameOver());

		// Fjerne brikker etter avsluttet spill gir feil
		Assertions.assertThrows(IllegalStateException.class, () -> {
			nim.removePieces(5, 0);
		});
	}

	@Test
	@DisplayName("Valid moves")
	public void testIsValidMove() {
		Assertions.assertTrue(checkValidMove(nim, 2, true));
		Assertions.assertTrue(checkValidMove(nim, -2, false));
		Assertions.assertTrue(checkValidMove(nim, 0, false));
		Assertions.assertTrue(checkValidMove(nim, 6, false));

		nim.removePieces(5, 0);
		Assertions.assertTrue(checkValidMove(nim, 2, false));

	}
}
