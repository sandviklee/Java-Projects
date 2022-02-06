package uke4;

public class Person {
    String name;
    int age;

    public String getName() {
        return name;   
    }

    public int getAge() {
        return this.age;
    }
    
    public Person(String name) {
        this();
        System.out.println("Person: inni konst 2");
        this.name = name;
    }
    
    public Person() {
        System.out.println("Person: inni tom konstruktør");
        this.name = "Wanda";
        this.age = 33;
    }

    

    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + "]";
    }

    

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        // Person p1 = new Person();
        // System.out.println(p1.getAge());
        // System.out.println(p1.getName());
        Person p2 = new Person("Åge");
        System.out.println(p2);

        Person p3 = new Person("Ida", 12);
        System.out.println(p3);
    }
}
