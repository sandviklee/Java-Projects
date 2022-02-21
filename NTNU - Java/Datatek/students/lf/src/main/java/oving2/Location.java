package oving2;

public class Location {

	private int x, y;

	public Location() {
		x = 0;
		y = 0;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public void up() {
		y--;
	}

	public void down() {
		y++;
	}

	public void left() {
		x--;
	}

	public void right() {
		x++;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
