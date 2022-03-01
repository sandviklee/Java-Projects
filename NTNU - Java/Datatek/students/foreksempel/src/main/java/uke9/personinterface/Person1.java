package uke9.personinterface;


public class Person1 implements Person{
	private String fulltNavn;

	
	public String getFornavn() {
		return fulltNavn.substring(0, fulltNavn.indexOf(' '));
	}
	public void setFornavn(String fornavn) {
		fulltNavn = fornavn + " " + getEtternavn();
	}

	public String getEtternavn() {
		return fulltNavn.substring(fulltNavn.indexOf(' ') + 1);
	}
	public void setEtternavn(String etternavn) {
		fulltNavn = getFornavn() + " " + etternavn;
	}

	@Override
	public String getFulltnavn() {
		return fulltNavn;
	}
	@Override
	public void setFulltnavn(String fulltNavn) {
		this.fulltNavn = fulltNavn;
	}
	
}
