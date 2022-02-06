package stateandbehavior;

public class Location {
    int x = 0;
    int y = 0;

    public Location() {

    }

    public void up() {
        y -= 1;
    }

    public void down() {
        y += 1;
    }

    public void left() {
        x -= 1;
    }

    public void right() {
        x += 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Location (" + getX() + "," + getY() + ")";
    }

    public static void main(String[] args) {

    }
}
