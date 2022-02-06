package of1.lf;

import java.util.List;

public class Exam {

    private List<Character> allowedGrades = List.of('A', 'B', 'C', 'D', 'E', 'F');

    private char letterGrade;

    private String subjectName; // e.g. "Objektorientert programmering"

    private String subjectCode; // e.g. "TDT4100"


    public Exam(char letterGrade, String subjectName, String subjectCode) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.setLetterGrade(letterGrade);
    }


    public char getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(char letterGrade) {
        if (allowedGrades.contains(letterGrade)) {
            this.letterGrade = letterGrade;
        } else {
            throw new IllegalArgumentException("Ugyldig karakter");
        }
    }

    public boolean isPassed() {
        if (this.letterGrade != 'F') {
            return true;
        }
        return false;
    }

    public int getGpa() {

        return 5 - (Character.valueOf(this.letterGrade) - 65);
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    @Override
    public String toString() {
        return  this.subjectCode + "-" + this.subjectName + "  Grade: "+ this.letterGrade;
    }

    public static void main(String[] args) {
        Exam e1 = new Exam('A', "Objektorientert programmering", "TDT4100");
        System.out.println(e1);
        System.out.println(e1.isPassed());
        System.out.println(e1.getGpa());
        e1.setLetterGrade('F');
        System.out.println(e1);
        System.out.println(e1.isPassed());
        System.out.println(e1.getGpa());
        try {
            
            e1.setLetterGrade('G');
        } catch (Exception e) {
            System.out.println("Her ble det feil :(");
        }

    }

}
