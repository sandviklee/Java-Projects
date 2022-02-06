package oving2;

public class Account {
    private double amount;
    private double rent;

    public Account(double amount, double rent) {
        if ((amount > 0) && (rent > 0)) {
            this.amount = amount;
            this.rent = rent;
        }
        else throw new IllegalArgumentException("Negative number");
    }

    public double getBalance() {
        return amount;
    }

    public double getInterestRate() {
        return rent;
    }

    public void setInterestRate(double rent) {
        if (rent >= 0) {
            this.rent = rent;
        }
        else throw new IllegalArgumentException("Negative Interestrate");
    }

    public void deposit(double add) {
        if (add >= 0) {
            amount += add;
        }
        else throw new IllegalArgumentException("Negative addition");
    }

    public void withdraw(double sub) {
        if (sub >= 0) {
            if (amount - sub > 0) {
                amount -= sub;
            }
            else throw new IllegalArgumentException("Negative sum");
        }
    }

    public void addInterest() {
        amount += rent*amount/100;
    }

    
    @Override
    public String toString() {
        return "Account [amount=" + amount + ", rent=" + rent + "]";
    }

    public static void main(String[] args) {
        Account acc = new Account(1001, 2);
        System.out.println(acc);
    }
}
