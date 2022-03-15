package uke10;

import java.util.function.Predicate;

public class PersonAgePredicate implements Predicate<Person> {

    @Override
    public boolean test(Person t) {
        return t.getAge() > 20;
    }
    
}
