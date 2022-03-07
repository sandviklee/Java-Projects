package uke9.accountinterface;

public class ATM {
    
    public void withdraw(Account account, int amount) {
        int howmuch = 0;
        try {
            howmuch = account.withdraw(amount);
            if (howmuch > 0) {
                System.out.println("Du fikk tatt ut "+howmuch);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deposit(Account account, int amount) {
        account.deposit(amount);
        System.out.println("Du har nå: "+account.getBalance());
    }

    public void getBalance(Account account) {
        System.out.println("Du har "+account.getBalance()+" penger på konto");
        if (account instanceof BonusAccount) {
            BonusAccount ba = (BonusAccount) account;
            System.out.println("Du har kredittgrense: "+ba.getMaxCredit());
            ba.setMaxCredit(500);

        }

    }
}
