package snakebird;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

	private Game game;

	private void createBoard() {
		game = new Game(16, 12);
		game.getTile(6, 11).setGround();
		game.getTile(7, 11).setGround();
		game.getTile(8, 11).setGround();
		game.getTile(6, 10).setGround();
		game.getTile(7, 10).setGround();
		game.getTile(8, 10).setGround();
		game.getTile(9, 10).setGround();
		game.getTile(6, 9).setGround();
		game.getTile(7, 9).setGround();
		game.getTile(8, 9).setGround();
		game.getTile(9, 9).setGround();
		game.getTile(6, 8).setGround();
		game.getTile(8, 6).setGround();
		game.getTile(10, 6).setGround();
		game.getTile(5, 5).setGround();
		game.getTile(5, 6).setFruit();
		game.getTile(9, 6).setFruit();
		game.getTile(8, 3).setGoal();
		List<Tile> snake = Arrays.asList(game.getTile(9, 8), game.getTile(8, 8));
		game.createSnake(snake);
	}

	@BeforeEach
	public void setup() {
		createBoard();
	}

	@Test
	public void testConstructor() {
		game = new Game(16, 12);

		// Test board dimensions
		assertEquals(game.getHeight(), 12);
		assertEquals(game.getWidth(), 16);

		// Test that all tiles are air initially
		for (int y = 0; y < game.getHeight(); y++) {
			for (int x = 0; x < game.getWidth(); x++) {
				assertEquals(game.getTile(x, y).getType(), 'a');
			}
		}
	}

	@Test
	public void testCreateSnake() {
		game = new Game(16, 12);
		List<Tile> snake = Arrays.asList(game.getTile(9, 8), game.getTile(8, 8));
		game.createSnake(snake);
		assertEquals(game.getSnake().get(0), game.getTile(9, 8));
		assertEquals(game.getSnake().get(1), game.getTile(8, 8));
		assertEquals(game.getSnake().get(0).getType(), 's');
		assertEquals(game.getSnake().get(1).getType(), 's');
		assertTrue(game.isSnakeHead(game.getTile(9, 8)));
	}

	@Test
	public void testMoveIntoWall() {
		game.moveLeft();
		game.moveLeft();
		assertThrows(
				IllegalStateException.class,
				() -> game.moveLeft(),
				"IllegalState skal kastes når man prøver å gå inn i veggen!");
	}

	@Test
	public void testGameOver() {
		game.moveRight();
		game.moveRight();
		assertThrows(
				IllegalStateException.class,
				() -> game.moveRight(),
				"IllegalState skal kastes når man prøver å gå inn i veggen!");
		assertTrue(game.isGameOver());
	}

	@Test
	@DisplayName("Test at slange blir 3 blokker lang når den spiser frukt")
	public void testEatFruit() {
		game.moveUp();
		game.moveUp();
		assertEquals(game.getSnake().size(), 3);
	}
}
