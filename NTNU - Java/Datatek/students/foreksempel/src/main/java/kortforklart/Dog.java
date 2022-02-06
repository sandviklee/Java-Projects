package kortforklart;


public class Dog {
	
	private String name;
	private int age;
	private String breed;
	
	public Dog(String name, int age, String breed) {
		this.name = name;
		this.age = age;
		this.breed = breed;
	}
	
	public Dog(int age, String breed) {
		this.age = age;
		this.breed = breed;
	}
	
	public Dog(String breed) {
		this(0, breed);
	}
	
	
	public void bark() {
		System.out.println("Woof");
	}
	
	public int getDogYears() {
		return this.age * 7;
	}
	
	public String toString() {
		return "Hei, jeg heter " + name + " og er " + this.age + " år gammel";
	}
	
	
	public static void main(String[] args) {
		Dog pluto = new Dog("Pluto", 10, "Golden Retriever");
		pluto.bark();
		System.out.println(pluto.getDogYears());
		Dog tinka = new Dog("Puddel");
		
		System.out.println(pluto);
		System.out.println(tinka);
		
	}
	
}
