package selfcheckout;

public class Item {

    // Felter / Tilstand
    private final String name;
    private final double price;
    private final String category;

    // Konstruktør
    public Item(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Gettere
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    /*
     * Endret for uke 11 (filbehandling):
     * Når vi leser inn objekter fra fil og lager nye objekter så
     * holder det ikke lenger bare å sjekke for referanselikhet (med ==)
     * Her har vi overridet .equals-funksjonen, som er
     * tilsvarende funksjon vi bruker for å sammenligne strenger.
     * I denne metoden har vi implementert en sjekk som lar oss sjekke om
     * attributtene til to Item-objekter er like, og derfor om også selve
     * Item-objektene er like
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Item) {
            Item otherItem = (Item) other;
            return this.name.equals(getName()) && this.price == otherItem.getPrice()
                    && this.category.equals(otherItem.getCategory());
        }
        return false;
    }

    @Override
    public String toString() {
        return name + "\n" + price + " kr";
    }
}
