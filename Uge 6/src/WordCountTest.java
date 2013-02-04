import java.util.concurrent.LinkedBlockingQueue;

public class WordCountTest {
	public static void main(String[] args){
		
		final LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
		
		for(String s : args){
			WordCount wc = new WordCount(s, queue);
			Thread t = new Thread(wc);
			t.start();
		}
		
		int total = 0;
		for(String s : args){
			try {
				total += queue.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Total word count is: " + total);
		
		

	}
}
