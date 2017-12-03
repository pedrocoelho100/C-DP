import java.net.*;
import java.io.*;

public class ServerThread {

	public static void main (String[] args){

		ServerSocket serverSocket = null;
		Socket socket = null;

		try{
			serverSocket = new ServerSocket(1234);
			System.out.println("Waiting for connection with client...");
		} catch (IOException e) {
			e.printStackTrace();
		}

		while(true){
			try{
				socket = serverSocket.accept();
				System.out.println("Connection established with a client!");
			} catch (IOException e) {
				e.printStackTrace();
			}
			new Server(socket).start();
		}

	}

}
