package uke3;

public class Xyz {

    static int x(int n1, int n2) {
        return n1 + n2;
    }
    static int y(int n1, int n2){ 
        return n1 - n2;
    }
    static int z(int a, int b, int c){
        int n1 = x(a, b);
        int n2 = y(n1, c);
        return n2;
    }

    public static void main(String[] args) {
        System.out.println(z(1, 2, 3));
    }

}
