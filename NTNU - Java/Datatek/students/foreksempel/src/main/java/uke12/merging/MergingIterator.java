package uke12.merging;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MergingIterator implements Iterator<String>{

	private Iterator<String> it1;
	private Iterator<String> it2;
	private boolean flippe;
	
	/**
	 * @param it1
	 * @param it2
	 */
	public MergingIterator(Iterator<String> it1, Iterator<String> it2) {
		super();
		this.it1 = it1;
		this.it2 = it2;
		this.flippe = true;
	}

	@Override
	public boolean hasNext() {
		return it1.hasNext() || it2.hasNext();
	}

	@Override
	public String next() {


		if(! hasNext()){ throw new NoSuchElementException(); }

		String result;

		if(! it1.hasNext()){
			result = it2.next();
		}
		else if(! it2.hasNext()){
			result = it1.next();
		}
		else {
			if(flippe){
				result = it1.next();
			} else{
				result = it2.next();
			}

			flippe = !flippe;
		}
		return result;
	}
}
