package peer;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import shared.User;

public class MainPeer_OLD {
	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		
//		PeerController peer = null;
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter alias:");
//		String alias = scanner.nextLine();
//		
//		try {
//			peer = new PeerController(alias);
//		} catch (RemoteException | MalformedURLException | NotBoundException e) {
//			e.printStackTrace();
//		}
//
//		System.out.println("Search for peer:");
//		alias = scanner.nextLine();
//		
//		
//		Peer peerConnected = null;
//		try {
//			peerConnected = peer.getPeer(alias);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("Connected to " + peerConnected.getAlias());
//		System.out.println("Message:");
//		
//		while(true) {
//			String message = scanner.nextLine();
//			peer.sendMessage(message, peerConnected);
//		}
	}
}
