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

/**
 * Author: Om Sunil Chaudhari
 * Datetime: Oct 29 10:01pm
 * Description: The EffortLoggingInputController class manages the input interface for logging effort related to projects.
 * Users can select a project, life cycle, effort category, and item using ComboBoxes and initiate or stop the logging with a button click.
 * Data regarding start times, end times, and other attributes is stored internally using ArrayLists.
 * The state of the logging (either running or stopped) is displayed via a Text component.
 * A back button is provided, allowing the user to navigate to previous screens based on certain conditions.
 * 
 */

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
//	ArrayList<LocalDateTime> startTimes = new ArrayList<>();
//	ArrayList<LocalDateTime> endTimes = new ArrayList<>();
//	ArrayList<String> projects = new ArrayList<>();
//	ArrayList<String> lifeCycles = new ArrayList<>();
//	ArrayList<String> effortCategories = new ArrayList<>();
//	ArrayList<String> items = new ArrayList<>();
	ArrayList<LocalDateTime> startTimes;// = new ArrayList<>();
	ArrayList<LocalDateTime> endTimes;// = new ArrayList<>();
	ArrayList<String> projects;// = new ArrayList<>();
	ArrayList<String> lifeCycles;// = new ArrayList<>();
	ArrayList<String> effortCategories;// = new ArrayList<>();
	ArrayList<String> items;// = new ArrayList<>();

	
	
	
	
	@FXML
	// Event handler for the "Start/Stop" button
	private void startStopClicked() {
		// Check if the clock has not started
		if (!started) {
			// Ensure all the selection boxes have values before proceeding
			if (!projectBox.getSelectionModel().isEmpty() && !lifeCycleBox.getSelectionModel().isEmpty() &&
					!effortCategoryBox.getSelectionModel().isEmpty() && !itemBox.getSelectionModel().isEmpty()) {
				// Log the current time and the selected values when the clock starts
				startTimes.add(LocalDateTime.now());
				projects.add(projectBox.getSelectionModel().getSelectedItem());
				lifeCycles.add(lifeCycleBox.getSelectionModel().getSelectedItem());
				effortCategories.add(effortCategoryBox.getSelectionModel().getSelectedItem());
				items.add(itemBox.getSelectionModel().getSelectedItem());
			}
			// Update the button and label texts
			startStopButton.setText("Stop activity");
			clockText.setText("Clock is RUNNING");
			started = true;
		} else {
			// Log the current time when the clock stops
			endTimes.add(LocalDateTime.now());
			// Update the button and label texts
			startStopButton.setText("Start activity");
			clockText.setText("Clock is STOPPED");
			started = false;
			
			// Print the logged data to the console
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
    // Event handler for the "Back" button
    private void backClicked(ActionEvent event) {
    	// Check if we're in single prototype mode
    	if (EffortLoggerData.getInstance().isSinglePrototype()) {
	    	try {
	    		// Navigate back to the main menu for single prototype mode
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
				// Navigate back to the post-login screen for integrated mode
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
    // Initialization method for the controller
    private void initialize() {
    	
    	// Fetch and store the logged data from the EffortLoggerData singleton
    	startTimes = EffortLoggerData.getInstance().getStartTimes();
    	endTimes = EffortLoggerData.getInstance().getEndTimes();
    	projects = EffortLoggerData.getInstance().getProjects();
    	lifeCycles = EffortLoggerData.getInstance().getLifeCycles();
    	effortCategories = EffortLoggerData.getInstance().getEffortCategories();
    	items = EffortLoggerData.getInstance().getItems();
    	
    	// Populate the selection boxes with their respective options
    	projectBox.getItems().addAll("Business Project", "Development Project");
    	lifeCycleBox.getItems().addAll("Planning", "Information Gathering", "Information Understanding", "Verifying",
    			"Outlining", "Drafting", "Finalizing", "Team Meeting", "Coach Meeting", "Stakeholder Meeting");
    	effortCategoryBox.getItems().addAll("Plans", "Deliverables", "Interruptions", "Defects");
    	itemBox.getItems().addAll("Conceptual Design", "Detailed Design", "Test Cases", "Solution", "Reflection", 
    			"Break", "Visitor", "Project Plan", "Risk Management Plan");
    }
	
	
	
}
