package uke9.loekkeinterface_ferdig;

public class CharArrayPrinter implements LoekkePrintInterface{

	@Override
	public void printCharacters(Object obj) {
		//
		if (obj instanceof char[]) {
			char[] tmp = (char[]) obj;
			for (int i = 0; i < tmp.length; i++) {				
				Character c = tmp[i];
				System.out.println(c);
			}

		}
		
	}
}
