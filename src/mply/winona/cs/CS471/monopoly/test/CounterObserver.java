package mply.winona.cs.CS471.monopoly.test;

import java.util.Observable;
import java.util.Observer;

public class CounterObserver implements Observer {
    public String information="This is a test"; 
    // String getInformation() { return information; }
    // void setInformation(String newValue) { information = newValue; }
    
    // This method gets called when overservable object is changed
	
	public void update(Observable changedObject, Object changedDescription) {
		System.out.println("The CounterObserver was notified of :"+changedDescription);
		
	}

}
