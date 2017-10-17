class NamedCounter2 implements Runnable {

	public void run() {

		for(int i = 0; i < 10; i++)
			System.out.println("Counter " + Thread.currentThread().getName() + ": " + i);

		System.out.println("Counter " + Thread.currentThread().getName() + " finished.");

	}

	public static void main(String[] args) {

		Thread t1 = new Thread(new NamedCounter2(), "John");
		Thread t2 = new Thread(new NamedCounter2(), "Peter");
		Thread t3 = new Thread(new NamedCounter2(), "Sam");
		t1.start();
		t2.start();
		t3.start();

	}

}
