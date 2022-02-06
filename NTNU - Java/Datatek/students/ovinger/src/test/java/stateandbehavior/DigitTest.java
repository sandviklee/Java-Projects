package stateandbehavior;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DigitTest {

	private String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	@Test
	@DisplayName("Constructor")
	public void testConstructor() {
		Digit digit = new Digit(10);
		assertEquals(0, digit.getValue(), "Wrong value when using constructor");
		assertEquals(10, digit.getBase(), "Wrong base when using constructor");
	}

	@Test
	@DisplayName("Increment value")
	public void testIncrementedValue() {
		for (int base = 2; base < 17; base++) {
			Digit digit = new Digit(base);
			assertEquals(0, digit.getValue(), "Wrong value for created digit");

			int i = 1;
			while (i < base) {
				boolean result = digit.increment();
				assertEquals(i, digit.getValue(), "The value was not incremented correctly");
				assertFalse(result, "Increment should return false when the value is less than the base");
				i++;
			}

			boolean result = digit.increment();
			assertEquals(0, digit.getValue(), "The value was not reset to 0 when it became equal to the base");
			assertTrue(result, "Increment should return true when the value is reset to 0");
		}
	}

	@Test
	@DisplayName("Increment value and convert to string")
	public void testIncrementedToString() {
		for (int base = 2; base < 17; base++) {
			Digit digit = new Digit(base);
			assertEquals("0", digit.toString(), "wrong string representation");

			int i = 1;
			while (i < base) {
				boolean result = digit.increment();
				assertEquals(String.valueOf(digits.charAt(i)), digit.toString(), "wrong string representation");
				assertFalse(result, "increment should return false when the value is less than the base");
				i++;
			}

			boolean result = digit.increment();
			assertEquals("0", digit.toString(), "wrong string representation");
			assertTrue(result, "increment should return true when the value is reset to 0");
		}
	}
}
