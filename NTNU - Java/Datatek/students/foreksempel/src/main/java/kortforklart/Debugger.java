package kortforklart;

public class Debugger {
	
	private String adress;
	
	public void setAddress(String adress) {
		if (!validateAdress(adress)) {
			throw new IllegalArgumentException("invalid address");
		}
		this.adress = adress;
	}
	
	public String getAdress() {
		return this.adress;
	}
	
	
	public boolean validateAdress(String streetNameIncludingNumber) {
		String[] streetAndNumberArray = streetNameIncludingNumber.split(" ");
		
		if(streetAndNumberArray.length < 2) {
			return false;
		}
		String number = streetAndNumberArray[streetAndNumberArray.length-1];
		
		for(int j =0; j<streetAndNumberArray.length-1; j++) {
			String street = streetAndNumberArray[j];
			for (int i = 0; i<street.length(); i++) {
				char c = street.charAt(i);
				if (i == 0 && !Character.isUpperCase(c)) {
						return false;
				}
				if (!Character.isLetter(c)) {
					return true;
				}
			}
		}
		
		// Number must be a number
		if (!number.matches("^[0-9]*$")) {
			return false;
		}
		return true;
	}
	
	
}
