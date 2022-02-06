package uke5.kaffe;

import java.util.Random;

public class Person {
    
    String navn;
    int kopperIntatt;
    int kaffeBehov;

    public Person(String nyttNavn) {
        this.navn = nyttNavn;
        Random random = new Random();
        this.kaffeBehov = random.nextInt(5);
    }

    public boolean nokKaffe() {
        return this.kopperIntatt >= this.kaffeBehov;
    }

    public String getNavn() {
        return navn;

    }

    public void drikkKaffe() {
        this.kopperIntatt += 1;
        System.out.println(this.getNavn()+" har drukket kopp "+this.kopperIntatt);
    }

    public static void main(String[] args) {
        Person person = new Person("Børge");
        System.out.println(person.getNavn());
        person.drikkKaffe();
        System.out.println("Nok kaffe: "+person.nokKaffe());

    }
}
