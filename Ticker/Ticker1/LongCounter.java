class LongCounter extends Thread {

	public void run() {
		for (int i = 0; i < 10000000; i++){
			if (i == 6000000)
				System.out.println("Counter: " + i);
		}
		System.out.println("Counter finished.");
	}
}
