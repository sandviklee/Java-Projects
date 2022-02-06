package of2.kode;

public class Car {

    // Felter / intern tilstand:
    private String model;
    private String brand;
    private String regNum;
    private int productionYear;
    private double weight;
    private double kmDriven;

    // Konstruktører:
    public Car(String model, String brand, String regNum, int productionYear, double weight) {
        this.model = model;
        this.brand = brand;
        this.regNum = regNum;
        this.productionYear = productionYear;
        this.weight = weight;
        this.kmDriven = 0;
    }

    public static void main(String[] args) {
        /*
         * // Modell, Produsent, Registeringsnummer, Produksjonsår, Kilometerstand, Vekt
         * Car car = new Car("S-MAX", "Ford", "AQ12345", 2019, 356.0);
         */
    }
}
