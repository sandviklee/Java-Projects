package kortforklart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarManager {
	
	private List<Car> cars = new ArrayList<>();
	
	public void addCar(Car car) {
		cars.add(car);
	}
	
	public void writeCarsToFile(String filename) {
		try {
			PrintWriter writer = new PrintWriter(filename);
			for (Car car: cars) {
				writer.println(car);	
			}
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getCarsFromFile(String filename) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(filename));
		// this.cars = new ArrayList<>();
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] lineInfo = line.split(",");
			
			String brand = lineInfo[0];
			String model = lineInfo[1];
			String regNr = lineInfo[2];
			
			Car car = new Car(brand, regNr, model);
			this.addCar(car);
		}
		scanner.close();
	}
	
	
	
	
	
	public static void main(String[] args) {
		CarManager manager = new CarManager();
		manager.addCar(new Car("Mitsubishi", "AA1111", "Carisma"));
		manager.addCar(new Car("Tesla", "EL24244", "Model 3"));
		manager.addCar(new Car("Ford", "AA1112", "Focus"));
		manager.addCar(new Car("Volkswagen", "BB3333", "Golf"));
		
		manager.writeCarsToFile("carlist2.txt");
		try {
			manager.getCarsFromFile("carlist.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Filnavnet finnes ikke");
		}
		manager.writeCarsToFile("carlist3.txt");

		
	}

}
