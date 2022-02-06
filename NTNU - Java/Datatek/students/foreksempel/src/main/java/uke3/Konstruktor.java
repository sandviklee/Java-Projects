package uke3;

public class Konstruktor {
    String navn;

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        if (navn.length() > 4) {
            this.navn = navn;
        }
        else {
            this.navn = "Forkort, så jeg valgte mitt eget";
        }
    }

    

    public Konstruktor() {
        System.out.println("Lages!");
    }

    
    public Konstruktor(String navn) {
        this.navn = navn;
    }

    public static void main(String[] args) {
        Konstruktor k = new Konstruktor();
        System.out.println(k.getNavn());
        Konstruktor k2 = new Konstruktor("Per");
        k2.setNavn("Ola Borten MOe");
        System.out.println(k2.getNavn());

    }
    
    
}
