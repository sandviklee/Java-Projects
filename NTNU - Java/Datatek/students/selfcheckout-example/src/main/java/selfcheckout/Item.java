package selfcheckout;

public class Item {

    // Felter / Tilstand
    private String name;
    private double price;
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

    @Override
    public String toString() {
        return name + "\n" + price + " kr";
    }
}
