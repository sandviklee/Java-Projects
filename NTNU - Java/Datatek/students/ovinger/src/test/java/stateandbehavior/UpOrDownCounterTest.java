package stateandbehavior;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UpOrDownCounterTest {

	@Test
	@DisplayName("Count up")
	public void testCountUp() {
		UpOrDownCounter counter = new UpOrDownCounter(1, 5);
		assertEquals(1, counter.getCounter(), "Counter value should be equal to starting value when created");

		for (int i = 2; i < 5; i++) {
			boolean result = counter.count();
			assertEquals(i, counter.getCounter(), "Wrong counter value");
			assertTrue(result, "#count() should return true while within legal values");
		}

		boolean result = counter.count();
		assertEquals(5, counter.getCounter(), "Wrong counter value");
		assertFalse(result, "#count() should return false when we can't count further");

		result = counter.count();
		assertEquals(5, counter.getCounter(), "Counter value should not change when counting beyond legal values");
		assertFalse(result, "#count() should return false when we can't count further");
	}

	@Test
	@DisplayName("Count down")
	public void testCountDown() {
		UpOrDownCounter counter = new UpOrDownCounter(1, -5);
		assertEquals(1, counter.getCounter(), "Counter value should be equal to starting value when created");

		for (int i = 0; i > -5; i--) {
			boolean result = counter.count();
			assertEquals(i, counter.getCounter(), "Wrong counter value");
			assertTrue(result, "#count() should return true while within legal values");
		}

		boolean result = counter.count();
		assertEquals(-5, counter.getCounter(), "Wrong counter value");
		assertFalse(result, "#count() should return false when we can't count further");

		result = counter.count();
		assertEquals(-5, counter.getCounter(), "Counter value should not change when counting beyond legal values");
		assertFalse(result, "#count() should return false when we can't count further");
	}
}
