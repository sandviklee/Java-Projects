package uke8.car;

import java.util.regex.Pattern;

public class Plate {

    String sign;

    public String getSign() {
        return sign;
    }

    // Jeg har gjort om denne til public etter forelesning. Rakk ikke vise eksempelet med Car2. Sjekk det ut!
    public static boolean checkSign(String sign) {
        return Pattern.matches("[A-Z]{2}[0-9]{5}", sign);
    }

    public Plate(String sign) {
        if (checkSign(sign)) {
            this.sign = sign;
        }
        else {
            throw new IllegalStateException("Feil i skilt "+sign);
        }
    }

    

    @Override
    public String toString() {
        return sign;
    }

    public static void main(String[] args) {
        Plate plate = new Plate("AA41383");
        System.out.println(plate);
        Plate plate2 = new Plate("AA41383675475");
        System.out.println(plate2);
    }
    
    
}
