package uke6.kino;

public class Filmvisning {

	String filmtittel;
	String sal;
	int alder;
	String nasjonalitet;
	String tid;
	int pris;

	public Filmvisning(String filmtittel, String sal, int alder, String nasjonalitet, String tid, int pris) {
		this.filmtittel = filmtittel;
		this.sal = sal;
		this.alder = alder;
		this.nasjonalitet = nasjonalitet;
		this.tid = tid;
		this.pris = pris;
	}


	public String getFilmtittel() {
		return filmtittel;
	}


	public String getSal() {
		return sal;
	}


	public int getAlder() {
		return alder;
	}


	public String getNasjonalitet() {
		return nasjonalitet;
	}


	public String getTid() {
		return tid;
	}


	public int getPris() {
		return pris;
	}
	
	
	@Override
	public String toString() {
		return "Filmvisning [filmtittel=" + filmtittel + ", sal=" + sal + ", alder=" + alder + ", nasjonalitet="
				+ nasjonalitet + ", tid=" + tid + ", pris=" + pris + "]";
	}


	public static void main(String[] args) {
		Filmvisning fv1 = new Filmvisning("Alexander", "Nova 3", 15, "USA", "20:00", 85);
		Filmvisning fv2 = new Filmvisning("Alexander", "Prinsen 4", 15, "USA", "17:00", 85);
		Filmvisning fv3 = new Filmvisning("Alexander", "Prinsen 4", 15, "USA", "20:30", 85);
		
		System.out.println(fv1);
		System.out.println(fv2);
		System.out.println(fv3);
	}
	
}
