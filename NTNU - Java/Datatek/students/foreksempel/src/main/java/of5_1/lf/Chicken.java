package of5_1.lf;

public class Chicken implements Animal {

    private int age;
    private String name;

    public Chicken(String name, int age) {
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
        return name + " sier klukk!";
    }

}
