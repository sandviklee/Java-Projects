package uke9.accountinterface_full;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ATMController {

	public static void main(String[] args) {
		// Dette kunne jeg hatt i main i ATM.java, men se for dere at 
		// denne koden ligger og snakker med FXML. Eller snarere at
		// atm.deposit og slikt er knyttet til knapper i grensesnittet. 
		// Da må ting skrives om så ATM.java returnerer strenger i stedet for å syso dem!
		
		List<Account> accounts = new ArrayList<>();

		ATM atm = new ATM();
		RegularAccount ra = new RegularAccount();
		accounts.add(ra);
		atm.deposit(ra,500);
		atm.deposit(ra,500);
		atm.deposit(ra,500);
		atm.withdraw(ra,1200);
		atm.withdraw(ra,1200);
		
		BonusAccount ba = new BonusAccount();
		accounts.add(ba);
		atm.deposit(ba,  600);
		atm.withdraw(ba, 333);
		atm.withdraw(ba, 1033);
		atm.withdraw(ba, 1333);
		atm.getBalance(ba);

		SavingsAccount sa = new SavingsAccount();
		accounts.add(sa);
		atm.deposit(sa, 300);
		atm.withdraw(sa, 100);
		atm.withdraw(sa, 100);
		atm.withdraw(sa, 100);
		System.out.println(accounts);
		Collections.sort(accounts,new AccountSorter());
		System.out.println(accounts);
	}

}
