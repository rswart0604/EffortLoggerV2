package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainmenuController {

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
	
	
	@FXML
	private void oneClicked(ActionEvent event) {
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
	private void twoClicked(ActionEvent event) {
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
	private void threeClicked(ActionEvent event) {
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
	private void fourClicked(ActionEvent event) {
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
	private void fiveClicked() {
		
	}
	
	@FXML
	private void sixClicked() {
		
	}
	
	@FXML
	private void integratedClicked() {
		
	}
	
	
	
	
	
	
	
    @FXML
    private void initialize() {
        // method stub, just initialize everything here
    }
	
	
	
}
