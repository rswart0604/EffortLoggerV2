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
 * Author: Mohan Kummarigunta
 * Datetime: Oct 29 9:53 pm
 * Description: This class, EffortLoggingDeleteController, is responsible for managing the deletion of effort logs.
 * It provides a user interface with fields to view existing logs, enter the index of a log to delete, and buttons to perform deletion or navigate back.
 * Internally, it maintains several ArrayLists to store different attributes of the logs, such as start times, end times, project names, life cycles, effort categories, and items.
 * There is a TextArea to display all the logs, a TextField to input the index of the log to delete, and a Text component to display messages.
 * When the delete button is clicked, the code checks if the entered index is valid and deletes the log if it is. The UI is then updated to reflect this deletion.
 * 
 */

public class EffortLoggingDeleteController {

	@FXML
	private TextArea effortLogsField;
	@FXML
	private TextField indexField;
	@FXML
	private Button deleteButton;
	@FXML
	private Button backButton;
	@FXML
	private Text messageText;
	
	// Lists for storing various effort logging data
	ArrayList<LocalDateTime> startTimes = new ArrayList<>();
	ArrayList<LocalDateTime> endTimes = new ArrayList<>();
	ArrayList<String> projects = new ArrayList<>();
	ArrayList<String> lifeCycles = new ArrayList<>();
	ArrayList<String> effortCategories = new ArrayList<>();
	ArrayList<String> items = new ArrayList<>();
	
	
	@FXML
	// Handle the delete button click, removes the selected log
	private void deleteClicked() {
		String toDelete = indexField.getText();
		if (toDelete.equals("")) {
			return;
		}
		int index;
		//try-catch exception 
		try {
			index = Integer.parseInt(toDelete);
		} catch (Exception e) {
			return;
		}
		
		if (index < 0 || index >= startTimes.size()) {
			messageText.setText("Index is out of bounds!");
			return;
		}
		
		startTimes.remove(index);
		endTimes.remove(index);
		projects.remove(index);
		lifeCycles.remove(index);
		effortCategories.remove(index);
		items.remove(index);
		
		messageText.setText("Effort " + Integer.toString(index) + " has been deleted!");
		setTextArea();
	}
	// Update the displayed list of effort logs in the TextArea component
	private void setTextArea() {
		String toSet = "";
		for (int i=0; i<startTimes.size(); i++) {
			toSet += "Effort " + Integer.toString(i) + "\n";
			toSet += "Start: " + startTimes.get(i).toString() + "\n";
			toSet += "End: " + endTimes.get(i).toString() + "\n";
			toSet += "Project: " + projects.get(i).toString() + "\n";
			toSet += "Life cycle: " + lifeCycles.get(i).toString() + "\n";
			toSet += "Effort category: " + effortCategories.get(i).toString() + "\n";
			toSet += "Item: " + items.get(i).toString() + "\n\n\n";
		}
		effortLogsField.setText(toSet);
	}
	
	
	
	@FXML
	// Navigate back to the main menu or post login screen
    private void backClicked(ActionEvent event) {
		if (EffortLoggerData.getInstance().isSinglePrototype()) {
	    	try {
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
    // Initialize the controller, loading mock data or real data as appropriate
    private void initialize() {
        // method stub, just initialize everything here
    	EffortLoggerData data = EffortLoggerData.getInstance();
    	if (data.isSinglePrototype()) {
	    	startTimes.add(LocalDateTime.now());
	    	startTimes.add(LocalDateTime.now());
	    	startTimes.add(LocalDateTime.now());
	    	endTimes.add(LocalDateTime.now());
	    	endTimes.add(LocalDateTime.now());
	    	endTimes.add(LocalDateTime.now());
	    	projects.add("Business project");
	    	projects.add("Business project");
	    	projects.add("Development project");
	    	lifeCycles.add("Verifying");
	    	lifeCycles.add("Outlining");
	    	lifeCycles.add("Drafting");
	    	effortCategories.add("Plans");
	    	effortCategories.add("Deliverables");
	    	effortCategories.add("Deliverables");
	    	items.add("Test Cases");
	    	items.add("Conceptual Design");
	    	items.add("Risk Management Plan");
    	} else {
    		startTimes = data.getStartTimes();
    		endTimes = data.getEndTimes();
    		projects = data.getProjects();
    		lifeCycles = data.getLifeCycles();
    		effortCategories = data.getEffortCategories();
    		items = data.getItems();
    	}
    	setTextArea();
    }
	
	
}
