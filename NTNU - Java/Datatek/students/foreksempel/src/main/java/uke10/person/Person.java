package uke10.person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Person implements Iterable<Person>{

	Collection<Person> children = new ArrayList<>();
	@Override
	public String toString() {
		return String.format("%s (%d)",name, age);
	}


	String name;
	int age;
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public void addChild(Person child) {
		children.add(child);
	}

	@Override
	public Iterator<Person> iterator() {
		return children.iterator();
	}
	
	
	public static void main(String[] args) {
		Person p = new Person("Børge", 46);
		Person j = new Person("Jørn", 13);
		Person h = new Person("Håvard", 11);
		
		p.addChild(j);
		p.addChild(h);
		
		// System.out.println(p);
		

		for (Person barn : p) {
			System.out.println(barn);
		}

		System.out.println("-----------------");
		Iterator<Person> ci = p.iterator();
		while (ci.hasNext()) {
			Person barn = ci.next();
			System.out.println(barn);
		}
		

	}
}
