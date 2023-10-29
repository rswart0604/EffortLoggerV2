package application;

import java.time.LocalDateTime;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EffortLoggingInputController {

	@FXML
	private Button backButton;
	@FXML
	private Button startStopButton;
	@FXML
	private ComboBox<String> projectBox;
	@FXML
	private ComboBox<String> lifeCycleBox;
	@FXML
	private ComboBox<String> effortCategoryBox;
	@FXML
	private ComboBox<String> itemBox;
	@FXML
	private Text clockText;
	
	private boolean started = false;
	
	
	
	
	// mock-ups for databases
    // these will all be in one table
    // the indices of each array correspond to the other ones
	ArrayList<LocalDateTime> startTimes = new ArrayList<>();
	ArrayList<LocalDateTime> endTimes = new ArrayList<>();
	ArrayList<String> projects = new ArrayList<>();
	ArrayList<String> lifeCycles = new ArrayList<>();
	ArrayList<String> effortCategories = new ArrayList<>();
	ArrayList<String> items = new ArrayList<>();
	
	
	
	
	@FXML
	private void startStopClicked() {
		if (!started) {
			if (!projectBox.getSelectionModel().isEmpty() && !lifeCycleBox.getSelectionModel().isEmpty() &&
					!effortCategoryBox.getSelectionModel().isEmpty() && !itemBox.getSelectionModel().isEmpty()) {
				startTimes.add(LocalDateTime.now());
				projects.add(projectBox.getSelectionModel().getSelectedItem());
				lifeCycles.add(lifeCycleBox.getSelectionModel().getSelectedItem());
				effortCategories.add(effortCategoryBox.getSelectionModel().getSelectedItem());
				items.add(itemBox.getSelectionModel().getSelectedItem());
			}
			startStopButton.setText("Stop activity");
			clockText.setText("Clock is RUNNING");
			started = true;
		} else {
			endTimes.add(LocalDateTime.now());
			startStopButton.setText("Start activity");
			clockText.setText("Clock is STOPPED");
			started = false;
			
			for (int i=0; i<projects.size(); i++) {
			
				System.out.println("Project: " + projects.get(i));
				System.out.println("Life cycle: " + lifeCycles.get(i));
				System.out.println("Effort category: " + effortCategories.get(i));
				System.out.println("Item: " + items.get(i));
				System.out.println("Start: " + startTimes.get(i).toString());
				System.out.println("End: " + endTimes.get(i).toString());
				System.out.println();
			}
			System.out.println("======================");
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
    	projectBox.getItems().addAll("Business Project", "Development Project");
    	lifeCycleBox.getItems().addAll("Planning", "Information Gathering", "Information Understanding", "Verifying",
    			"Outlining", "Drafting", "Finalizing", "Team Meeting", "Coach Meeting", "Stakeholder Meeting");
    	effortCategoryBox.getItems().addAll("Plans", "Deliverables", "Interruptions", "Defects");
    	itemBox.getItems().addAll("Conceptual Design", "Detailed Design", "Test Cases", "Solution", "Reflection", 
    			"Break", "Visitor", "Project Plan", "Risk Management Plan");
    }
	
	
	
}
