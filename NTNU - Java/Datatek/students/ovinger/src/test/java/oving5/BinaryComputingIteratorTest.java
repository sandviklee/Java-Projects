package oving5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinaryComputingIteratorTest {

	private Iterator<Double> iterator1, iterator2, iteratorShort;

	@BeforeEach
	public void setup() {
		iterator1 = Arrays.asList(0.5, -2.0).iterator();
		iterator2 = Arrays.asList(5.0, 3.0).iterator();
		iteratorShort = Arrays.asList(5.0).iterator();
	}

	@Test
	@DisplayName("Sjekk BinaryComputingIterator med multiplikasjon")
	public void testMultiplication() {
		BinaryComputingIterator binaryIt = new BinaryComputingIterator(iterator1, iterator2, (a, b) -> a * b);
		Assertions.assertEquals(2.5, binaryIt.next(), "Det første tallet var feil");
		Assertions.assertTrue(binaryIt.hasNext());
		Assertions.assertEquals(-6.0, binaryIt.next(), "Det andre tallet var feil");
		Assertions.assertFalse(binaryIt.hasNext());
	}

	@Test
	@DisplayName("Sjekk BinaryComputingIterator med addisjon")
	public void testAddition() {
		BinaryComputingIterator binaryIt = new BinaryComputingIterator(iterator1, iterator2, (a, b) -> a + b);
		Assertions.assertEquals(5.5, binaryIt.next(), "Det første tallet var feil");
		Assertions.assertTrue(binaryIt.hasNext());
		Assertions.assertEquals(1.0, binaryIt.next(), "Det andre tallet var feil");
		Assertions.assertFalse(binaryIt.hasNext());
	}

	@Test
	@DisplayName("Test multiplikasjon med bare ett tall")
	public void testShortIterator() {
		BinaryComputingIterator binaryIt = new BinaryComputingIterator(iterator1, iteratorShort, (a, b) -> a * b);
		Assertions.assertEquals(2.5, binaryIt.next(), "Det første tallet var feil");
		Assertions.assertFalse(binaryIt.hasNext());
	}

	@Test
	@DisplayName("Test med standardverdi, både et tall og null")
	public void testShortIteratorAndDefault() {
		BinaryComputingIterator binaryIt = new BinaryComputingIterator(iterator1, iteratorShort, null, 2.0,
				(a, b) -> a * b);
		Assertions.assertEquals(2.5, binaryIt.next(), "Det første tallet var feil");
		Assertions.assertTrue(binaryIt.hasNext());
		Assertions.assertEquals(-4.0, binaryIt.next(), "Det andre tallet var feil");
		Assertions.assertFalse(binaryIt.hasNext());
	}

	@Test
	@DisplayName("Test med en tom iterator")
	public void testEmptyIterator() {
		BinaryComputingIterator binaryIt = new BinaryComputingIterator(new ArrayList().iterator(),
				new ArrayList().iterator(), (a, b) -> a * b);
		Assertions.assertFalse(binaryIt.hasNext(), "En tom iterator skal ikke ha next");
	}

	@Test
	@DisplayName("Test en tom iterator med standardverdi")
	public void testEmptyIteratorAndDefault() {
		BinaryComputingIterator binaryIt = new BinaryComputingIterator(new ArrayList().iterator(),
				new ArrayList().iterator(), 1.0, 2.0, (a, b) -> a * b);
		Assertions.assertFalse(binaryIt.hasNext(), "En tom iterator skal ikke ha next");
	}
}
