package kortforklart;

public class ZipCodeValidator {
	
	
	private String zipCode; 
	private String location; 
	
	public ZipCodeValidator(String zipCode, String location) {
		this.validateZipCodeWithLocation(zipCode, location);
		this.zipCode = zipCode;
		this.location = location;
	}
	
	public boolean validateZipCodeWithLocation(String zipCode, String location) {
		// Tester at zipcode har 4 karakterer
		if (zipCode.length() != 4) {
			throw new IllegalArgumentException("Zip code must contain 4 characters");
		}
		
		// Zip code must be between 0000-9999, and be all numbers
		if (!zipCode.matches("^[0-9]*$")) {
			throw new IllegalArgumentException("Can only be numbers");
		}
		
		// Oslo har postnummerene 0000-0999 
		if (zipCode.startsWith("0") && !location.equalsIgnoreCase("oslo")) {
			throw new IllegalArgumentException("Zip code in the wrong location");
		}
		if (!zipCode.startsWith("0") && location.equalsIgnoreCase("Oslo")) {
			throw new IllegalArgumentException("Zip code in the wrong location");

		}
		
		return true;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getLocation() {
		return location;
	}

	
}
