package uke8.account;

public class Account {

	private int balance;


	public void deposit(int amount) {
		balance += amount ;
	}

	public void withdraw(int amount) {
		if (balance - amount < 0)
			System.err.println("Ingen kreditt, dude.");
		else
			balance -= amount;
	}

	public void addInterest(int interest) {
		this.balance *= (100.0+interest)/100;
	}

	public int getBalance() {
		return balance;
	}

	public void test(boolean resultat, String msg) {
		if (! resultat) {
			System.err.println("Her var der feil: "+msg);
		}
	}

	public Account() {
		super();
		this.balance = 0;
	}

	public static void main(String[] args) {

		Account konto = new Account();
		if (konto.getBalance() != 0)
			System.err.println("Konstruktør lager Account med feil balance.");
		konto.deposit(1000);
		if (konto.getBalance() != 1000)
			System.err.println("Feil: Forventet 1000, ble "+konto.getBalance());
		konto.deposit(1000);
		if (konto.getBalance() != 2000)
			System.err.println("Feil: Forventet 2000, ble "+konto.getBalance());
		konto.withdraw(1500);
		if (konto.getBalance() != 500)
			System.err.println("Feil: Forventet 1500, ble "+konto.getBalance());
		konto.withdraw(500);
		if (konto.getBalance() != 0)
			System.err.println("Feil: Forventet 0, ble "+konto.getBalance());
		konto.withdraw(500);
		if (konto.getBalance() != 0)
			System.err.println("Feil2: Forventet 0, ble "+konto.getBalance());
		System.out.println(konto.getBalance());
		
		// En egen metode for å forenkle testbeskrivelser
		konto.test(konto.getBalance() == 0, "Skulle vært 0 men var "+konto.getBalance());

		// Renter. 
		konto.deposit(1000);
		System.out.println("Legger på rente... vi sier 12 prosent");
		konto.addInterest(12);
		konto.test(konto.getBalance() == 1120,"Feil i renter: Forventet 1120, ble "+konto.getBalance());
		
		// Men som sagt er det mye bedre å strukturere ting i JUnit. Du får så mye ekstra!

	}

}
