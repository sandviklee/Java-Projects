

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import uke5.Car;
import uke5.fasit.Person;

public class CarController {

	Car	car;
	
	@FXML TextField carPlate;
	@FXML TextField carSeats;
	@FXML TextField driverName;
	@FXML TextField driverAge;
	@FXML TextField passengerName;
	@FXML TextField passengerAge;
	@FXML TextField removePassenger;
	@FXML Label carInfo;
	@FXML Label ageInfo;
	@FXML Button setDriver;
	@FXML Button addPassenger;
	@FXML Button setCar;
	@FXML Button removePassengerButton;

	@FXML void handleSetCar() {
		String regnr = carPlate.getText();
		int antall = Integer.parseInt(carSeats.getText());
		
		try {
			car = new Car(regnr, antall);
			updateGUI();
		} catch (Exception e) {
			carInfo.setText(e.getMessage());
		}
	}
	
	@FXML void handleSetDriver() {
		String name = driverName.getText();
		int age = Integer.parseInt(driverAge.getText());
		try {
			car.setDriver(new Person(name, age));
			updateGUI();
		} catch (IllegalArgumentException e) {
			System.out.println(name + "er ikke gammel nok! Ble passasjer.");
			car.addPassenger(new Person(name, age));
			updateGUI();
		}
	}

	@FXML void handleAddPassenger() {
		String PassName = passengerName.getText();
		int PassAge = Integer.parseInt(passengerAge.getText());

		car.addPassenger(new Person(PassName, PassAge));
		updateGUI();
	}
	
	@FXML void handleRemovePassenger() {
		String name = removePassenger.getText();
		car.removePerson(name);
		updateGUI();
	}

	private void updateGUI() {
		if (car != null) {
			carInfo.setText(car.toString());
			addPassenger.setDisable(car.isFull());
			ageInfo.setText(Integer.toString(car.getTotalAge()));
		}
		
	}
}
