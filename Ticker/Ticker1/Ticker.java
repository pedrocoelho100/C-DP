public class Ticker extends Thread {

	private long time;
	public Ticker (long time) {

		super("Ticker " + time);
		this.time = time;
		setDaemon(true);
	}

	public void run(){

		try{
			while(true){
				sleep(time);
				System.out.println("======< tick >======");
			}
		} catch(InterruptedException e) {
			System.out.println("Ticker interrupted.");
		}
		System.out.println("Ticker finished.");
	}
}
