package uke9.accountinterface_full;

public class BonusAccount implements Account{
	private int balance;
	private int maxCredit = -1000;
	
	public void setCredit(int kreditt) {
		this.maxCredit = kreditt;
	}
	
	public int getCredit() {
		return maxCredit;
	}

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
	public String toString() {
		return "BonusAccount med " + balance + " kroner tilgjengelig.";
	}

	@Override
	public int withdraw(int amount) {
		if ((balance - amount) >= maxCredit) { // 1000 i maks kreditt
			balance -= amount;
			return amount;
		}
		throw new IllegalArgumentException("Ikke nok kreditt.");
	}

}
