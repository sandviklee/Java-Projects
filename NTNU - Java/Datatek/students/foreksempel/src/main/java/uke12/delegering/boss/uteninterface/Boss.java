package uke12.delegering.boss.uteninterface;

public class Boss extends Worker {

	Worker secretary = new Secretary();
	
	@Override
	public String work() {
		return secretary.work();
	}
	
	public static void main(String[] args) {
		Boss boss = new Boss();
		System.out.println(boss.work());
	}

}
