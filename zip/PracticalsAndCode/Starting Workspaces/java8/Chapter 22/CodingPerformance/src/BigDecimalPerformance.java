import java.math.BigDecimal;

public class BigDecimalPerformance {

	private BigDecimal addNumbers1(long howMany){
		BigDecimal result = BigDecimal.ZERO;
		BigDecimal adder = new BigDecimal(17.31);
		for (long l = 0; l<=howMany; l++) {
			result = result.add(adder);
		}
		return (result);
	}
	
	private BigDecimal addNumbers2(long howMany){
		Double result = 0d;
		Double adder = 17.31d;
		for (long l = 0; l<=howMany; l++) {
			result = result + adder;
		}
		return (new BigDecimal(result));
	}
	
public void run()  {
				
		System.out.println("warm up period starting");
		addNumbers2(1000l);
		
		System.out.println("warm up period done");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println("measurement period starting");
		
		long start = System.currentTimeMillis(); 
		addNumbers2(1000000l);
		long end = System.currentTimeMillis();
		System.out.println("measurement period done");
		System.out.println("time taken to add 1,000,000 numbers: " + (end - start) + " milliseconds");
	}
}

