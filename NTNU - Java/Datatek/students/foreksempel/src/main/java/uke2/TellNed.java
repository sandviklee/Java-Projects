package uke2;

public class TellNed {

    int igjen;

    public TellNed(int igjen) {
        this.igjen = igjen;
    }

    public void start() {
        while (this.igjen >= 0) {
            System.out.println("Det er igjen "+this.igjen+" sekunder til forelesning. Omtrent.");
            this.igjen -= 1;
            try {Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Ferdig!");
    }
    public static void main(String[] args) {
        TellNed tellned = new TellNed(10);
        tellned.start();
    }
}
