package kortforklart;

import java.util.ArrayList;
import java.util.List;

public class MedalMany {
	
	private String metal;
	private List<AthleteMany> athletes = new ArrayList<>();
	
	public MedalMany(String metal) {
		this.metal = metal;
	}
	
	public void addAthlete(AthleteMany athlete) {
		if (!this.hasAthlete(athlete)) {
			this.athletes.add(athlete);
		}
		if (!athlete.hasMedal(this)) {
			athlete.addMedal(this);
		}
	}
	
	public void removeAthlete(AthleteMany athlete) {
		this.athletes.remove(athlete);
	}
	
	public boolean hasAthlete(AthleteMany athlete) {
		return this.athletes.contains(athlete);
	}
	
}
