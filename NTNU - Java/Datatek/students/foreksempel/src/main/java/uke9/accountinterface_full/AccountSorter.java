package uke9.accountinterface_full;

import java.util.Comparator;

public class AccountSorter implements Comparator<Account>{

    @Override
    public int compare(Account a1, Account a2) {
        return a1.getBalance()- a2.getBalance();
    }

}
