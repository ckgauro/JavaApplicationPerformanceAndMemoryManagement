import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StringBuilderPerformance {

	String[] firstNames = {"Adam","Bill","Carey","Delia","Emma","Frank","Gillian","Harold"};
	String[] middleNames = {"Irene","Jill","Kevin","Leanne","Mike","Nick","Orphelia","Pete"};
	String[] surnames = {"Green","White","Black","Brown","Purple","Yellow","Pink","Orange"};
	
	private String generateNames1() {
		Random r = new Random();
		String result = firstNames[r.nextInt(8)];
		result = result + " ";
		result = result + middleNames[r.nextInt(8)];
		result = result + " ";
		result = result + surnames[r.nextInt(8)];
		result = result + " and ";
		result = result + firstNames[r.nextInt(8)];
		result = result + " ";
		result = result + middleNames[r.nextInt(8)];
		result = result + " ";
		result = result + surnames[r.nextInt(8)];
		return (result);
	}
	
	private String generateNames2() {
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		sb.append(firstNames[r.nextInt(8)]);
		sb.append(" ");
		sb.append(middleNames[r.nextInt(8)]);
		sb.append(" ");
		sb.append(surnames[r.nextInt(8)]);
		sb.append(" and ");
		sb.append(firstNames[r.nextInt(8)]);
		sb.append(" ");
		sb.append(middleNames[r.nextInt(8)]);
		sb.append(" ");
		sb.append(surnames[r.nextInt(8)]);
		return sb.toString();
	}
		
public void run()  {
				
		System.out.println("warm up period starting");
		for (int i=1; i < 50000; i++)
			generateNames1();
		
		System.out.println("warm up period done");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println("measurement period starting");
		
		long start = System.currentTimeMillis(); 
				for (int i=1; i < 500000; i++)
					generateNames1();
		long end = System.currentTimeMillis();
		System.out.println("measurement period done");
		System.out.println("time taken to generate 500,000 names: " + (end - start) + " milliseconds");
	}
}
