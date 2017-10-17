class Counter3 implements Runnable {

	public void run() {

		for(int i = -10; i < 10; i++)
			if(i > -3)
				System.out.println("Counter: " + i);

		System.out.println("Counter finished.");

	}

	public static void main(String[] args) {

		Counter3 c = new Counter3();
		Thread t = new Thread(c);
		System.out.println("Counter created.");

		t.start();
		System.out.println("Counter started.");

		System.out.println("Main finished.");
	
	}
}
