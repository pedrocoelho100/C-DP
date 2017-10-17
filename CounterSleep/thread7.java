class CounterSleep3 implements Runnable {

	public void run() {

		for(int i = 0; i < 10; i++)
			System.out.println("Counter: " + i);
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			System.out.println("Interrupted.");
		}

		for(int i = 10; i < 20; i++)
			System.out.println("Counter: " + i);

		System.out.println("Counter finished.");

	}

	public static void main(String[] args) {

		Thread t = new Thread(new CounterSleep3());
		System.out.println("Counter created.");

		t.start();
		System.out.println("Counter started.");

		System.out.println("Main finished.");
	
	}
}
