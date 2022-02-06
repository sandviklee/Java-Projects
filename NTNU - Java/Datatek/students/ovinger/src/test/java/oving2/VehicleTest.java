package oving2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VehicleTest {

	private Vehicle vehicle;

	private void checkVehicleState(char vehicleType, char fuelType, String registrationNumber, Vehicle vehicle) {
		Assertions.assertEquals(vehicleType, vehicle.getVehicleType());
		Assertions.assertEquals(fuelType, vehicle.getFuelType());
		Assertions.assertEquals(registrationNumber, vehicle.getRegistrationNumber());
	}

	private static void checkInvalidConstructor(char vehicleType, char fuelType, String registrationNumber) {
		assertThrows(IllegalArgumentException.class, () -> {
			new Vehicle(vehicleType, fuelType, registrationNumber);
		});
	}

	private static void checkInvalidsetRegistration(Vehicle vehicle, String originalRegNum, String newRegNum) {
		assertThrows(IllegalArgumentException.class, () -> {
			vehicle.setRegistrationNumber(newRegNum);
		});
		assertEquals(originalRegNum, vehicle.getRegistrationNumber());
	}

	@Test
	@DisplayName("Private fields")
	public void testPrivateFields() {
		TestHelper.checkIfFieldsPrivate(Vehicle.class);
	}

	@Test
	void testConstructor() {
		vehicle = new Vehicle('C', 'D', "BN12345");
		checkVehicleState('C', 'D', "BN12345", vehicle);
		vehicle = new Vehicle('M', 'E', "EL1234");
		checkVehicleState('M', 'E', "EL1234", vehicle);
		checkInvalidConstructor('C', 'Y', "BN12345");
		checkInvalidConstructor('M', 'H', "HY1234");

		checkInvalidConstructor('P', 'D', "BN12345");

		checkInvalidConstructor('C', 'G', "A1234");
		checkInvalidConstructor('C', 'G', "A12345");
		checkInvalidConstructor('C', 'G', "A123456");
		checkInvalidConstructor('C', 'G', "A12344");
		checkInvalidConstructor('C', 'G', "AÆ12345");
		checkInvalidConstructor('C', 'G', "ab12345");
		checkInvalidConstructor('C', 'G', "A12345");
		checkInvalidConstructor('C', 'G', "A1B12345");

		checkInvalidConstructor('M', 'G', "A1234");
		checkInvalidConstructor('M', 'G', "A12345");
		checkInvalidConstructor('M', 'G', "A123");
		checkInvalidConstructor('M', 'G', "AB12345");
		checkInvalidConstructor('M', 'G', "ABC1234");
		checkInvalidConstructor('M', 'G', "ABC12345");
		checkInvalidConstructor('C', 'G', "AÅ1234");
		checkInvalidConstructor('C', 'G', "ab1234");

		checkInvalidConstructor('C', 'G', "EL12345");
		checkInvalidConstructor('C', 'G', "EK12345");
		checkInvalidConstructor('C', 'G', "HY12345");
		checkInvalidConstructor('C', 'D', "EL12345");
		checkInvalidConstructor('C', 'D', "EK12345");
		checkInvalidConstructor('C', 'D', "HY12345");
		checkInvalidConstructor('C', 'H', "EL12345");
		checkInvalidConstructor('C', 'H', "EK12345");
		checkInvalidConstructor('C', 'H', "BN12345");
		checkInvalidConstructor('C', 'E', "HY12345");
		checkInvalidConstructor('C', 'E', "BN12345");
		checkInvalidConstructor('M', 'G', "EL1234");
		checkInvalidConstructor('M', 'G', "EK1234");
		checkInvalidConstructor('M', 'G', "HY1234");
		checkInvalidConstructor('M', 'D', "EL1234");
		checkInvalidConstructor('M', 'D', "EK1234");
		checkInvalidConstructor('M', 'D', "HY1234");
		checkInvalidConstructor('M', 'E', "HY1234");
		checkInvalidConstructor('M', 'E', "BN1234");
	}

	@Test
	void testSetRegistrationNumber() {
		vehicle = new Vehicle('C', 'D', "BN12345");
		vehicle.setRegistrationNumber("AB54321");
		checkVehicleState('C', 'D', "AB54321", vehicle);

		vehicle = new Vehicle('M', 'E', "EK1234");
		vehicle.setRegistrationNumber("EL4321");
		checkVehicleState('M', 'E', "EL4321", vehicle);

		vehicle = new Vehicle('C', 'D', "BN12345");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			vehicle.setRegistrationNumber("AB654321");
		});
		checkVehicleState('C', 'D', "BN12345", vehicle);

		vehicle = new Vehicle('M', 'E', "EL1234");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			vehicle.setRegistrationNumber("HY1234");
		});
		checkVehicleState('M', 'E', "EL1234", vehicle);
		vehicle = new Vehicle('C', 'G', "AB12345");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "A1234");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "A12345");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "AB1234");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "AB123456");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "ABC1234");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "AÆ12345");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "ab12345");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "A1B2345");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "A1234");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "A12345");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "AB1234");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "AB123456");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "ABC1234");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "AÆ12345");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "ab12345");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "A1B2345");
		vehicle = new Vehicle('M', 'G', "AB1234");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "A1234");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "A12345");
		;
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "AB123");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "AB12345");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "ABC1234");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "ABC12345");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "AÅ1234");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "ab1234");
		vehicle = new Vehicle('C', 'G', "AB12345");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "EL12345");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "EK12345");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "HY12345");
		vehicle = new Vehicle('C', 'D', "AB12345");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "EL12345");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "EK12345");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "HY12345");
		vehicle = new Vehicle('C', 'H', "HY12345");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "EL12345");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "EK12345");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "BN12345");
		vehicle = new Vehicle('C', 'E', "EL12345");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "HY12345");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "BN12345");
		vehicle = new Vehicle('M', 'G', "AB1234");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "EL1234");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "EK1234");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "HY1234");
		vehicle = new Vehicle('M', 'D', "AB1234");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "EL1234");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "EK1234");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "HY1234");
		vehicle = new Vehicle('M', 'E', "EK1234");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "HY1234");
		checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "BN1234");
	}

}
