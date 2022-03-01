package oving3;

import java.util.ArrayList;

public class CardDeck {

	// List to hold Card objects
	private ArrayList<Card> cards;

	public CardDeck(int suitSize) {
		if (suitSize < 0 || suitSize > 13) {
			throw new IllegalArgumentException("Illegal suit size " + suitSize);
		}

		this.cards = new ArrayList<Card>();

		for (char suit : Card.SUITS.toCharArray()) {
			for (int face = 1; face <= suitSize; face++) {
				Card card = new Card(suit, face);
				cards.add(card);
			}
		}
	}

	public int getCardCount() {
		return this.cards.size();
	}

	public Card getCard(int i) {
		if (i < 0 || i >= this.getCardCount()) {
			throw new IllegalArgumentException(
					String.format("%s is an illegal card index, when the size of the deck is %s", i, getCardCount()));
		}

		return cards.get(i);
	}

	public void shufflePerfectly() {
		int halfSize = cards.size() / 2;
		for (int i = 0; i < halfSize; i++) {
			Card card = cards.remove(halfSize + i);
			cards.add(i * 2 + 1, card);
		}
	}

	@Override
	public String toString() {
		return "[Deck " + cards.toString().substring(1);
	}
}
