import java.net.*;
import java.io.*;

public class Server extends Thread {

	private Socket csocket;
	
	Server(Socket csocket){
		super();
		this.csocket = csocket;
	}

	private static void serveClient(Socket s){
		new Server(s).start();
	}

	public static void main(String[] args) throws Exception {

		ServerSocket csocket = new ServerSocket(1234);
	      	System.out.println("Waiting for connection with client...");

		Socket s = csocket.accept();  // Accept connection on port 1234
		serveClient(s);

		try{
				
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			BufferedReader readMsg = new BufferedReader(new InputStreamReader(System.in));
		 
		      	String receive, send;
             
		      	while(true){
				if((receive = in.readLine()) != null){  // Receive from client
			   		System.out.println(receive);  // Print message       
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
