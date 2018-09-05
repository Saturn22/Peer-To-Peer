package peer;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import peer.view.ViewController;
import server.Server;
import shared.IPeer;
import shared.IServer;
import shared.User;

public class Peer implements IPeer, Serializable {

	private IServer server;
	private User user;
	private HashMap<String, User> peers;
	private ViewController viewController;
	
	public Peer(ViewController viewController) throws RemoteException, MalformedURLException, NotBoundException {
		this.viewController = viewController;
		viewController.setPeerController(this);
		connectServer();
		viewController.showCreateAliasLayout();
	}
	
	private void connectServer() throws RemoteException, MalformedURLException, NotBoundException {
		server = (IServer) Naming.lookup("rmi://localhost:1099/Server");
		UnicastRemoteObject.exportObject (this, 0);	
	}
	
	public boolean registerPeer(String alias) throws RemoteException {
		user = new User(alias, this);
		getAllPeers();
		return server.register(user);	
	}
	
	public User getPeer(String alias) throws RemoteException {
		if(peers.containsKey(alias))
			return peers.get(alias);
		else
			return server.getPeer(alias);
	}
	
	private void getAllPeers() throws RemoteException{
		peers = server.getAllPeers();
	}

	public void sendMessage(String message, User receiver) throws RemoteException, MalformedURLException, NotBoundException {
		receiver.getPeerInstance().message(message, user);
	}
	
	@Override
	public void message(String message, User sender) {
		if(!peers.containsKey(sender.getAlias())) {
			peers.put(sender.getAlias(), sender);
		}
		System.out.println(message + " from " + sender.getAlias());
		viewController.appendMessage(message, sender.getAlias());
	}
}