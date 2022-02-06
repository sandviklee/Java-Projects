package kortforklart;

import java.util.ArrayList;
import java.util.List;

public class AthleteMany {
	
	
	private String name;
	private List<MedalMany> medals = new ArrayList<>();
	
	public AthleteMany(String name) {
		this.name = name;
	}
	
	public void addMedal(MedalMany medal) {
		if (!this.hasMedal(medal)) {
			this.medals.add(medal);
		}
		if (!medal.hasAthlete(this)) {
			medal.addAthlete(this);
		}
	}
	
	public void removeMedal(MedalMany medal) {
		this.medals.remove(medal);
	}
	
	public boolean hasMedal(MedalMany medal) {
		return this.medals.contains(medal);
	}
	
	
	public static void main(String[] args) {
		AthleteMany athlete1 = new AthleteMany("Johannes Thingnes Bø");
		AthleteMany athlete2 = new AthleteMany("Tarjei Bø");
		MedalMany medal = new MedalMany("Gold");
		medal.addAthlete(athlete1);
		medal.addAthlete(athlete2);

	}
}
