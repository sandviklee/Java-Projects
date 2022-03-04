package uke9.accountinterface;

public class ATM {
    
    public void withdraw(Account account, int amount) {
        int howmuch = account.withdraw(amount);
        if (howmuch > 0) {
            System.out.println("Du fikk tatt ut "+howmuch);
        }
    }

    public void deposit(Account account, int amount) {
        account.deposit(amount);
        System.out.println("Du har nå: "+account.getBalance());
    }

    public void getBalance(Account account) {
        System.out.println("Du har "+account.getBalance()+" penger på konto");
    }
}
