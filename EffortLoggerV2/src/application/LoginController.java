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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
 * Author: Ryan Swart
 * Datetime: Oct 27 4:00PM
 * Description: This class provides the control for the login prototype.
 * 	the bulk of the functionality is in the "submitClicked" method, which checks
 * 	the username and password against database and logs them in
 * 
 */

public class LoginController {

    @FXML
    private Button submitButton; // matches the "Submit" button 
    @FXML
    private Button addUserButton; // matches the "Add user" button
    @FXML
    private Button proceedButton; // the button that lets us move forward to next page
    @FXML
    private Button backButton; // take us back to main menu
    @FXML
    private TextField usernameField; // matches the top "Username" text 
    @FXML
    private PasswordField passwordField; // matches the bottom "Password" text
    @FXML
    private Text messageText; // lets us output messages about success or failure
    
    // mock-ups for databases
    // these will all be in one table
    // the indices of each array correspond to the other ones
    // IMPLEMENTATION: our passwordList will be hashed and therefore keep them secure
    private ArrayList<String> usernameList = new ArrayList<>(Arrays.asList("user1", "user2", "admin1"));
    private ArrayList<String> passwordList = new ArrayList<>(Arrays.asList("password1", "abcdef", "strong_password"));
    private ArrayList<Boolean> isAdminList = new ArrayList<>(Arrays.asList(false, false, true));
    
    int numberOfAttempts = 0;
    // curUserIsAdmin and curUsername would both be used in other aspects of EffortLoggerV2
    Boolean curUserIsAdmin = false;
    String curUsername = "";
    
    
    @FXML
    private void submitClicked() {
    	if (numberOfAttempts < 10 && numberOfAttempts >= 0) { // if not too many attempts,
	    	if (usernameList.contains(usernameField.getText())) { // check our username first
	    		int index = usernameList.indexOf(usernameField.getText());
	    		// then check our corresponding password
	    		// DESIGN GOAL: have secure authentication
	    		// IMPLEMENTATION: the implementation meets design by checking both user and password more or less at the same time
	    		if (passwordList.get(index).equals(passwordField.getText())) {
	    			messageText.setText("success! welcome back " + usernameField.getText()); // if good, then tell us
	    			System.out.println("success!");
	    			curUsername = usernameField.getText();
	    			EffortLoggerData.getInstance().setUsername(curUsername); // add it to our data
	    			
	    			// get whether or not we're an admin
	    			curUserIsAdmin = isAdminList.get(index);
	    			System.out.println("Is admin? " + curUserIsAdmin.toString());
	    			
	    			// let us proceed
	    			proceedButton.setVisible(true);
	    			// DESIGN GOAL: be able to log in, authenticate a user, and then let them continue and saving their username
	    		} else {
	    			messageText.setText("Incorrect username or password"); // if bad, tell us
	    			curUsername = "";
	    			
	    			// don't let us proceed anymore
	    			proceedButton.setVisible(false);
	    			numberOfAttempts++;
	    			System.out.println("Fail");
	    		}
	    	} else {
	    		messageText.setText("Incorrect username or password"); // if bad, tell us
	    		curUsername = "";
	    		
	    		// don't let us proceed anymore
	    		proceedButton.setVisible(false);
	    		numberOfAttempts++;
	    		System.out.println("Fail");
	    	}
    	} else { // if we've reached too many attempts, don't check anything else. just tell us
    		messageText.setText("Too many incorrect attempts! Please contact a supervisor.");
    		curUsername = "";
    		
    		// don't let us proceed anymore
    		proceedButton.setVisible(false);
    		// TODO! we will implement supervisor stuff later. right now, we just turn it off and back on
    		// to reset the number of attempts
    		// DESIGN GOAL: have secure authentication
    	}
    }
    
    @FXML
    private void addUserButtonClicked() {
    	// TODO: we will add functionality for this later. we only care abt authentication
    	// DESIGN GOAL: have extra powers as admin
    	if (curUserIsAdmin) {
    		System.out.println(curUsername + " can add users!");
    	} else {
    		System.out.println(curUsername + " cannot add users :(");
    	}
    }
    
    @FXML
    private void proceedClicked(ActionEvent event) {
    	System.out.println("Hello! I would move to new application now.");
    	
    	if (!EffortLoggerData.getInstance().singlePrototype) {
    		try {
    	    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	    	Parent root = FXMLLoader.load(getClass().getResource("/PostLoginSCreen.fxml"));
    			Scene scene = new Scene(root, 300, 500);
    			stage.setTitle("Menu");
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
			Scene scene = new Scene(root, 300, 500);
			stage.setTitle("Main menu");
			stage.setScene(scene);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    private void initialize() {
        // method stub, just initialize everything here
    }
}
