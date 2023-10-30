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

public class PostLoginScreen {
	
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
	
	
	@FXML
	private void inputClicked(ActionEvent event) {
		System.out.println("I want to go to the effort log input page!");
		if (!EffortLoggerData.getInstance().singlePrototype) {
			try {
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
    private void initialize() {
		if (!EffortLoggerData.getInstance().singlePrototype) {
			username = EffortLoggerData.getInstance().getUsername();
		} else {
			username = "TestUser";
		}
    	welcomeLabel.setText("Welcome, " + username);
        // method stub, just initialize everything here
    }
	
}
