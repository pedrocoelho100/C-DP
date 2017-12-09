package rmi_chat_server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import rmi_chat_client.ChatClientInterface;

public class ChatServer implements ChatServerInterface {
	
	ArrayList<ChatClientInterface> chatClients = new ArrayList<ChatClientInterface>();	

	public synchronized void registerChatClient(ChatClientInterface chatClient) {
		this.chatClients.add(chatClient);
	}

	public synchronized void broadcastMessage(String message) throws RemoteException {
		int i = 0;
		while(i < chatClients.size()) {
			chatClients.get(i++).retrieveMessage(message);
		}
	}

	public static void main(String args[]) {
		
		if(System.getSecurityManager() == null){
			System.setSecurityManager(new SecurityManager());
		}

		try{

			ChatServer chatServer = new ChatServer();
			ChatServerInterface chatServerIf = (ChatServerInterface) UnicastRemoteObject.exportObject(chatServer, 0);
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind("RMIChat", chatServerIf);
			System.out.println("Chat server");

		} catch(RemoteException e){
			e.printStackTrace();
		}
	}

}