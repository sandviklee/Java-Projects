package uke12.delegering.kokk;

public class Kokk1 implements Chef {


	@Override
	public String makeSauce() {
		return "honning";
	}

	@Override
	public String makeMain() {
		return "pannekaker";
	}

	@Override
	public String makePotatoes() {
		return "pommes frites";
	}

}
