package uke9.accountinterface_full;

public class ATM {

	public void withdraw(Account account, int amount) {
		
		int money = 0;
		try {
			money = account.withdraw(amount);
			System.out.println("Du fikk tatt ut " + money + " kroner. Kontoinformasjon:\n"+account+"\n");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void deposit(Account account, int amount) {
		account.deposit(amount);
		System.out.println(amount + " kroner satt inn. Kontoinformasjon:\n"+account+"\n");
	}
	
	public void getBalance(Account account) {
		if (account instanceof BonusAccount) {
			BonusAccount ba = (BonusAccount) account;
			System.out.println("kredittgrense: "+ba.getCredit());
		}
		System.out.println(account.getBalance());
	}
}
