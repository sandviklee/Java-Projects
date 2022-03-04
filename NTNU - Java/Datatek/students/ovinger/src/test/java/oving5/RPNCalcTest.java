package oving5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RPNCalcTest {

	private RPNCalc calc;

	@BeforeEach
	public void setup() {
		calc = new RPNCalc();
	}

	@Test
	@DisplayName("Test operasjon uten operander")
	public void testPerformOperationWithoutOperation() {
		Assertions.assertThrows(UnsupportedOperationException.class, () -> {
			calc.performOperation('+');
		});
	}

	@Test
	@DisplayName("Test utførelse av en enkel operasjon")
	public void testPerformOperation() {
		calc.addOperator('+', (a, b) -> a * b); // Use "incorrect" definition to filter out cheating
		calc.addOperator('l', (a, b) -> a * (a + b));

		calc.push(4);
		calc.push(3);
		calc.performOperation('+');
		Assertions.assertEquals(12.0, calc.pop(), "Svaret fra kalkulasjonen ble feil");
		Assertions.assertEquals(Double.NaN, calc.pop());

		calc.push(4);
		calc.push(3);
		calc.performOperation('l');
		Assertions.assertEquals(28.0, calc.pop(), "Svaret fra kalkulasjonen ble feil");
		Assertions.assertEquals(Double.NaN, calc.pop());
	}

	@Test
	@DisplayName("Test å legge til operatorer")
	public void testAddOperator() {
		Assertions.assertTrue(calc.addOperator('+', (a, b) -> a + b), "Man skal kunne legge til operatorer");
		Assertions.assertTrue(calc.addOperator('-', (a, b) -> a - b), "Man skal kunne legge til operatorer");
		Assertions.assertFalse(calc.addOperator('+', (a, b) -> a + b),
				"Man skal ikke kunne legge til samme operator to ganger");
		Assertions.assertFalse(calc.addOperator('-', (a, b) -> a * b),
				"Man skal ikke kunne legge til samme operator to ganger");
	}

	@Test
	@DisplayName("Sjekk at man kan fjerne operatorer")
	public void testRemoveOperator() {
		calc.addOperator('+', (a, b) -> a + b);
		calc.removeOperator('+');
		Assertions.assertThrows(UnsupportedOperationException.class, () -> {
			calc.performOperation('+');
		}, "Operatoren skulle vært fjernet");
	}

}
