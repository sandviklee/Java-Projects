package kortforklart;

import java.util.ArrayList;
import java.util.List;

public class CapsuleCoffeeMaker implements CoffeeMaker{

	@Override
	public void makeCoffee() {
		System.out.println("Insert a capsule and makes coffee");
		
	}
	
	public void cleanCapsules() {
		System.out.println("Cleaning capsules");
	}
	
	public static void main(String[] args) {
		CapsuleCoffeeMaker capsuleMaker = new CapsuleCoffeeMaker();
		Moccamaster moccaMaster = new Moccamaster();
		
		List<CoffeeMaker> coffeeMakers = new ArrayList<>();
		coffeeMakers.add(capsuleMaker);
		coffeeMakers.add(moccaMaster);
		
		for (CoffeeMaker coffeeMaker: coffeeMakers) {
			coffeeMaker.makeCoffee();
		}
	}

}
