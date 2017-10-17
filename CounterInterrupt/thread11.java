class CounterInt2 implements Runnable {

	public void run() {

		for(int i = 0; i < 1000000; i++){
			while(!Thread.currentThread().isInterrupted()){
				System.out.println("Counter: " + i);
				if(Thread.currentThread().interrupted())
					break;
			}
		}
		System.out.println("Counter finished.");

	}

	public static void main(String[] args) throws InterruptedException {

		CounterInt2 c = new CounterInt2();
		Thread t1 = new Thread(c);
		System.out.println("Counter created.");

		t1.start();
		System.out.println("Counter started.");

		Thread.sleep(1);
		t1.interrupt();

		System.out.println("Main finished.");

	}
}
