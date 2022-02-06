package of2.praktisk.kode;

public class Car {

	// Felter / intern tilstand:
	private String model;
	private String brand;
	private int productionYear;
	private double weight;

	private String regNum;
	private double kmDriven;
	private double velocity = 0.0;

	// Konstruktører:
	public Car(String model, String brand, String regNum, int productionYear, double weight) {
		this.requireNotNegative(productionYear);
		this.requireNotNegative(weight);

		this.model = model;
		this.brand = brand;
		this.regNum = regNum;
		this.productionYear = productionYear;
		this.weight = weight;
		this.kmDriven = 0;
	}

	public double getVelocity() {
		return velocity;
	}

	public String getModel() {
		return model;
	}

	public String getBrand() {
		return brand;
	}

	public String getRegNum() {
		return regNum;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public double getKmDriven() {
		return kmDriven;
	}

	public double getWeight() {
		return weight;
	}

	// Setters og andre metoder for å endre tilstand:

	public void driveDistance(double km) {
		this.requireNotNegative(km);
		this.kmDriven += km;
	}

	public void accelerate(double velocityChange) {
		this.requireNotNegative(velocityChange);
		velocity += velocityChange;
	}

	public void brake(double velocityChange) {
		this.requireNotNegative(velocityChange);
		velocity -= velocityChange;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	// Hjelpemetoder:

	private void requireNotNegative(double number) {
		if (number < 0) {
			throw new IllegalArgumentException(number + " er ikke et positivt tall!");
		}
	}

	// Tekstrepresentasjon:

	@Override
	public String toString() {
		return String.format(
				"""
						Modell: %s
						Produsent: %s
						Kilometerstand: %s kilometer
						Nåværende hastighet: %s
						Produksjonsår: %s
						Vekt: %s
						""",
				this.model,
				this.brand,
				this.kmDriven,
				this.velocity,
				this.productionYear,
				this.weight);
	}

	// Main-metode / testkode:

	public static void main(String[] args) {
		
	}
}
