class Counter4 implements Runnable {

	public void run() {

		for(int i = 0; i < 10; i++)
			if(i == 7)
				System.out.println("Counter: " + i);

		System.out.println("Counter finished.");

	}

	public static void main(String[] args) {

		Counter4 c = new Counter4();
		Thread t = new Thread(c);
		System.out.println("Counter created.");

		t.start();
		System.out.println("Counter started.");

		System.out.println("Main finished.");
	
	}
}
