package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import shared.IServer;

public class ServerMain {
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			IServer server = new Server();
			Naming.rebind("Server", server);
			System.out.println("Server running");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
