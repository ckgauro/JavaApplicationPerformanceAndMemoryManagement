import java.util.ArrayList;
import java.util.List;

public class FibonnaciNumbersTask implements Runnable {

	private List<Integer> fibonnacis = new ArrayList<Integer>();
	private Boolean finished;

	public void taskComplete() {
		finished = true;
	}

	public int getSize() {
		synchronized (this) {
			return (fibonnacis.size());
		}
	}

	public Integer getNextNumber() {
		synchronized (this) {
			if (fibonnacis.size() >0) {
				return fibonnacis.remove(0);
			}
			else return null;
		}
	}


	@Override
	public void run() {
		finished = false;
		int a = 0;
		int b = 1;

		synchronized (this) {
			fibonnacis.add(a);
			fibonnacis.add(b);
		}

		while (!finished) {
			//only the add really needs to be synchronized.

			synchronized (this) {
				//we need to stop the fibonnaci numbers growing too quickly so we'll pause if there are > 100 waiting to be collected
				if (fibonnacis.size() < 100) {
					int c = a+b;
					fibonnacis.add(c);
					a = b;
					b = c;
				}
			}

		}

	}

}
