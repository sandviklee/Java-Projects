package uke6.arv;

public class Bok {
    

    String tittel;
    String forfatter;
    int sider;
    

    public String getTittel() {
        return this.tittel;
    }

    public String getForfatter() {
        return this.forfatter;
    }

    public int getSider() {
        return this.sider;
    }

    public void setForfatter(String forfatter) {
        this.forfatter = forfatter;
    }

    public Bok(String tittel, String forfatter, int sider) {
        this.tittel = tittel;
        this.forfatter = forfatter;
        this.sider = sider;
    }


    @Override
    public String toString() {
        return getTittel() + ":" +
            getForfatter() +", sider=" + getSider();
    }


    public static void main(String[] args) {
        Bok bok = new Bok("Illiaden", "Homer", 398);
        System.out.println(bok);
        Bok bok2 = new Bok("Odysseen", "Homer", 362);
        System.out.println(bok2);

    }
    
    
}
