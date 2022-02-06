package stateandbehavior;

public class Account {
    double balance = 0.0;
    double interestRate = 0.0;


    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double balance) {
        if (balance > 0) {
            this.balance = balance;
        }
    }

    public void addInterest() {
        balance += balance*interestRate/100;
    }

    @Override
    public String toString() {
        return "Account [balance=" + balance + ", interestRate=" + interestRate + "]";
    }

    public static void main(String[] args) {
    }

    
    
}
