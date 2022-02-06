package uke5.fasit;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CarController {

	Car	car;
	List<Car> cars = new ArrayList<>();
	
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
	
/*
 Ting som kunne vært bedre her:
 - Vi har ingen sjekk for om det faktisk finnes en bil før vi begynner å legge inn passasjerer
   og alle andre metoder som kalles. Dette burde en hatt
 - En kunne også sjekket at knappene for å legge inn passasjerer, fører, og fjerne dem, ikke
   er tilgjengelige før en faktisk har define en bil.
 - I FXML burde en kanskje hatt noen tekstbeskrivelser av hva de ulike feltene er.
*/


	// Enten finner vi en eksisterende bil, eller vi lager en ny
	@FXML void handleSetCar() {
		String plate = carPlate.getText(); // altså fra feltet i appen som har regnr.
		
		Car tmpcar = this.getCar(plate); // Har vi den allerede?
		if (tmpcar != null) {
			car = tmpcar; // Den finnes
		}
		else { 
			System.out.println("Ny bil!");
			// Denne neste virker KUN hvis en faktisk har et tall skrevet inn i carSeats da, ellers krasjer det!
			car = new Car(carPlate.getText(),Integer.parseInt(carSeats.getText()));
			cars.add(car);
		}
		// carInfo.setText(car.toString());
		// ageInfo.setText(Integer.toString(car.getTotalAge()));
		updateGUI(); // Denne oppdaterer alle de ulike komponentene i grensesnittet, så en slipper kopier.
	}

	private Car getCar(String plate) {
		for (Car carOrig : cars) {
			if (carOrig.getSign().equals(plate)) {
				System.out.println("Funnet: "+carOrig);
				return carOrig;
			}
		}
		return null;
	}
	

	@FXML void handleRemovePassenger() {
		car.removePassenger(car.findPerson(removePassenger.getText()));
		// carInfo.setText(car.toString());
		// ageInfo.setText(Integer.toString(car.getTotalAge()));
		// toggleDisableAddPassenger();
		updateGUI(); // Denne oppdaterer alle de ulike komponentene i grensesnittet, så en slipper kopier.
	}

	
	@FXML void handleSetDriver() {
		car.setDriver(new Person(driverName.getText(), Integer.parseInt(driverAge.getText())));
		// carInfo.setText(car.toString());
		// ageInfo.setText(Integer.toString(car.getTotalAge()));
		updateGUI(); // Denne oppdaterer alle de ulike komponentene i grensesnittet, så en slipper kopier.
	}

	// For å oppdatere grensesnittet så den viser korrekt tilstand for bilen. HVIS det er definert en bil, da.
	private void updateGUI(){
		// Oppdatere carInfo dersom en bil faktisk finnes
		if (car != null)  { 
			carInfo.setText(car.toString());
	
			// Oppdatere total alder
			ageInfo.setText(Integer.toString(car.getTotalAge()));

			if (car.isFull()) addPassenger.setDisable(true);
				else addPassenger.setDisable(false);

		}
		else { // Hva skal det stå hvis det ikke er definert noen bil!
			carInfo.setText("Legg inn en ny bil over! Og så passasjerer etc...");
		}

		// Kan man legge til flere passasjerer eller ikke
		

	}

	private void toggleDisableAddPassenger() {
		if (car.isFull()) addPassenger.setDisable(true);
		else addPassenger.setDisable(false);

	}

	@FXML void handleAddPassenger() {
		car.addPassenger(new Person(passengerName.getText(), Integer.parseInt(passengerAge.getText())));
		// carInfo.setText(car.toString());
		// ageInfo.setText(Integer.toString(car.getTotalAge()));
		// toggleDisableAddPassenger();
		updateGUI();
	}

}
