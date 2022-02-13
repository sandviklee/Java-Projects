package uke6.kino3;

public class Sal {
	
	String navn;
	int plasser;
	
	
	public String getNavn() {
		return navn;
	}


	public int getPlasser() {
		return plasser;
	}


	@Override
	public String toString() {
		return "Sal [navn=" + navn + ", plasser=" + plasser + "]";
	}


	public Sal(String navn, int plasser) {
		super();
		this.navn = navn;
		this.plasser = plasser;
	}
	

}
