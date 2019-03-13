package mply.winona.cs.CS471.monopoly.test;

public class ObserverMain {

	public static void main(String[] args) {
		System.out.println("This is a simple class that creates an observer that ");; 
		System.out.println("observes an observable object");
		
		System.out.println("Creating an observer");
		CounterObserver observer = new CounterObserver(); 
		
		System.out.println("Creating the observable counter");
		CounterObservable counter = new CounterObservable(0); 
		
		System.out.println("Telling the observable about the observer");; 
		counter.addObserver(observer);
		
		System.out.println("Looping and incrementing the counter");
		System.out.println("We should be notified of the change by the Observer");
		
		for (int i = 0; i < 100; i++) {
			counter.increment();
		}

		System.out.println("The test is done");
		
	}

}
