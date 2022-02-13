package uke6.kino3;


public class Filmvisning {

	Sal sal;
	String tid;
	int pris;
	Film film;

	/**
	 * Denne tar inn en Film. Det betyr at en må lage Film-objekter på utsiden av Filmvisning, og så sende
	 * dem inn når en lager en visning.
	 * @param sal
	 * @param tid
	 * @param pris
	 * @param film
	 */
	public Filmvisning(Sal sal, String tid, int pris, Film film) {
		super();
		this.sal = sal;
		this.tid = tid;
		this.pris = pris;
		this.film = film;
	}


	@Override
	public String toString() {
		return "Filmvisning [sal=" + sal + ", tid=" + tid + ", pris=" + pris + ", film=" + film + "]";
	}

	

}
