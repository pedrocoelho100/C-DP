class CounterSleep1 extends Thread {

	public void run() {

		for(int i = 0; i < 10; i++)
			System.out.println("Counter: " + i);
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			System.out.println("Interrupted.");
		}

		System.out.println("Counter finished.");

	}

	public static void main(String[] args) {

		CounterSleep1 c = new CounterSleep1();
		System.out.println("Counter created.");

		c.start();
		System.out.println("Counter started.");

		System.out.println("Main finished.");
	
	}
}
