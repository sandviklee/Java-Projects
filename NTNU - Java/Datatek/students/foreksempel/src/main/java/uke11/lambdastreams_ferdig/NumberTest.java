package uke11.lambdastreams_ferdig;

import java.util.Arrays;
import java.util.Comparator;

// Kode fra https://www.journaldev.com/2763/java-8-functional-interfaces - den var så fin!

import java.util.List;

// Eksempel hentet fra https://www.journaldev.com/2763/java-8-functional-interfaces

public class NumberTest {

	private static int findSquareOfMaxOdd(List<Integer> numbers) {
		int max = 0;
		for (int i : numbers) {
			if (i % 2 != 0 && i > 3 && i < 11 && i > max) {
				max = i;
			}
		}
		return max * max;
	}
	
	
	/*
	 * Poenget her er at en ved å splitte opp if-sjekken ovenfor ved hjelp av streams, og 
	 * egne metoder, så vil en gjøre koden mye mer lesbar.
	 */
	public static int findSquareOfMaxOdd2(List<Integer> numbers) {
		return numbers.stream()
				.filter(NumberTest::isOdd) 		//Predicate is functional interface and
				.filter(NumberTest::isGreaterThan3)	// we are using lambdas to initialize it
				.filter(NumberTest::isLessThan11)	// rather than anonymous inner classes
				.max(Comparator.naturalOrder())
				.map(i -> i * i)
				.get(); // Returner den.
	}

	public static boolean isOdd(int i) {
		return i % 2 != 0;
	}
	
	public static boolean isGreaterThan3(int i){
		return i > 3;
	}
	
	public static boolean isLessThan11(int i){
		return i < 11;
	}
	
	public static void main(String[] args) {
		System.out.println(NumberTest.findSquareOfMaxOdd(Arrays.asList(1,2,3,4,5,6,7,8,9,10)));
		System.out.println(NumberTest.findSquareOfMaxOdd2(Arrays.asList(1,2,3,4,5,6,7,8,9,10)));
	}
}
