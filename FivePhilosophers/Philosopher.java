public class Philosopher implements Runnable{

	private Object left;
	private Object right;

	public Philosopher(Object left, Object right){
		this.left = left;
		this.right = right;
	}

	private void thinking(String s) throws InterruptedException{
		System.out.println(Thread.currentThread().getName() + " " + s);
		Thread.sleep(((int) (Math.random() * 100)));
	}
 
	public void run(){
		
		try{
			while(true){
				thinking(System.nanoTime() + "- Thinking.");
				synchronized(left){
					thinking(System.nanoTime() + "- Picked up left fork.");
					synchronized(right){
						thinking(System.nanoTime() + "- Picked up right fork - eating.");
						thinking(System.nanoTime() + "- Put down right fork.");
					}
				}
				thinking(System.nanoTime() + "- Put down left fork - thinking.");
			}
		}catch(InterruptedException e){
			Thread.currentThread().interrupt();
			return;
		}
	}
}
