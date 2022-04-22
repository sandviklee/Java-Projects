package oving5.debugging;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringMergingIterator implements Iterator<String> {

	private Iterator<String> first;
	private Iterator<String> second;
	private boolean turnSwitch;

	public StringMergingIterator(Iterator<String> first, Iterator<String> second) {
		this.first = first;
		this.second = second;
		this.turnSwitch = true;
	}

	@Override
	public boolean hasNext() {
		return first.hasNext() || second.hasNext();
	}

	@Override
	public String next() {

		if (!hasNext()) {
			throw new NoSuchElementException();
		}

		String result = null;

		 
		// if (turnSwitch) {
		// 	if (first.hasNext()) {
		// 		result = first.next();
		// 		turnSwitch = false;
		// 		return result;
		// 	} else {
		// 		result = second.next();
		// 		turnSwitch = false;
		// 	}
		// }
		// else if (!turnSwitch) {
		// 	result = second.next();
		// 	turnSwitch = true;
		// }

		if (!first.hasNext()) {
			result = second.next();
		} else if (!second.hasNext()) {
			result = first.next();
		} else {
			if (turnSwitch) {
				result = first.next();
				turnSwitch = false;
			} else {
				result = second.next();
				turnSwitch = true;
			}
		}
		return result;
	}

}
