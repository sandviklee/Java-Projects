package uke4;

public class Bok {
    
    private String tittel;
    private int sider;
    private int hvor;


    

    public Bok(String inntittel, int sider) {
        super();
        System.out.println("Inni konstruktør med parametre");
        this.tittel = inntittel;
        this.sider = sider;
    }

    public Bok() {
    }


    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public int getSider() {
        return sider;
    }

    public void setSider(int sider) {
        this.sider = sider;
    }

    public int getLest() {
        return this.hvor;
    }

    public void lest(int antall) {
        if (hvor + antall > sider) {
            System.out.println("Du kan ikke lese så langt.");
            throw new IllegalArgumentException("Ikke så mange sider");
        }
        this.hvor += antall;   
    }

    @Override
    public String toString() {
        return "Bok [hvor=" + hvor + ", sider=" + sider + ", tittel=" + tittel + "]";
    }

    public static void main(String[] args) {
        Bok bok = new Bok();
        bok.setTittel("Mikke og vennene hans på tur.");
        bok.setSider(32);
        Bok bok2 = new Bok("Das Kapital", 517);
        
        System.out.println(bok);
        System.out.println(bok2);
        bok2.lest(20);
        System.out.println(bok2);

        try {
            bok2.lest(204444);            
        }
        catch (Exception ex) {
            System.out.println("Unntak utløst: "+ex);
        }

        System.out.println(bok2);
    }
    
}
