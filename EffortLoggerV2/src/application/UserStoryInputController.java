package application;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/*
 * Author: Sankritya Thakur
 * Datetime: OCt 28 3:54PM
 * Description: This class provides the functionality for user story inputting.
 * 					The main risk associated with this class is to test input validation.
 * 					However, we also want to test how we will get user story information
 * 					for use with Planning Poker. This is where we get most of the data for that.
 * 					Dual purpose: Can enter in user stories that will be used in a future round of
 * 					Planning Poker OR can enter in past user stories that already have been assigned
 * 					effort points.
 */


public class UserStoryInputController {
	
	// UI components declarations
	@FXML
	private Button submitButton;
	@FXML
	private Button backButton;
	@FXML
	private TextArea userStoryText;
	@FXML
	private TextArea keyWordsText;
	@FXML
	private Text messageText;
	@FXML
	private CheckBox pastStoryCheckbox;
	@FXML
	private TextField effortPointsField;
	
	boolean checkboxClicked = false;
	
	
    // mock-ups for databases
    // these will all be in one table
    // the indices of each array correspond to the other ones
	ArrayList<String> userStories = new ArrayList<>();
	ArrayList<String[]> keyWords = new ArrayList<>();
	ArrayList<Integer> effortPoints = new ArrayList<>(); // -1 means it's not a past user story. so no effort points
	
	
	@FXML
	private void submitClicked() {
		String userStoryString = userStoryText.getText();
		if (userStoryString.length() > 1000) {
			messageText.setText("User story is too long");
			return;
		}
		if (userStoryString.length() < 5) {
			messageText.setText("User story is too short");
			return;
		}
		if (userStoryString.contains("/") || userStoryString.contains("_") ||
				userStoryString.contains(";") || userStoryString.contains("\\") ||
				userStoryString.contains("=") || userStoryString.contains("&")) {
			messageText.setText("User story contains invalid characters ('\\', '/', '_', ';', '=', '&')");	
			return;
		}
		if (!userStoryString.matches(".*[A-Za-z] +.*")) { // some syntactic validation with regex
			messageText.setText("User story must contain some words!");
			return;
		}
		
		String keyWordsString = keyWordsText.getText();
		// check if too long
		if (keyWordsString.length() > 1000) {
			messageText.setText("Key words section is too long");
			return;
		}
		// check if too short
		if (keyWordsString.length() < 5) {
			messageText.setText("Key words section is too short");
			return;
		}
		// this regex sees if we have any numbers and yells if we do 
		if (keyWordsString.matches(".*[0-9]+.*")) {
			messageText.setText("Key words cannot contain any numbers!");
			return;
		}
		// this regex makes sure that what we have is a comma separated list of words
		if (!keyWordsString.matches("([a-zA-Z]+)(,\\s*[a-zA-z]+)*")) {
			
		}
		// check if the string contains bad characters
		if (keyWordsString.contains("/") || keyWordsString.contains("_") ||
				keyWordsString.contains(";") || keyWordsString.contains("\\") ||
				keyWordsString.contains("=") || keyWordsString.contains("&")) {
			messageText.setText("Key words section contains invalid characters ('\\', '/', '_', ';', '=', '&')");	
			return;
		}		
		String[] keyWordsArr;
		try {
			keyWordsArr = keyWordsString.split(",");
		} catch (Exception e) {
			messageText.setText("Something is wrong with key words!");
			return;
		}
		if (keyWordsArr.length < 1) {
			messageText.setText("No key words found!");
			return;
		}
		if (keyWordsArr.length > 100) {
			messageText.setText("Too many key words!");
			return;
		}
		
		int effortPointsValue = -1;
		// todo: HERE WE GET EFFORT POINTS BUT MAKE SURE IT'S LOGICAL! LIKE NOT TOO HIGH NOT TOO LOW!
		// ALSO MAKE SURE IT'S AN INT
		if (checkboxClicked) {
			String effortString = effortPointsField.getText();
			if (!effortString.matches("[0-9]+")) {
				messageText.setText("Effort points must be entered as a number.");
				return;
			}
			if (effortString.length() > 3) {
				messageText.setText("Effort points number is too long!");
				return;
			}
			if (effortString.length() <= 0) {
				messageText.setText("Must have effort points!");
				return;
			}
			try {
				effortPointsValue = Integer.parseInt(effortString);
			} catch (Exception e) {
				messageText.setText("There was a problem collecting the effort points.");
				return;
			}
			if (effortPointsValue < 0 || effortPointsValue > 100) {
				messageText.setText("Effort points value is invalid! (must be from 0-100)");
				return;
			}
		}
		
		if (!userStories.contains(userStoryString)) {
			userStories.add(userStoryString);
			keyWords.add(keyWordsArr);
			effortPoints.add(effortPointsValue);
			System.out.println("User story arrays:");
			for (int i=0; i<userStories.size(); i++) {
				System.out.println("User story: " + userStories.get(i));
				System.out.println("Key words: " + String.join(",", keyWords.get(i)));
				System.out.println("Effort points: " + Integer.toString(effortPoints.get(i)));
			}
			System.out.println("=========\n");
			messageText.setText("User story successfully added!");
		} else {
			messageText.setText("User story already added!");
		}
	}
	
	
	@FXML
	// Method to handle the action when the past story checkbox is clicked
	private void pastStoryCheckboxClicked() {
		checkboxClicked = !checkboxClicked;
		// If the checkbox is checked, show the effortPointsField; otherwise, hide it
		if (checkboxClicked) {
			effortPointsField.setVisible(true);
		} else {
			effortPointsField.setVisible(false);
		}
	}
	
	
	
    @FXML
    // Method to handle the action when the back button is clicked
    private void backClicked(ActionEvent event) {
    	// Check if the application is in single prototype mode
    	if (EffortLoggerData.getInstance().isSinglePrototype()) {
	    	try {
	    		// Navigate back to the main menu screen
		    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    	Parent root = FXMLLoader.load(getClass().getResource("/main_menu.fxml"));
				Scene scene = new Scene(root, 300, 500);
				stage.setTitle("Main menu");
				stage.setScene(scene);
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
		} else {
			try {
				// Navigate back to the post login screen
		    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		    	Parent root = FXMLLoader.load(getClass().getResource("/PostLoginScreen.fxml"));
				Scene scene = new Scene(root, 1000, 560);
				stage.setTitle("Main menu");
				stage.setScene(scene);
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
		}
    }

    @FXML
    private void initialize() {
        // method stub, just initialize everything here
    }
	
}
