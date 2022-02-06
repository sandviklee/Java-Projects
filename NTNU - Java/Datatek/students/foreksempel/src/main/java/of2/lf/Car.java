package of2.lf;

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

    // Konstruktører:
    public Car(String model, String brand, String regNum, int productionYear, double weight, double kmDriven) {
        this(model, brand, regNum, productionYear, weight);
        this.kmDriven = kmDriven;
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", kmDriven=" + kmDriven + ", model=" + model + ", productionYear="
                + productionYear + ", regNum=" + regNum + ", weight=" + weight + "]";
    }

    public static void main(String[] args) {

        // Modell, Produsent, Registeringsnummer, Produksjonsår, Kilometerstand, Vekt
        Car car = new Car("S-MAX", "Ford", "AQ12345", 2019, 356.0);
        System.out.println(car);
    }
}
