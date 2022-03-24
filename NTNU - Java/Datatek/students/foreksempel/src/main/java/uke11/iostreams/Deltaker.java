package uke11.iostreams;

public class Deltaker {

	// Helt vanlig fil -  settere og gettere, konstrukt�r alt autogenerert.
	String name, holdbreath;
	int poker, balloonshooting, sausageeating;
	double highjump;
	
	@Override
	public String toString() {
		return "Deltaker [name=" + name + ", holdbreath=" + holdbreath + ", poker=" + poker + ", balloonshooting="
				+ balloonshooting + ", sausageeating=" + sausageeating + ", highjump=" + highjump + "]";
	}
	public String getName() {
		return name;
	}
	public String getHoldbreath() {
		return holdbreath;
	}
	public int getPoker() {
		return poker;
	}
	public int getBalloonshooting() {
		return balloonshooting;
	}
	public int getSausageeating() {
		return sausageeating;
	}
	public double getHighjump() {
		return highjump;
	}
	public Deltaker() {
		super();
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setHoldbreath(String holdbreath) {
		this.holdbreath = holdbreath;
	}
	public void setPoker(int poker) {
		this.poker = poker;
	}
	public void setBaloonshooting(int balloonshooting) {
		this.balloonshooting = balloonshooting;
	}
	public void setSausageeating(int sausageeating) {
		this.sausageeating = sausageeating;
	}
	public void setHighjump(double highjump) {
		this.highjump = highjump;
	}
	public Deltaker(String name, int poker, double highjump, int balloonshooting, int sausageeating, String holdbreath) {
		super();
		this.name = name;
		this.poker = poker;
		this.highjump = highjump;
		this.balloonshooting = balloonshooting;
		this.sausageeating = sausageeating;
		this.holdbreath = holdbreath;
	}
	
}
