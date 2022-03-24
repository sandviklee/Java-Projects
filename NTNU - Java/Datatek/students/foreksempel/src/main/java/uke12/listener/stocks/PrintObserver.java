package uke12.listener;

/**
 * Fryktelig enkel lytter (les FileObserver for en større forklaring)
 * Eneste ting som skjer ved update er at ting skrives ut til fil.
 */
public class PrintObserver implements IObserver {

    StockObservable observable;

    public PrintObserver(StockObservable observable) {
        this.observable = observable;
        observable.addListener(this);
    }

    @Override
    public void update(IObservable subject, String name) {
        System.out.println("Ny verdi for "+name+": "+
            subject.getValue(name));
    }
}
