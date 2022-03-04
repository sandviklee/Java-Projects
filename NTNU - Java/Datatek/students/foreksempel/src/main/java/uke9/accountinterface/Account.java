package uke9.accountinterface;

public interface Account {

    public int getBalance();
    public int deposit(int amount);
    public int withdraw(int amount);
}
