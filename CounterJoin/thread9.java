class CounterJoin1 extends Thread {

	public void run() {

		for(int i = 0; i < 10; i++)
			System.out.println("Counter: " + i);

		System.out.println("Counter finished.");

	}

	public static void main(String[] args) {

		CounterJoin1 c = new CounterJoin1();
		System.out.println("Counter created.");

		c.start();
		System.out.println("Counter started.");

		try {
			c.join();  // Give a timeout
			System.out.println("Main finished.");
		} catch(InterruptedException e) {
			System.out.println("Stopped!");
		}
	}
}
