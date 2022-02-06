package of2.praktisk.lf;

public class ErrorProgram {
    
    private String myString;

    public ErrorProgram(String myString) {
        this.validateString();
        this.myString = myString;
    }

    private void validateString() {
        if (!myString.equals("valid")) {
            throw new IllegalArgumentException(">:(");
        }
    }

    public static void main(String[] args) {
        new ErrorProgram("HELLO");
    }
}
