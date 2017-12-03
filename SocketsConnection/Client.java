import java.net.*;
import java.io.*;

class Client extends Thread {

	public static void main (String[] args){
	
		Socket socket = null;

		String adres = args[0];
		int port = Integer.parseInt(args[1]);

		try{
			socket = new Socket(adres, port);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedReader readMsg = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Connection made! Client address: " + adres + "! You can start chatting:");

			String receive, send;

			while(true){

        			send = readMsg.readLine();  // Read from keyboard
        			out.println(send);  // Send to server
        			out.flush();  // Flush data
        			if((receive = in.readLine()) != null){  // Receive from server
           				System.out.println("Server: " + receive);  // Print message
        			}
			}        

		} catch(UnknownHostException e) { e.printStackTrace(); }
		  catch(IOException e) { e.printStackTrace(); }
		  finally { try { socket.close(); }
			    catch(IOException e) { e.printStackTrace(); }
		}            
	}                    
}
