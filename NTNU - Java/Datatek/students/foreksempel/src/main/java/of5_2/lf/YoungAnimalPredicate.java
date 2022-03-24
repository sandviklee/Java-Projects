package of5_2.lf;

import java.util.function.Predicate;

public class YoungAnimalPredicate implements Predicate<Animal> {

    @Override
    public boolean test(Animal t) {
        return t.getAge() <= 2;
    }

}
