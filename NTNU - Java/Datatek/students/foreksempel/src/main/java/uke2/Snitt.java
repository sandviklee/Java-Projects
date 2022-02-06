package uke2;

public class Snitt {
    
    int sum, antall;

    public void leggTil(int tall) {
        sum += tall;
        antall += 1;
    }

    public int hentSnitt() {
        return sum/antall;
    }

    @Override
    public String toString() {
        return "Snitt [antall=" + antall + ", sum=" + sum + "]";
    }

    public static void main(String[] args) {
        Snitt snitt = new Snitt();
        snitt.leggTil(12);
        snitt.leggTil(3);
        System.out.println(snitt.hentSnitt());
        snitt.leggTil(122);
        snitt.leggTil(33);
        System.out.println("Snittet er nå "+snitt.hentSnitt());
    }
    
}
