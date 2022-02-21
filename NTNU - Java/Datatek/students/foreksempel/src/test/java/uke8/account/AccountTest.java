package uke8.account;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AccountTest {

	Account konto;
	
	@BeforeEach
	public void setUp() throws Exception {
		System.out.println("Initialiserer...");
		konto = new Account();
	}

	@Test
	public void constructurZeroBalanceUponCreation() {
		assertEquals(0, konto.getBalance());
	}

	@Test
	public void cantGetNegativeBalance() {
		konto.withdraw(1000);
		assertEquals(0, konto.getBalance());
		konto.deposit(700);
		assertEquals(700, konto.getBalance());
	}

	@Test
	public void depositMoney() {
		konto.deposit(1000);
		assertEquals(1000, konto.getBalance());
		konto.deposit(1000);
		assertEquals(2000, konto.getBalance());
	}

	@DisplayName("Verify that moneys are withdrawn correctly. Assumes that deposit works.")
	@Test
	public void withdrawMoney() {
		konto.deposit(1000);
		konto.withdraw(300);
		assertEquals(700, konto.getBalance());
	}
}
