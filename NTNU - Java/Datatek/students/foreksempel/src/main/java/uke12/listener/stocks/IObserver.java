package uke12.listener;

public interface IObserver {
    public void update(IObservable subject, String what);
}
