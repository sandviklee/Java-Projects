package uke12.listener;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;

/**
 * Klassen abonnerer på endringer i en StockObservable. Jeg kunne ha latt den ta inn en
 * IObservable i konstruktøren, men da måtte jeg enten castet den til en SO, ELLER utvidet
 * interfacet IObservable med get-metoden, for å kunne hente ut verdiene. Det er jo en mulighet,
 * men her ville jeg holde interfacet smått.
 * 
 * Det som skjer når den får inn beskjed om endringer er å sjekke om endringene gjelder "Equinoor".
 * Hvis så, åpner den filen 'stocks.txt' som ligger i rota til prosjektet (scroll helt ned i explorer
 * i VS Code). Deretter skriver den ut én ny linje med aksjens nye verdi. DecimalFormat bruker jeg
 * for å vise en måte å formattere desimaltall.
 * 
 */
public class FileObserver implements IObserver {

    StockObservable observable;
    DecimalFormat df = new DecimalFormat("##.#");


    public FileObserver(StockObservable observable) {
        this.observable = observable;
        observable.addListener(this);
    }

    @Override
    public void update(IObservable subject, String what) {
        if (what.equals("Equinoor")) {

            // Denne ender opp i rota på prosjektet.
            try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("stocks.txt", true)))) {
                System.out.println();
                pw.print(what + ": "+df.format(subject.getValue(what))+"\n");
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }

        }
    }
    
}
