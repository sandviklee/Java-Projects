package uke9.loekkeinterface;

import java.util.ArrayList;
import java.util.List;

public class LoekkerOld {

	public static void main(String[] args) {

		List<Character> liste = new ArrayList<>();
		liste.add('a');
		liste.add('b');
		liste.add('c');		
		for (char character : liste) {
			char c = character;
			System.out.println(c);
		}

		String streng = new String("def");
		for (int i = 0; i < streng.length(); i++) {
			char c = streng.charAt(i);
			System.out.println(c);			
		}

		char[] charArray = { 'g', 'h', 'i'}; 
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			System.out.println(c);
		}
	}
}
