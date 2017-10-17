class LongCounter extends Thread {

	public void run() {
		for (int i = 0; i < 10000000; i++){
			if (i % 2000000 == 0)
				System.out.println("Even: " + i);
		}
		for (int j = 0; j < 10; j++){
			if (j % 2000000 != 0)
				System.out.println("Odd: " + j);
		}
		System.out.println("Counter finished.");
	}
}
