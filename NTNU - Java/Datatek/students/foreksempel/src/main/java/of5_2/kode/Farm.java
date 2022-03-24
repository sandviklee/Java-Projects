package of5_2.kode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Farm {

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

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>(List.of(
                new Dog("Ludo", 2),
                new Chicken("Albert", 1),
                new Dog("Ollie", 6),
                new Chicken("Ringo", 6),
                new Dog("Buddy", 8),
                new Chicken("Kjell", 5)));

        Collections.sort(animals, new AnimalTypeComparator());

        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
        }
    }
}
