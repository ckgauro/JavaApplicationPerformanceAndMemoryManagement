package main;

public class PrimativesPerformance {

	private long addNumbers1(long howMany){
		long result = 0;
		for (long l = 0; l<=howMany; l++) {
			result = result + 17l;
		}
		return (result);
	}
	
	private long addNumbers2(Long howMany){
		Long result = 0l;
		Long adder = 17l;
		for (long l = 0; l<=howMany; l++) {
			result = result + adder;
		}
		return (result);
	}
	
public void run()  {
				
		System.out.println("warm up period starting");
		addNumbers1(1000l);
		
		System.out.println("warm up period done");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println("measurement period starting");
		
		long start = System.currentTimeMillis(); 
		addNumbers1(1000000l);
		long end = System.currentTimeMillis();
		System.out.println("measurement period done");
		System.out.println("time taken to add 1,000000 longs: " + (end - start) + " milliseconds");
	}
}

