package oving5.twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AgeSortTest {
    private List<TwitterAccount> accounts;

    public void init() {
        accounts = new ArrayList<TwitterAccount>(Arrays.asList(
            new TwitterAccount("Simon", 5),
            new TwitterAccount("Erik", 6),
            new TwitterAccount("Isak", 2)
        ));
    }

    public void run() {
        System.out.println("Før sortering: " + accounts);
        Collections.sort(accounts, new FollowersCountComparator());
        System.out.println("Etter sortering: " + accounts);
    }

    public static void main(String[] args) {
        AgeSortTest program = new AgeSortTest();
        program.init();
        program.run();
    }

}
