package uke12.merging;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MergeBruk {

	public static void main(String[] args) {

		List<String> liste1 = Arrays.asList("a","b","c","d","e","f","g");
		List<String> liste2 = Arrays.asList("A","B","C","D","E");

		Iterator<String> it = new MergingIterator(liste1.iterator(), liste2.iterator());
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
