package uke9.loekkeinterface_ferdig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Loekker {

	public static void main(String[] args) {
		
		Loekker loekker = new Loekker();
		
		List<Character> liste = new ArrayList<>();
		liste.add('a');
		liste.add('b');
		liste.add('c');		
		
		String streng = new String("def");
		
		char[] charArray = { 'g', 'h', 'i'}; 

		loekker.skrivut(liste, new ListCharPrinter());
		loekker.skrivut(streng, new StringCharPrinter());
		loekker.skrivut(charArray, new CharArrayPrinter());	
	}

	private void skrivut(Object ob, LoekkePrintInterface pI) {
		pI.printCharacters(ob);
	}
}
