/**
 * @author Chandra
 */
import java.util.Date;
// to run from console java Main 10
//Compiler Flags
//-XX:+PrintCompilation
// java -XX:+PrintCompilation Main 10
//https://intellij-support.jetbrains.com/hc/en-us/articles/206544869-Configuring-JVM-options-and-platform-properties
public class Main {

    public static void main(String[] args) throws InterruptedException {

      //  Thread.sleep(5000);
        Date start=new Date();
        PrimeNumbers primeNumbers = new PrimeNumbers();
        Integer max = Integer.parseInt(args[0]);
       // Integer max = 5;
        primeNumbers.generateNumbers(max);
        Date end=new Date();
        System.out.println("Elapsed time was "+(end.getTime()-start.getTime())+" ms. ");
    }

}
