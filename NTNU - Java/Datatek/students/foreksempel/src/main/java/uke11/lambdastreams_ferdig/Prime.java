package uke11.lambdastreams_ferdig;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

// Eksempel fra https://www.journaldev.com/2763/java-8-functional-interfaces

public class Prime {
	//Traditional approach
	private static boolean isPrime(int number) {		
		if(number < 2) return false;
		for(int i=2; i<number; i++){
			if(number % i == 0) return false;
		}
		return true;
	}
	
	//Declarative approach
	private static boolean isPrime2(int number) {		
		return number > 1
				&& IntStream.range(2, number).noneMatch(
						index -> number % index == 0);
	}
	
	private static boolean isPrime3(int number) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		IntPredicate isDivisible = index -> number % index == 0;
		
		return number > 1
				&& IntStream.range(2, number).noneMatch(isDivisible);
	}
	
	public static void main(String[] args) {
		IntStream.range(0, 100)
//		.parallel() // Fjern kommentar, sjekk hva som skjer!
		.filter(d -> Prime.isPrime3(d))
		.forEach(System.out::println);
		System.out.println(isPrime(23));
	}
}
