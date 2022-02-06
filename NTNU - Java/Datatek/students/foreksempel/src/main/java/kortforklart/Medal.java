package kortforklart;

public class Medal {
	
	private String metal;
	private Athlete athlete;
	
	public Medal(String metal) {
		this.metal = metal;
	}
	
	public void setAthlete(Athlete athlete) {
		if (this.athlete != null) {
			this.athlete.removeMedal(this);
		}
		
		this.athlete = athlete;
		if (!athlete.hasMedal(this)) {
			athlete.addMedal(this);

		}
	}
	
	public Athlete getAthlete() {
		return this.athlete;
	}
	
}
