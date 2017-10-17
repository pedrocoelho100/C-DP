class CounterYield1 extends Thread {

	public void run() {

		for(int i = 0; i < 1000000; i++){
			System.out.println("Counter: " + i);
			if(i % 2 == 0) yield();
			if (interrupted()) break;
		}
		System.out.println("Counter finished.");

	}

	public static void main(String[] args) throws InterruptedException {

		CounterYield1 c = new CounterYield1();
		System.out.println("Counter created.");

		c.start();
		System.out.println("Counter started.");

		Thread.sleep(1);
		c.interrupt();

		System.out.println("Main finished.");

	}
}
