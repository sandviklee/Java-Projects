package uke4.fasit;

public class A {
    
    int maxNumber = 10;
    int number;

    public void setTall(int num) {
        if (num > maxNumber) {
            throw new IllegalArgumentException(num+" is too large.");
        }
        else number = num;
    }

    public int getNumber() {
        return number;
    }
}
