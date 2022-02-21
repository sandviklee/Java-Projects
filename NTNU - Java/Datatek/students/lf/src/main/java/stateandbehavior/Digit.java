package stateandbehavior;

public class Digit {

	private int base;
	private int value = 0;

	public Digit(int base) {
		this.base = base;
	}

	public String toString() {
		return String.valueOf("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(value));
	}

	public int getValue() {
		return value;
	}

	public int getBase() {
		return base;
	}

	public boolean increment() {
		value += 1;
		if (value == base) {
			value = 0;
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// Ekstraoppgave
		Digit digit1 = new Digit(10);
		Digit digit2 = new Digit(10);
		Digit digit3 = new Digit(10);

		boolean complete = false;
		while (!complete) {
			if (digit3.increment()) {
				if (digit2.increment()) {
					if (digit1.increment()) {
						complete = true;
					}
				}
			}

			System.out.println(digit1.toString() + digit2.toString() + digit3.toString());
		}
	}
}
