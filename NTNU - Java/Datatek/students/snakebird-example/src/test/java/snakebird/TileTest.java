package snakebird;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import snakebird.Tile;

public class TileTest {

	private Tile tile;

	@BeforeEach
	public void setup() {
		tile = new Tile(0, 0);
	}

	@Test
	public void testSetValidType() {
		tile.setType('a');
		assertTrue(tile.isAir());
		tile.setType('s');
		assertTrue(tile.isSnake());
		assertThrows(
				IllegalArgumentException.class,
				() -> tile.setType('?'),
				"IllegalArgument skal kastes når man setter Tile til ugyldig verdi!");
	}

	@Test
	public void testSetInvalidType() {
		assertThrows(IllegalArgumentException.class, () -> {
			tile.setType('?');
		}, "IllegalArgument skal kastes når man setter Tile til ugyldig verdi!");
	}

}
