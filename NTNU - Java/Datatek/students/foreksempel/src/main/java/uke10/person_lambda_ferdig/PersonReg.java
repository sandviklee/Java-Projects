package uke10.person_lambda_ferdig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class PersonReg implements Iterable<Person> {
    
    List<Person> persons = new ArrayList<>();

    @Override
    public Iterator iterator() {
        return persons.iterator();
    }

    // Denne er litt søt. Tar inn så mange argumenter en vil, og legger dem til som en liste.
    public void addPersons(final Person...persons) {
		this.persons.addAll(List.of(persons));
	}


    // Denne tar inn en Comparator, og sorterer personene basert på denne.
    public void sortPersons(Comparator<Person> comp) {
        Collections.sort(persons, comp);
    }

    // Denne tar inn et predikat, og leter igjennom én og én Person på jakt
    // etter en som tilfredsstiller kravet i predikatet.
    public Person findFirst(Predicate<Person> tester ) {
        for (Person person : persons) {
            if (tester.test(person))
                return person;
        }
        return null;
    }

    // Samle alle Personer som tilfredsstiller et predikat, og returner dem i en Collection.
    public Collection<Person> findAll(Predicate<Person> tester) {
        Collection<Person> tmp = new ArrayList<>();
        for (Person person : persons) {
            if (tester.test(person)) {
                System.out.println("Found "+person);
                tmp.add(person);
            }
        }
        return tmp;
    }

    // Utfør en Consumer på hvert element i listen personer
	public Person forEachPerson(final Consumer<Person> consumer) {
		for (final Person person : persons) {
			consumer.accept(person);
		}
		return null;
	}

    // Utfør en Function på hver Person i personer.
    public Collection<String> getPersonProperties(final Function<Person, String> fun) {
		final Collection<String> result = new ArrayList<>();
		for (final Person person : persons) {
			result.add(fun.apply(person));
		}
        
		return result;
	}

    

    @Override
    public String toString() {
        return persons.toString();
    }

    public static void main(String[] args) {
        Person a = new Person("Ada", 34);
        Person b = new Person("Børge", 46);
        Person c = new Person("Cåre", 76);
        Person d = new Person("Dora", 6);
        Person e = new Person("Espen", 50);
        Person f = new Person("Frida", 1);
        Person g = new Person("Geir Kjetil", 12);
        Person h = new Person("Håvard", 13);
        Person i = new Person("Irma", 112);
		Person j = new Person("Jørn", 15);

        PersonReg pr = new PersonReg();
        pr.addPersons(a,b,c,d,e,f,g,h,i,j); // Enkel måte ja!

        // Comparator som egen klasse
        pr.sortPersons(new NameLengthSorter());
        pr.sortPersons(new NameComparator());
        System.out.println(pr);
        // Vi kan lage en Comparatorklasse inni denne klassen!
        Comparator<Person> pcomp = new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
            
        };
        pr.sortPersons(pcomp);

        // Anonym indre klasse
        pr.sortPersons(new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }

        });

        System.out.println(pr);
        // Comparator som lambda
        Comparator<Person> comp = (p1, p2) -> p1.getName().compareTo(p2.getName());
        pr.sortPersons(comp);
        // Kan like gjerne gjøres direkte:
        pr.sortPersons((p1, p2) -> p1.getName().compareTo(p2.getName()));
        System.out.println(pr);


        // Predikater:
        // Finn første person med alder over 17 år
        System.out.println(pr.findFirst(p -> p.getAge() > 17));
        // Alle over 17 år
        System.out.println("Over 17:" +pr.findAll(p -> p.isAdult()));
        System.out.println("Over 17:" +pr.findAll(Person::isAdult));
        // Finn alle som har navn lenger enn 5 tegn
        System.out.println(pr.findAll(p -> p.getName().length() > 5));

        // Consumer:
        System.out.println("Consumers:");
        pr.forEachPerson(new Consumer<Person>() {

            @Override
            public void accept(Person p) {
                System.out.println(p);
            }

        });
        // // Samme som
        // pr.forEachPerson(p -> System.out.println(p));
        // // Samme som
        // pr.forEachPerson(System.out::println);

        // Function:
        System.out.println("Function:");
        System.out.println(pr.getPersonProperties(new Function<Person,String>() {

            @Override
            public String apply(Person p) {
                return p.getName();
            }
            
        }));
        // Samme som
        System.out.println(pr.getPersonProperties(p -> p.getName()));


        // Navnene på alle over 17
        Collection<String> names = new ArrayList<>();
        for (Person person : pr) {
            if (person.getAge() > 17)
                names.add(person.getName());
        }
        System.out.println(names);
        System.out.println(pr.persons.stream()
            .filter(p -> p.getAge() > 17)
            .map(p -> p.getName() + ":"+p.getAge())
            .toList());
    }

    

}
