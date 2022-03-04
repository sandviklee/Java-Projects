package uke9.accountinterface;

public class RegularAccount implements Account{
    
    int balance;

    public int getBalance() {
        return balance;
    }

    public int deposit(int amount) {
        balance += amount;
        return balance;
    }

    public int withdraw(int amount) {
        if (balance - amount >= 0) {
            balance -= amount;
            return amount;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Account: "+balance;
    }
}
