package kortforklart;

public class Moccamaster implements CoffeeMaker {

	@Override
	public void makeCoffee() {
		System.out.println("Insert water and filter with coffee to make coffee");
		
	}
	
	public void cleanCoffeeMaker() {
		System.out.println("Cleaning moccamaster");
	}

}
