package uke12.listener;

/**
 * Klassen er den som skal fyre i gang hele kostebinderiet.
 */
public class RunMe {
    public static void main(String[] args) {
        // Den som skal lyttes til, altså 'den observerte'.
        StockObservable so = new StockObservable();

        // Lage to lyttere, de må få inn hvem de skal lytte til, altså observatørene:
        PrintObserver po = new PrintObserver(so);
        FileObserver fo = new FileObserver(so);
        
        // Kjøre igang tråden som oppdaterer tilfeldige aksjer hvert sekund:
        so.run();
    }
}
