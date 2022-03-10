package uke10.person_lambda_ferdig;

import java.util.Comparator;

public class NameLengthSorter implements Comparator<Person>{

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().length()-p2.getName().length();
    }

}
