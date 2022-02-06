package uke2.fasit;

import java.util.Random;

public class Person {
    
    String name;
    int kaffeBehov;
    int kopperIntatt = 0;

    // Har personen fått nok kaffe?
    public boolean nokKaffe() {
        return this.kopperIntatt >= this.kaffeBehov;
    }

    // Personen drikker en kopp. Da må vi endre tilstanden til Person. Én kopp mer!
    public void drikkKaffe() {
        this.kopperIntatt += 1;
        System.out.println(this.name+" drikker kaffe");
    }

    public Person(String name) {
        this.name = name;
        Random random = new Random();
        this.kaffeBehov = random.nextInt(5);
    }

    public String getName() {
     return this.name;   
    }

    public static void main(String[] args) {
        System.out.println("Inni main i Person");
        Person person = new Person("Børge");
        System.out.println(person.getName()+" er kaffemett: "+person.nokKaffe());
        person.drikkKaffe();
        System.out.println(person.getName()+" er kaffemett: "+person.nokKaffe());
        person.drikkKaffe();
        System.out.println(person.getName()+" er kaffemett: "+person.nokKaffe());
        person.drikkKaffe();
        System.out.println(person.getName()+" er kaffemett: "+person.nokKaffe());
        person.drikkKaffe();
        System.out.println(person.kaffeBehov);
        System.out.println(person.getName()+" er kaffemett: "+person.nokKaffe());
        person.drikkKaffe();
        System.out.println(person.getName()+" er kaffemett: "+person.nokKaffe());
        person.drikkKaffe();
        System.out.println(person.getName()+" er kaffemett: "+person.nokKaffe());
        person.drikkKaffe();
    }
    
    
}
