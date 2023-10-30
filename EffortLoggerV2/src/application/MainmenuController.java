package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Author: Mohan Kummarigunta
 * Datetime: Oct 29 10:05pm
 * Description: The MainmenuController class is responsible for handling user actions on the main menu of the application.
 * It provides buttons for different prototypes that users can choose to interact with.
 * Each button, when clicked, will trigger a different event, loading a specific FXML file and changing the stage's scene to the corresponding layout.
 * The EffortLoggerData singleton instance is utilized to set whether a single prototype is being accessed or an integrated one.
 * Every time a prototype button is clicked, the application loads a new screen corresponding to that prototype.
 * The initialize method is provided as a stub, suggesting that any necessary initial setup for the controller can be done here.
 * 
 */

public class MainmenuController {
	
	// Declaring buttons for individual prototypes
	@FXML
    private Button prototypeOneButton;
	@FXML
    private Button prototypeTwoButton;
	@FXML
    private Button prototypeThreeButton;
	@FXML
    private Button prototypeFourButton;
	@FXML
    private Button prototypeFiveButton;
	@FXML
    private Button prototypeSixButton;
	@FXML
    private Button integratedPrototypeButton;
	
	
	//event handler for prototype one button
	@FXML
	private void oneClicked(ActionEvent event) {
		EffortLoggerData.getInstance().setSinglePrototype(true);
		try {
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			System.out.println(stage);
			Parent root = FXMLLoader.load(getClass().getResource("/login.fxml"));
			Scene scene = new Scene(root, 1000, 560);
			stage.setTitle("Prototype 1");
			stage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	//event handler for prototype two button
	private void twoClicked(ActionEvent event) {
		EffortLoggerData.getInstance().setSinglePrototype(true);
		try {
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			System.out.println(stage);
			Parent root = FXMLLoader.load(getClass().getResource("/user_story_input.fxml"));
			Scene scene = new Scene(root, 1000, 560);
			stage.setTitle("Prototype 2");
			stage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	//event handler for prototype three button
	private void threeClicked(ActionEvent event) {
		EffortLoggerData.getInstance().setSinglePrototype(true);
		try {
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			System.out.println(stage);
			Parent root = FXMLLoader.load(getClass().getResource("/effortlogging_input.fxml"));
			Scene scene = new Scene(root, 1000, 560);
			stage.setTitle("Prototype 3");
			stage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	//event handler for prototype four button
	private void fourClicked(ActionEvent event) {
		EffortLoggerData.getInstance().setSinglePrototype(true);
		try {
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			System.out.println(stage);
			Parent root = FXMLLoader.load(getClass().getResource("/effortlogging_display.fxml"));
			Scene scene = new Scene(root, 1000, 560);
			stage.setTitle("Prototype 4");
			stage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	//event handler for prototype five button
	private void fiveClicked(ActionEvent event) {
		EffortLoggerData.getInstance().setSinglePrototype(true);
		try {
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			System.out.println(stage);
			Parent root = FXMLLoader.load(getClass().getResource("/PostLoginScreen.fxml"));
			Scene scene = new Scene(root, 1000, 560);
			stage.setTitle("Prototype 6");
			stage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	//event handler for prototype six button
	private void sixClicked(ActionEvent event) {
		EffortLoggerData.getInstance().setSinglePrototype(true);
		try {
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			System.out.println(stage);
			Parent root = FXMLLoader.load(getClass().getResource("/effortlogging_delete.fxml"));
			Scene scene = new Scene(root, 1000, 560);
			stage.setTitle("Prototype 6");
			stage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	//event handler for integrated prototype button
	private void integratedClicked(ActionEvent event) {
		EffortLoggerData.getInstance().setSinglePrototype(false);
		try {
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			System.out.println(stage);
			Parent root = FXMLLoader.load(getClass().getResource("/login.fxml"));
			Scene scene = new Scene(root, 1000, 560);
			stage.setTitle("Prototype 1");
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
