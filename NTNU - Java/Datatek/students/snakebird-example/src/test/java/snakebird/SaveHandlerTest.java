package snakebird;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class SaveHandlerTest {

	private Game game;
	private SaveHandler saveHandler = new SaveHandler();

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
	public void testLoad() {
		Game savedNewGame; // Required to ignore Eclipse warning
		try {
			savedNewGame = saveHandler.load("test-save");
		} catch (FileNotFoundException e) {
			fail("Could not load saved file");
			return;
		}
		assertEquals(game.toString(), savedNewGame.toString());
		assertFalse(game.isGameOver());
	}

	@Test
	public void testLoadNonExistingFile() {
		assertThrows(
				FileNotFoundException.class,
				() -> game = saveHandler.load("foo"),
				"FileNotFoundException should be thrown when file does not exist!");
	}

	@Test
	public void testLoadInvalidFile() {
		assertThrows(
				Exception.class,
				() -> game = saveHandler.load("invalid-save"),
				"An exception should be thrown if loaded file is invalid!");
	}

	@Test
	public void testSave() {
		try {
			saveHandler.save("test-save-new", game);
		} catch (FileNotFoundException e) {
			fail("Could not save file");
		}

		byte[] testFile = null, newFile = null;

		try {
			testFile = Files.readAllBytes(Path.of(SaveHandler.getFilePath("test-save")));
		} catch (IOException e) {
			fail("Could not load test file");
		}

		try {
			newFile = Files.readAllBytes(Path.of(SaveHandler.getFilePath("test-save-new")));
		} catch (IOException e) {
			fail("Could not load saved file");
		}
		assertNotNull(testFile);
		assertNotNull(newFile);
		assertTrue(Arrays.equals(testFile, newFile));

	}

	@AfterAll
	static void teardown() {
		File newTestSaveFile = new File(SaveHandler.getFilePath("test-save-new"));
		newTestSaveFile.delete();
	}

}
