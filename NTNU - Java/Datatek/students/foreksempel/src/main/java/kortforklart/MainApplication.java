package kortforklart;

public class MainApplication {
	
	
	public static void main(String[] args) {
		ExamResult examResult = new ExamResult("100");
		examResult.setResult("A");
		System.out.println(examResult.getResult());
	}
}
