package uke3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CounterTest {

	
	
	/*
	 * Vi har ikke forelest om dette ennå, men her kan dere se
	 * hvordan man kan bruke et testrammeverk for å verifisere
	 * at koden oppfører seg som forventet. 
	 * AssertEquals sammenlikner to verdier som er forventet å
	 * å være like, testen feiler ellers. AssertFalse og AssertTrue
	 * forventer at parameteren skal evalueres til false, hhv true,
	 * og testen feiler ellers. 
	 * 
	 * Det som skjer her er at vi endrer tilstanden til ett Count-
	 * objekt, og verifiserer at dette oppfører seg som forventet.
	 * 
	 * Det fine med å ha tester som sikrer at tilstanden er korrekt
	 * er at en kan endre innmaten i koden og allikevel være trygg(ere)
	 * på at koden gjør det den skal.
	 */
	@Test
	public void testCount() {
		Counter co = new Counter(5);
		assertEquals(1, co.getCounter());
		System.out.println(co.getCounter());
		co.count(); // Nå skal den være 2
		assertEquals(2, co.getCounter());
		co.count(); // Nå skal den være 3
		assertEquals(3, co.getCounter());
		assertFalse(co.count()); // 4
		assertEquals(4, co.getCounter());
		assertTrue(co.count()); // 5
		assertEquals(5, co.getCounter());
		assertTrue(co.count());
		assertEquals(5, co.getCounter());
		assertTrue(co.count());
		assertEquals(5, co.getCounter());
	}

}
