package uke3;

public class Eier {
    
    Bil bil;

    public Bil getBil() {
        return bil;
    }

    public void setBil(Bil bil) {
        this.bil = bil;
    }

    public static void main(String[] args) {
        Eier eier = new Eier();
        Bil bil = new Bil();
        bil.setType("Fård");
        System.out.println(bil.getType());
    }
    
}
