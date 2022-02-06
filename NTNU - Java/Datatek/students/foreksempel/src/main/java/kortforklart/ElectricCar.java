package kortforklart;

public class ElectricCar extends Car{
	
	private int batterySize;
	
	public ElectricCar(String brand, String registrationNumber, String model) {
		super(brand, registrationNumber, model);
	}
	
	public void loadVehicle() {
		if (this.model.equals("Tesla")) {
			System.out.println("Du kan bruke en hurtiglader");
		}
	}
	
	public static void main(String[] args) {
		Car car = new ElectricCar("3", "EL22", "Tesla");
		if (car instanceof ElectricCar) {
			ElectricCar castedCar = (ElectricCar) car;
			castedCar.loadVehicle();
		}
	
	}
}
