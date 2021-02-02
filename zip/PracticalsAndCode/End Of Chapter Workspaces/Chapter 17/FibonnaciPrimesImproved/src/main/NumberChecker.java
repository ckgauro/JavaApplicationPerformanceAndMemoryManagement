package main;

public class NumberChecker {

	public Boolean isPrime(int testNumber) {
		int maxToCheck = (int)Math.sqrt(testNumber);
		for (int i = 2; i <= maxToCheck; i++) {
			if (testNumber % i == 0) return false;
		}
		return true;
	}
	
	
}
