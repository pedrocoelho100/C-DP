public class Philosopher2 extends Thread{

	private Fork left;
	private Fork right;

	public Philosopher2(Fork left, Fork right){
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
				if(!left.used){
					if(!right.used){
						left.putUp();
						right.putUp();
						thinking(System.nanoTime() + "- Eating.");
						right.putDown();
						left.putDown();
					}
				}
				thinking(System.nanoTime() + "- Thinking.");
			}
		}catch(InterruptedException e){
			Thread.currentThread().interrupt();
			return;
		}
	}

}

class Fork{
	
	public boolean used;

	public synchronized void putUp(){
		this.used = true;
	}

	public synchronized void putDown(){
		this.used = false;
	}

}
