package oving3;

public class Card {
    char cardColor;
    int cardValue;

    public Card(char cardColor, int cardValue) {
        if (cardColor == 'S' || cardColor == 'D' || cardColor == 'H' || cardColor == 'C') {
            this.cardColor = cardColor;
        } else throw new IllegalArgumentException("Ikke gyldig farge.");
        if (cardValue <= 13 && cardValue >= 1) {
            this.cardValue = cardValue;
        } else throw new IllegalArgumentException("Ikke gyldig tall");
    }

    public char getSuit() {
        return cardColor;
    }

    public int getFace() {
        return cardValue;
    }

    @Override
    public String toString() {
        return "" + cardColor + cardValue  + "";
    }

    public static void main(String[] args) {
        Card c = new Card('S', 4);
        System.out.println(c.toString());
    }

    
}
