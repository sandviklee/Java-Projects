package snakebird;

public class Tile {

    private char type = 'a';
    private int x;
    private int y;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setType(char symbol) {
        if ("asgf@s".indexOf(symbol) == -1) {
            throw new IllegalArgumentException("Not a valid state");
        }

        type = symbol;
    }

    public char getType() {
        return type;
    }

    public void setAir() {
        type = 'a';
    }

    public void setSnake() {
        type = 's';
    }

    public void setGround() {
        type = 'g';
    }

    public void setFruit() {
        type = 'f';
    }

    public void setGoal() {
        type = '@';
    }

    public boolean isAir() {
        return type == 'a';
    }

    public boolean isSnake() {
        return type == 's';
    }

    public boolean isGround() {
        return type == 'g';
    }

    public boolean isFruit() {
        return type == 'f';
    }

    public boolean isGoal() {
        return type == '@';
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean hasCollision() {
        return isGround() || isSnake();
    }

    @Override
    public String toString() {
        switch (type) {
            case 'g':
                return "#";
            case '@':
                return "@";
            case 's':
                return "O";
            case 'f':
                return "*";
            case 'a':
            default:
                return " ";
        }
    }
}
