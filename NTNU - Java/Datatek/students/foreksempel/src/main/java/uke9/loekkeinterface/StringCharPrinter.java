package uke9.loekkeinterface_ferdig;

public class StringCharPrinter implements LoekkePrintInterface{

	@Override
	public void printCharacters(Object obj) {
		//
		if (obj instanceof String) {
			String tmp = (String) obj;
			for (int i = 0; i < tmp.length(); i++) {
				Character c = tmp.charAt(i);
				System.out.println(c);
			}

		}
		
	}

}
