import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class WordCount implements Runnable {

	private Scanner sc;
	private File file;
	private int count;
	private LinkedBlockingQueue<Integer> lbq;
	
	public WordCount(String text, LinkedBlockingQueue<Integer> linked) {
		file = new File(text);
		this.lbq = linked;
	}

	@Override
	public void run() {
		try {
			sc = new Scanner(new FileInputStream(file));

			while (sc.hasNext()) {
				sc.next();
				count++;
			}
			
			lbq.add(count);

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
