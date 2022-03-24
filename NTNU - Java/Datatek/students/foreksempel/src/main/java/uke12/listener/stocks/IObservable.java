package uke12.listener;

public interface IObservable {
    
    public void addListener(IObserver listener);
    public void removeListener(IObserver listener);
    public void notifyListeners(String what);
    public double getValue(String what);

}
