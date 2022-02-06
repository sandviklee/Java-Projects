package kortforklart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ZipCodeValidatorTest {
	
	private ZipCodeValidator validator;

	@Test
	void testZipCodeMustBe4Characters() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			validator = new ZipCodeValidator("MASSE LANGE KARAKTERER", "Oslo");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			validator = new ZipCodeValidator("000", "Oslo");
		});
	}
	
	@Test
	public void testZipCodeMustOnlyBeCharacters() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			validator = new ZipCodeValidator("VOFF", "Oslo");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			validator = new ZipCodeValidator("222%", "Oslo");
		});
	}
	
	@Test
	public void testZipCodesBelow1000IsInOslo() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			validator = new ZipCodeValidator("0564", "Asker");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			validator = new ZipCodeValidator("0999", "Trondheim");
		});
	}
	
	@Test
	public void testZipCodesInOsloMustBeSpecificNumbers() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			validator = new ZipCodeValidator("4444", "oslo");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			validator = new ZipCodeValidator("5555", "Oslo");
		});
	}
	
	@Test
	public void testCanSetValidZipCodes() {
		validator = new ZipCodeValidator("5122", "Stavanger");
		Assertions.assertEquals("Stavanger", validator.getLocation());
		Assertions.assertEquals("5122", validator.getZipCode());
		
		validator = new ZipCodeValidator("7043", "Trondheim");
		Assertions.assertEquals("Trondheim", validator.getLocation());
		Assertions.assertEquals("7043", validator.getZipCode());
		

	}

}
