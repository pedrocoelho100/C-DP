package rmi_chat_server;

import rmi_chat_client.ChatClientInterface;

public interface ChatServerInterface extends java.rmi.Remote {

	public void registerChatClient(ChatClientInterface chatClient) throws java.rmi.RemoteException;
	public void broadcastMessage(String message) throws java.rmi.RemoteException;
	
}