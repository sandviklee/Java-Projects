package uke10.streng;

import java.util.Iterator;

public class StrengIterator implements Iterator<Character> {
	private String s;
	private int pos = 0;

	public StrengIterator(String s) {
		this.s = s;
	}

	@Override
	public boolean hasNext() {
		return pos < s.length();
	}

	@Override
	public Character next() {
		char next = s.charAt(pos);
		pos++;
		return next;
	}
}
