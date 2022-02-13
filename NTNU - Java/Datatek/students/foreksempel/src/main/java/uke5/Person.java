package uke5;

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
        this.name = name;
    }
    
    public Person() {
        this.name = "Wanda";
        this.age = 33;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return name+" ("+age+")";
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
