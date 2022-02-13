package snakebird;

import java.io.FileNotFoundException;

public interface ISaveHandler {

	public void save(String filename, Game game) throws FileNotFoundException;

	public Game load(String filename) throws FileNotFoundException;

}
