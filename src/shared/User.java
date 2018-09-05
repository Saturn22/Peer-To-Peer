package shared;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import server.Server;

public class User implements Serializable {
	
	private String alias;
	private IPeer peerInstance;
	
	public User(String alias, IPeer peerInstance) {
		this.peerInstance = peerInstance;
		this.alias = alias;
	}
	
	public String getAlias() {
		return alias;
	}
	
	public IPeer getPeerInstance() {
		return peerInstance;
	}
	
	public String toString() {
		return alias;
	}
}
