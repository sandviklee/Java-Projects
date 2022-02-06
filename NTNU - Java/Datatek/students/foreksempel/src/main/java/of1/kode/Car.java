package of1.kode;

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
         * Car car = new Car("S-MAX", "Ford", "AQ12345", 2019, 356.0,);
         * System.out.println(car);
         * 
         * car.driveDistance(256.0);
         * System.out.println(car);
         * 
         * car.accelerate(50);
         * car.brake(20);
         * System.out.println(car);
         * 
         * car.brake(60);
         * System.out.println(car);
         */
    }
}
