import java.util.Date;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Date start = new Date();
		PrimeNumbers primeNumbers = new PrimeNumbers();
		Integer max = Integer.parseInt(args[0]);
		primeNumbers.generateNumbers(max);
		Date end = new Date();
		System.out.println("Elapsed time was " + (end.getTime() - start.getTime()) +" ms.");
	}

}
