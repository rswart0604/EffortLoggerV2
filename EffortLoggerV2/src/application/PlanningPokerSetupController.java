package application;
import javafx.scene.control.ScrollPane;
import java.util.ArrayList;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// Author: Ryan Swart

public class PlanningPokerSetupController {
	
	// Elements to be shown on the screen
	@FXML
	private TextField newProjectField;
	@FXML
	private TextArea userStoryTextArea;
	@FXML
	private TextArea keyWordsTextArea;
	@FXML
	private Button continueButton;
	
	@FXML
	private Text messageText;

	// Planning poker data instance
	PlanningPokerData data = PlanningPokerData.getInstance();
	
	
	// Save the stuff and take us to the next screen
	@FXML
	private void continueClicked(ActionEvent event) {
		
		// input validation
		String currentStory = userStoryTextArea.getText();
		if (currentStory.length() > 1000) { // check too long
			messageText.setText("User story is too long");
			return;
		}
		if (currentStory.length() < 5) { // check too short
			messageText.setText("User story is too short");
			return;
		}
		if (currentStory.contains("/") || currentStory.contains("_") || // check invalid characters
				currentStory.contains(";") || currentStory.contains("\\") ||
				currentStory.contains("=") || currentStory.contains("&")) {
			messageText.setText("User story contains invalid characters ('\\', '/', '_', ';', '=', '&')");	
			return;
		}
		if (!currentStory.matches(".*[A-Za-z] +.*")) { // some syntactic validation with regex
			messageText.setText("User story must contain some words!");
			return;
		}
		
		String newProject = newProjectField.getText();
		if (newProject.length() > 1000) { // too long
			messageText.setText("Project name is too long");
			return;
		}
		if (newProject.length() < 5) { // too short
			messageText.setText("Project name is too short");
			return;
		}
		if (newProject.contains("/") || newProject.contains("_") || // invalid characters
				newProject.contains(";") || newProject.contains("\\") ||
				newProject.contains("=") || newProject.contains("&")) {
			messageText.setText("Project name contains invalid characters ('\\', '/', '_', ';', '=', '&')");	
			return;
		}
		if (!newProject.matches(".*[A-Za-z] +.*")) { // some syntactic validation with regex
			messageText.setText("Project name must contain some words!");
			return;
		}
		
		
		data.currentStory = currentStory; // use data from our singleton!
		data.currentProject = newProject;
		data.currentKeys = keyWordsTextArea.getText().split(",");
				
		try { // next screen
			// go to planning poker first round
	    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    	Parent root = FXMLLoader.load(getClass().getResource("/planning_poker_first_round.fxml"));
			Scene scene = new Scene(root, 1000, 1000);
			stage.setTitle("Main menu");
			stage.setScene(scene);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
	}
	
	
	// Initialization to load everything
	@FXML
	private void initialize() {
		
	}
	
	
	
	
	
}
