package of5_2.lf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Farm implements Iterable<Animal> {

    List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        if (animals.contains(animal)) {
            throw new IllegalArgumentException("Animal already in farm!");
        }
        animals.add(animal);
    }

    public List<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }

    public int numberOfAnimals() {
        return animals.size();
    }

    public Animal getAnimal(int index) {
        return animals.get(index);
    }

    @Override
    public Iterator<Animal> iterator() {
        return animals.iterator();
    }

    public List<String> getAnimalNames() {
        return animals.stream()
                .map((animal) -> animal.getName())
                .distinct()
                .toList();
    }

    public static void main(String[] args) {
        Farm farm = new Farm();
        farm.addAnimal(new Dog("Ludo", 12));
        farm.addAnimal(new Dog("Fido", 0));
        farm.addAnimal(new Chicken("Peter", 1));
        farm.addAnimal(new Chicken("Albert", 4));

        Iterator<Animal> iterator = new FilterAnimalsIterator(farm, new DogPredicate());
        while (iterator.hasNext()) {
            System.out.println(iterator.next().makeSound());
        }
        System.out.println();

        farm.getAnimals().stream().filter(new DogPredicate()).forEach(animal -> {
            System.out.println(animal.makeSound());
        });
    }

}
