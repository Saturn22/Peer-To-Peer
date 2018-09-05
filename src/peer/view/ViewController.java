package peer.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import peer.Peer;
import peer.view.chat.ChatController;
import peer.view.createAlias.CreateAliasController;

public class ViewController {

	private Stage primaryStage;
    private BorderPane rootLayout;
    private Peer peerController;
    private ChatController chatController;
    
    public ViewController(Stage primaryStage) {
    	this.primaryStage = primaryStage;
    	initRootLayout();
    }
    
    public void initRootLayout() {
    	try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ViewController.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showCreateAliasLayout() {
    	try {
    		
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(ViewController.class.getResource("createAlias/CreateAlias.fxml"));
    		AnchorPane createAlias = (AnchorPane) loader.load();
        
    		rootLayout.setCenter(createAlias);

	        CreateAliasController controller = loader.getController();
	        controller.setViewController(this);
	        controller.setPeerController(peerController);
	        
	        rootLayout.setOnKeyPressed(e -> {
		        if (e.getCode() == KeyCode.ENTER) {
		        	controller.handleContinue();
		        }
		    });
	        
    	} catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showChatLayout() {
    	
    	try {
		    FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ViewController.class.getResource("chat/Chat.fxml"));
			AnchorPane chat = (AnchorPane) loader.load();
		    
			rootLayout.setCenter(chat);
			
			chatController = loader.getController();
			chatController.setPeerController(peerController);
			
			rootLayout.setOnKeyPressed(e -> {
		        if (e.getCode() == KeyCode.ENTER) {
		        	chatController.handleSend();
		        }
		    });
			
    	} catch (IOException e) {
    		e.printStackTrace();
    	}	
    }
    
    public void appendMessage(String message, String senderAlias) {
    	chatController.appendMessage(message, senderAlias);
    }
    
    public void setPeerController(Peer peerController) {
    	this.peerController = peerController;
    }
    
    public void setTitle(String alias) {
    	primaryStage.setTitle("Alias: " + alias);
    }
}
