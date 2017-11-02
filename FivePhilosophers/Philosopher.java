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
				thinking("- Thinking");
				synchronized(left){
					thinking("- Picked up left fork");
					synchronized(right){
						thinking("- Picked up right fork - Eating");
						thinking("- Put down right fork");
					}
				}
				thinking("- Put down left fork - Thinking");
			}
		}catch(InterruptedException e){
			Thread.currentThread().interrupt();
			return;
		}
	}
}
