package of5_2.lf;

import java.util.Iterator;

public class YoungAnimalsIterator implements Iterator<Animal> {

    private int index = 0;
    private Farm farm;

    public YoungAnimalsIterator(Farm farm) {
        this.farm = farm;
    }

    @Override
    public boolean hasNext() {
        while (index < farm.numberOfAnimals()) {
            if (farm.getAnimal(index).getAge() <= 2) {
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public Animal next() {
        if (!hasNext()) {
            throw new IllegalArgumentException("No more animals in farm");
        }
        return farm.getAnimal(index++);
    }

}
