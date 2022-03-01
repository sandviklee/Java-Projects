package oving3;

public class Card {

	// The set of suits in decreasing order. If you are curious about final and static 
	// you can read about them here:
	// final: https://www.w3schools.com/java/ref_keyword_final.asp
	// static: https://www.w3schools.com/java/ref_keyword_static.asp
	// Note that (ab)using static is generally bad OOP
	public final static String SUITS = "SHDC";

	private char suit;
	private int face;

	public Card(char suit, int face) {
		// String#indexOf returns -1 when it doesn't contain the given character
		if (SUITS.indexOf(suit) == -1) {
			throw new IllegalArgumentException("Illegal suit " + suit);
		}

		if (face < 1 || face > 13) {
			throw new IllegalArgumentException("Illegal face " + face);
		}

		this.suit = suit;
		this.face = face;
	}

	public char getSuit() {
		return this.suit;
	}

	public int getFace() {
		return this.face;
	}

	/*
	 * Returns suit and face as a string
	 * E.g. Ace of spades is S1 and king of clubs is C13
	 */
	@Override
	public String toString() {
		return String.valueOf(suit) + face;
	}
}
