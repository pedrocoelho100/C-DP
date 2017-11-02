public class FivePhilosophers2{

	public static void main(String[] args) throws Exception{

		final Philosopher2[] philosophers = new Philosopher2[5];
		Fork[] forks = new Fork[philosophers.length];
 
		for(int i = 0; i < forks.length; i++)
			forks[i] = new Fork();
 
		for(int i = 0; i < philosophers.length; i++) {
			Fork left = forks[i];
			Fork right = forks[(i + 1) % forks.length];
 
			// philosophers[i] = new Philosopher(left, right);  deadlock

			if(i == philosophers.length - 1)
				philosophers[i] = new Philosopher2(right, left);			
			else
				philosophers[i] = new Philosopher2(left, right);

			Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
			t.start();
		}
	}
}
