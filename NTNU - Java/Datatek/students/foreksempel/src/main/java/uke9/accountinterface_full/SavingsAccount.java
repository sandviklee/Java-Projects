package uke9.accountinterface_full;

public class SavingsAccount implements Account{
	@Override
	public String toString() {
		return "SavingsAccount med " + balance + " kroner tilgjengelig, gjenværende uttak: " + 
	(maxWithdrawals - withdrawals);
	}

	private int balance;
	private int withdrawals;
	private int maxWithdrawals = 2;
	
	@Override
	public int getBalance() {
		return balance;
	}

	@Override
	public int deposit(int amount) {
		balance += amount;
		return balance;
	}

	@Override
	public int withdraw(int amount) {
		if (withdrawals == maxWithdrawals) // Maks 2 uttak (
			throw new IllegalArgumentException("Maks antall uttak gjort.");
		if ((balance - amount) >= -1000) {
			balance -= amount;
			withdrawals ++;
			return amount;
		}
		return 0;
	}
}
