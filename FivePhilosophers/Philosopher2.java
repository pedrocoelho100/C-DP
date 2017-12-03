import java.util.*;

public class Philosopher2 extends Thread{

	private Fork left;
	private Fork right;
	private String name;
	private static Random randnum = new Random();

	public Philosopher2(String name, Fork left, Fork right){
		this.name = name;
		this.left = left;
		this.right = right;
	}

	private void print(String s) throws InterruptedException{
		System.out.println(Thread.currentThread().getName() + " " + s);
	}
	
	public void run(){
		
		try{
			while(true){
				Thread.sleep(300*randnum.nextInt(6));
				print("- Thinking");
				synchronized(left){
					Thread.sleep(300);
					print("- Picked up left fork");
					synchronized(right){
						Thread.sleep(300);
						print("- Picked up right fork - Eating");
						Thread.sleep(300);
						print("- Put down right fork");						
					}
				}
				Thread.sleep(300);
				print("- Put down left fork - Thinking");	
			}
		}catch(InterruptedException e){
			Thread.currentThread().interrupt();
			return;
		}
	}
}
