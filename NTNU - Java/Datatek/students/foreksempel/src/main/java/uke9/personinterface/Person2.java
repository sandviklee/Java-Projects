package uke9.personinterface;
public class Person2 implements Person{

	private String fornavn, etternavn;

	public String getFornavn() {
		return fornavn;
	}
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getFulltnavn() {
		return fornavn + " " + etternavn;
	}

	@Override
	public void setFulltnavn(String fulltNavn) {
		int pos = fulltNavn.indexOf(' ');
		setFornavn(fulltNavn.substring(0, pos));
		setEtternavn(fulltNavn.substring(pos + 1));
	}
}