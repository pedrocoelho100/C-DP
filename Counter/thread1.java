class Counter1 extends Thread {

	public void run() {

		for(int i = 0; i < 20; i++)
			if(i % 3 == 0) 
				System.out.println("Counter % 3: " + i);

		System.out.println("Counter finished.");

	}

	public static void main(String[] args) {

		Counter1 c = new Counter1();
		System.out.println("Counter created.");

		c.start();
		System.out.println("Counter started.");

		System.out.println("Main finished.");
	
	}
}
