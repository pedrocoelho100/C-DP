package rmi_chat_client;

public interface ChatClientInterface extends java.rmi.Remote {

	void retrieveMessage(String message) throws java.rmi.RemoteException;

}