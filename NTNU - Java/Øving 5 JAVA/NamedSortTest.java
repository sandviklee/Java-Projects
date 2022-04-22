package oving5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NamedSortTest {
    private List<Named> names;

    public void init() {
        names = new ArrayList<Named>(Arrays.asList(
            new Person1("Simon", "Sandvik"),
            new Person2("Simon Alv"),
            new Person1("Simon", "Bod"),
            new Person2("Simon Skogheim")
        ));
    }

    public void run() {
        System.out.println("Før sortering: "+ names);
        Collections.sort(names, new NamedComparator());
        System.out.println("Etter sortering: " + names);
    }

    public static void main(String[] args) {
        NamedSortTest program = new NamedSortTest();
        program.init();
        program.run();
    }
}
