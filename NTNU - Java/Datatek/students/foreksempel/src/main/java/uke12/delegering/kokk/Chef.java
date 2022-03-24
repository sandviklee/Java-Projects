package uke12.delegering.kokk;


/*
 * Grensesnittet som enhver kokk må oppfylle.
 * Hovedkokken ChefdelaChef og underkokkene fyller alle denne rollen.
 */
public interface Chef {
	public String makeMain();
	public String makePotatoes();
	public String makeSauce();
}
