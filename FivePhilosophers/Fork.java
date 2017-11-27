class Fork{
	
	private boolean available;

	public Fork(boolean available){
		this.available = available;
	}

	public synchronized void putUp() throws InterruptedException {
		while(!available){
			wait();
		}
		this.available = false;
	}

	public synchronized void putDown(){
		this.available = true;
		notifyAll();
	}

}
