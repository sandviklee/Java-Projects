package kortforklart;

import java.util.ArrayList;
import java.util.List;

public class Athlete implements Comparable<Athlete>{
	
	
	private String name;
	private List<Medal> medals = new ArrayList<>();
	
	public Athlete(String name) {
		this.name = name;
	}
	
	public void addMedal(Medal medal) {
		if (this.hasMedal(medal)) {
			this.medals.add(medal);
		}
		if (medal.getAthlete() != this) {
			medal.setAthlete(this);
		}
	}
	
	public void removeMedal(Medal medal) {
		this.medals.remove(medal);
	}
	
	public boolean hasMedal(Medal medal) {
		return this.medals.contains(medal);
	}
	
	public String getName() {
		return this.name;
	}
	
	
	public static void main(String[] args) {
		Athlete athlete1 = new Athlete("Johannes Thingnes Bø");
		Athlete athlete2 = new Athlete("Tarjei Bø");
		Medal medal = new Medal("Gold");
		medal.setAthlete(athlete1);
		athlete2.addMedal(medal);
	}
	
	@Override
	public int compareTo(Athlete o) {
		// Positivt tall hvis this er større enn o 
		// 0 hvis de er like
		// Negativt tall hvis this er mindre enn o. 
		return this.medals.size() - o.medals.size();
	}
}
