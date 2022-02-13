package snakebird;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveHandler implements ISaveHandler {

	public void save(String filename, Game game) throws FileNotFoundException {
		try (PrintWriter writer = new PrintWriter(new File(getFilePath(filename)))) {
			writer.println(game.getWidth());
			writer.println(game.getHeight());
			writer.println(game.isGameOver());
			writer.println(game.isGameWon());
			for (int y = 0; y < game.getHeight(); y++) {
				for (int x = 0; x < game.getWidth(); x++) {
					writer.print(game.getTile(x, y).getType());
				}
			}

			writer.println();
			writer.println(game.getSnake().size());
			for (Tile tile : game.getSnake()) {
				writer.print(tile.getX());
				writer.print(" ");
				writer.println(tile.getY());
				// Eventuelt
				// writer.printf("%d %d\n", tile.getX(), tile.getY());
			}
		}
	}

	public Game load(String filename) throws FileNotFoundException {
		try (Scanner scanner = new Scanner(new File(getFilePath(filename)))) {
			int width = scanner.nextInt();
			int height = scanner.nextInt();
			Game game = new Game(width, height);

			if (scanner.nextBoolean()) {
				game.setGameOver();
			}

			if (scanner.nextBoolean()) {
				game.setGameWon();
			}

			scanner.nextLine();

			String board = scanner.next();
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					char symbol = board.charAt(y * width + x);
					game.getTile(x, y).setType(symbol);
				}
			}

			int snakeLength = scanner.nextInt();
			List<Tile> snake = new ArrayList<>();
			for (int i = 0; i < snakeLength; i++) {
				snake.add(game.getTile(scanner.nextInt(), scanner.nextInt()));
			}
			game.createSnake(snake);

			return game;
		}
	}

	public static String getFilePath(String filename) {
		return SaveHandler.class.getResource("saves/").getFile() + filename + ".txt";
	}

}
