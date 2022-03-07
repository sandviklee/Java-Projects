package uke9.accountinterface;

public class BonusAccount implements Account {

    int balance;
    int maxCredit = -1000;

    public int getMaxCredit() {
        return maxCredit;
    }

    public void setMaxCredit(int maxCredit) {
        this.maxCredit = maxCredit;
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
    public int withdraw(int amount) {
        
        if ((balance - amount) >= maxCredit) {
            balance -= amount;
            return amount;
        }
        throw new IllegalArgumentException("Ikke nok kreditt til å ta ut "+amount);
    }
    
    @Override
    public String toString() {
        return "BonusAccount: "+balance+", credit: "+maxCredit;
    }
}
