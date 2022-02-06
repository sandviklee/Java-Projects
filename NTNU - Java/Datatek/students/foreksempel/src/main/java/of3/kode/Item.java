package of3.kode;

public class Item {

    // Felter / Tilstand
    private String name;
    private double price;
    private final String category;
    private String barcode;

    // Konstruktør
    public Item(String name, double price, String category, String barcode) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.barcode = barcode;
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

    public String getBarcode() {
        return barcode;
    }

}
