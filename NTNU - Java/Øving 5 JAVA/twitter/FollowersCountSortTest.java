package oving5.twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FollowersCountSortTest {
    private List<TwitterAccount> accounts;

    public void init() {
        TwitterAccount simonsle = new TwitterAccount("Simon");
        TwitterAccount Frida = new TwitterAccount("Frida");
        TwitterAccount Sverre = new TwitterAccount("Sverre");

  
        accounts.add(simonsle);
        accounts.add(Frida);
        accounts.add(Sverre);

        simonsle.follow(Frida);
        Sverre.follow(Frida);
        Frida.follow(simonsle);

    }

    public void run() {
        System.out.println("Før sortering:" + accounts);
        Collections.sort(accounts, new FollowersCountComparator());
        System.out.println("Etter sortering: " + accounts);
    }

    public static void main(String[] args) {
        FollowersCountSortTest program = new FollowersCountSortTest();
        program.init();
        program.run();
    }
}
