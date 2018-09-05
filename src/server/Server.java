package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import shared.IPeer;
import shared.IServer;
import shared.User;

public class Server implements IServer {
	
	private HashMap<String, User> peers;
	
	public Server() throws RemoteException {
		peers = new HashMap<>();
		UnicastRemoteObject.exportObject(this, 0);
	}
	
	@Override
	public synchronized boolean register(User peer) throws RemoteException {
		if(peers.containsKey(peer.getAlias())) {
			return false;
		}
		else {
			peers.put(peer.getAlias(), peer);
			System.out.println("Peer registered: " + peer);
			return true;
		}
	}
	
	@Override
	public synchronized User getPeer(String alias) throws RemoteException {
		return peers.get(alias);
	}
	
	public synchronized HashMap<String, User> getAllPeers(){
		return peers;
	}
}
