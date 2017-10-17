class CounterInt1 extends Thread {

	public void run() {

		for(int i = 0; i < 1000000; i++) {
			System.out.println("Counter: " + i);
			if(interrupted()) break;
		}

		System.out.println("Counter finished.");

	}

	public static void main(String[] args) throws InterruptedException {

		CounterInt1 c = new CounterInt1();
		System.out.println("Counter created.");

		c.start();
		System.out.println("Counter started.");

		Thread.sleep(1);
		c.interrupt();

		System.out.println("Main finished.");

	}
}
