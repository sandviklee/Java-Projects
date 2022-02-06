package oving2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AccountTest {

	private Account account;

	private double epsilon = 0.000001d;

	@BeforeEach
	public void setup() {
		account = new Account(100, 5);
	}

	@Test
	@DisplayName("Private fields")
	public void testPrivateFields() {
		TestHelper.checkIfFieldsPrivate(Account.class);
	}

	@Test
	public void testConstructor() {
		Assertions.assertEquals(100.0d, account.getBalance(), epsilon);
		Assertions.assertEquals(5.0d, account.getInterestRate(), epsilon);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Account(-1, 5);
		});

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Account(100, -1);
		});
	}

	@Test
	public void testSetInterestRate() {
		account.setInterestRate(7);
		Assertions.assertEquals(7, account.getInterestRate(), epsilon);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			account.setInterestRate(-2);
		});
	}

	@Test
	public void testDeposit() {
		account.deposit(100);
		Assertions.assertEquals(200.0d, account.getBalance(), epsilon);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			account.deposit(-50);
		});
	}

	@Test
	public void testWithdraw() {
		account.withdraw(50);
		Assertions.assertEquals(50.0d, account.getBalance(), epsilon);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			account.withdraw(150);
		});
	}

}
