public class Philosopher2 extends Thread{

	private int nPhilosopher;
	private Fork left;
	private Fork right;
	private String name;

	public Philosopher2(int nPhilosopher, String name, Fork left, Fork right){
		this.nPhilosopher = nPhilosopher;
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
				print("- Thinking");
				Thread.sleep(((int) (Math.random() * 100)));
				if(nPhilosopher % 2 == 1){
					print("- Picked up left fork");
					left.putUp();
					print("- Picked up right fork");
					right.putUp();
				}
				else{
					if(nPhilosopher == 4){
						print("- Picked up right fork");
						right.putUp();
					}
					else{
						print("- Picked up left fork");
						left.putUp();
						print("- Picked up right fork");
						right.putUp();
					}
				}
				print("- Eating");
				Thread.sleep(((int) (Math.random() * 100)));
				print("- Put down left fork");
				left.putDown();
				print("- Put down right fork");
				right.putDown();
				print("- Thinking");
			}

		}catch(InterruptedException e){
			Thread.currentThread().interrupt();
			return;
		}
	}
}
