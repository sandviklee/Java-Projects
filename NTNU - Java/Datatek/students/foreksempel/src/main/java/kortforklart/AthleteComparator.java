package kortforklart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AthleteComparator implements Comparator<Athlete>{

	@Override
	public int compare(Athlete o1, Athlete o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
	public static void main(String[] args) {
		Athlete athlete1 = new Athlete("1");
		Athlete athlete2 = new Athlete("2");
		
		List<Athlete> athletes = new ArrayList<>();
		athletes.add(athlete1);
		athletes.add(athlete2);
		Collections.sort(athletes, new AthleteComparator());
		
	}

}
