package uke9.accountinterface;

public class SavingsAccount implements Account{

    int balance;
    int maxWithdrawals = 2;
    int withdrawals;

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
        
        if (maxWithdrawals == withdrawals)
            throw new IllegalArgumentException("Penga er slukt");
        if (balance - amount >= 0) {
            balance -= amount;
            withdrawals++;
            return amount;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "SavingsAccount: "+balance +", uttak igjen: "+(maxWithdrawals - withdrawals);
    }
}
