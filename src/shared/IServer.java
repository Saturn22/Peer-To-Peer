package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

public interface IServer extends Remote {

	boolean register(User peer) throws RemoteException;
	User getPeer(String alias) throws RemoteException;
	HashMap<String, User> getAllPeers() throws RemoteException;
}
