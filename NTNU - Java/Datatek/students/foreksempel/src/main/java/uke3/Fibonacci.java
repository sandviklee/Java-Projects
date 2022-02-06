package uke3;

public class Fibonacci {
    
	// En rekursiv funksjon - stopper den noen gang?
	// https://en.wikipedia.org/wiki/Fibonacci_number
	public static int foo(int n) {
		System.out.println("n: "+n);
		if (n <= 1) {
			return 1;
		}
		else {
			return foo(n - 1 ) + foo(n - 2);
		}
	}
	
	public static void main(String[] args) {
		// spørre etter i etter løkken der den deklareres
		for (int i = 0; i < 10; i++) {
			if (i > 5) break;
		}

		System.out.println(foo(4));
	}

}
