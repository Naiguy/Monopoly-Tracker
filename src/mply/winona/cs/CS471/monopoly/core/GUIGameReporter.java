package mply.winona.cs.CS471.monopoly.core;

import java.util.Observable;
import java.util.Observer;

public class GUIGameReporter implements Observer {
	String current = "";
	@Override
	public void update(Observable changedObject, Object changedDescription) {
		System.out.println("The CounterObserver was notified of :"+changedDescription);
		current = (String) changedDescription;
	}
	public String getCurrent() {
		return current;
	}
	public void setCurrent(String current) {
		this.current = current;
	}
		

}
