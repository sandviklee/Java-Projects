package oving5.twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class UsernameSortTest {
    private List<TwitterAccount> accounts;

    public void init() {
        accounts = new ArrayList<TwitterAccount>(Arrays.asList(
            new TwitterAccount("Bjørnen"), 
            new TwitterAccount("Apekatten"),
            new TwitterAccount("Giraffen")
        ));
    }

    public void run() {
        System.out.println("Før sortering:" + accounts);
        Collections.sort(accounts, new UserNameComparator());
        System.out.println("Etter sortering: " + accounts);
    }

    public static void main(String[] args) {
        UsernameSortTest program = new UsernameSortTest();
        program.init();
        program.run();
    }
}
