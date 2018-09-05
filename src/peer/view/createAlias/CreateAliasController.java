package peer.view.createAlias;

import java.rmi.RemoteException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import peer.Peer;
import peer.view.ViewController;

public class CreateAliasController {
	
	private ViewController viewController;
	private Peer peerController;
	
	@FXML
    private Label errorLabel;
	@FXML
    private TextField alias;
	
	
	@FXML
    public void handleContinue() {
		boolean exists = false;
		try {
			exists = peerController.registerPeer(alias.getText());
		} catch (RemoteException e) {
			Alert alert = new Alert(AlertType.WARNING);
	        alert.setTitle("Error while connecting to server");
	        alert.setHeaderText("Error while connecting to server");
	        alert.setContentText("Please try again later.");
	        alert.showAndWait();
			e.printStackTrace();
		}
		
		if(!exists) {
			errorLabel.setText("Alias already exists try another one.");
		}
		else {
			viewController.setTitle(alias.getText());
			viewController.showChatLayout();
		}
	}
	
	public void setViewController(ViewController viewController) {
		this.viewController = viewController;
	}
	
	public void setPeerController(Peer peerController) {
		this.peerController = peerController;
	}
}
