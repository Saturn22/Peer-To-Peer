package peer.view.chat;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import peer.Peer;
import shared.User;

public class ChatController {

	private Peer peerController;
	
	@FXML
	private TextArea chat;
	@FXML
	private Label errorLabel;
	@FXML
	private TextField alias;
	@FXML 
	private TextField message;
	
	@FXML
	public void handleSend() {
		
		User receiver = null;
		try {
			receiver = peerController.getPeer(alias.getText());
		} catch (RemoteException e) {
			errorLabel.setText("User does not exist.");
			e.printStackTrace();
			return;
		}
		
		try {
			peerController.sendMessage(message.getText(), receiver);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			errorLabel.setText("Error while sending message. Try again later.");
			e.printStackTrace();
			return;
		}
		
		appendMessage(message.getText(), "Me");
		message.clear();
	}
	
	public void appendMessage(String message, String alias) {
		chat.appendText(alias + ": " + message + "\n");
	}
	
	public void setPeerController(Peer peerController) {
		this.peerController = peerController;
	}
}
