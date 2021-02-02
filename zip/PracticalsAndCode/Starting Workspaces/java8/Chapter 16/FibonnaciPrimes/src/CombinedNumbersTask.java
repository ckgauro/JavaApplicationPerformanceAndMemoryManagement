import java.util.ArrayList;
import java.util.List;

public class CombinedNumbersTask implements Runnable {

	private FibonnaciNumbersTask fibonnaciNumbersTask;
	private PrimeNumbersTask primeNumbersTask;
	
	private List<Integer> primes = new ArrayList<Integer>();
	private List<Integer> fibonnacis = new ArrayList<Integer>();
	private List<Integer> combined = new ArrayList<Integer>();
	
	private Boolean finished;
	
	public void taskComplete() {
		finished = true;
	}
	
	public void printCombinedNumbers() {
		synchronized (this) {
			System.out.println(combined.toString());			
		}
	}
	
	public void printStatus() {
		System.out.println("primes : " + primes.size() + " fibs : " + fibonnacis.size());
	}
	
	public void setFibonnaciNumbersTask(FibonnaciNumbersTask fibonnaciNumbersTask) {
		this.fibonnaciNumbersTask = fibonnaciNumbersTask;
	}

	public void setPrimeNumbersTask(PrimeNumbersTask primeNumbersTask) {
		this.primeNumbersTask = primeNumbersTask;
	}
	
	public int getSize() {
		synchronized (this) {
			if (combined == null) return 0;
			return (combined.size());
		}
	}


	@Override
	public void run() {
		finished = false;
		
		while (!finished) {
			Integer prime = primeNumbersTask.getNextNumber();
			if (prime != null) primes.add(prime);
			Integer fib = fibonnaciNumbersTask.getNextNumber();
			if (fib != null) fibonnacis.add(fib);
			
			synchronized (this) {
				combined = new ArrayList<>(primes);
				combined.retainAll(fibonnacis);				
			}

		}
		
	}

}
