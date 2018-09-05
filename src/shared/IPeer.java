package shared;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPeer extends Remote {
	
	void message(String message, User sender) throws RemoteException, MalformedURLException, NotBoundException;

}
