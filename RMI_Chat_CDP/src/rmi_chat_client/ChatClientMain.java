package rmi_chat_client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi_chat_server.ChatServerInterface;

public class ChatClientMain {

	public static void main(String args[]) {
		
		if(System.getSecurityManager() == null){
			System.setSecurityManager(new SecurityManager());
		}

		try{

			Registry registry = LocateRegistry.getRegistry(args[1]);
			ChatServerInterface chatServerIf = (ChatServerInterface) registry.lookup("RMIChat");
			new Thread(new ChatClient(args[0], chatServerIf)).start();
			
		} catch(RemoteException e) {
			e.printStackTrace();
		} catch(NotBoundException e) {
			e.printStackTrace();
		}
	}
	
}