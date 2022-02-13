package uke6.arv;

public class BarneBok extends Bok {

    int aldersgrense;

    public BarneBok(String tittel, String forfatter, int sider, int aldersgrense) {
        super(tittel, forfatter, sider);
        this.aldersgrense = aldersgrense;
    }


    // Vi bruker her Bok sin toString, og legger til litt mer informasjon:
    // I en subklasse kan vi referere til metoder fra superklassen, men ikke motsatt.
    @Override
    public String toString() {
        return super.toString() + ", aldersgrense:"+getAldersgrense();
    }


    private int getAldersgrense() {
        return aldersgrense;
    }


    public static void main(String[] args) {
        BarneBok bb = new BarneBok("Lillelord-trilogien ", "Johann Borgen",782, 13);
        System.out.println(bb);
        System.out.println(bb.getForfatter()); // Se hvilken getForfatter den bruker - Bok sin!

    }
    
    
}
