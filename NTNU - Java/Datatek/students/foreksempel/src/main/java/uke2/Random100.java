package uke2;

import java.util.Random;

public class Random100 {

public int nextInt() {
    Random random = new Random();
    return random.nextInt(100);
}

    public static void main(String[] args) {
        Random100 ra = new Random100();
        System.out.println(ra.nextInt());
        

    }

}