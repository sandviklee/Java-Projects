package oving3;

public class Nim {

	private int[] piles;

	public Nim() {
		this(10);
	}

	public Nim(int pileSize) {
		this.piles = new int[] { pileSize, pileSize, pileSize };
	}

	public void removePieces(int number, int targetPile) {
		if (this.isGameOver()) {
			throw new IllegalStateException("Cannot remove pieces when game is over");
		}

		if (!this.isValidMove(number, targetPile)) {
			throw new IllegalArgumentException("Move is not valid");
		}

		piles[targetPile] -= number;
	}

	public boolean isValidMove(int number, int targetPile) {
		return number > 0 && this.getPile(targetPile) >= number && !this.isGameOver();
	}

	public boolean isGameOver() {
		return this.getPile(0) == 0 || this.getPile(1) == 0 || this.getPile(2) == 0;
	}

	public int getPile(int targetPile) {
		return this.piles[targetPile];
	}

	@Override
	public String toString() {
		return String.format("Piles: %d, %d, %d", piles[0], piles[1], piles[2]);
	}
}
