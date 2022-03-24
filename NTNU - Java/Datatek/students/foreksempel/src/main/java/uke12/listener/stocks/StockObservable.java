package uke12.listener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StockObservable implements IObservable, Runnable {

    Collection<IObserver> listeners = new ArrayList<>();
    Map<String, Double> stocks = new HashMap<>();
    Random random = new Random();

    public StockObservable() {
        updateStock("Equinoor", 500.0);
        updateStock("DNBee", 250.0);
        updateStock("Kråkerøy fotballklubb ASA", 12.50);
    }

    public double getValue(String name) {
        return this.stocks.get(name);
    }

    // Oppdaterer verdien HashMap, fra 0 om den ikke fantes fra før.
    public void updateStock(String name, double value) {
        this.stocks.put(name, stocks.getOrDefault(name, 0.0) + value);
        notifyListeners(name); // NB: informer lytterne!
    }

    // De tre (typiske) metodene som må implementeres for en som blir observert.
    // Oppfyller i dette eksempelet også interfacet 'IObservable'  
    @Override
    public void addListener(IObserver listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removeListener(IObserver listener) {
        this.listeners.remove(listener);        
    }

    // Alle lyttere blir oppdatert - de får selv velge hva de vil gjøre med beskjeden.
    @Override
    public void notifyListeners(String what) {
        for (IObserver listener : listeners) {
            listener.update(this, what);
        }        
    }

    // Metoden som må implementeres for å støtte 'Runnable'. Er ikke pensum, viser bare
    // hvordan man kan fyre løs en tråd som kjører på egenhånd. Noen liker sliktno!
    @Override
    public void run() {

        for (int i = 0; i < 100; i++) { // Bare oppdatere aksjer 100 ganger.

            try { 
                Thread.sleep(1000); // Neste linje ser merkelig ut. Sånn er det!
                String[] keys = stocks.keySet().toArray(new String[stocks.size()]);
                String randomKey = keys[random.nextInt(keys.length)];
                updateStock(randomKey, random.nextDouble(20)-10);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
