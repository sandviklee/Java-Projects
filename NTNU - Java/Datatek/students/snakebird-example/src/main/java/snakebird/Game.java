package snakebird;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Tile[][] board;
    private ArrayList<Tile> snake;
    private boolean isGameOver = false;
    private boolean isGameWon = false;

    public Game(int width, int height) {
        board = new Tile[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                board[y][x] = new Tile(x, y);
            }
        }
    }

    public void createSnake(List<Tile> tiles) {
        if (snake != null) {
            throw new IllegalStateException("Snake already created");
        }

        for (Tile tile : tiles) {
            tile.setSnake();
        }
        snake = new ArrayList<>(tiles);
    }

    public boolean isTile(int x, int y) {
        return 0 <= x && x < getWidth() && 0 <= y && y < getHeight();
    }

    public Tile getTile(int x, int y) {
        if (!isTile(x, y)) {
            throw new IllegalArgumentException("Not a valid tile");
        }

        return board[y][x];
    }

    public int getHeight() {
        return board.length;
    }

    public int getWidth() {
        return board[0].length;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public boolean isGameWon() {
        return isGameWon;
    }

    public void setGameOver() {
        isGameOver = true;
    }

    public void setGameWon() {
        isGameWon = true;
    }

    private boolean canMove(int dx, int dy) {
        if (snake == null || Math.abs(dx) + Math.abs(dy) > 1 || isGameOver() || isGameWon()) {
            return false;
        }

        int x = snake.get(0).getX() + dx;
        int y = snake.get(0).getY() + dy;

        return isTile(x, y) && (!getTile(x, y).hasCollision() || getTile(x, y) == snake.get(snake.size() - 1));
    }

    private void move(int dx, int dy) {
        if (!canMove(dx, dy)) {
            throw new IllegalStateException("Not a valid move");
        }

        Tile targetTile = getTile(snake.get(0).getX() + dx, snake.get(0).getY() + dy);

        if (targetTile.isGoal()) {
            isGameWon = true;
        }

        if (!targetTile.isFruit()) {
            snake.get(snake.size() - 1).setAir();
            snake.remove(snake.size() - 1);
        }
        snake.add(0, targetTile);
        snake.get(0).setSnake();

        if (isGameWon) {
            return;
        }

        while (snakeInAir()) {
            isGameOver = false;
            for (Tile tile : snake) {
                if (!isTile(tile.getX(), tile.getY() + 1)) {
                    isGameOver = true;
                }
            }
            if (isGameOver) {
                break;
            }

            for (Tile tile : snake) {
                tile.setAir();
            }

            ArrayList<Tile> newSnake = new ArrayList<>();
            for (Tile tile : snake) {
                Tile newTile = getTile(tile.getX(), tile.getY() + 1);
                newTile.setSnake();
                newSnake.add(newTile);
            }
            snake = newSnake;
        }
    }

    private boolean snakeInAir() {
        for (Tile tile : snake) {
            if (isTile(tile.getX(), tile.getY() + 1) && getTile(tile.getX(), tile.getY() + 1).isGround()) {
                return false;
            }
        }
        return true;
    }

    public boolean isSnakeHead(Tile tile) {
        return snake != null && tile == snake.get(0);
    }

    public void moveUp() {
        move(0, -1);
        System.out.println(this);
    }

    public void moveDown() {
        move(0, 1);
        System.out.println(this);
    }

    public void moveLeft() {
        move(-1, 0);
        System.out.println(this);
    }

    public void moveRight() {
        move(1, 0);
        System.out.println(this);
    }

    public List<Tile> getSnake() {
        return new ArrayList<>(snake);
    }

    @Override
    public String toString() {
        String representation = "";
        if (isGameWon()) {
            representation = "You Won!";
        } else if (isGameOver()) {
            representation = "You Lost!";
        }

        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                if (snake != null && snake.get(0) == getTile(x, y)) {
                    representation = representation + "8";
                } else {
                    representation = representation + getTile(x, y).toString();
                }
            }
            representation = representation + "\n";
        }
        return representation;
    }

}
