package application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * Author: Kinjal Chatterjee
 * Datetime: Oct 29 at 9:42pm
 * Description: This class, PostLoginScreen, controls the behavior of the post-login UI of the application.
 * 	It manages various UI components such as buttons and labels, and handles user interactions with these components.
 * 	The class provides navigation functionalities, allowing users to navigate to various pages like effort log input,
 * effort log display, and effort log deletion. It also has a back button to return to the main menu. 
 * The "initialize" method initializes necessary data, like setting up the username to be displayed.
 * 
 */

public class PostLoginScreen {
	
	// FXML components declaration.
	@FXML
	private Button backButton;
	@FXML
	private Button effortLoggerInputButton;
	@FXML
	private Button effortLoggerDisplayButton;
	@FXML
	private Button effortLoggerDeletionButton;
	@FXML
	private Button storyInputButton;
	@FXML
	private Label welcomeLabel;
	
	
	private String username;
	
	// Event handler for the input button.
	@FXML
	private void inputClicked(ActionEvent event) {
		System.out.println("I want to go to the effort log input page!");
		
		// Check if it's not in single prototype mode.
		if (!EffortLoggerData.getInstance().singlePrototype) {
			try {
				// Navigation code to the effort log input page.
		    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    	Parent root = FXMLLoader.load(getClass().getResource("/effortlogging_input.fxml"));
				Scene scene = new Scene(root, 1000, 560);
				stage.setTitle("Main menu");
				stage.setScene(scene);
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
		}
	}
	
	@FXML
	// Event handler for the display button.
	private void displayClicked(ActionEvent event) {
		System.out.println("I want to go to the effort log display page!");
		if (!EffortLoggerData.getInstance().singlePrototype) {
			try {
		    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    	Parent root = FXMLLoader.load(getClass().getResource("/effortlogging_display.fxml"));
				Scene scene = new Scene(root, 1000, 560);
				stage.setTitle("Main menu");
				stage.setScene(scene);
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
		}
	}
	
	@FXML
	// Event handler for the deletion button.
	private void deletionClicked(ActionEvent event) {
		System.out.println("I want to go to the effort log deletion page!");
		if (!EffortLoggerData.getInstance().singlePrototype) {
			try {
		    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    	Parent root = FXMLLoader.load(getClass().getResource("/effortlogging_delete.fxml"));
				Scene scene = new Scene(root, 1000, 560);
				stage.setTitle("Main menu");
				stage.setScene(scene);
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
		}
	}
	
	@FXML
	// Event handler for the story input button.
	private void storyInputClicked(ActionEvent event) {
		System.out.println("I want to go to the user story input page!");
		if (!EffortLoggerData.getInstance().singlePrototype) {
			try {
		    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    	Parent root = FXMLLoader.load(getClass().getResource("/user_story_input.fxml"));
				Scene scene = new Scene(root, 1000, 560);
				stage.setTitle("Main menu");
				stage.setScene(scene);
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
		}
	}
	
	
	
	
	
    @FXML
    // Event handler for the back button.
    private void backClicked(ActionEvent event) {
    	try {
	    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    	Parent root = FXMLLoader.load(getClass().getResource("/main_menu.fxml"));
			Scene scene = new Scene(root, 1000, 560);
			stage.setTitle("Main menu");
			stage.setScene(scene);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    // Initialization method.
    private void initialize() {
		if (!EffortLoggerData.getInstance().singlePrototype) {
			username = EffortLoggerData.getInstance().getUsername();
		} else {
			username = "TestUser";
		}
		// Set the welcome message with the username.
    	welcomeLabel.setText("Welcome, " + username);
        // method stub, just initialize everything here
    }
	
}
