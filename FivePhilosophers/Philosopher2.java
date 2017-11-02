public class Philosopher2 extends Thread{

	private Fork left;
	private Fork right;
	private String name;
	private int state; // State 1 = Thinking, State 2 = Eating

	public Philosopher2(String name, Fork left, Fork right){
		this.state = 1;
		this.name = name;
		this.left = left;
		this.right = right;
	}

	private void thinking(String s) throws InterruptedException{
		this.state = 1;
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
						
						System.out.println(name + " - Eating");
						Thread.sleep(((int) (Math.random() * 100)));

						right.putDown();
						left.putDown();
					}
				}
				thinking("- Thinking");
			}
		}catch(InterruptedException e){
			Thread.currentThread().interrupt();
			return;
		}
	}

}

class Fork{
	
	public String name;
	public boolean used;

	public Fork(String name){
		this.name = name;
	}

	public synchronized void putUp(){
		System.out.println("Picked up the fork number " + name);
		this.used = true;
	}

	public synchronized void putDown(){
		System.out.println("Put down the fork number " + name);
		this.used = false;
	}

}
