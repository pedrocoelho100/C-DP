class NamedCounter extends Thread {

	public NamedCounter (String name)
	{ super(name); }

	public void run() {

		for(int i = 0; i < 10; i++)
			if(i % 2 != 0)
				System.out.println("Odd numbers -> " + getName() + ": " + i);

		System.out.println("Counter " + getName() + " finished.");

	}

	public static void main(String[] args) {

		NamedCounter c1 = new NamedCounter("John");
		NamedCounter c2 = new NamedCounter("Peter");
		NamedCounter c3 = new NamedCounter("Sam");
		c1.start();
		c2.start();
		c3.start();

	}

}
