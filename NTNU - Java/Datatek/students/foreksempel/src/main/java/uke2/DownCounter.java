package uke2;

public class DownCounter {
    int counter = 0;

	public boolean isFinished() {
		return counter == 0;
	}
	
	public void countDown() {
		if (! isFinished()) {
			counter -= 1;
			System.out.println("Teller ned, er p "+counter);
		}
	}
	
	public DownCounter(int counter) {
		super();
		this.counter = counter;
	}
    public static void main(String[] args) {	
		DownCounter dc = new DownCounter(4);
		System.out.println(dc.isFinished());
		dc.countDown();
		System.out.println(dc.isFinished());
		dc.countDown();
		System.out.println(dc.isFinished());
		dc.countDown();
		System.out.println(dc.isFinished());
		dc.countDown();
		System.out.println(dc.isFinished());
		dc.countDown();
		System.out.println(dc.isFinished());
		dc.countDown();

	}

}
