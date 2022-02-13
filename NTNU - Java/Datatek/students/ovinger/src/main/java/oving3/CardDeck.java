package oving3;

import java.util.ArrayList;
// import java.util.Collection;

public class CardDeck {
    ArrayList<Card> cards  = new ArrayList<>();
    ArrayList<Card> setOneCards = new ArrayList<>();
    ArrayList<Card> setTwoCards = new ArrayList<>();

    public CardDeck(int n) {
        if (n >= 0 && n <= 4) {
            char[] cardTypes = {'S', 'H', 'D', 'C'};
            for (int i = 0; i < 4; i++) {
                for (int j = 1; j <= n; j++) {
                    cards.add(new Card(cardTypes[i], j));
                }
            }
        } else throw new IllegalArgumentException("For høyt tall.");
    }

    public int getCardCount() {
        return cards.size();
    }

    public Card getCard(int n) throws IllegalArgumentException {
        try {
            return cards.get(n);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Tallet n er ikke i listen.");
        }
    }

    public void shufflePerfectly() {
        int j = 0;
        int z = 0;
        for (int i = 0; i < cards.size()/2; i++) {
            setOneCards.add(getCard(i));
        }

        for (int i = cards.size()/2; i < cards.size(); i++) {
            setTwoCards.add(getCard(i));
        }

        for (int i = 1; i < cards.size()-1; i++) {
            if (i % 2 != 0) {
                j += 1;
                cards.set(i, setTwoCards.get(j-1));
            } else {
                z += 1;
                cards.set(i, setOneCards.get(z));
            }
        }

    }

    public int getSetOne() {
        return setOneCards.size();
    }

    public int getSetTwo() {
        System.out.println(setTwoCards);
        return setTwoCards.size();
    }

    public static void main(String[] args) {
        CardDeck CD = new CardDeck(4);
        System.out.println(CD.getCardCount());
        CD.shufflePerfectly();
        System.out.println(CD.getCardCount());

    }
}
