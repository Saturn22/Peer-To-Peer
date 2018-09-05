package peer;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import peer.view.ViewController;

public class MainPeer extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		Peer peerController = null;
		ViewController viewController = new ViewController(primaryStage);
		
		try {
			peerController = new Peer(viewController);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Error while connecting to server");
	        alert.setHeaderText("Error while connecting to server");
	        alert.setContentText("Please try again later.");
	        alert.showAndWait();
	        
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
