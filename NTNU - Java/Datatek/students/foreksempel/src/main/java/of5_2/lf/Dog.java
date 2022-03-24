package of5_2.lf;

public class Dog implements Animal {

    private int age;
    private String name;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String makeSound() {
        return name + " sier bjeff!";
    }

    @Override
    public int compareTo(Animal other) {
        return this.getAge() - other.getAge();
    }

}
