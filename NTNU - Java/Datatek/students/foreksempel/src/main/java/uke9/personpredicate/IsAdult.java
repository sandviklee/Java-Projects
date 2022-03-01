package uke9.personpredicate;

import java.util.function.Predicate;

public class IsAdult implements Predicate<Person> {
    @Override
    public boolean test(Person p) {
        return p.getAge() > 17;
    }
}
