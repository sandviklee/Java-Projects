package uke5.downcounter;

public class DownCounter {
	
	int counter = 0;
	
	public DownCounter(int initCounter) {
		counter = initCounter;
	}
		
	public DownCounter() {
		java.util.Random rand = new java.util.Random();
		counter = rand.nextInt(10);
	}

	public void countDown() {
		if (! isFinished()) {
			counter = counter - 1;
			System.out.println("Teller ned med 1.\nCounter er nå " + counter);
		}
	}
	
	public boolean isFinished() {
		return counter == 0;
	}

	public static void main(String[] args) {

		DownCounter dc1 = new DownCounter();
		System.out.println(dc1.isFinished());
		dc1.countDown();
		System.out.println(dc1.isFinished());
		dc1.countDown();
		System.out.println(dc1.isFinished());
		dc1.countDown();
	}
}
