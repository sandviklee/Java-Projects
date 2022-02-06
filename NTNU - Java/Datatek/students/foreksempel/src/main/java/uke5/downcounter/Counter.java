package uke5.downcounter;

public class Counter {

	int end;
	int counter = 1;
	
	public Counter(int i) {
		end = i;
	}
	
	boolean count() {
		if (counter == end)
			return true;
		else {
			counter++;
			return false;
		}
	}
	
	boolean count(int i) {
		if (counter == end)
			return true;
		else {
			counter += i;
			return false;
		}
	}


	public static void main(String[] args) {

		Counter c = new Counter(3);
		System.out.println(c.getCounter());
		System.out.println(c.count(2));
		System.out.println(c.getCounter());
		System.out.println(c.count(2));
	}

	int getCounter() {
		return counter;
	}

}
