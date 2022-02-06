package stateandbehavior;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class AccountTest {
	private double delta = 1e-8;

	private Account account;

	@BeforeEach
	public void setup() {
		account = new Account();
	}

	@Test
	@DisplayName("Constructor")
	public void testConstructor() {
		Assertions.assertEquals(0.0, account.getBalance(), delta, "Wrong balance for newly created account");
	}

	@Test
	@DisplayName("Deposit")
	public void testDeposit() {
		account.deposit(100);

		Assertions.assertEquals(100.0, account.getBalance(), delta, "Wrong balance after depositing");
	}

	@Test
	@DisplayName("Negative deposit")
	public void testNegativeDeposit() {
		account.deposit(-50);

		Assertions.assertEquals(0.0, account.getBalance(), delta, "Wrong balance after making negative deposit");
	}

	@Test
	@DisplayName("Adding interest")
	public void testAddInterest() {
		account.setInterestRate(5);

		Assertions.assertEquals(0, account.getBalance(), delta, "Wrong balance after updating interest rate");
		Assertions.assertEquals(5, account.getInterestRate(), delta,
				"Wrong interest rate after updating interest rate");

		account.deposit(100);
		Assertions.assertEquals(100, account.getBalance(), delta, "Wrong balance after depositing");

		account.addInterest();
		Assertions.assertEquals(105, account.getBalance(), delta, "Wrong balance after adding interest");
	}
}