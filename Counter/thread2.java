class Counter2 extends Thread {

	public void run() {

		for(int i = 15; i > 0; i--)
			System.out.println("Counter: " + i);

		System.out.println("Counter finished.");

	}

	public static void main(String[] args) {

		Counter2 c = new Counter2();
		System.out.println("Counter created.");

		c.start();
		System.out.println("Counter started.");

		System.out.println("Main finished.");
	
	}
}
