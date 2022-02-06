package uke3.fasit;

public class Fakultet {
    static int fak(int n) {
        if (n <= 1) {
            return 1;
        }
        int n1 = fak(n-1);
        return n * n1;
    }

    public static void main(String[] args) {
        System.out.println(Fakultet.fak(3));
        System.out.println(Fakultet.fak(4));
        System.out.println(Fakultet.fak(5));
        System.out.println(Fakultet.fak(6));
    }
    
}
