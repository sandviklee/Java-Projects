package kortforklart;

public class Car {
	
	private String brand;
	private String registrationNumber;
	protected String model;
	

	
	public Car(String brand, String registrationNumber, String model) {
		this.brand = brand;
		this.registrationNumber = registrationNumber;
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public String toString() {
		return this.getBrand() + "," + this.getModel() + "," + this.getRegistrationNumber();
	}

}
