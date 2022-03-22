package uke12.boss.uteninterface;

public class Boss extends Worker {

	Worker secretary = new Secretary();
	
	@Override
	public String work() {
		return secretary.work();
	}
	
	public static void main(String[] args) {
		Boss boss = new Boss();
		System.out.println(boss.work());

		// Hvordan hadde dette sett ut uten bruk av interface?
		// Hvordan hadde det fungert å arve her?
	}

}
