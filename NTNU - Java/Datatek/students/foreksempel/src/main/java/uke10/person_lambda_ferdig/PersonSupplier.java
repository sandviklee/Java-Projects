package uke10.person_lambda_ferdig;

import java.util.Random;
import java.util.function.Supplier;

public class PersonSupplier implements Supplier<Person> {

    @Override
    public Person get() {
        Random rand = new Random();
        return new Person("Randi", rand.nextInt(100));
    }


    public static void main(String[] args) {
        Supplier<Person> supplier = new PersonSupplier();
        System.out.println(supplier.get());
    }
}
