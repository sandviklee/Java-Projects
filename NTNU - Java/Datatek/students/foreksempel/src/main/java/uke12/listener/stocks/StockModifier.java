package uke12.listener;

public class StockModifier implements Runnable {

    private String stockName;
    private StockObservable stockObservable;

    public StockModifier(String stockName, StockObservable stockObservable) {
        this.stockName = stockName;
        this.stockObservable = stockObservable;
    }

    @Override
    public void run() {
        
    }
    
}
