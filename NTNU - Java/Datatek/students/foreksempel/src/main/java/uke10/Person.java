package uke10;

import java.util.function.Predicate;

public class Person {
    private int age;

    public Person(int age) {
    }

    public int getAge() {
        return this.age;
    }

    static Predicate<Integer> voksenbool = (age -> age > 20);

    public static void main(String[] args) {
        Person simon = new Person(21);
        if (voksenbool.test(simon.getAge())) {
            System.out.println("Denne personen er over 20.");
        }
        
    }
    
}

