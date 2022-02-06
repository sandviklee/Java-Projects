package uke2;

import java.util.Random;

public class RandomAverage {

	DownCounter downCounter;
	Random random;
	Average average;
	
	
	public double computeRandomAverage(int count) {
		downCounter = new DownCounter(count);
		random = new Random();
		average = new Average();
		while (! downCounter.isFinished()) {
			int value = random.nextInt(100);
			average.acceptValue(value);
			downCounter.countDown();
		}
		return average.getAverage();
	}
	
	public static void main(String[] args) {
		RandomAverage ra = new RandomAverage();
		System.out.println(ra.computeRandomAverage(100000));
	}

}
