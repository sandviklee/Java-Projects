package uke8.counter;

public class Counter {

	private int count;
	private int max;
	
	public Counter(int max) {
		count = 0;
		this.max = max;
	}

	public int getCount() {
		return count;
	}
	
	public void count() {
		if (count < max) {
			count++;
		}
	}

	public boolean isMax() {
		return count >= max;
	}

	public static void main(String[] args) {
		Counter c = new Counter(10);
		for (int i = 0; i < 12; i++) {
			c.count();
			System.out.println(c.getCount());

		}
		
		Counter c2 = new Counter(10);
		while (! c2.isMax()) {
			c2.count();
			System.out.println(c2.getCount());
		}
	}

}
