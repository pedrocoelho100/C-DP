public class TickerDemo {

	public static void main(String[] args){

		Ticker ticker = new Ticker(2);
		LongCounter counter = new LongCounter();

		ticker.start();
		counter.start();

		System.out.println("Main thread finished.");

	}
}
