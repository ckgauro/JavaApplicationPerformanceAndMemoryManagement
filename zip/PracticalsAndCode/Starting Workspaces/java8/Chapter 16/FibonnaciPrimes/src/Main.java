
public class Main {

	public static void main(String[] args) throws InterruptedException {
		int target = 100;
		
		PrimeNumbersTask primeNumbersTask = new PrimeNumbersTask();
		Thread primesGeneratorThread = new Thread(primeNumbersTask);
		primesGeneratorThread.start();
		primesGeneratorThread.setName("primesGeneratorThread");
		
		FibonnaciNumbersTask fibonnaciNumbersTask = new FibonnaciNumbersTask();
		Thread fibonnaciNumbersThread = new Thread(fibonnaciNumbersTask);
		fibonnaciNumbersThread.setName("fibonnaciNumbersThread");
		fibonnaciNumbersThread.start();
		
		CombinedNumbersTask combinedNumbersTask = new CombinedNumbersTask();
		combinedNumbersTask.setPrimeNumbersTask(primeNumbersTask);
		combinedNumbersTask.setFibonnaciNumbersTask(fibonnaciNumbersTask);
		Thread combinedNumbersThread = new Thread(combinedNumbersTask);
		combinedNumbersThread.start();
		combinedNumbersThread.setName("combinedNumbersThread");
		
		int combined = 0;
		int iterations = 0;
		while (combined < target) {
			iterations++;
			combined = combinedNumbersTask.getSize();
			
			if (combined > 100)  {
				primeNumbersTask.taskComplete();
				fibonnaciNumbersTask.taskComplete();
				combinedNumbersTask.taskComplete();
			}
			
			if (iterations > 200) {
				iterations = 0;
				System.out.println( "Currently got " + combined + " matching numbers.");
				if (combined > 0) combinedNumbersTask.printCombinedNumbers();
				Thread.sleep(1000);
			}
		}
		System.out.println("Job done  - found " + combined + ".");
		if (combined > 0) combinedNumbersTask.printCombinedNumbers();
	}

}
