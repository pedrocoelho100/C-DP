package rmi_chat_client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import rmi_chat_server.ChatServerInterface;

public class ChatClient implements ChatClientInterface, Runnable {
	
	private static final long serialVersionUID = 1L;
	private rmi_chat_server.ChatServerInterface chatServer;
	private String name = null;
	
	public ChatClient(String name, ChatServerInterface chatServer) throws RemoteException {
		this.name = name;
		this.chatServer = chatServer;
		ChatClientInterface thisstub = (ChatClientInterface) UnicastRemoteObject.exportObject(this, 0);
		chatServer.registerChatClient(thisstub);	
	}
	
	public void retrieveMessage(String message) {
		System.out.println(message);
	}
	
	public void run() {
		
		Scanner scanner = new Scanner(System.in);
		String message;
	
		while(true) {
			message = scanner.nextLine();
			try {
				chatServer.broadcastMessage(name + " : " + message);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}
}