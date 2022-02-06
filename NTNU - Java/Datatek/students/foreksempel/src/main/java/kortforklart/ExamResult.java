package kortforklart;

import java.util.Arrays;
import java.util.List;

public class ExamResult {
	
	private final String candidateId; // Skal aldri kunne endres 
	private String result; // Skal være A-F eller null 
	private int year; // 1900-2100
	private char semester; // Skal være S, H, V. 
	private String subject; 
	
	private static List<String> validResults = Arrays.asList("A", "B", "C", "D", "E", "F");
	
	
	
	public ExamResult(String candidateId) {
		this.candidateId = candidateId;
	}
	
	public ExamResult(String candidateId, String result) {
		this.candidateId = candidateId;
		this.setResult(result);
		
	}
	
	public boolean hasPassed() {
		return this.result.equals("F") && this.result != null;
	}

	public String getCandidateId() {
		return candidateId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		if (validResults.contains(result)) {
			this.result = result;
		}
		else {
			throw new IllegalArgumentException("Ikke gyldig resultat");
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year < 1900 || year > 2100) {
			throw new IllegalArgumentException("Ugyldig år");
		}
		this.year = year;
	}

	public char getSemester() {
		return semester;
	}

	public void setSemester(char semester) {
		if (semester != 'H' && semester != 'V' && semester != 'S') {
			throw new IllegalArgumentException("Ugyldig semester");
		}
		this.semester = semester;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
