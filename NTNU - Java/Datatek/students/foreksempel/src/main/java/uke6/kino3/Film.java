package uke6.kino3;

public class Film {
	
	String name;
	int alder;
	String nasjonalitet;
	
	
	public Film(String name, int alder, String nasjonalitet) {
		super();
		this.name = name;
		this.alder = alder;
		this.nasjonalitet = nasjonalitet;
	}


	public static void main(String[] args) {
		
		Film alexander = new Film("Alexander", 15, "USA");
		Film badsanta = new Film("Bad Santa", 11, "USA");
		System.out.println(alexander);
		System.out.println(badsanta);
		
	}


	@Override
	public String toString() {
		return "Film [name=" + name + ", alder=" + alder + ", nasjonalitet=" + nasjonalitet + "]";
	}
	
}
