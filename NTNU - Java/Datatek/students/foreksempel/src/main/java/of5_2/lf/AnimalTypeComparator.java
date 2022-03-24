package of5_2.lf;

import java.util.Comparator;

public class AnimalTypeComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal a1, Animal a2) {
        if (a1 instanceof Dog) {
            if (a2 instanceof Dog) {
                return 0;
            }
            return -1;
        }
        return 1;
    }

}
