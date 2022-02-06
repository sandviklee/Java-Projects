package of2.praktisk.lf;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Car {

	private static final String GEARS = "FNR";

	// Felter / intern tilstand:
	private CarModel model;
	private Person owner;
	private int productionYear;
	private String regNum;
	
	private double kmDriven;
	private double velocity = 0.0;
	private char gear;

	// Konstruktører:
	public Car(CarModel model, Person owner, String regNum, int productionYear) {
		this.isValidRegNr(regNum);
		this.requireValidOwner(owner);

		this.model = model;
		this.owner = owner;
		this.regNum = regNum;
		this.productionYear = productionYear;
		this.kmDriven = 0;
		this.gear = 'N';
	}

	public Person getOwner() {
		return this.owner;
	}

	public double getVelocity() {
		return velocity;
	}

	public CarModel getModel() {
		return model;
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

	public boolean isInGear() {
		return this.gear != 'N';
	}

	public boolean isGoingForward() {
		return this.gear == 'F';
	}

	public boolean isGoingBackwards() {
		return this.gear == 'R';
	}

	// Setters og andre metoder for å endre tilstand:

	public void changeGear(char gear) {
		if (this.velocity > 0) {
			throw new IllegalStateException("Bilen står ikke stille!");
		}

		if (GEARS.indexOf(gear) == -1) {
			throw new IllegalArgumentException("Ugyldig gir " + gear);
		}

		this.gear = gear;
	}

	public void setOwner(Person person) {
		this.requireValidOwner(person);

		this.owner = person;
	}

	public void driveTime(double minutes) {
		this.requireNotNegative(minutes);
		this.kmDriven += this.timeToKm(this.velocity, minutes);
	}

	public void driveDistance(double km) {
		this.requireNotNegative(km);
		this.kmDriven += km;
	}

	public void accelerate(double velocityChange) {
		this.requireNotNegative(velocityChange);

		if (!this.isInGear()) {
			throw new IllegalStateException("Bilen er ikke i gir!");
		}

		// Ternary operator
		double maxVelocity; // = this.isGoingForward() ? this.maxVelocityForward : this.maxVelocityBackward;
		if (this.isGoingForward()) {
			maxVelocity = this.getModel().getMaxVelocityForward();
		} else {
			maxVelocity = this.getModel().getMaxVelocityBackward();
		}

		if (this.velocity + velocityChange > maxVelocity) {
			throw new IllegalArgumentException("For høy hastighet!");
		}

		velocity += velocityChange;
	}

	public void brake(double velocityChange) {
		this.requireNotNegative(velocityChange);
		velocity -= Math.min(velocityChange, velocity);
	}

	public void setRegNum(String regNum) {
		this.isValidRegNr(regNum);

		this.regNum = regNum;
	}

	// Hjelpemetoder:

	private double timeToKm(double velocity, double minutes) {
		return velocity * (minutes / 60.0d);
	}

	private void requireValidOwner(Person person) {
		if (person.getAge() < 18) {
			throw new IllegalArgumentException(person + " er ikke 18");
		}
	}

	private void requireNotNegative(double number) {
		if (number < 0) {
			throw new IllegalArgumentException(number + " er ikke et positivt tall!");
		}
	}

	private void isValidRegNr2(String regNr) {
		if (!regNr.matches("[A-Z]{2}([A-Z]{5}|[0-9]{5})")) {
			throw new IllegalArgumentException("Ugyldig bilskilt " + regNr);
		}
	}

	private void isValidRegNr(String regNr) {
		if (regNr.length() != 7) {
			throw new IllegalArgumentException("Ugyldig bilskilt " + regNr);
		}

		String twoFirst = regNr.substring(0, 2);
		if (!this.isAllUpperCase(twoFirst)) {
			throw new IllegalArgumentException("Ugyldig bilskilt " + regNr);
		}

		String fiveLast = regNr.substring(2, 7);
		if (!this.isAllDigit(fiveLast) && !this.isAllUpperCase(fiveLast)) {
			throw new IllegalArgumentException("Ugyldig bilskilt " + regNr);
		}
	}

	private boolean isAllDigit(String str) {
		for (char ch : str.toCharArray()) {
			if (!Character.isDigit(ch)) {
				return false;
			}
		}

		return true;
	}

	private boolean isAllUpperCase(String str) {
		for (char ch : str.toCharArray()) {
			if (!Character.isUpperCase(ch)) {
				return false;
			}
		}

		return true;
	}

	// Tekstrepresentasjon:

	@Override
	public String toString() {
		return "Car [gear=" + gear +
				", kmDriven=" + kmDriven +
				", model=" + model +
				", productionYear=" + productionYear +
				", regNum=" + regNum +
				", velocity=" + velocity + "]";
	}

	// Main-metode / testkode:

	public static void main(String[] args) {
		CarModel model = new CarModel("Hiace", "Toyota", 1500.0, 80.0, 10.0);

		Person eirik = new Person("Eirik", "Tanberg", LocalDateTime.now().minus(21, ChronoUnit.YEARS), "12345678");
		Person magnus = new Person("Magnus", "Schjølberg", LocalDateTime.now().minus(18, ChronoUnit.YEARS), "12345678");

		Car car1 = new Car(model, eirik, "UF12345", 2003);
		Car car2 = new Car(model, magnus, "UF12346", 2004);

		car1.brake(10);
		car1.changeGear('F');
		car1.accelerate(50);
		car1.brake(60);

		System.out.println(car1);
	}
}
