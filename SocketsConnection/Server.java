import java.net.*;
import java.io.*;

public class Server extends Thread {

	private Socket csocket;

	public Server(Socket socket){
		this.csocket = socket;
	}

	public void run() {

		try{
				
			PrintWriter out = new PrintWriter(csocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(csocket.getInputStream()));
			BufferedReader readMsg = new BufferedReader(new InputStreamReader(System.in));
		 
		      	String receive, send;
             
		      	while(true){
				if((receive = in.readLine()) != null){  // Receive from client
			   		System.out.println("Client : " + receive);  // Print message       
				}   
				send = readMsg.readLine();  // Read from keyboard
				out.println(send);  // Send to client           
				out.flush();  // Flush data
		      	}

		} catch(IOException e) {
			e.printStackTrace();
		} finally {
		  try { csocket.close(); }
		  catch(IOException e) { e.printStackTrace(); }
		}   
	}
}   
