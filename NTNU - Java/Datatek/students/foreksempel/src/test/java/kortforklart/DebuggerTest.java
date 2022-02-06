package kortforklart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class DebuggerTest {
	private Debugger debugger;
	
	
	@BeforeEach
	public void setup() {
		debugger = new Debugger();
	}
	
	@Test
	void testValidStreetNameOnlyNameAndStreet() {
		Assertions.assertTrue(debugger.validateAdress("Kongsgata 4"));
	}
	
	@Test
	void testValidStreetNameDoubleNames() {
		Assertions.assertTrue(debugger.validateAdress("Ola Narr 9"));
	}
	
	@Test
	void testValidStreetNameDoubleNamesSmallletter() {
		Assertions.assertFalse(debugger.validateAdress("Ola narr 9"));
	}
	
	@Test
	void testStreetMustEndWithNumber() {
		Assertions.assertFalse(debugger.validateAdress("Kongsgata"));
	}
	
	@Test
	public void testStreetMustNotStartWithNumber() {
		Assertions.assertFalse(debugger.validateAdress("47 47"));
	}
	
	@Test
	public void testSetAddress() {
		debugger.setAddress("Kongshaugen 4");
		Assertions.assertEquals("Kongshaugen 4", debugger.getAdress());
	}

}
