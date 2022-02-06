package kortforklart;

public class SnowPlough implements SnowListener{
	
	public void cmofSnowChanged(int oldCm, int newCm, SkiResort skiResort) {
		if (newCm > oldCm) {
			System.out.println("ut å måke");
		}
		else {
			System.out.println("Slapp av");
		}
	}

}
