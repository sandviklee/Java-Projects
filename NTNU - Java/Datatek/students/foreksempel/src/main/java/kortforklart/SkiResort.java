package kortforklart;

import java.util.ArrayList;
import java.util.Collection;

public class SkiResort {
	
	private int cmOfSnow;
	private String name;
	private Collection<SnowListener> listeners = new ArrayList<>();
	
	public SkiResort(String name) {
		this.name = name;
	}
	
	public void setCmOfSnow(int cmOfSnow) {
		this.fireStateChanged(this.cmOfSnow, cmOfSnow);
		this.cmOfSnow = cmOfSnow;
	}
	
	public void addListener(SnowListener listener) {
		if (!listeners.contains(listener)) {
			this.listeners.add(listener);
		}
	}
	
	public void removeListener(SnowListener listener) {
		this.listeners.remove(listener);
	}
	
	public void fireStateChanged(int oldState, int newState) {
		this.listeners.forEach(listener -> listener.cmofSnowChanged(oldState, newState, this));
		
	}
}
