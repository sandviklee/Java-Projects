package uke9.accountinterface;

public class ATMController {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Account account = new RegularAccount();
        atm.deposit(account, 500);
        atm.deposit(account, 500);
        atm.withdraw(account, 300);
        atm.withdraw(account, 300);
        atm.withdraw(account, 300);
        atm.withdraw(account, 300);
        atm.getBalance(account);

        Account account2 = new BonusAccount();
        atm.deposit(account2, 1000);
        atm.withdraw(account2, 1500);
        System.out.println(account2);
    }
}
