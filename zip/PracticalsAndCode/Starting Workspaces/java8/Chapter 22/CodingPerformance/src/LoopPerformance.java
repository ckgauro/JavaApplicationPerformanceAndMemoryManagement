import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LoopPerformance {

		String[] firstNames = {"Adam","Bill","Carey","Delia","Emma","Frank","Gillian","Harold"};
		String[] middleNames = {"Irene","Jill","Kevin","Leanne","Mike","Nick","Orphelia","Pete"};
		String[] surnames = {"Green","White","Black","Brown","Purple","Yellow","Pink","Orange"};
		
		private String generateName() {
			Random r = new Random();
			String result = firstNames[r.nextInt(8)] + " " + middleNames[r.nextInt(8)] + " " + surnames[r.nextInt(8)];
				return (result);
		}
		
	private long calculateLength1(List<String> names) {
		long length = 0;
		for (String name : names) {
			long nameLength = name.length();
			if (nameLength > 9) 
				length = length + name.length();
		}
		System.out.println(length);
		return length;
	}
	
	private long calculateLength2(List<String> names) {
		long length = 0;
		
		length = names.stream().mapToInt(s -> s.length()).filter(l -> l > 9) .sum();
		System.out.println(length);
		return length;
	}
			
	public void run()  {
		
		List<String> names = new ArrayList<String>();
		for (int i=1; i < 5000000; i++)
			names.add(generateName());
					
		System.out.println("warm up period starting");
		calculateLength1(names);
			
		System.out.println("warm up period done");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		System.out.println("measurement period starting");
		long start = System.currentTimeMillis(); 
		calculateLength1(names);		
		long end = System.currentTimeMillis();
		System.out.println("measurement period done");
		System.out.println("time taken to loop through 5,000,000 strings: " + (end - start) + " milliseconds");
	}
}
