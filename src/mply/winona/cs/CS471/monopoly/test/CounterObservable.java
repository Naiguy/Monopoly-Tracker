package mply.winona.cs.CS471.monopoly.test;

import java.util.Observable;

public class CounterObservable extends Observable {
   int count; 
   
   public CounterObservable(int startCount) { 
	   count = startCount; 
   }
   
   // Note:  Because this extends Observable, we do not need to 
   // implement the addObserver method
   // 
   
   
   // Increment the counter and notify the observers that 
   // the count has incremented. 
   public void increment() {
	   count++; 
	   // Indicate that the object has been changed
	   setChanged();
	   // Notify the observers of the change
	   notifyObservers("The count is now "+count); 
   }
}
